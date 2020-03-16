package ru.liga.web.rest;

import ru.liga.JHipsterApp;
import ru.liga.domain.SimpleMessageWithServiceInterfaceDtoInfinityScrollFiltering;
import ru.liga.repository.SimpleMessageWithServiceInterfaceDtoInfinityScrollFilteringRepository;
import ru.liga.service.SimpleMessageWithServiceInterfaceDtoInfinityScrollFilteringService;
import ru.liga.service.dto.SimpleMessageWithServiceInterfaceDtoInfinityScrollFilteringDTO;
import ru.liga.service.mapper.SimpleMessageWithServiceInterfaceDtoInfinityScrollFilteringMapper;
import ru.liga.web.rest.errors.ExceptionTranslator;
import ru.liga.service.dto.SimpleMessageWithServiceInterfaceDtoInfinityScrollFilteringCriteria;
import ru.liga.service.SimpleMessageWithServiceInterfaceDtoInfinityScrollFilteringQueryService;

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
 * Integration tests for the {@link SimpleMessageWithServiceInterfaceDtoInfinityScrollFilteringResource} REST controller.
 */
@SpringBootTest(classes = JHipsterApp.class)
public class SimpleMessageWithServiceInterfaceDtoInfinityScrollFilteringResourceIT {

    @Autowired
    private SimpleMessageWithServiceInterfaceDtoInfinityScrollFilteringRepository simpleMessageWithServiceInterfaceDtoInfinityScrollFilteringRepository;

    @Autowired
    private SimpleMessageWithServiceInterfaceDtoInfinityScrollFilteringMapper simpleMessageWithServiceInterfaceDtoInfinityScrollFilteringMapper;

    @Autowired
    private SimpleMessageWithServiceInterfaceDtoInfinityScrollFilteringService simpleMessageWithServiceInterfaceDtoInfinityScrollFilteringService;

    @Autowired
    private SimpleMessageWithServiceInterfaceDtoInfinityScrollFilteringQueryService simpleMessageWithServiceInterfaceDtoInfinityScrollFilteringQueryService;

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

    private MockMvc restSimpleMessageWithServiceInterfaceDtoInfinityScrollFilteringMockMvc;

    private SimpleMessageWithServiceInterfaceDtoInfinityScrollFiltering simpleMessageWithServiceInterfaceDtoInfinityScrollFiltering;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
        final SimpleMessageWithServiceInterfaceDtoInfinityScrollFilteringResource simpleMessageWithServiceInterfaceDtoInfinityScrollFilteringResource = new SimpleMessageWithServiceInterfaceDtoInfinityScrollFilteringResource(simpleMessageWithServiceInterfaceDtoInfinityScrollFilteringService, simpleMessageWithServiceInterfaceDtoInfinityScrollFilteringQueryService);
        this.restSimpleMessageWithServiceInterfaceDtoInfinityScrollFilteringMockMvc = MockMvcBuilders.standaloneSetup(simpleMessageWithServiceInterfaceDtoInfinityScrollFilteringResource)
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
    public static SimpleMessageWithServiceInterfaceDtoInfinityScrollFiltering createEntity(EntityManager em) {
        SimpleMessageWithServiceInterfaceDtoInfinityScrollFiltering simpleMessageWithServiceInterfaceDtoInfinityScrollFiltering = new SimpleMessageWithServiceInterfaceDtoInfinityScrollFiltering();
        return simpleMessageWithServiceInterfaceDtoInfinityScrollFiltering;
    }
    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static SimpleMessageWithServiceInterfaceDtoInfinityScrollFiltering createUpdatedEntity(EntityManager em) {
        SimpleMessageWithServiceInterfaceDtoInfinityScrollFiltering simpleMessageWithServiceInterfaceDtoInfinityScrollFiltering = new SimpleMessageWithServiceInterfaceDtoInfinityScrollFiltering();
        return simpleMessageWithServiceInterfaceDtoInfinityScrollFiltering;
    }

    @BeforeEach
    public void initTest() {
        simpleMessageWithServiceInterfaceDtoInfinityScrollFiltering = createEntity(em);
    }

