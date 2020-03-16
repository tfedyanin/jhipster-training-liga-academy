package ru.liga.web.rest;

import ru.liga.JHipsterApp;
import ru.liga.domain.SimpleMessageWithServiceInterfaceDtoInfinityScroll;
import ru.liga.repository.SimpleMessageWithServiceInterfaceDtoInfinityScrollRepository;
import ru.liga.service.SimpleMessageWithServiceInterfaceDtoInfinityScrollService;
import ru.liga.service.dto.SimpleMessageWithServiceInterfaceDtoInfinityScrollDTO;
import ru.liga.service.mapper.SimpleMessageWithServiceInterfaceDtoInfinityScrollMapper;
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
 * Integration tests for the {@link SimpleMessageWithServiceInterfaceDtoInfinityScrollResource} REST controller.
 */
@SpringBootTest(classes = JHipsterApp.class)
public class SimpleMessageWithServiceInterfaceDtoInfinityScrollResourceIT {

    @Autowired
    private SimpleMessageWithServiceInterfaceDtoInfinityScrollRepository simpleMessageWithServiceInterfaceDtoInfinityScrollRepository;

    @Autowired
    private SimpleMessageWithServiceInterfaceDtoInfinityScrollMapper simpleMessageWithServiceInterfaceDtoInfinityScrollMapper;

    @Autowired
    private SimpleMessageWithServiceInterfaceDtoInfinityScrollService simpleMessageWithServiceInterfaceDtoInfinityScrollService;

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

    private MockMvc restSimpleMessageWithServiceInterfaceDtoInfinityScrollMockMvc;

    private SimpleMessageWithServiceInterfaceDtoInfinityScroll simpleMessageWithServiceInterfaceDtoInfinityScroll;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
        final SimpleMessageWithServiceInterfaceDtoInfinityScrollResource simpleMessageWithServiceInterfaceDtoInfinityScrollResource = new SimpleMessageWithServiceInterfaceDtoInfinityScrollResource(simpleMessageWithServiceInterfaceDtoInfinityScrollService);
        this.restSimpleMessageWithServiceInterfaceDtoInfinityScrollMockMvc = MockMvcBuilders.standaloneSetup(simpleMessageWithServiceInterfaceDtoInfinityScrollResource)
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
    public static SimpleMessageWithServiceInterfaceDtoInfinityScroll createEntity(EntityManager em) {
        SimpleMessageWithServiceInterfaceDtoInfinityScroll simpleMessageWithServiceInterfaceDtoInfinityScroll = new SimpleMessageWithServiceInterfaceDtoInfinityScroll();
        return simpleMessageWithServiceInterfaceDtoInfinityScroll;
    }
    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static SimpleMessageWithServiceInterfaceDtoInfinityScroll createUpdatedEntity(EntityManager em) {
        SimpleMessageWithServiceInterfaceDtoInfinityScroll simpleMessageWithServiceInterfaceDtoInfinityScroll = new SimpleMessageWithServiceInterfaceDtoInfinityScroll();
        return simpleMessageWithServiceInterfaceDtoInfinityScroll;
    }

    @BeforeEach
    public void initTest() {
        simpleMessageWithServiceInterfaceDtoInfinityScroll = createEntity(em);
    }

    @Test
    @Transactional
    public void createSimpleMessageWithServiceInterfaceDtoInfinityScroll() throws Exception {
        int databaseSizeBeforeCreate = simpleMessageWithServiceInterfaceDtoInfinityScrollRepository.findAll().size();

        // Create the SimpleMessageWithServiceInterfaceDtoInfinityScroll
        SimpleMessageWithServiceInterfaceDtoInfinityScrollDTO simpleMessageWithServiceInterfaceDtoInfinityScrollDTO = simpleMessageWithServiceInterfaceDtoInfinityScrollMapper.toDto(simpleMessageWithServiceInterfaceDtoInfinityScroll);
        restSimpleMessageWithServiceInterfaceDtoInfinityScrollMockMvc.perform(post("/api/simple-message-with-service-interface-dto-infinity-scrolls")
            .contentType(TestUtil.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(simpleMessageWithServiceInterfaceDtoInfinityScrollDTO)))
            .andExpect(status().isCreated());

        // Validate the SimpleMessageWithServiceInterfaceDtoInfinityScroll in the database
        List<SimpleMessageWithServiceInterfaceDtoInfinityScroll> simpleMessageWithServiceInterfaceDtoInfinityScrollList = simpleMessageWithServiceInterfaceDtoInfinityScrollRepository.findAll();
        assertThat(simpleMessageWithServiceInterfaceDtoInfinityScrollList).hasSize(databaseSizeBeforeCreate + 1);
        SimpleMessageWithServiceInterfaceDtoInfinityScroll testSimpleMessageWithServiceInterfaceDtoInfinityScroll = simpleMessageWithServiceInterfaceDtoInfinityScrollList.get(simpleMessageWithServiceInterfaceDtoInfinityScrollList.size() - 1);
    }

