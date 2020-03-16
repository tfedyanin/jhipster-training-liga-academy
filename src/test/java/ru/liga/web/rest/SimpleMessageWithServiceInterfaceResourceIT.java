package ru.liga.web.rest;

import ru.liga.JHipsterApp;
import ru.liga.domain.SimpleMessageWithServiceInterface;
import ru.liga.repository.SimpleMessageWithServiceInterfaceRepository;
import ru.liga.service.SimpleMessageWithServiceInterfaceService;
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
 * Integration tests for the {@link SimpleMessageWithServiceInterfaceResource} REST controller.
 */
@SpringBootTest(classes = JHipsterApp.class)
public class SimpleMessageWithServiceInterfaceResourceIT {

    @Autowired
    private SimpleMessageWithServiceInterfaceRepository simpleMessageWithServiceInterfaceRepository;

    @Autowired
    private SimpleMessageWithServiceInterfaceService simpleMessageWithServiceInterfaceService;

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

    private MockMvc restSimpleMessageWithServiceInterfaceMockMvc;

    private SimpleMessageWithServiceInterface simpleMessageWithServiceInterface;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
        final SimpleMessageWithServiceInterfaceResource simpleMessageWithServiceInterfaceResource = new SimpleMessageWithServiceInterfaceResource(simpleMessageWithServiceInterfaceService);
        this.restSimpleMessageWithServiceInterfaceMockMvc = MockMvcBuilders.standaloneSetup(simpleMessageWithServiceInterfaceResource)
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
    public static SimpleMessageWithServiceInterface createEntity(EntityManager em) {
        SimpleMessageWithServiceInterface simpleMessageWithServiceInterface = new SimpleMessageWithServiceInterface();
        return simpleMessageWithServiceInterface;
    }
    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static SimpleMessageWithServiceInterface createUpdatedEntity(EntityManager em) {
        SimpleMessageWithServiceInterface simpleMessageWithServiceInterface = new SimpleMessageWithServiceInterface();
        return simpleMessageWithServiceInterface;
    }

    @BeforeEach
    public void initTest() {
        simpleMessageWithServiceInterface = createEntity(em);
    }

    @Test
    @Transactional
    public void createSimpleMessageWithServiceInterface() throws Exception {
        int databaseSizeBeforeCreate = simpleMessageWithServiceInterfaceRepository.findAll().size();

        // Create the SimpleMessageWithServiceInterface
        restSimpleMessageWithServiceInterfaceMockMvc.perform(post("/api/simple-message-with-service-interfaces")
            .contentType(TestUtil.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(simpleMessageWithServiceInterface)))
            .andExpect(status().isCreated());

        // Validate the SimpleMessageWithServiceInterface in the database
        List<SimpleMessageWithServiceInterface> simpleMessageWithServiceInterfaceList = simpleMessageWithServiceInterfaceRepository.findAll();
        assertThat(simpleMessageWithServiceInterfaceList).hasSize(databaseSizeBeforeCreate + 1);
        SimpleMessageWithServiceInterface testSimpleMessageWithServiceInterface = simpleMessageWithServiceInterfaceList.get(simpleMessageWithServiceInterfaceList.size() - 1);
    }

    @Test
    @Transactional
    public void createSimpleMessageWithServiceInterfaceWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = simpleMessageWithServiceInterfaceRepository.findAll().size();

        // Create the SimpleMessageWithServiceInterface with an existing ID
        simpleMessageWithServiceInterface.setId(1L);

        // An entity with an existing ID cannot be created, so this API call must fail
        restSimpleMessageWithServiceInterfaceMockMvc.perform(post("/api/simple-message-with-service-interfaces")
            .contentType(TestUtil.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(simpleMessageWithServiceInterface)))
            .andExpect(status().isBadRequest());