    @Test
    @Transactional
    public void createSimpleMessageWithServiceInterfaceDtoInfinityScrollFiltering() throws Exception {
        int databaseSizeBeforeCreate = simpleMessageWithServiceInterfaceDtoInfinityScrollFilteringRepository.findAll().size();

        // Create the SimpleMessageWithServiceInterfaceDtoInfinityScrollFiltering
        SimpleMessageWithServiceInterfaceDtoInfinityScrollFilteringDTO simpleMessageWithServiceInterfaceDtoInfinityScrollFilteringDTO = simpleMessageWithServiceInterfaceDtoInfinityScrollFilteringMapper.toDto(simpleMessageWithServiceInterfaceDtoInfinityScrollFiltering);
        restSimpleMessageWithServiceInterfaceDtoInfinityScrollFilteringMockMvc.perform(post("/api/simple-message-with-service-interface-dto-infinity-scroll-filterings")
            .contentType(TestUtil.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(simpleMessageWithServiceInterfaceDtoInfinityScrollFilteringDTO)))
            .andExpect(status().isCreated());

        // Validate the SimpleMessageWithServiceInterfaceDtoInfinityScrollFiltering in the database
        List<SimpleMessageWithServiceInterfaceDtoInfinityScrollFiltering> simpleMessageWithServiceInterfaceDtoInfinityScrollFilteringList = simpleMessageWithServiceInterfaceDtoInfinityScrollFilteringRepository.findAll();
        assertThat(simpleMessageWithServiceInterfaceDtoInfinityScrollFilteringList).hasSize(databaseSizeBeforeCreate + 1);
        SimpleMessageWithServiceInterfaceDtoInfinityScrollFiltering testSimpleMessageWithServiceInterfaceDtoInfinityScrollFiltering = simpleMessageWithServiceInterfaceDtoInfinityScrollFilteringList.get(simpleMessageWithServiceInterfaceDtoInfinityScrollFilteringList.size() - 1);
    }

    @Test
    @Transactional
    public void createSimpleMessageWithServiceInterfaceDtoInfinityScrollFilteringWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = simpleMessageWithServiceInterfaceDtoInfinityScrollFilteringRepository.findAll().size();

        // Create the SimpleMessageWithServiceInterfaceDtoInfinityScrollFiltering with an existing ID
        simpleMessageWithServiceInterfaceDtoInfinityScrollFiltering.setId(1L);
        SimpleMessageWithServiceInterfaceDtoInfinityScrollFilteringDTO simpleMessageWithServiceInterfaceDtoInfinityScrollFilteringDTO = simpleMessageWithServiceInterfaceDtoInfinityScrollFilteringMapper.toDto(simpleMessageWithServiceInterfaceDtoInfinityScrollFiltering);

        // An entity with an existing ID cannot be created, so this API call must fail
        restSimpleMessageWithServiceInterfaceDtoInfinityScrollFilteringMockMvc.perform(post("/api/simple-message-with-service-interface-dto-infinity-scroll-filterings")
            .contentType(TestUtil.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(simpleMessageWithServiceInterfaceDtoInfinityScrollFilteringDTO)))
            .andExpect(status().isBadRequest());

