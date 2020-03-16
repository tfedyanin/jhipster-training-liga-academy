package ru.liga.web.rest;

import ru.liga.domain.SimpleMessageWithService;
import ru.liga.service.SimpleMessageWithServiceService;
import ru.liga.web.rest.errors.BadRequestAlertException;

import io.github.jhipster.web.util.HeaderUtil;
import io.github.jhipster.web.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing {@link ru.liga.domain.SimpleMessageWithService}.
 */
@RestController
@RequestMapping("/api")
public class SimpleMessageWithServiceResource {

    private final Logger log = LoggerFactory.getLogger(SimpleMessageWithServiceResource.class);

    private static final String ENTITY_NAME = "simpleMessageWithService";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final SimpleMessageWithServiceService simpleMessageWithServiceService;

    public SimpleMessageWithServiceResource(SimpleMessageWithServiceService simpleMessageWithServiceService) {
        this.simpleMessageWithServiceService = simpleMessageWithServiceService;
    }

    /**
     * {@code POST  /simple-message-with-services} : Create a new simpleMessageWithService.
     *
     * @param simpleMessageWithService the simpleMessageWithService to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new simpleMessageWithService, or with status {@code 400 (Bad Request)} if the simpleMessageWithService has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/simple-message-with-services")
    public ResponseEntity<SimpleMessageWithService> createSimpleMessageWithService(@RequestBody SimpleMessageWithService simpleMessageWithService) throws URISyntaxException {
        log.debug("REST request to save SimpleMessageWithService : {}", simpleMessageWithService);
        if (simpleMessageWithService.getId() != null) {
            throw new BadRequestAlertException("A new simpleMessageWithService cannot already have an ID", ENTITY_NAME, "idexists");
        }
        SimpleMessageWithService result = simpleMessageWithServiceService.save(simpleMessageWithService);
        return ResponseEntity.created(new URI("/api/simple-message-with-services/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /simple-message-with-services} : Updates an existing simpleMessageWithService.
     *
     * @param simpleMessageWithService the simpleMessageWithService to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated simpleMessageWithService,
     * or with status {@code 400 (Bad Request)} if the simpleMessageWithService is not valid,
     * or with status {@code 500 (Internal Server Error)} if the simpleMessageWithService couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/simple-message-with-services")
    public ResponseEntity<SimpleMessageWithService> updateSimpleMessageWithService(@RequestBody SimpleMessageWithService simpleMessageWithService) throws URISyntaxException {
        log.debug("REST request to update SimpleMessageWithService : {}", simpleMessageWithService);
        if (simpleMessageWithService.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        SimpleMessageWithService result = simpleMessageWithServiceService.save(simpleMessageWithService);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, simpleMessageWithService.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /simple-message-with-services} : get all the simpleMessageWithServices.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of simpleMessageWithServices in body.
     */
    @GetMapping("/simple-message-with-services")
    public List<SimpleMessageWithService> getAllSimpleMessageWithServices() {
        log.debug("REST request to get all SimpleMessageWithServices");
        return simpleMessageWithServiceService.findAll();
    }

    /**
     * {@code GET  /simple-message-with-services/:id} : get the "id" simpleMessageWithService.
     *
     * @param id the id of the simpleMessageWithService to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the simpleMessageWithService, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/simple-message-with-services/{id}")
    public ResponseEntity<SimpleMessageWithService> getSimpleMessageWithService(@PathVariable Long id) {
        log.debug("REST request to get SimpleMessageWithService : {}", id);
        Optional<SimpleMessageWithService> simpleMessageWithService = simpleMessageWithServiceService.findOne(id);
        return ResponseUtil.wrapOrNotFound(simpleMessageWithService);
    }

    /**
     * {@code DELETE  /simple-message-with-services/:id} : delete the "id" simpleMessageWithService.
     *
     * @param id the id of the simpleMessageWithService to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/simple-message-with-services/{id}")
    public ResponseEntity<Void> deleteSimpleMessageWithService(@PathVariable Long id) {
        log.debug("REST request to delete SimpleMessageWithService : {}", id);
        simpleMessageWithServiceService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString())).build();
    }
}
