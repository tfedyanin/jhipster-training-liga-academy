package ru.liga.service;

import ru.liga.service.dto.SimpleMessageWithServiceInterfaceDtoDTO;

import java.util.List;
import java.util.Optional;

/**
 * Service Interface for managing {@link ru.liga.domain.SimpleMessageWithServiceInterfaceDto}.
 */
public interface SimpleMessageWithServiceInterfaceDtoService {

    /**
     * Save a simpleMessageWithServiceInterfaceDto.
     *
     * @param simpleMessageWithServiceInterfaceDtoDTO the entity to save.
     * @return the persisted entity.
     */
    SimpleMessageWithServiceInterfaceDtoDTO save(SimpleMessageWithServiceInterfaceDtoDTO simpleMessageWithServiceInterfaceDtoDTO);

    /**
     * Get all the simpleMessageWithServiceInterfaceDtos.
     *
     * @return the list of entities.
     */
    List<SimpleMessageWithServiceInterfaceDtoDTO> findAll();

    /**
     * Get the "id" simpleMessageWithServiceInterfaceDto.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<SimpleMessageWithServiceInterfaceDtoDTO> findOne(Long id);

    /**
     * Delete the "id" simpleMessageWithServiceInterfaceDto.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