        // Validate the SimpleMessageWithServiceInterfaceDtoInfinityScrollFiltering in the database
        List<SimpleMessageWithServiceInterfaceDtoInfinityScrollFiltering> simpleMessageWithServiceInterfaceDtoInfinityScrollFilteringList = simpleMessageWithServiceInterfaceDtoInfinityScrollFilteringRepository.findAll();
        assertThat(simpleMessageWithServiceInterfaceDtoInfinityScrollFilteringList).hasSize(databaseSizeBeforeCreate);
    }


    @Test
    @Transactional
    public void getAllSimpleMessageWithServiceInterfaceDtoInfinityScrollFilterings() throws Exception {
        // Initialize the database
        simpleMessageWithServiceInterfaceDtoInfinityScrollFilteringRepository.saveAndFlush(simpleMessageWithServiceInterfaceDtoInfinityScrollFiltering);

        // Get all the simpleMessageWithServiceInterfaceDtoInfinityScrollFilteringList
        restSimpleMessageWithServiceInterfaceDtoInfinityScrollFilteringMockMvc.perform(get("/api/simple-message-with-service-interface-dto-infinity-scroll-filterings?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(simpleMessageWithServiceInterfaceDtoInfinityScrollFiltering.getId().intValue())));
    }
    
    @Test
    @Transactional
    public void getSimpleMessageWithServiceInterfaceDtoInfinityScrollFiltering() throws Exception {
        // Initialize the database
        simpleMessageWithServiceInterfaceDtoInfinityScrollFilteringRepository.saveAndFlush(simpleMessageWithServiceInterfaceDtoInfinityScrollFiltering);

        // Get the simpleMessageWithServiceInterfaceDtoInfinityScrollFiltering
        restSimpleMessageWithServiceInterfaceDtoInfinityScrollFilteringMockMvc.perform(get("/api/simple-message-with-service-interface-dto-infinity-scroll-filterings/{id}", simpleMessageWithServiceInterfaceDtoInfinityScrollFiltering.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(simpleMessageWithServiceInterfaceDtoInfinityScrollFiltering.getId().intValue()));
    }


    @Test
    @Transactional
    public void getSimpleMessageWithServiceInterfaceDtoInfinityScrollFilteringsByIdFiltering() throws Exception {
        // Initialize the database
        simpleMessageWithServiceInterfaceDtoInfinityScrollFilteringRepository.saveAndFlush(simpleMessageWithServiceInterfaceDtoInfinityScrollFiltering);

        Long id = simpleMessageWithServiceInterfaceDtoInfinityScrollFiltering.getId();

        defaultSimpleMessageWithServiceInterfaceDtoInfinityScrollFilteringShouldBeFound("id.equals=" + id);
        defaultSimpleMessageWithServiceInterfaceDtoInfinityScrollFilteringShouldNotBeFound("id.notEquals=" + id);

        defaultSimpleMessageWithServiceInterfaceDtoInfinityScrollFilteringShouldBeFound("id.greaterThanOrEqual=" + id);
        defaultSimpleMessageWithServiceInterfaceDtoInfinityScrollFilteringShouldNotBeFound("id.greaterThan=" + id);

        defaultSimpleMessageWithServiceInterfaceDtoInfinityScrollFilteringShouldBeFound("id.lessThanOrEqual=" + id);
        defaultSimpleMessageWithServiceInterfaceDtoInfinityScrollFilteringShouldNotBeFound("id.lessThan=" + id);
    }

    /**
     * Executes the search, and checks that the default entity is returned.
     */
    private void defaultSimpleMessageWithServiceInterfaceDtoInfinityScrollFilteringShouldBeFound(String filter) throws Exception {
        restSimpleMessageWithServiceInterfaceDtoInfinityScrollFilteringMockMvc.perform(get("/api/simple-message-with-service-interface-dto-infinity-scroll-filterings?sort=id,desc&" + filter))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(simpleMessageWithServiceInterfaceDtoInfinityScrollFiltering.getId().intValue())));

        // Check, that the count call also returns 1
        restSimpleMessageWithServiceInterfaceDtoInfinityScrollFilteringMockMvc.perform(get("/api/simple-message-with-service-interface-dto-infinity-scroll-filterings/count?sort=id,desc&" + filter))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(content().string("1"));
    }

    /**
     * Executes the search, and checks that the default entity is not returned.
     */
    private void defaultSimpleMessageWithServiceInterfaceDtoInfinityScrollFilteringShouldNotBeFound(String filter) throws Exception {
        restSimpleMessageWithServiceInterfaceDtoInfinityScrollFilteringMockMvc.perform(get("/api/simple-message-with-service-interface-dto-infinity-scroll-filterings?sort=id,desc&" + filter))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$").isArray())
            .andExpect(jsonPath("$").isEmpty());

        // Check, that the count call also returns 0
        restSimpleMessageWithServiceInterfaceDtoInfinityScrollFilteringMockMvc.perform(get("/api/simple-message-with-service-interface-dto-infinity-scroll-filterings/count?sort=id,desc&" + filter))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(content().string("0"));
    }


    @Test
    @Transactional
    public void getNonExistingSimpleMessageWithServiceInterfaceDtoInfinityScrollFiltering() throws Exception {
        // Get the simpleMessageWithServiceInterfaceDtoInfinityScrollFiltering
        restSimpleMessageWithServiceInterfaceDtoInfinityScrollFilteringMockMvc.perform(get("/api/simple-message-with-service-interface-dto-infinity-scroll-filterings/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateSimpleMessageWithServiceInterfaceDtoInfinityScrollFiltering() throws Exception {
        // Initialize the database
        simpleMessageWithServiceInterfaceDtoInfinityScrollFilteringRepository.saveAndFlush(simpleMessageWithServiceInterfaceDtoInfinityScrollFiltering);

        int databaseSizeBeforeUpdate = simpleMessageWithServiceInterfaceDtoInfinityScrollFilteringRepository.findAll().size();

        // Update the simpleMessageWithServiceInterfaceDtoInfinityScrollFiltering
        SimpleMessageWithServiceInterfaceDtoInfinityScrollFiltering updatedSimpleMessageWithServiceInterfaceDtoInfinityScrollFiltering = simpleMessageWithServiceInterfaceDtoInfinityScrollFilteringRepository.findById(simpleMessageWithServiceInterfaceDtoInfinityScrollFiltering.getId()).get();
        // Disconnect from session so that the updates on updatedSimpleMessageWithServiceInterfaceDtoInfinityScrollFiltering are not directly saved in db
        em.detach(updatedSimpleMessageWithServiceInterfaceDtoInfinityScrollFiltering);
        SimpleMessageWithServiceInterfaceDtoInfinityScrollFilteringDTO simpleMessageWithServiceInterfaceDtoInfinityScrollFilteringDTO = simpleMessageWithServiceInterfaceDtoInfinityScrollFilteringMapper.toDto(updatedSimpleMessageWithServiceInterfaceDtoInfinityScrollFiltering);

        restSimpleMessageWithServiceInterfaceDtoInfinityScrollFilteringMockMvc.perform(put("/api/simple-message-with-service-interface-dto-infinity-scroll-filterings")
            .contentType(TestUtil.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(simpleMessageWithServiceInterfaceDtoInfinityScrollFilteringDTO)))
            .andExpect(status().isOk());

        // Validate the SimpleMessageWithServiceInterfaceDtoInfinityScrollFiltering in the database
        List<SimpleMessageWithServiceInterfaceDtoInfinityScrollFiltering> simpleMessageWithServiceInterfaceDtoInfinityScrollFilteringList = simpleMessageWithServiceInterfaceDtoInfinityScrollFilteringRepository.findAll();
        assertThat(simpleMessageWithServiceInterfaceDtoInfinityScrollFilteringList).hasSize(databaseSizeBeforeUpdate);
        SimpleMessageWithServiceInterfaceDtoInfinityScrollFiltering testSimpleMessageWithServiceInterfaceDtoInfinityScrollFiltering = simpleMessageWithServiceInterfaceDtoInfinityScrollFilteringList.get(simpleMessageWithServiceInterfaceDtoInfinityScrollFilteringList.size() - 1);
    }

    @Test
    @Transactional
    public void updateNonExistingSimpleMessageWithServiceInterfaceDtoInfinityScrollFiltering() throws Exception {
        int databaseSizeBeforeUpdate = simpleMessageWithServiceInterfaceDtoInfinityScrollFilteringRepository.findAll().size();

        // Create the SimpleMessageWithServiceInterfaceDtoInfinityScrollFiltering
        SimpleMessageWithServiceInterfaceDtoInfinityScrollFilteringDTO simpleMessageWithServiceInterfaceDtoInfinityScrollFilteringDTO = simpleMessageWithServiceInterfaceDtoInfinityScrollFilteringMapper.toDto(simpleMessageWithServiceInterfaceDtoInfinityScrollFiltering);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restSimpleMessageWithServiceInterfaceDtoInfinityScrollFilteringMockMvc.perform(put("/api/simple-message-with-service-interface-dto-infinity-scroll-filterings")
            .contentType(TestUtil.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(simpleMessageWithServiceInterfaceDtoInfinityScrollFilteringDTO)))
            .andExpect(status().isBadRequest());

        // Validate the SimpleMessageWithServiceInterfaceDtoInfinityScrollFiltering in the database
        List<SimpleMessageWithServiceInterfaceDtoInfinityScrollFiltering> simpleMessageWithServiceInterfaceDtoInfinityScrollFilteringList = simpleMessageWithServiceInterfaceDtoInfinityScrollFilteringRepository.findAll();
        assertThat(simpleMessageWithServiceInterfaceDtoInfinityScrollFilteringList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteSimpleMessageWithServiceInterfaceDtoInfinityScrollFiltering() throws Exception {
        // Initialize the database
        simpleMessageWithServiceInterfaceDtoInfinityScrollFilteringRepository.saveAndFlush(simpleMessageWithServiceInterfaceDtoInfinityScrollFiltering);

        int databaseSizeBeforeDelete = simpleMessageWithServiceInterfaceDtoInfinityScrollFilteringRepository.findAll().size();

        // Delete the simpleMessageWithServiceInterfaceDtoInfinityScrollFiltering
        restSimpleMessageWithServiceInterfaceDtoInfinityScrollFilteringMockMvc.perform(delete("/api/simple-message-with-service-interface-dto-infinity-scroll-filterings/{id}", simpleMessageWithServiceInterfaceDtoInfinityScrollFiltering.getId())
            .accept(TestUtil.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        List<SimpleMessageWithServiceInterfaceDtoInfinityScrollFiltering> simpleMessageWithServiceInterfaceDtoInfinityScrollFilteringList = simpleMessageWithServiceInterfaceDtoInfinityScrollFilteringRepository.findAll();
        assertThat(simpleMessageWithServiceInterfaceDtoInfinityScrollFilteringList).hasSize(databaseSizeBeforeDelete - 1);
    }
}
