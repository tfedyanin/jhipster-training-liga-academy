package ru.liga.web.rest;

import ru.liga.JHipsterApp;
import ru.liga.domain.SimpleMessageWithServiceInterfaceDtoPagination;
import ru.liga.repository.SimpleMessageWithServiceInterfaceDtoPaginationRepository;
import ru.liga.service.SimpleMessageWithServiceInterfaceDtoPaginationService;
import ru.liga.service.dto.SimpleMessageWithServiceInterfaceDtoPaginationDTO;
import ru.liga.service.mapper.SimpleMessageWithServiceInterfaceDtoPaginationMapper;
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
 * Integration tests for the {@link SimpleMessageWithServiceInterfaceDtoPaginationResource} REST controller.
 */
@SpringBootTest(classes = JHipsterApp.class)
public class SimpleMessageWithServiceInterfaceDtoPaginationResourceIT {

    @Autowired
    private SimpleMessageWithServiceInterfaceDtoPaginationRepository simpleMessageWithServiceInterfaceDtoPaginationRepository;

    @Autowired
    private SimpleMessageWithServiceInterfaceDtoPaginationMapper simpleMessageWithServiceInterfaceDtoPaginationMapper;

    @Autowired
    private SimpleMessageWithServiceInterfaceDtoPaginationService simpleMessageWithServiceInterfaceDtoPaginationService;

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

    private MockMvc restSimpleMessageWithServiceInterfaceDtoPaginationMockMvc;

    private SimpleMessageWithServiceInterfaceDtoPagination simpleMessageWithServiceInterfaceDtoPagination;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
        final SimpleMessageWithServiceInterfaceDtoPaginationResource simpleMessageWithServiceInterfaceDtoPaginationResource = new SimpleMessageWithServiceInterfaceDtoPaginationResource(simpleMessageWithServiceInterfaceDtoPaginationService);
        this.restSimpleMessageWithServiceInterfaceDtoPaginationMockMvc = MockMvcBuilders.standaloneSetup(simpleMessageWithServiceInterfaceDtoPaginationResource)
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
    public static SimpleMessageWithServiceInterfaceDtoPagination createEntity(EntityManager em) {
        SimpleMessageWithServiceInterfaceDtoPagination simpleMessageWithServiceInterfaceDtoPagination = new SimpleMessageWithServiceInterfaceDtoPagination();
        return simpleMessageWithServiceInterfaceDtoPagination;
    }
    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static SimpleMessageWithServiceInterfaceDtoPagination createUpdatedEntity(EntityManager em) {
        SimpleMessageWithServiceInterfaceDtoPagination simpleMessageWithServiceInterfaceDtoPagination = new SimpleMessageWithServiceInterfaceDtoPagination();
        return simpleMessageWithServiceInterfaceDtoPagination;
    }

    @BeforeEach
    public void initTest() {
        simpleMessageWithServiceInterfaceDtoPagination = createEntity(em);
    }

    @Test
    @Transactional
    public void createSimpleMessageWithServiceInterfaceDtoPagination() throws Exception {
        int databaseSizeBeforeCreate = simpleMessageWithServiceInterfaceDtoPaginationRepository.findAll().size();

        // Create the SimpleMessageWithServiceInterfaceDtoPagination
        SimpleMessageWithServiceInterfaceDtoPaginationDTO simpleMessageWithServiceInterfaceDtoPaginationDTO = simpleMessageWithServiceInterfaceDtoPaginationMapper.toDto(simpleMessageWithServiceInterfaceDtoPagination);
        restSimpleMessageWithServiceInterfaceDtoPaginationMockMvc.perform(post("/api/simple-message-with-service-interface-dto-paginations")
            .contentType(TestUtil.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(simpleMessageWithServiceInterfaceDtoPaginationDTO)))
            .andExpect(status().isCreated());

        // Validate the SimpleMessageWithServiceInterfaceDtoPagination in the database
        List<SimpleMessageWithServiceInterfaceDtoPagination> simpleMessageWithServiceInterfaceDtoPaginationList = simpleMessageWithServiceInterfaceDtoPaginationRepository.findAll();
        assertThat(simpleMessageWithServiceInterfaceDtoPaginationList).hasSize(databaseSizeBeforeCreate + 1);
        SimpleMessageWithServiceInterfaceDtoPagination testSimpleMessageWithServiceInterfaceDtoPagination = simpleMessageWithServiceInterfaceDtoPaginationList.get(simpleMessageWithServiceInterfaceDtoPaginationList.size() - 1);
    }

