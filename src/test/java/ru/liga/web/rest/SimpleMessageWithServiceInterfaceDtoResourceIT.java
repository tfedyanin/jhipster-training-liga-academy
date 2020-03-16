package ru.liga.web.rest;

import ru.liga.JHipsterApp;
import ru.liga.domain.SimpleMessageWithServiceInterfaceDto;
import ru.liga.repository.SimpleMessageWithServiceInterfaceDtoRepository;
import ru.liga.service.SimpleMessageWithServiceInterfaceDtoService;
import ru.liga.service.dto.SimpleMessageWithServiceInterfaceDtoDTO;
import ru.liga.service.mapper.SimpleMessageWithServiceInterfaceDtoMapper;
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
 * Integration tests for the {@link SimpleMessageWithServiceInterfaceDtoResource} REST controller.
 */
@SpringBootTest(classes = JHipsterApp.class)
public class SimpleMessageWithServiceInterfaceDtoResourceIT {

    @Autowired
    private SimpleMessageWithServiceInterfaceDtoRepository simpleMessageWithServiceInterfaceDtoRepository;

    @Autowired
    private SimpleMessageWithServiceInterfaceDtoMapper simpleMessageWithServiceInterfaceDtoMapper;

    @Autowired
    private SimpleMessageWithServiceInterfaceDtoService simpleMessageWithServiceInterfaceDtoService;

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

    private MockMvc restSimpleMessageWithServiceInterfaceDtoMockMvc;

    private SimpleMessageWithServiceInterfaceDto simpleMessageWithServiceInterfaceDto;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
        final SimpleMessageWithServiceInterfaceDtoResource simpleMessageWithServiceInterfaceDtoResource = new SimpleMessageWithServiceInterfaceDtoResource(simpleMessageWithServiceInterfaceDtoService);
        this.restSimpleMessageWithServiceInterfaceDtoMockMvc = MockMvcBuilders.standaloneSetup(simpleMessageWithServiceInterfaceDtoResource)
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
    public static SimpleMessageWithServiceInterfaceDto createEntity(EntityManager em) {
        SimpleMessageWithServiceInterfaceDto simpleMessageWithServiceInterfaceDto = new SimpleMessageWithServiceInterfaceDto();
        return simpleMessageWithServiceInterfaceDto;
    }
    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static SimpleMessageWithServiceInterfaceDto createUpdatedEntity(EntityManager em) {
        SimpleMessageWithServiceInterfaceDto simpleMessageWithServiceInterfaceDto = new SimpleMessageWithServiceInterfaceDto();
        return simpleMessageWithServiceInterfaceDto;
    }

    @BeforeEach
    public void initTest() {
        simpleMessageWithServiceInterfaceDto = createEntity(em);
    }

    @Test
    @Transactional
    public void createSimpleMessageWithServiceInterfaceDto() throws Exception {
        int databaseSizeBeforeCreate = simpleMessageWithServiceInterfaceDtoRepository.findAll().size();

        // Create the SimpleMessageWithServiceInterfaceDto
        SimpleMessageWithServiceInterfaceDtoDTO simpleMessageWithServiceInterfaceDtoDTO = simpleMessageWithServiceInterfaceDtoMapper.toDto(simpleMessageWithServiceInterfaceDto);
        restSimpleMessageWithServiceInterfaceDtoMockMvc.perform(post("/api/simple-message-with-service-interface-dtos")
            .contentType(TestUtil.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(simpleMessageWithServiceInterfaceDtoDTO)))
            .andExpect(status().isCreated());

        // Validate the SimpleMessageWithServiceInterfaceDto in the database
        List<SimpleMessageWithServiceInterfaceDto> simpleMessageWithServiceInterfaceDtoList = simpleMessageWithServiceInterfaceDtoRepository.findAll();
        assertThat(simpleMessageWithServiceInterfaceDtoList).hasSize(databaseSizeBeforeCreate + 1);
        SimpleMessageWithServiceInterfaceDto testSimpleMessageWithServiceInterfaceDto = simpleMessageWithServiceInterfaceDtoList.get(simpleMessageWithServiceInterfaceDtoList.size() - 1);
    }

    @Test
    @Transactional
    public void createSimpleMessageWithServiceInterfaceDtoWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = simpleMessageWithServiceInterfaceDtoRepository.findAll().size();

        // Create the SimpleMessageWithServiceInterfaceDto with an existing ID
        simpleMessageWithServiceInterfaceDto.setId(1L);
        SimpleMessageWithServiceInterfaceDtoDTO simpleMessageWithServiceInterfaceDtoDTO = simpleMessageWithServiceInterfaceDtoMapper.toDto(simpleMessageWithServiceInterfaceDto);

        // An entity with an existing ID cannot be created, so this API call must fail
        restSimpleMessageWithServiceInterfaceDtoMockMvc.perform(post("/api/simple-message-with-service-interface-dtos")
            .contentType(TestUtil.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(simpleMessageWithServiceInterfaceDtoDTO)))
            .andExpect(status().isBadRequest());

