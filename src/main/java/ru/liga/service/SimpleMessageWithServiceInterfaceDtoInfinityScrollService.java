package ru.liga.service;

import ru.liga.service.dto.SimpleMessageWithServiceInterfaceDtoInfinityScrollDTO;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * Service Interface for managing {@link ru.liga.domain.SimpleMessageWithServiceInterfaceDtoInfinityScroll}.
 */
public interface SimpleMessageWithServiceInterfaceDtoInfinityScrollService {

    /**
     * Save a simpleMessageWithServiceInterfaceDtoInfinityScroll.
     *
     * @param simpleMessageWithServiceInterfaceDtoInfinityScrollDTO the entity to save.
     * @return the persisted entity.
     */
    SimpleMessageWithServiceInterfaceDtoInfinityScrollDTO save(SimpleMessageWithServiceInterfaceDtoInfinityScrollDTO simpleMessageWithServiceInterfaceDtoInfinityScrollDTO);

    /**
     * Get all the simpleMessageWithServiceInterfaceDtoInfinityScrolls.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<SimpleMessageWithServiceInterfaceDtoInfinityScrollDTO> findAll(Pageable pageable);

    /**
     * Get the "id" simpleMessageWithServiceInterfaceDtoInfinityScroll.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<SimpleMessageWithServiceInterfaceDtoInfinityScrollDTO> findOne(Long id);

    /**
     * Delete the "id" simpleMessageWithServiceInterfaceDtoInfinityScroll.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