    @Test
    @Transactional
    public void createSimpleMessageWithServiceInterfaceDtoPaginationWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = simpleMessageWithServiceInterfaceDtoPaginationRepository.findAll().size();

        // Create the SimpleMessageWithServiceInterfaceDtoPagination with an existing ID
        simpleMessageWithServiceInterfaceDtoPagination.setId(1L);
        SimpleMessageWithServiceInterfaceDtoPaginationDTO simpleMessageWithServiceInterfaceDtoPaginationDTO = simpleMessageWithServiceInterfaceDtoPaginationMapper.toDto(simpleMessageWithServiceInterfaceDtoPagination);

        // An entity with an existing ID cannot be created, so this API call must fail
        restSimpleMessageWithServiceInterfaceDtoPaginationMockMvc.perform(post("/api/simple-message-with-service-interface-dto-paginations")
            .contentType(TestUtil.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(simpleMessageWithServiceInterfaceDtoPaginationDTO)))
            .andExpect(status().isBadRequest());

        // Validate the SimpleMessageWithServiceInterfaceDtoPagination in the database
        List<SimpleMessageWithServiceInterfaceDtoPagination> simpleMessageWithServiceInterfaceDtoPaginationList = simpleMessageWithServiceInterfaceDtoPaginationRepository.findAll();
        assertThat(simpleMessageWithServiceInterfaceDtoPaginationList).hasSize(databaseSizeBeforeCreate);
    }


    @Test
    @Transactional
    public void getAllSimpleMessageWithServiceInterfaceDtoPaginations() throws Exception {
        // Initialize the database
        simpleMessageWithServiceInterfaceDtoPaginationRepository.saveAndFlush(simpleMessageWithServiceInterfaceDtoPagination);

        // Get all the simpleMessageWithServiceInterfaceDtoPaginationList
        restSimpleMessageWithServiceInterfaceDtoPaginationMockMvc.perform(get("/api/simple-message-with-service-interface-dto-paginations?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(simpleMessageWithServiceInterfaceDtoPagination.getId().intValue())));
    }
    
    @Test
    @Transactional
    public void getSimpleMessageWithServiceInterfaceDtoPagination() throws Exception {
        // Initialize the database
        simpleMessageWithServiceInterfaceDtoPaginationRepository.saveAndFlush(simpleMessageWithServiceInterfaceDtoPagination);

        // Get the simpleMessageWithServiceInterfaceDtoPagination
        restSimpleMessageWithServiceInterfaceDtoPaginationMockMvc.perform(get("/api/simple-message-with-service-interface-dto-paginations/{id}", simpleMessageWithServiceInterfaceDtoPagination.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(simpleMessageWithServiceInterfaceDtoPagination.getId().intValue()));
    }

    @Test
    @Transactional
    public void getNonExistingSimpleMessageWithServiceInterfaceDtoPagination() throws Exception {
        // Get the simpleMessageWithServiceInterfaceDtoPagination
        restSimpleMessageWithServiceInterfaceDtoPaginationMockMvc.perform(get("/api/simple-message-with-service-interface-dto-paginations/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateSimpleMessageWithServiceInterfaceDtoPagination() throws Exception {
        // Initialize the database
        simpleMessageWithServiceInterfaceDtoPaginationRepository.saveAndFlush(simpleMessageWithServiceInterfaceDtoPagination);

        int databaseSizeBeforeUpdate = simpleMessageWithServiceInterfaceDtoPaginationRepository.findAll().size();

        // Update the simpleMessageWithServiceInterfaceDtoPagination
        SimpleMessageWithServiceInterfaceDtoPagination updatedSimpleMessageWithServiceInterfaceDtoPagination = simpleMessageWithServiceInterfaceDtoPaginationRepository.findById(simpleMessageWithServiceInterfaceDtoPagination.getId()).get();
        // Disconnect from session so that the updates on updatedSimpleMessageWithServiceInterfaceDtoPagination are not directly saved in db
        em.detach(updatedSimpleMessageWithServiceInterfaceDtoPagination);
        SimpleMessageWithServiceInterfaceDtoPaginationDTO simpleMessageWithServiceInterfaceDtoPaginationDTO = simpleMessageWithServiceInterfaceDtoPaginationMapper.toDto(updatedSimpleMessageWithServiceInterfaceDtoPagination);

        restSimpleMessageWithServiceInterfaceDtoPaginationMockMvc.perform(put("/api/simple-message-with-service-interface-dto-paginations")
            .contentType(TestUtil.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(simpleMessageWithServiceInterfaceDtoPaginationDTO)))
            .andExpect(status().isOk());

        // Validate the SimpleMessageWithServiceInterfaceDtoPagination in the database
        List<SimpleMessageWithServiceInterfaceDtoPagination> simpleMessageWithServiceInterfaceDtoPaginationList = simpleMessageWithServiceInterfaceDtoPaginationRepository.findAll();
        assertThat(simpleMessageWithServiceInterfaceDtoPaginationList).hasSize(databaseSizeBeforeUpdate);
        SimpleMessageWithServiceInterfaceDtoPagination testSimpleMessageWithServiceInterfaceDtoPagination = simpleMessageWithServiceInterfaceDtoPaginationList.get(simpleMessageWithServiceInterfaceDtoPaginationList.size() - 1);
    }

    @Test
    @Transactional
    public void updateNonExistingSimpleMessageWithServiceInterfaceDtoPagination() throws Exception {
        int databaseSizeBeforeUpdate = simpleMessageWithServiceInterfaceDtoPaginationRepository.findAll().size();

        // Create the SimpleMessageWithServiceInterfaceDtoPagination
        SimpleMessageWithServiceInterfaceDtoPaginationDTO simpleMessageWithServiceInterfaceDtoPaginationDTO = simpleMessageWithServiceInterfaceDtoPaginationMapper.toDto(simpleMessageWithServiceInterfaceDtoPagination);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restSimpleMessageWithServiceInterfaceDtoPaginationMockMvc.perform(put("/api/simple-message-with-service-interface-dto-paginations")
            .contentType(TestUtil.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(simpleMessageWithServiceInterfaceDtoPaginationDTO)))
            .andExpect(status().isBadRequest());

        // Validate the SimpleMessageWithServiceInterfaceDtoPagination in the database
        List<SimpleMessageWithServiceInterfaceDtoPagination> simpleMessageWithServiceInterfaceDtoPaginationList = simpleMessageWithServiceInterfaceDtoPaginationRepository.findAll();
        assertThat(simpleMessageWithServiceInterfaceDtoPaginationList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteSimpleMessageWithServiceInterfaceDtoPagination() throws Exception {
        // Initialize the database
        simpleMessageWithServiceInterfaceDtoPaginationRepository.saveAndFlush(simpleMessageWithServiceInterfaceDtoPagination);

        int databaseSizeBeforeDelete = simpleMessageWithServiceInterfaceDtoPaginationRepository.findAll().size();

        // Delete the simpleMessageWithServiceInterfaceDtoPagination
        restSimpleMessageWithServiceInterfaceDtoPaginationMockMvc.perform(delete("/api/simple-message-with-service-interface-dto-paginations/{id}", simpleMessageWithServiceInterfaceDtoPagination.getId())
            .accept(TestUtil.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        List<SimpleMessageWithServiceInterfaceDtoPagination> simpleMessageWithServiceInterfaceDtoPaginationList = simpleMessageWithServiceInterfaceDtoPaginationRepository.findAll();
        assertThat(simpleMessageWithServiceInterfaceDtoPaginationList).hasSize(databaseSizeBeforeDelete - 1);
    }
}