        // Validate the SimpleMessageWithServiceInterfaceDto in the database
        List<SimpleMessageWithServiceInterfaceDto> simpleMessageWithServiceInterfaceDtoList = simpleMessageWithServiceInterfaceDtoRepository.findAll();
        assertThat(simpleMessageWithServiceInterfaceDtoList).hasSize(databaseSizeBeforeCreate);
    }


    @Test
    @Transactional
    public void getAllSimpleMessageWithServiceInterfaceDtos() throws Exception {
        // Initialize the database
        simpleMessageWithServiceInterfaceDtoRepository.saveAndFlush(simpleMessageWithServiceInterfaceDto);

        // Get all the simpleMessageWithServiceInterfaceDtoList
        restSimpleMessageWithServiceInterfaceDtoMockMvc.perform(get("/api/simple-message-with-service-interface-dtos?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(simpleMessageWithServiceInterfaceDto.getId().intValue())));
    }
    
    @Test
    @Transactional
    public void getSimpleMessageWithServiceInterfaceDto() throws Exception {
        // Initialize the database
        simpleMessageWithServiceInterfaceDtoRepository.saveAndFlush(simpleMessageWithServiceInterfaceDto);

        // Get the simpleMessageWithServiceInterfaceDto
        restSimpleMessageWithServiceInterfaceDtoMockMvc.perform(get("/api/simple-message-with-service-interface-dtos/{id}", simpleMessageWithServiceInterfaceDto.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(simpleMessageWithServiceInterfaceDto.getId().intValue()));
    }

    @Test
    @Transactional
    public void getNonExistingSimpleMessageWithServiceInterfaceDto() throws Exception {
        // Get the simpleMessageWithServiceInterfaceDto
        restSimpleMessageWithServiceInterfaceDtoMockMvc.perform(get("/api/simple-message-with-service-interface-dtos/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateSimpleMessageWithServiceInterfaceDto() throws Exception {
        // Initialize the database
        simpleMessageWithServiceInterfaceDtoRepository.saveAndFlush(simpleMessageWithServiceInterfaceDto);

        int databaseSizeBeforeUpdate = simpleMessageWithServiceInterfaceDtoRepository.findAll().size();

        // Update the simpleMessageWithServiceInterfaceDto
        SimpleMessageWithServiceInterfaceDto updatedSimpleMessageWithServiceInterfaceDto = simpleMessageWithServiceInterfaceDtoRepository.findById(simpleMessageWithServiceInterfaceDto.getId()).get();
        // Disconnect from session so that the updates on updatedSimpleMessageWithServiceInterfaceDto are not directly saved in db
        em.detach(updatedSimpleMessageWithServiceInterfaceDto);
        SimpleMessageWithServiceInterfaceDtoDTO simpleMessageWithServiceInterfaceDtoDTO = simpleMessageWithServiceInterfaceDtoMapper.toDto(updatedSimpleMessageWithServiceInterfaceDto);

        restSimpleMessageWithServiceInterfaceDtoMockMvc.perform(put("/api/simple-message-with-service-interface-dtos")
            .contentType(TestUtil.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(simpleMessageWithServiceInterfaceDtoDTO)))
            .andExpect(status().isOk());

        // Validate the SimpleMessageWithServiceInterfaceDto in the database
        List<SimpleMessageWithServiceInterfaceDto> simpleMessageWithServiceInterfaceDtoList = simpleMessageWithServiceInterfaceDtoRepository.findAll();
        assertThat(simpleMessageWithServiceInterfaceDtoList).hasSize(databaseSizeBeforeUpdate);
        SimpleMessageWithServiceInterfaceDto testSimpleMessageWithServiceInterfaceDto = simpleMessageWithServiceInterfaceDtoList.get(simpleMessageWithServiceInterfaceDtoList.size() - 1);
    }

    @Test
    @Transactional
    public void updateNonExistingSimpleMessageWithServiceInterfaceDto() throws Exception {
        int databaseSizeBeforeUpdate = simpleMessageWithServiceInterfaceDtoRepository.findAll().size();

        // Create the SimpleMessageWithServiceInterfaceDto
        SimpleMessageWithServiceInterfaceDtoDTO simpleMessageWithServiceInterfaceDtoDTO = simpleMessageWithServiceInterfaceDtoMapper.toDto(simpleMessageWithServiceInterfaceDto);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restSimpleMessageWithServiceInterfaceDtoMockMvc.perform(put("/api/simple-message-with-service-interface-dtos")
            .contentType(TestUtil.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(simpleMessageWithServiceInterfaceDtoDTO)))
            .andExpect(status().isBadRequest());

        // Validate the SimpleMessageWithServiceInterfaceDto in the database
        List<SimpleMessageWithServiceInterfaceDto> simpleMessageWithServiceInterfaceDtoList = simpleMessageWithServiceInterfaceDtoRepository.findAll();
        assertThat(simpleMessageWithServiceInterfaceDtoList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteSimpleMessageWithServiceInterfaceDto() throws Exception {
        // Initialize the database
        simpleMessageWithServiceInterfaceDtoRepository.saveAndFlush(simpleMessageWithServiceInterfaceDto);

        int databaseSizeBeforeDelete = simpleMessageWithServiceInterfaceDtoRepository.findAll().size();

        // Delete the simpleMessageWithServiceInterfaceDto
        restSimpleMessageWithServiceInterfaceDtoMockMvc.perform(delete("/api/simple-message-with-service-interface-dtos/{id}", simpleMessageWithServiceInterfaceDto.getId())
            .accept(TestUtil.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        List<SimpleMessageWithServiceInterfaceDto> simpleMessageWithServiceInterfaceDtoList = simpleMessageWithServiceInterfaceDtoRepository.findAll();
        assertThat(simpleMessageWithServiceInterfaceDtoList).hasSize(databaseSizeBeforeDelete - 1);
    }
}
