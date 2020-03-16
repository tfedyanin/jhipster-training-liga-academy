package ru.liga.service;

import ru.liga.domain.SimpleMessageWithService;
import ru.liga.repository.SimpleMessageWithServiceRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * Service Implementation for managing {@link SimpleMessageWithService}.
 */
@Service
@Transactional
public class SimpleMessageWithServiceService {

    private final Logger log = LoggerFactory.getLogger(SimpleMessageWithServiceService.class);

    private final SimpleMessageWithServiceRepository simpleMessageWithServiceRepository;

    public SimpleMessageWithServiceService(SimpleMessageWithServiceRepository simpleMessageWithServiceRepository) {
        this.simpleMessageWithServiceRepository = simpleMessageWithServiceRepository;
    }

    /**
     * Save a simpleMessageWithService.
     *
     * @param simpleMessageWithService the entity to save.
     * @return the persisted entity.
     */
    public SimpleMessageWithService save(SimpleMessageWithService simpleMessageWithService) {
        log.debug("Request to save SimpleMessageWithService : {}", simpleMessageWithService);
        return simpleMessageWithServiceRepository.save(simpleMessageWithService);
    }

    /**
     * Get all the simpleMessageWithServices.
     *
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public List<SimpleMessageWithService> findAll() {
        log.debug("Request to get all SimpleMessageWithServices");
        return simpleMessageWithServiceRepository.findAll();
    }

    /**
     * Get one simpleMessageWithService by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<SimpleMessageWithService> findOne(Long id) {
        log.debug("Request to get SimpleMessageWithService : {}", id);
        return simpleMessageWithServiceRepository.findById(id);
    }

    /**
     * Delete the simpleMessageWithService by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete SimpleMessageWithService : {}", id);
        simpleMessageWithServiceRepository.deleteById(id);
    }
}
