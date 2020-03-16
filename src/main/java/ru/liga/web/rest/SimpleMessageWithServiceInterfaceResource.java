package ru.liga.web.rest;

import ru.liga.domain.SimpleMessageWithServiceInterface;
import ru.liga.service.SimpleMessageWithServiceInterfaceService;
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
 * REST controller for managing {@link ru.liga.domain.SimpleMessageWithServiceInterface}.
 */
@RestController
@RequestMapping("/api")
public class SimpleMessageWithServiceInterfaceResource {

    private final Logger log = LoggerFactory.getLogger(SimpleMessageWithServiceInterfaceResource.class);

    private static final String ENTITY_NAME = "simpleMessageWithServiceInterface";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final SimpleMessageWithServiceInterfaceService simpleMessageWithServiceInterfaceService;

    public SimpleMessageWithServiceInterfaceResource(SimpleMessageWithServiceInterfaceService simpleMessageWithServiceInterfaceService) {
        this.simpleMessageWithServiceInterfaceService = simpleMessageWithServiceInterfaceService;
    }

    /**
     * {@code POST  /simple-message-with-service-interfaces} : Create a new simpleMessageWithServiceInterface.
     *
     * @param simpleMessageWithServiceInterface the simpleMessageWithServiceInterface to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new simpleMessageWithServiceInterface, or with status {@code 400 (Bad Request)} if the simpleMessageWithServiceInterface has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/simple-message-with-service-interfaces")
    public ResponseEntity<SimpleMessageWithServiceInterface> createSimpleMessageWithServiceInterface(@RequestBody SimpleMessageWithServiceInterface simpleMessageWithServiceInterface) throws URISyntaxException {
        log.debug("REST request to save SimpleMessageWithServiceInterface : {}", simpleMessageWithServiceInterface);
        if (simpleMessageWithServiceInterface.getId() != null) {
            throw new BadRequestAlertException("A new simpleMessageWithServiceInterface cannot already have an ID", ENTITY_NAME, "idexists");
        }
        SimpleMessageWithServiceInterface result = simpleMessageWithServiceInterfaceService.save(simpleMessageWithServiceInterface);
        return ResponseEntity.created(new URI("/api/simple-message-with-service-interfaces/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /simple-message-with-service-interfaces} : Updates an existing simpleMessageWithServiceInterface.
     *
     * @param simpleMessageWithServiceInterface the simpleMessageWithServiceInterface to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated simpleMessageWithServiceInterface,
     * or with status {@code 400 (Bad Request)} if the simpleMessageWithServiceInterface is not valid,
     * or with status {@code 500 (Internal Server Error)} if the simpleMessageWithServiceInterface couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/simple-message-with-service-interfaces")
    public ResponseEntity<SimpleMessageWithServiceInterface> updateSimpleMessageWithServiceInterface(@RequestBody SimpleMessageWithServiceInterface simpleMessageWithServiceInterface) throws URISyntaxException {
        log.debug("REST request to update SimpleMessageWithServiceInterface : {}", simpleMessageWithServiceInterface);
        if (simpleMessageWithServiceInterface.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        SimpleMessageWithServiceInterface result = simpleMessageWithServiceInterfaceService.save(simpleMessageWithServiceInterface);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, simpleMessageWithServiceInterface.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /simple-message-with-service-interfaces} : get all the simpleMessageWithServiceInterfaces.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of simpleMessageWithServiceInterfaces in body.
     */
    @GetMapping("/simple-message-with-service-interfaces")
    public List<SimpleMessageWithServiceInterface> getAllSimpleMessageWithServiceInterfaces() {
        log.debug("REST request to get all SimpleMessageWithServiceInterfaces");
        return simpleMessageWithServiceInterfaceService.findAll();
    }

    /**
     * {@code GET  /simple-message-with-service-interfaces/:id} : get the "id" simpleMessageWithServiceInterface.
     *
     * @param id the id of the simpleMessageWithServiceInterface to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the simpleMessageWithServiceInterface, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/simple-message-with-service-interfaces/{id}")
    public ResponseEntity<SimpleMessageWithServiceInterface> getSimpleMessageWithServiceInterface(@PathVariable Long id) {
        log.debug("REST request to get SimpleMessageWithServiceInterface : {}", id);
        Optional<SimpleMessageWithServiceInterface> simpleMessageWithServiceInterface = simpleMessageWithServiceInterfaceService.findOne(id);
        return ResponseUtil.wrapOrNotFound(simpleMessageWithServiceInterface);
    }

    /**
     * {@code DELETE  /simple-message-with-service-interfaces/:id} : delete the "id" simpleMessageWithServiceInterface.
     *
     * @param id the id of the simpleMessageWithServiceInterface to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/simple-message-with-service-interfaces/{id}")
    public ResponseEntity<Void> deleteSimpleMessageWithServiceInterface(@PathVariable Long id) {
        log.debug("REST request to delete SimpleMessageWithServiceInterface : {}", id);
        simpleMessageWithServiceInterfaceService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString())).build();
    }
}
