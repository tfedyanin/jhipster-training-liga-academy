package ru.liga.service.impl;

import ru.liga.service.SimpleMessageWithServiceInterfaceDtoInfinityScrollFilteringService;
import ru.liga.domain.SimpleMessageWithServiceInterfaceDtoInfinityScrollFiltering;
import ru.liga.repository.SimpleMessageWithServiceInterfaceDtoInfinityScrollFilteringRepository;
import ru.liga.service.dto.SimpleMessageWithServiceInterfaceDtoInfinityScrollFilteringDTO;
import ru.liga.service.mapper.SimpleMessageWithServiceInterfaceDtoInfinityScrollFilteringMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link SimpleMessageWithServiceInterfaceDtoInfinityScrollFiltering}.
 */
@Service
@Transactional
public class SimpleMessageWithServiceInterfaceDtoInfinityScrollFilteringServiceImpl implements SimpleMessageWithServiceInterfaceDtoInfinityScrollFilteringService {

    private final Logger log = LoggerFactory.getLogger(SimpleMessageWithServiceInterfaceDtoInfinityScrollFilteringServiceImpl.class);

    private final SimpleMessageWithServiceInterfaceDtoInfinityScrollFilteringRepository simpleMessageWithServiceInterfaceDtoInfinityScrollFilteringRepository;

    private final SimpleMessageWithServiceInterfaceDtoInfinityScrollFilteringMapper simpleMessageWithServiceInterfaceDtoInfinityScrollFilteringMapper;

    public SimpleMessageWithServiceInterfaceDtoInfinityScrollFilteringServiceImpl(SimpleMessageWithServiceInterfaceDtoInfinityScrollFilteringRepository simpleMessageWithServiceInterfaceDtoInfinityScrollFilteringRepository, SimpleMessageWithServiceInterfaceDtoInfinityScrollFilteringMapper simpleMessageWithServiceInterfaceDtoInfinityScrollFilteringMapper) {
        this.simpleMessageWithServiceInterfaceDtoInfinityScrollFilteringRepository = simpleMessageWithServiceInterfaceDtoInfinityScrollFilteringRepository;
        this.simpleMessageWithServiceInterfaceDtoInfinityScrollFilteringMapper = simpleMessageWithServiceInterfaceDtoInfinityScrollFilteringMapper;
    }

    /**
     * Save a simpleMessageWithServiceInterfaceDtoInfinityScrollFiltering.
     *
     * @param simpleMessageWithServiceInterfaceDtoInfinityScrollFilteringDTO the entity to save.
     * @return the persisted entity.
     */
    @Override
    public SimpleMessageWithServiceInterfaceDtoInfinityScrollFilteringDTO save(SimpleMessageWithServiceInterfaceDtoInfinityScrollFilteringDTO simpleMessageWithServiceInterfaceDtoInfinityScrollFilteringDTO) {
        log.debug("Request to save SimpleMessageWithServiceInterfaceDtoInfinityScrollFiltering : {}", simpleMessageWithServiceInterfaceDtoInfinityScrollFilteringDTO);
        SimpleMessageWithServiceInterfaceDtoInfinityScrollFiltering simpleMessageWithServiceInterfaceDtoInfinityScrollFiltering = simpleMessageWithServiceInterfaceDtoInfinityScrollFilteringMapper.toEntity(simpleMessageWithServiceInterfaceDtoInfinityScrollFilteringDTO);
        simpleMessageWithServiceInterfaceDtoInfinityScrollFiltering = simpleMessageWithServiceInterfaceDtoInfinityScrollFilteringRepository.save(simpleMessageWithServiceInterfaceDtoInfinityScrollFiltering);
        return simpleMessageWithServiceInterfaceDtoInfinityScrollFilteringMapper.toDto(simpleMessageWithServiceInterfaceDtoInfinityScrollFiltering);
    }

    /**
     * Get all the simpleMessageWithServiceInterfaceDtoInfinityScrollFilterings.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Override
    @Transactional(readOnly = true)
    public Page<SimpleMessageWithServiceInterfaceDtoInfinityScrollFilteringDTO> findAll(Pageable pageable) {
        log.debug("Request to get all SimpleMessageWithServiceInterfaceDtoInfinityScrollFilterings");
        return simpleMessageWithServiceInterfaceDtoInfinityScrollFilteringRepository.findAll(pageable)
            .map(simpleMessageWithServiceInterfaceDtoInfinityScrollFilteringMapper::toDto);
    }

    /**
     * Get one simpleMessageWithServiceInterfaceDtoInfinityScrollFiltering by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<SimpleMessageWithServiceInterfaceDtoInfinityScrollFilteringDTO> findOne(Long id) {
        log.debug("Request to get SimpleMessageWithServiceInterfaceDtoInfinityScrollFiltering : {}", id);
        return simpleMessageWithServiceInterfaceDtoInfinityScrollFilteringRepository.findById(id)
            .map(simpleMessageWithServiceInterfaceDtoInfinityScrollFilteringMapper::toDto);
    }

    /**
     * Delete the simpleMessageWithServiceInterfaceDtoInfinityScrollFiltering by id.
     *
     * @param id the id of the entity.
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete SimpleMessageWithServiceInterfaceDtoInfinityScrollFiltering : {}", id);
        simpleMessageWithServiceInterfaceDtoInfinityScrollFilteringRepository.deleteById(id);
    }
}
