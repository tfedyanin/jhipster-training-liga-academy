package ru.liga.web.rest;

import ru.liga.domain.SimpleMessage;
import ru.liga.repository.SimpleMessageRepository;
import ru.liga.web.rest.errors.BadRequestAlertException;

import io.github.jhipster.web.util.HeaderUtil;
import io.github.jhipster.web.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing {@link ru.liga.domain.SimpleMessage}.
 */
@RestController
@RequestMapping("/api")
@Transactional
public class SimpleMessageResource {

    private final Logger log = LoggerFactory.getLogger(SimpleMessageResource.class);

    private static final String ENTITY_NAME = "simpleMessage";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final SimpleMessageRepository simpleMessageRepository;

    public SimpleMessageResource(SimpleMessageRepository simpleMessageRepository) {
        this.simpleMessageRepository = simpleMessageRepository;
    }

    /**
     * {@code POST  /simple-messages} : Create a new simpleMessage.
     *
     * @param simpleMessage the simpleMessage to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new simpleMessage, or with status {@code 400 (Bad Request)} if the simpleMessage has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/simple-messages")
    public ResponseEntity<SimpleMessage> createSimpleMessage(@RequestBody SimpleMessage simpleMessage) throws URISyntaxException {
        log.debug("REST request to save SimpleMessage : {}", simpleMessage);
        if (simpleMessage.getId() != null) {
            throw new BadRequestAlertException("A new simpleMessage cannot already have an ID", ENTITY_NAME, "idexists");
        }
        SimpleMessage result = simpleMessageRepository.save(simpleMessage);
        return ResponseEntity.created(new URI("/api/simple-messages/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /simple-messages} : Updates an existing simpleMessage.
     *
     * @param simpleMessage the simpleMessage to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated simpleMessage,
     * or with status {@code 400 (Bad Request)} if the simpleMessage is not valid,
     * or with status {@code 500 (Internal Server Error)} if the simpleMessage couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/simple-messages")
    public ResponseEntity<SimpleMessage> updateSimpleMessage(@RequestBody SimpleMessage simpleMessage) throws URISyntaxException {
        log.debug("REST request to update SimpleMessage : {}", simpleMessage);
        if (simpleMessage.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        SimpleMessage result = simpleMessageRepository.save(simpleMessage);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, simpleMessage.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /simple-messages} : get all the simpleMessages.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of simpleMessages in body.
     */
    @GetMapping("/simple-messages")
    public List<SimpleMessage> getAllSimpleMessages() {
        log.debug("REST request to get all SimpleMessages");
        return simpleMessageRepository.findAll();
    }

    /**
     * {@code GET  /simple-messages/:id} : get the "id" simpleMessage.
     *
     * @param id the id of the simpleMessage to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the simpleMessage, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/simple-messages/{id}")
    public ResponseEntity<SimpleMessage> getSimpleMessage(@PathVariable Long id) {
        log.debug("REST request to get SimpleMessage : {}", id);
        Optional<SimpleMessage> simpleMessage = simpleMessageRepository.findById(id);
        return ResponseUtil.wrapOrNotFound(simpleMessage);
    }

    /**
     * {@code DELETE  /simple-messages/:id} : delete the "id" simpleMessage.
     *
     * @param id the id of the simpleMessage to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/simple-messages/{id}")
    public ResponseEntity<Void> deleteSimpleMessage(@PathVariable Long id) {
        log.debug("REST request to delete SimpleMessage : {}", id);
        simpleMessageRepository.deleteById(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString())).build();
    }
}
