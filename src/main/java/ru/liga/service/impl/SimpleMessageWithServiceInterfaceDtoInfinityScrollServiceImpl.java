package ru.liga.service.impl;

import ru.liga.service.SimpleMessageWithServiceInterfaceDtoInfinityScrollService;
import ru.liga.domain.SimpleMessageWithServiceInterfaceDtoInfinityScroll;
import ru.liga.repository.SimpleMessageWithServiceInterfaceDtoInfinityScrollRepository;
import ru.liga.service.dto.SimpleMessageWithServiceInterfaceDtoInfinityScrollDTO;
import ru.liga.service.mapper.SimpleMessageWithServiceInterfaceDtoInfinityScrollMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link SimpleMessageWithServiceInterfaceDtoInfinityScroll}.
 */
@Service
@Transactional
public class SimpleMessageWithServiceInterfaceDtoInfinityScrollServiceImpl implements SimpleMessageWithServiceInterfaceDtoInfinityScrollService {

    private final Logger log = LoggerFactory.getLogger(SimpleMessageWithServiceInterfaceDtoInfinityScrollServiceImpl.class);

    private final SimpleMessageWithServiceInterfaceDtoInfinityScrollRepository simpleMessageWithServiceInterfaceDtoInfinityScrollRepository;

    private final SimpleMessageWithServiceInterfaceDtoInfinityScrollMapper simpleMessageWithServiceInterfaceDtoInfinityScrollMapper;

    public SimpleMessageWithServiceInterfaceDtoInfinityScrollServiceImpl(SimpleMessageWithServiceInterfaceDtoInfinityScrollRepository simpleMessageWithServiceInterfaceDtoInfinityScrollRepository, SimpleMessageWithServiceInterfaceDtoInfinityScrollMapper simpleMessageWithServiceInterfaceDtoInfinityScrollMapper) {
        this.simpleMessageWithServiceInterfaceDtoInfinityScrollRepository = simpleMessageWithServiceInterfaceDtoInfinityScrollRepository;
        this.simpleMessageWithServiceInterfaceDtoInfinityScrollMapper = simpleMessageWithServiceInterfaceDtoInfinityScrollMapper;
    }

    /**
     * Save a simpleMessageWithServiceInterfaceDtoInfinityScroll.
     *
     * @param simpleMessageWithServiceInterfaceDtoInfinityScrollDTO the entity to save.
     * @return the persisted entity.
     */
    @Override
    public SimpleMessageWithServiceInterfaceDtoInfinityScrollDTO save(SimpleMessageWithServiceInterfaceDtoInfinityScrollDTO simpleMessageWithServiceInterfaceDtoInfinityScrollDTO) {
        log.debug("Request to save SimpleMessageWithServiceInterfaceDtoInfinityScroll : {}", simpleMessageWithServiceInterfaceDtoInfinityScrollDTO);
        SimpleMessageWithServiceInterfaceDtoInfinityScroll simpleMessageWithServiceInterfaceDtoInfinityScroll = simpleMessageWithServiceInterfaceDtoInfinityScrollMapper.toEntity(simpleMessageWithServiceInterfaceDtoInfinityScrollDTO);
        simpleMessageWithServiceInterfaceDtoInfinityScroll = simpleMessageWithServiceInterfaceDtoInfinityScrollRepository.save(simpleMessageWithServiceInterfaceDtoInfinityScroll);
        return simpleMessageWithServiceInterfaceDtoInfinityScrollMapper.toDto(simpleMessageWithServiceInterfaceDtoInfinityScroll);
    }

    /**
     * Get all the simpleMessageWithServiceInterfaceDtoInfinityScrolls.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Override
    @Transactional(readOnly = true)
    public Page<SimpleMessageWithServiceInterfaceDtoInfinityScrollDTO> findAll(Pageable pageable) {
        log.debug("Request to get all SimpleMessageWithServiceInterfaceDtoInfinityScrolls");
        return simpleMessageWithServiceInterfaceDtoInfinityScrollRepository.findAll(pageable)
            .map(simpleMessageWithServiceInterfaceDtoInfinityScrollMapper::toDto);
    }

    /**
     * Get one simpleMessageWithServiceInterfaceDtoInfinityScroll by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<SimpleMessageWithServiceInterfaceDtoInfinityScrollDTO> findOne(Long id) {
        log.debug("Request to get SimpleMessageWithServiceInterfaceDtoInfinityScroll : {}", id);
        return simpleMessageWithServiceInterfaceDtoInfinityScrollRepository.findById(id)
            .map(simpleMessageWithServiceInterfaceDtoInfinityScrollMapper::toDto);
    }

    /**
     * Delete the simpleMessageWithServiceInterfaceDtoInfinityScroll by id.
     *
     * @param id the id of the entity.
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete SimpleMessageWithServiceInterfaceDtoInfinityScroll : {}", id);
        simpleMessageWithServiceInterfaceDtoInfinityScrollRepository.deleteById(id);
    }
}
