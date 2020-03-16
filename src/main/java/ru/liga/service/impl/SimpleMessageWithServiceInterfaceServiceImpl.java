package ru.liga.service.impl;

import ru.liga.service.SimpleMessageWithServiceInterfaceService;
import ru.liga.domain.SimpleMessageWithServiceInterface;
import ru.liga.repository.SimpleMessageWithServiceInterfaceRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * Service Implementation for managing {@link SimpleMessageWithServiceInterface}.
 */
@Service
@Transactional
public class SimpleMessageWithServiceInterfaceServiceImpl implements SimpleMessageWithServiceInterfaceService {

    private final Logger log = LoggerFactory.getLogger(SimpleMessageWithServiceInterfaceServiceImpl.class);

    private final SimpleMessageWithServiceInterfaceRepository simpleMessageWithServiceInterfaceRepository;

    public SimpleMessageWithServiceInterfaceServiceImpl(SimpleMessageWithServiceInterfaceRepository simpleMessageWithServiceInterfaceRepository) {
        this.simpleMessageWithServiceInterfaceRepository = simpleMessageWithServiceInterfaceRepository;
    }

    /**
     * Save a simpleMessageWithServiceInterface.
     *
     * @param simpleMessageWithServiceInterface the entity to save.
     * @return the persisted entity.
     */
    @Override
    public SimpleMessageWithServiceInterface save(SimpleMessageWithServiceInterface simpleMessageWithServiceInterface) {
        log.debug("Request to save SimpleMessageWithServiceInterface : {}", simpleMessageWithServiceInterface);
        return simpleMessageWithServiceInterfaceRepository.save(simpleMessageWithServiceInterface);
    }

    /**
     * Get all the simpleMessageWithServiceInterfaces.
     *
     * @return the list of entities.
     */
    @Override
    @Transactional(readOnly = true)
    public List<SimpleMessageWithServiceInterface> findAll() {
        log.debug("Request to get all SimpleMessageWithServiceInterfaces");
        return simpleMessageWithServiceInterfaceRepository.findAll();
    }

    /**
     * Get one simpleMessageWithServiceInterface by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<SimpleMessageWithServiceInterface> findOne(Long id) {
        log.debug("Request to get SimpleMessageWithServiceInterface : {}", id);
        return simpleMessageWithServiceInterfaceRepository.findById(id);
    }

    /**
     * Delete the simpleMessageWithServiceInterface by id.
     *
     * @param id the id of the entity.
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete SimpleMessageWithServiceInterface : {}", id);
        simpleMessageWithServiceInterfaceRepository.deleteById(id);
    }
}