    @Test
    @Transactional
    public void createSimpleMessageWithServiceInterfaceDtoInfinityScrollWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = simpleMessageWithServiceInterfaceDtoInfinityScrollRepository.findAll().size();

        // Create the SimpleMessageWithServiceInterfaceDtoInfinityScroll with an existing ID
        simpleMessageWithServiceInterfaceDtoInfinityScroll.setId(1L);
        SimpleMessageWithServiceInterfaceDtoInfinityScrollDTO simpleMessageWithServiceInterfaceDtoInfinityScrollDTO = simpleMessageWithServiceInterfaceDtoInfinityScrollMapper.toDto(simpleMessageWithServiceInterfaceDtoInfinityScroll);

        // An entity with an existing ID cannot be created, so this API call must fail
        restSimpleMessageWithServiceInterfaceDtoInfinityScrollMockMvc.perform(post("/api/simple-message-with-service-interface-dto-infinity-scrolls")
            .contentType(TestUtil.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(simpleMessageWithServiceInterfaceDtoInfinityScrollDTO)))
            .andExpect(status().isBadRequest());

        // Validate the SimpleMessageWithServiceInterfaceDtoInfinityScroll in the database
        List<SimpleMessageWithServiceInterfaceDtoInfinityScroll> simpleMessageWithServiceInterfaceDtoInfinityScrollList = simpleMessageWithServiceInterfaceDtoInfinityScrollRepository.findAll();
        assertThat(simpleMessageWithServiceInterfaceDtoInfinityScrollList).hasSize(databaseSizeBeforeCreate);
    }


    @Test
    @Transactional
    public void getAllSimpleMessageWithServiceInterfaceDtoInfinityScrolls() throws Exception {
        // Initialize the database
        simpleMessageWithServiceInterfaceDtoInfinityScrollRepository.saveAndFlush(simpleMessageWithServiceInterfaceDtoInfinityScroll);

        // Get all the simpleMessageWithServiceInterfaceDtoInfinityScrollList
        restSimpleMessageWithServiceInterfaceDtoInfinityScrollMockMvc.perform(get("/api/simple-message-with-service-interface-dto-infinity-scrolls?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(simpleMessageWithServiceInterfaceDtoInfinityScroll.getId().intValue())));
    }
    
    @Test
    @Transactional
    public void getSimpleMessageWithServiceInterfaceDtoInfinityScroll() throws Exception {
        // Initialize the database
        simpleMessageWithServiceInterfaceDtoInfinityScrollRepository.saveAndFlush(simpleMessageWithServiceInterfaceDtoInfinityScroll);

        // Get the simpleMessageWithServiceInterfaceDtoInfinityScroll
        restSimpleMessageWithServiceInterfaceDtoInfinityScrollMockMvc.perform(get("/api/simple-message-with-service-interface-dto-infinity-scrolls/{id}", simpleMessageWithServiceInterfaceDtoInfinityScroll.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(simpleMessageWithServiceInterfaceDtoInfinityScroll.getId().intValue()));
    }

    @Test
    @Transactional
    public void getNonExistingSimpleMessageWithServiceInterfaceDtoInfinityScroll() throws Exception {
        // Get the simpleMessageWithServiceInterfaceDtoInfinityScroll
        restSimpleMessageWithServiceInterfaceDtoInfinityScrollMockMvc.perform(get("/api/simple-message-with-service-interface-dto-infinity-scrolls/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateSimpleMessageWithServiceInterfaceDtoInfinityScroll() throws Exception {
        // Initialize the database
        simpleMessageWithServiceInterfaceDtoInfinityScrollRepository.saveAndFlush(simpleMessageWithServiceInterfaceDtoInfinityScroll);

        int databaseSizeBeforeUpdate = simpleMessageWithServiceInterfaceDtoInfinityScrollRepository.findAll().size();

        // Update the simpleMessageWithServiceInterfaceDtoInfinityScroll
        SimpleMessageWithServiceInterfaceDtoInfinityScroll updatedSimpleMessageWithServiceInterfaceDtoInfinityScroll = simpleMessageWithServiceInterfaceDtoInfinityScrollRepository.findById(simpleMessageWithServiceInterfaceDtoInfinityScroll.getId()).get();
        // Disconnect from session so that the updates on updatedSimpleMessageWithServiceInterfaceDtoInfinityScroll are not directly saved in db
        em.detach(updatedSimpleMessageWithServiceInterfaceDtoInfinityScroll);
        SimpleMessageWithServiceInterfaceDtoInfinityScrollDTO simpleMessageWithServiceInterfaceDtoInfinityScrollDTO = simpleMessageWithServiceInterfaceDtoInfinityScrollMapper.toDto(updatedSimpleMessageWithServiceInterfaceDtoInfinityScroll);

        restSimpleMessageWithServiceInterfaceDtoInfinityScrollMockMvc.perform(put("/api/simple-message-with-service-interface-dto-infinity-scrolls")
            .contentType(TestUtil.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(simpleMessageWithServiceInterfaceDtoInfinityScrollDTO)))
            .andExpect(status().isOk());

        // Validate the SimpleMessageWithServiceInterfaceDtoInfinityScroll in the database
        List<SimpleMessageWithServiceInterfaceDtoInfinityScroll> simpleMessageWithServiceInterfaceDtoInfinityScrollList = simpleMessageWithServiceInterfaceDtoInfinityScrollRepository.findAll();
        assertThat(simpleMessageWithServiceInterfaceDtoInfinityScrollList).hasSize(databaseSizeBeforeUpdate);
        SimpleMessageWithServiceInterfaceDtoInfinityScroll testSimpleMessageWithServiceInterfaceDtoInfinityScroll = simpleMessageWithServiceInterfaceDtoInfinityScrollList.get(simpleMessageWithServiceInterfaceDtoInfinityScrollList.size() - 1);
    }

    @Test
    @Transactional
    public void updateNonExistingSimpleMessageWithServiceInterfaceDtoInfinityScroll() throws Exception {
        int databaseSizeBeforeUpdate = simpleMessageWithServiceInterfaceDtoInfinityScrollRepository.findAll().size();

        // Create the SimpleMessageWithServiceInterfaceDtoInfinityScroll
        SimpleMessageWithServiceInterfaceDtoInfinityScrollDTO simpleMessageWithServiceInterfaceDtoInfinityScrollDTO = simpleMessageWithServiceInterfaceDtoInfinityScrollMapper.toDto(simpleMessageWithServiceInterfaceDtoInfinityScroll);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restSimpleMessageWithServiceInterfaceDtoInfinityScrollMockMvc.perform(put("/api/simple-message-with-service-interface-dto-infinity-scrolls")
            .contentType(TestUtil.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(simpleMessageWithServiceInterfaceDtoInfinityScrollDTO)))
            .andExpect(status().isBadRequest());

        // Validate the SimpleMessageWithServiceInterfaceDtoInfinityScroll in the database
        List<SimpleMessageWithServiceInterfaceDtoInfinityScroll> simpleMessageWithServiceInterfaceDtoInfinityScrollList = simpleMessageWithServiceInterfaceDtoInfinityScrollRepository.findAll();
        assertThat(simpleMessageWithServiceInterfaceDtoInfinityScrollList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteSimpleMessageWithServiceInterfaceDtoInfinityScroll() throws Exception {
        // Initialize the database
        simpleMessageWithServiceInterfaceDtoInfinityScrollRepository.saveAndFlush(simpleMessageWithServiceInterfaceDtoInfinityScroll);

        int databaseSizeBeforeDelete = simpleMessageWithServiceInterfaceDtoInfinityScrollRepository.findAll().size();

        // Delete the simpleMessageWithServiceInterfaceDtoInfinityScroll
        restSimpleMessageWithServiceInterfaceDtoInfinityScrollMockMvc.perform(delete("/api/simple-message-with-service-interface-dto-infinity-scrolls/{id}", simpleMessageWithServiceInterfaceDtoInfinityScroll.getId())
            .accept(TestUtil.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        List<SimpleMessageWithServiceInterfaceDtoInfinityScroll> simpleMessageWithServiceInterfaceDtoInfinityScrollList = simpleMessageWithServiceInterfaceDtoInfinityScrollRepository.findAll();
        assertThat(simpleMessageWithServiceInterfaceDtoInfinityScrollList).hasSize(databaseSizeBeforeDelete - 1);
    }
}