        // Validate the SimpleMessageWithServiceInterface in the database
        List<SimpleMessageWithServiceInterface> simpleMessageWithServiceInterfaceList = simpleMessageWithServiceInterfaceRepository.findAll();
        assertThat(simpleMessageWithServiceInterfaceList).hasSize(databaseSizeBeforeCreate);
    }


    @Test
    @Transactional
    public void getAllSimpleMessageWithServiceInterfaces() throws Exception {
        // Initialize the database
        simpleMessageWithServiceInterfaceRepository.saveAndFlush(simpleMessageWithServiceInterface);

        // Get all the simpleMessageWithServiceInterfaceList
        restSimpleMessageWithServiceInterfaceMockMvc.perform(get("/api/simple-message-with-service-interfaces?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(simpleMessageWithServiceInterface.getId().intValue())));
    }
    
    @Test
    @Transactional
    public void getSimpleMessageWithServiceInterface() throws Exception {
        // Initialize the database
        simpleMessageWithServiceInterfaceRepository.saveAndFlush(simpleMessageWithServiceInterface);

        // Get the simpleMessageWithServiceInterface
        restSimpleMessageWithServiceInterfaceMockMvc.perform(get("/api/simple-message-with-service-interfaces/{id}", simpleMessageWithServiceInterface.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(simpleMessageWithServiceInterface.getId().intValue()));
    }

    @Test
    @Transactional
    public void getNonExistingSimpleMessageWithServiceInterface() throws Exception {
        // Get the simpleMessageWithServiceInterface
        restSimpleMessageWithServiceInterfaceMockMvc.perform(get("/api/simple-message-with-service-interfaces/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateSimpleMessageWithServiceInterface() throws Exception {
        // Initialize the database
        simpleMessageWithServiceInterfaceService.save(simpleMessageWithServiceInterface);

        int databaseSizeBeforeUpdate = simpleMessageWithServiceInterfaceRepository.findAll().size();

        // Update the simpleMessageWithServiceInterface
        SimpleMessageWithServiceInterface updatedSimpleMessageWithServiceInterface = simpleMessageWithServiceInterfaceRepository.findById(simpleMessageWithServiceInterface.getId()).get();
        // Disconnect from session so that the updates on updatedSimpleMessageWithServiceInterface are not directly saved in db
        em.detach(updatedSimpleMessageWithServiceInterface);

        restSimpleMessageWithServiceInterfaceMockMvc.perform(put("/api/simple-message-with-service-interfaces")
            .contentType(TestUtil.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(updatedSimpleMessageWithServiceInterface)))
            .andExpect(status().isOk());

        // Validate the SimpleMessageWithServiceInterface in the database
        List<SimpleMessageWithServiceInterface> simpleMessageWithServiceInterfaceList = simpleMessageWithServiceInterfaceRepository.findAll();
        assertThat(simpleMessageWithServiceInterfaceList).hasSize(databaseSizeBeforeUpdate);
        SimpleMessageWithServiceInterface testSimpleMessageWithServiceInterface = simpleMessageWithServiceInterfaceList.get(simpleMessageWithServiceInterfaceList.size() - 1);
    }

    @Test
    @Transactional
    public void updateNonExistingSimpleMessageWithServiceInterface() throws Exception {
        int databaseSizeBeforeUpdate = simpleMessageWithServiceInterfaceRepository.findAll().size();

        // Create the SimpleMessageWithServiceInterface

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restSimpleMessageWithServiceInterfaceMockMvc.perform(put("/api/simple-message-with-service-interfaces")
            .contentType(TestUtil.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(simpleMessageWithServiceInterface)))
            .andExpect(status().isBadRequest());

        // Validate the SimpleMessageWithServiceInterface in the database
        List<SimpleMessageWithServiceInterface> simpleMessageWithServiceInterfaceList = simpleMessageWithServiceInterfaceRepository.findAll();
        assertThat(simpleMessageWithServiceInterfaceList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteSimpleMessageWithServiceInterface() throws Exception {
        // Initialize the database
        simpleMessageWithServiceInterfaceService.save(simpleMessageWithServiceInterface);

        int databaseSizeBeforeDelete = simpleMessageWithServiceInterfaceRepository.findAll().size();

        // Delete the simpleMessageWithServiceInterface
        restSimpleMessageWithServiceInterfaceMockMvc.perform(delete("/api/simple-message-with-service-interfaces/{id}", simpleMessageWithServiceInterface.getId())
            .accept(TestUtil.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        List<SimpleMessageWithServiceInterface> simpleMessageWithServiceInterfaceList = simpleMessageWithServiceInterfaceRepository.findAll();
        assertThat(simpleMessageWithServiceInterfaceList).hasSize(databaseSizeBeforeDelete - 1);
    }
}
