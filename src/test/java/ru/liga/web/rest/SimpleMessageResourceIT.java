package ru.liga.web.rest;

import ru.liga.JHipsterApp;
import ru.liga.domain.SimpleMessage;
import ru.liga.repository.SimpleMessageRepository;
import ru.liga.web.rest.errors.ExceptionTranslator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.Validator;

import javax.persistence.EntityManager;
import java.util.List;

import static ru.liga.web.rest.TestUtil.createFormattingConversionService;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Integration tests for the {@link SimpleMessageResource} REST controller.
 */
@SpringBootTest(classes = JHipsterApp.class)
public class SimpleMessageResourceIT {

    private static final String DEFAULT_MSG = "AAAAAAAAAA";
    private static final String UPDATED_MSG = "BBBBBBBBBB";

    @Autowired
    private SimpleMessageRepository simpleMessageRepository;

    @Autowired
    private MappingJackson2HttpMessageConverter jacksonMessageConverter;

    @Autowired
    private PageableHandlerMethodArgumentResolver pageableArgumentResolver;

    @Autowired
    private ExceptionTranslator exceptionTranslator;

    @Autowired
    private EntityManager em;

    @Autowired
    private Validator validator;

    private MockMvc restSimpleMessageMockMvc;

    private SimpleMessage simpleMessage;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
        final SimpleMessageResource simpleMessageResource = new SimpleMessageResource(simpleMessageRepository);
        this.restSimpleMessageMockMvc = MockMvcBuilders.standaloneSetup(simpleMessageResource)
            .setCustomArgumentResolvers(pageableArgumentResolver)
            .setControllerAdvice(exceptionTranslator)
            .setConversionService(createFormattingConversionService())
            .setMessageConverters(jacksonMessageConverter)
            .setValidator(validator).build();
    }

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static SimpleMessage createEntity(EntityManager em) {
        SimpleMessage simpleMessage = new SimpleMessage()
            .msg(DEFAULT_MSG);
        return simpleMessage;
    }
    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static SimpleMessage createUpdatedEntity(EntityManager em) {
        SimpleMessage simpleMessage = new SimpleMessage()
            .msg(UPDATED_MSG);
        return simpleMessage;
    }

    @BeforeEach
    public void initTest() {
        simpleMessage = createEntity(em);
    }

    @Test
    @Transactional
    public void createSimpleMessage() throws Exception {
        int databaseSizeBeforeCreate = simpleMessageRepository.findAll().size();

        // Create the SimpleMessage
        restSimpleMessageMockMvc.perform(post("/api/simple-messages")
            .contentType(TestUtil.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(simpleMessage)))
            .andExpect(status().isCreated());

        // Validate the SimpleMessage in the database
        List<SimpleMessage> simpleMessageList = simpleMessageRepository.findAll();
        assertThat(simpleMessageList).hasSize(databaseSizeBeforeCreate + 1);
        SimpleMessage testSimpleMessage = simpleMessageList.get(simpleMessageList.size() - 1);
        assertThat(testSimpleMessage.getMsg()).isEqualTo(DEFAULT_MSG);
    }

    @Test
    @Transactional
    public void createSimpleMessageWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = simpleMessageRepository.findAll().size();

        // Create the SimpleMessage with an existing ID
        simpleMessage.setId(1L);

        // An entity with an existing ID cannot be created, so this API call must fail
        restSimpleMessageMockMvc.perform(post("/api/simple-messages")
            .contentType(TestUtil.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(simpleMessage)))
            .andExpect(status().isBadRequest());

        // Validate the SimpleMessage in the database
        List<SimpleMessage> simpleMessageList = simpleMessageRepository.findAll();
        assertThat(simpleMessageList).hasSize(databaseSizeBeforeCreate);
    }


    @Test
    @Transactional
    public void getAllSimpleMessages() throws Exception {
        // Initialize the database
        simpleMessageRepository.saveAndFlush(simpleMessage);

        // Get all the simpleMessageList
        restSimpleMessageMockMvc.perform(get("/api/simple-messages?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(simpleMessage.getId().intValue())))
            .andExpect(jsonPath("$.[*].msg").value(hasItem(DEFAULT_MSG)));
    }
    
    @Test
    @Transactional
    public void getSimpleMessage() throws Exception {
        // Initialize the database
        simpleMessageRepository.saveAndFlush(simpleMessage);

        // Get the simpleMessage
        restSimpleMessageMockMvc.perform(get("/api/simple-messages/{id}", simpleMessage.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(simpleMessage.getId().intValue()))
            .andExpect(jsonPath("$.msg").value(DEFAULT_MSG));
    }

    @Test
    @Transactional
    public void getNonExistingSimpleMessage() throws Exception {
        // Get the simpleMessage
        restSimpleMessageMockMvc.perform(get("/api/simple-messages/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateSimpleMessage() throws Exception {
        // Initialize the database
        simpleMessageRepository.saveAndFlush(simpleMessage);

        int databaseSizeBeforeUpdate = simpleMessageRepository.findAll().size();

        // Update the simpleMessage
        SimpleMessage updatedSimpleMessage = simpleMessageRepository.findById(simpleMessage.getId()).get();
        // Disconnect from session so that the updates on updatedSimpleMessage are not directly saved in db
        em.detach(updatedSimpleMessage);
        updatedSimpleMessage
            .msg(UPDATED_MSG);

        restSimpleMessageMockMvc.perform(put("/api/simple-messages")
            .contentType(TestUtil.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(updatedSimpleMessage)))
            .andExpect(status().isOk());

        // Validate the SimpleMessage in the database
        List<SimpleMessage> simpleMessageList = simpleMessageRepository.findAll();
        assertThat(simpleMessageList).hasSize(databaseSizeBeforeUpdate);
        SimpleMessage testSimpleMessage = simpleMessageList.get(simpleMessageList.size() - 1);
        assertThat(testSimpleMessage.getMsg()).isEqualTo(UPDATED_MSG);
    }

    @Test
    @Transactional
    public void updateNonExistingSimpleMessage() throws Exception {
        int databaseSizeBeforeUpdate = simpleMessageRepository.findAll().size();

        // Create the SimpleMessage

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restSimpleMessageMockMvc.perform(put("/api/simple-messages")
            .contentType(TestUtil.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(simpleMessage)))
            .andExpect(status().isBadRequest());

        // Validate the SimpleMessage in the database
        List<SimpleMessage> simpleMessageList = simpleMessageRepository.findAll();
        assertThat(simpleMessageList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteSimpleMessage() throws Exception {
        // Initialize the database
        simpleMessageRepository.saveAndFlush(simpleMessage);

        int databaseSizeBeforeDelete = simpleMessageRepository.findAll().size();

        // Delete the simpleMessage
        restSimpleMessageMockMvc.perform(delete("/api/simple-messages/{id}", simpleMessage.getId())
            .accept(TestUtil.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        List<SimpleMessage> simpleMessageList = simpleMessageRepository.findAll();
        assertThat(simpleMessageList).hasSize(databaseSizeBeforeDelete - 1);
    }
}
