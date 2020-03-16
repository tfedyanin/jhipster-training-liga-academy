package ru.liga.web.rest;

import ru.liga.JHipsterApp;
import ru.liga.domain.SimpleMessageWithService;
import ru.liga.repository.SimpleMessageWithServiceRepository;
import ru.liga.service.SimpleMessageWithServiceService;
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
 * Integration tests for the {@link SimpleMessageWithServiceResource} REST controller.
 */
@SpringBootTest(classes = JHipsterApp.class)
public class SimpleMessageWithServiceResourceIT {

    @Autowired
    private SimpleMessageWithServiceRepository simpleMessageWithServiceRepository;

    @Autowired
    private SimpleMessageWithServiceService simpleMessageWithServiceService;

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

    private MockMvc restSimpleMessageWithServiceMockMvc;

    private SimpleMessageWithService simpleMessageWithService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
        final SimpleMessageWithServiceResource simpleMessageWithServiceResource = new SimpleMessageWithServiceResource(simpleMessageWithServiceService);
        this.restSimpleMessageWithServiceMockMvc = MockMvcBuilders.standaloneSetup(simpleMessageWithServiceResource)
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
    public static SimpleMessageWithService createEntity(EntityManager em) {
        SimpleMessageWithService simpleMessageWithService = new SimpleMessageWithService();
        return simpleMessageWithService;
    }
    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static SimpleMessageWithService createUpdatedEntity(EntityManager em) {
        SimpleMessageWithService simpleMessageWithService = new SimpleMessageWithService();
        return simpleMessageWithService;
    }

    @BeforeEach
    public void initTest() {
        simpleMessageWithService = createEntity(em);
    }

    @Test
    @Transactional
    public void createSimpleMessageWithService() throws Exception {
        int databaseSizeBeforeCreate = simpleMessageWithServiceRepository.findAll().size();

        // Create the SimpleMessageWithService
        restSimpleMessageWithServiceMockMvc.perform(post("/api/simple-message-with-services")
            .contentType(TestUtil.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(simpleMessageWithService)))
            .andExpect(status().isCreated());

        // Validate the SimpleMessageWithService in the database
        List<SimpleMessageWithService> simpleMessageWithServiceList = simpleMessageWithServiceRepository.findAll();
        assertThat(simpleMessageWithServiceList).hasSize(databaseSizeBeforeCreate + 1);
        SimpleMessageWithService testSimpleMessageWithService = simpleMessageWithServiceList.get(simpleMessageWithServiceList.size() - 1);
    }

    @Test
    @Transactional
    public void createSimpleMessageWithServiceWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = simpleMessageWithServiceRepository.findAll().size();

        // Create the SimpleMessageWithService with an existing ID
        simpleMessageWithService.setId(1L);

        // An entity with an existing ID cannot be created, so this API call must fail
        restSimpleMessageWithServiceMockMvc.perform(post("/api/simple-message-with-services")
            .contentType(TestUtil.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(simpleMessageWithService)))
            .andExpect(status().isBadRequest());

        // Validate the SimpleMessageWithService in the database
        List<SimpleMessageWithService> simpleMessageWithServiceList = simpleMessageWithServiceRepository.findAll();
        assertThat(simpleMessageWithServiceList).hasSize(databaseSizeBeforeCreate);
    }


    @Test
    @Transactional
    public void getAllSimpleMessageWithServices() throws Exception {
        // Initialize the database
        simpleMessageWithServiceRepository.saveAndFlush(simpleMessageWithService);

        // Get all the simpleMessageWithServiceList
        restSimpleMessageWithServiceMockMvc.perform(get("/api/simple-message-with-services?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(simpleMessageWithService.getId().intValue())));
    }
    
    @Test
    @Transactional
    public void getSimpleMessageWithService() throws Exception {
        // Initialize the database
        simpleMessageWithServiceRepository.saveAndFlush(simpleMessageWithService);

        // Get the simpleMessageWithService
        restSimpleMessageWithServiceMockMvc.perform(get("/api/simple-message-with-services/{id}", simpleMessageWithService.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(simpleMessageWithService.getId().intValue()));
    }

    @Test
    @Transactional
    public void getNonExistingSimpleMessageWithService() throws Exception {
        // Get the simpleMessageWithService
        restSimpleMessageWithServiceMockMvc.perform(get("/api/simple-message-with-services/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateSimpleMessageWithService() throws Exception {
        // Initialize the database
        simpleMessageWithServiceService.save(simpleMessageWithService);

        int databaseSizeBeforeUpdate = simpleMessageWithServiceRepository.findAll().size();

        // Update the simpleMessageWithService
        SimpleMessageWithService updatedSimpleMessageWithService = simpleMessageWithServiceRepository.findById(simpleMessageWithService.getId()).get();
        // Disconnect from session so that the updates on updatedSimpleMessageWithService are not directly saved in db
        em.detach(updatedSimpleMessageWithService);

        restSimpleMessageWithServiceMockMvc.perform(put("/api/simple-message-with-services")
            .contentType(TestUtil.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(updatedSimpleMessageWithService)))
            .andExpect(status().isOk());

        // Validate the SimpleMessageWithService in the database
        List<SimpleMessageWithService> simpleMessageWithServiceList = simpleMessageWithServiceRepository.findAll();
        assertThat(simpleMessageWithServiceList).hasSize(databaseSizeBeforeUpdate);
        SimpleMessageWithService testSimpleMessageWithService = simpleMessageWithServiceList.get(simpleMessageWithServiceList.size() - 1);
    }

    @Test
    @Transactional
    public void updateNonExistingSimpleMessageWithService() throws Exception {
        int databaseSizeBeforeUpdate = simpleMessageWithServiceRepository.findAll().size();

        // Create the SimpleMessageWithService

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restSimpleMessageWithServiceMockMvc.perform(put("/api/simple-message-with-services")
            .contentType(TestUtil.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(simpleMessageWithService)))
            .andExpect(status().isBadRequest());

        // Validate the SimpleMessageWithService in the database
        List<SimpleMessageWithService> simpleMessageWithServiceList = simpleMessageWithServiceRepository.findAll();
        assertThat(simpleMessageWithServiceList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteSimpleMessageWithService() throws Exception {
        // Initialize the database
        simpleMessageWithServiceService.save(simpleMessageWithService);

        int databaseSizeBeforeDelete = simpleMessageWithServiceRepository.findAll().size();

        // Delete the simpleMessageWithService
        restSimpleMessageWithServiceMockMvc.perform(delete("/api/simple-message-with-services/{id}", simpleMessageWithService.getId())
            .accept(TestUtil.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        List<SimpleMessageWithService> simpleMessageWithServiceList = simpleMessageWithServiceRepository.findAll();
        assertThat(simpleMessageWithServiceList).hasSize(databaseSizeBeforeDelete - 1);
    }
}
