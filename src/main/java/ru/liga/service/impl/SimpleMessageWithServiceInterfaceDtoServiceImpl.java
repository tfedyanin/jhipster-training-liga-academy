package ru.liga.service.impl;

import ru.liga.service.SimpleMessageWithServiceInterfaceDtoService;
import ru.liga.domain.SimpleMessageWithServiceInterfaceDto;
import ru.liga.repository.SimpleMessageWithServiceInterfaceDtoRepository;
import ru.liga.service.dto.SimpleMessageWithServiceInterfaceDtoDTO;
import ru.liga.service.mapper.SimpleMessageWithServiceInterfaceDtoMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Service Implementation for managing {@link SimpleMessageWithServiceInterfaceDto}.
 */
@Service
@Transactional
public class SimpleMessageWithServiceInterfaceDtoServiceImpl implements SimpleMessageWithServiceInterfaceDtoService {

    private final Logger log = LoggerFactory.getLogger(SimpleMessageWithServiceInterfaceDtoServiceImpl.class);

    private final SimpleMessageWithServiceInterfaceDtoRepository simpleMessageWithServiceInterfaceDtoRepository;

    private final SimpleMessageWithServiceInterfaceDtoMapper simpleMessageWithServiceInterfaceDtoMapper;

    public SimpleMessageWithServiceInterfaceDtoServiceImpl(SimpleMessageWithServiceInterfaceDtoRepository simpleMessageWithServiceInterfaceDtoRepository, SimpleMessageWithServiceInterfaceDtoMapper simpleMessageWithServiceInterfaceDtoMapper) {
        this.simpleMessageWithServiceInterfaceDtoRepository = simpleMessageWithServiceInterfaceDtoRepository;
        this.simpleMessageWithServiceInterfaceDtoMapper = simpleMessageWithServiceInterfaceDtoMapper;
    }

    /**
     * Save a simpleMessageWithServiceInterfaceDto.
     *
     * @param simpleMessageWithServiceInterfaceDtoDTO the entity to save.
     * @return the persisted entity.
     */
    @Override
    public SimpleMessageWithServiceInterfaceDtoDTO save(SimpleMessageWithServiceInterfaceDtoDTO simpleMessageWithServiceInterfaceDtoDTO) {
        log.debug("Request to save SimpleMessageWithServiceInterfaceDto : {}", simpleMessageWithServiceInterfaceDtoDTO);
        SimpleMessageWithServiceInterfaceDto simpleMessageWithServiceInterfaceDto = simpleMessageWithServiceInterfaceDtoMapper.toEntity(simpleMessageWithServiceInterfaceDtoDTO);
        simpleMessageWithServiceInterfaceDto = simpleMessageWithServiceInterfaceDtoRepository.save(simpleMessageWithServiceInterfaceDto);
        return simpleMessageWithServiceInterfaceDtoMapper.toDto(simpleMessageWithServiceInterfaceDto);
    }

    /**
     * Get all the simpleMessageWithServiceInterfaceDtos.
     *
     * @return the list of entities.
     */
    @Override
    @Transactional(readOnly = true)
    public List<SimpleMessageWithServiceInterfaceDtoDTO> findAll() {
        log.debug("Request to get all SimpleMessageWithServiceInterfaceDtos");
        return simpleMessageWithServiceInterfaceDtoRepository.findAll().stream()
            .map(simpleMessageWithServiceInterfaceDtoMapper::toDto)
            .collect(Collectors.toCollection(LinkedList::new));
    }

    /**
     * Get one simpleMessageWithServiceInterfaceDto by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<SimpleMessageWithServiceInterfaceDtoDTO> findOne(Long id) {
        log.debug("Request to get SimpleMessageWithServiceInterfaceDto : {}", id);
        return simpleMessageWithServiceInterfaceDtoRepository.findById(id)
            .map(simpleMessageWithServiceInterfaceDtoMapper::toDto);
    }

    /**
     * Delete the simpleMessageWithServiceInterfaceDto by id.
     *
     * @param id the id of the entity.
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete SimpleMessageWithServiceInterfaceDto : {}", id);
        simpleMessageWithServiceInterfaceDtoRepository.deleteById(id);
    }
}
