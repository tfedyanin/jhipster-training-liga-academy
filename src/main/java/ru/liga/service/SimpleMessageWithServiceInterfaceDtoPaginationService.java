package ru.liga.service;

import ru.liga.service.dto.SimpleMessageWithServiceInterfaceDtoPaginationDTO;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * Service Interface for managing {@link ru.liga.domain.SimpleMessageWithServiceInterfaceDtoPagination}.
 */
public interface SimpleMessageWithServiceInterfaceDtoPaginationService {

    /**
     * Save a simpleMessageWithServiceInterfaceDtoPagination.
     *
     * @param simpleMessageWithServiceInterfaceDtoPaginationDTO the entity to save.
     * @return the persisted entity.
     */
    SimpleMessageWithServiceInterfaceDtoPaginationDTO save(SimpleMessageWithServiceInterfaceDtoPaginationDTO simpleMessageWithServiceInterfaceDtoPaginationDTO);

    /**
     * Get all the simpleMessageWithServiceInterfaceDtoPaginations.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<SimpleMessageWithServiceInterfaceDtoPaginationDTO> findAll(Pageable pageable);

    /**
     * Get the "id" simpleMessageWithServiceInterfaceDtoPagination.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<SimpleMessageWithServiceInterfaceDtoPaginationDTO> findOne(Long id);

    /**
     * Delete the "id" simpleMessageWithServiceInterfaceDtoPagination.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
