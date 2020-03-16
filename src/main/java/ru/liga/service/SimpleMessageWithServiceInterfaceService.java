package ru.liga.service;

import ru.liga.domain.SimpleMessageWithServiceInterface;

import java.util.List;
import java.util.Optional;

/**
 * Service Interface for managing {@link SimpleMessageWithServiceInterface}.
 */
public interface SimpleMessageWithServiceInterfaceService {

    /**
     * Save a simpleMessageWithServiceInterface.
     *
     * @param simpleMessageWithServiceInterface the entity to save.
     * @return the persisted entity.
     */
    SimpleMessageWithServiceInterface save(SimpleMessageWithServiceInterface simpleMessageWithServiceInterface);

    /**
     * Get all the simpleMessageWithServiceInterfaces.
     *
     * @return the list of entities.
     */
    List<SimpleMessageWithServiceInterface> findAll();

    /**
     * Get the "id" simpleMessageWithServiceInterface.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<SimpleMessageWithServiceInterface> findOne(Long id);

    /**
     * Delete the "id" simpleMessageWithServiceInterface.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
