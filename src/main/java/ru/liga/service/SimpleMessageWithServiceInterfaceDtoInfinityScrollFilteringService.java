package ru.liga.service;

import ru.liga.service.dto.SimpleMessageWithServiceInterfaceDtoInfinityScrollFilteringDTO;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * Service Interface for managing {@link ru.liga.domain.SimpleMessageWithServiceInterfaceDtoInfinityScrollFiltering}.
 */
public interface SimpleMessageWithServiceInterfaceDtoInfinityScrollFilteringService {

    /**
     * Save a simpleMessageWithServiceInterfaceDtoInfinityScrollFiltering.
     *
     * @param simpleMessageWithServiceInterfaceDtoInfinityScrollFilteringDTO the entity to save.
     * @return the persisted entity.
     */
    SimpleMessageWithServiceInterfaceDtoInfinityScrollFilteringDTO save(SimpleMessageWithServiceInterfaceDtoInfinityScrollFilteringDTO simpleMessageWithServiceInterfaceDtoInfinityScrollFilteringDTO);

    /**
     * Get all the simpleMessageWithServiceInterfaceDtoInfinityScrollFilterings.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<SimpleMessageWithServiceInterfaceDtoInfinityScrollFilteringDTO> findAll(Pageable pageable);

    /**
     * Get the "id" simpleMessageWithServiceInterfaceDtoInfinityScrollFiltering.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<SimpleMessageWithServiceInterfaceDtoInfinityScrollFilteringDTO> findOne(Long id);

    /**
     * Delete the "id" simpleMessageWithServiceInterfaceDtoInfinityScrollFiltering.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
