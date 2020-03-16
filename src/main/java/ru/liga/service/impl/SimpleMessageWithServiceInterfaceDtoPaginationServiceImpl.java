package ru.liga.service.impl;

import ru.liga.service.SimpleMessageWithServiceInterfaceDtoPaginationService;
import ru.liga.domain.SimpleMessageWithServiceInterfaceDtoPagination;
import ru.liga.repository.SimpleMessageWithServiceInterfaceDtoPaginationRepository;
import ru.liga.service.dto.SimpleMessageWithServiceInterfaceDtoPaginationDTO;
import ru.liga.service.mapper.SimpleMessageWithServiceInterfaceDtoPaginationMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link SimpleMessageWithServiceInterfaceDtoPagination}.
 */
@Service
@Transactional
public class SimpleMessageWithServiceInterfaceDtoPaginationServiceImpl implements SimpleMessageWithServiceInterfaceDtoPaginationService {

    private final Logger log = LoggerFactory.getLogger(SimpleMessageWithServiceInterfaceDtoPaginationServiceImpl.class);

    private final SimpleMessageWithServiceInterfaceDtoPaginationRepository simpleMessageWithServiceInterfaceDtoPaginationRepository;

    private final SimpleMessageWithServiceInterfaceDtoPaginationMapper simpleMessageWithServiceInterfaceDtoPaginationMapper;

    public SimpleMessageWithServiceInterfaceDtoPaginationServiceImpl(SimpleMessageWithServiceInterfaceDtoPaginationRepository simpleMessageWithServiceInterfaceDtoPaginationRepository, SimpleMessageWithServiceInterfaceDtoPaginationMapper simpleMessageWithServiceInterfaceDtoPaginationMapper) {
        this.simpleMessageWithServiceInterfaceDtoPaginationRepository = simpleMessageWithServiceInterfaceDtoPaginationRepository;
        this.simpleMessageWithServiceInterfaceDtoPaginationMapper = simpleMessageWithServiceInterfaceDtoPaginationMapper;
    }

    /**
     * Save a simpleMessageWithServiceInterfaceDtoPagination.
     *
     * @param simpleMessageWithServiceInterfaceDtoPaginationDTO the entity to save.
     * @return the persisted entity.
     */
    @Override
    public SimpleMessageWithServiceInterfaceDtoPaginationDTO save(SimpleMessageWithServiceInterfaceDtoPaginationDTO simpleMessageWithServiceInterfaceDtoPaginationDTO) {
        log.debug("Request to save SimpleMessageWithServiceInterfaceDtoPagination : {}", simpleMessageWithServiceInterfaceDtoPaginationDTO);
        SimpleMessageWithServiceInterfaceDtoPagination simpleMessageWithServiceInterfaceDtoPagination = simpleMessageWithServiceInterfaceDtoPaginationMapper.toEntity(simpleMessageWithServiceInterfaceDtoPaginationDTO);
        simpleMessageWithServiceInterfaceDtoPagination = simpleMessageWithServiceInterfaceDtoPaginationRepository.save(simpleMessageWithServiceInterfaceDtoPagination);
        return simpleMessageWithServiceInterfaceDtoPaginationMapper.toDto(simpleMessageWithServiceInterfaceDtoPagination);
    }

    /**
     * Get all the simpleMessageWithServiceInterfaceDtoPaginations.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Override
    @Transactional(readOnly = true)
    public Page<SimpleMessageWithServiceInterfaceDtoPaginationDTO> findAll(Pageable pageable) {
        log.debug("Request to get all SimpleMessageWithServiceInterfaceDtoPaginations");
        return simpleMessageWithServiceInterfaceDtoPaginationRepository.findAll(pageable)
            .map(simpleMessageWithServiceInterfaceDtoPaginationMapper::toDto);
    }

    /**
     * Get one simpleMessageWithServiceInterfaceDtoPagination by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<SimpleMessageWithServiceInterfaceDtoPaginationDTO> findOne(Long id) {
        log.debug("Request to get SimpleMessageWithServiceInterfaceDtoPagination : {}", id);
        return simpleMessageWithServiceInterfaceDtoPaginationRepository.findById(id)
            .map(simpleMessageWithServiceInterfaceDtoPaginationMapper::toDto);
    }

    /**
     * Delete the simpleMessageWithServiceInterfaceDtoPagination by id.
     *
     * @param id the id of the entity.
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete SimpleMessageWithServiceInterfaceDtoPagination : {}", id);
        simpleMessageWithServiceInterfaceDtoPaginationRepository.deleteById(id);
    }
}
