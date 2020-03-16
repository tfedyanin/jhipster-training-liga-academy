package ru.liga.web.rest;

import ru.liga.service.SimpleMessageWithServiceInterfaceDtoService;
import ru.liga.web.rest.errors.BadRequestAlertException;
import ru.liga.service.dto.SimpleMessageWithServiceInterfaceDtoDTO;

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
 * REST controller for managing {@link ru.liga.domain.SimpleMessageWithServiceInterfaceDto}.
 */
@RestController
@RequestMapping("/api")
public class SimpleMessageWithServiceInterfaceDtoResource {

    private final Logger log = LoggerFactory.getLogger(SimpleMessageWithServiceInterfaceDtoResource.class);

    private static final String ENTITY_NAME = "simpleMessageWithServiceInterfaceDto";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final SimpleMessageWithServiceInterfaceDtoService simpleMessageWithServiceInterfaceDtoService;

    public SimpleMessageWithServiceInterfaceDtoResource(SimpleMessageWithServiceInterfaceDtoService simpleMessageWithServiceInterfaceDtoService) {
        this.simpleMessageWithServiceInterfaceDtoService = simpleMessageWithServiceInterfaceDtoService;
    }

    /**
     * {@code POST  /simple-message-with-service-interface-dtos} : Create a new simpleMessageWithServiceInterfaceDto.
     *
     * @param simpleMessageWithServiceInterfaceDtoDTO the simpleMessageWithServiceInterfaceDtoDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new simpleMessageWithServiceInterfaceDtoDTO, or with status {@code 400 (Bad Request)} if the simpleMessageWithServiceInterfaceDto has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/simple-message-with-service-interface-dtos")
    public ResponseEntity<SimpleMessageWithServiceInterfaceDtoDTO> createSimpleMessageWithServiceInterfaceDto(@RequestBody SimpleMessageWithServiceInterfaceDtoDTO simpleMessageWithServiceInterfaceDtoDTO) throws URISyntaxException {
        log.debug("REST request to save SimpleMessageWithServiceInterfaceDto : {}", simpleMessageWithServiceInterfaceDtoDTO);
        if (simpleMessageWithServiceInterfaceDtoDTO.getId() != null) {
            throw new BadRequestAlertException("A new simpleMessageWithServiceInterfaceDto cannot already have an ID", ENTITY_NAME, "idexists");
        }
        SimpleMessageWithServiceInterfaceDtoDTO result = simpleMessageWithServiceInterfaceDtoService.save(simpleMessageWithServiceInterfaceDtoDTO);
        return ResponseEntity.created(new URI("/api/simple-message-with-service-interface-dtos/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /simple-message-with-service-interface-dtos} : Updates an existing simpleMessageWithServiceInterfaceDto.
     *
     * @param simpleMessageWithServiceInterfaceDtoDTO the simpleMessageWithServiceInterfaceDtoDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated simpleMessageWithServiceInterfaceDtoDTO,
     * or with status {@code 400 (Bad Request)} if the simpleMessageWithServiceInterfaceDtoDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the simpleMessageWithServiceInterfaceDtoDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/simple-message-with-service-interface-dtos")
    public ResponseEntity<SimpleMessageWithServiceInterfaceDtoDTO> updateSimpleMessageWithServiceInterfaceDto(@RequestBody SimpleMessageWithServiceInterfaceDtoDTO simpleMessageWithServiceInterfaceDtoDTO) throws URISyntaxException {
        log.debug("REST request to update SimpleMessageWithServiceInterfaceDto : {}", simpleMessageWithServiceInterfaceDtoDTO);
        if (simpleMessageWithServiceInterfaceDtoDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        SimpleMessageWithServiceInterfaceDtoDTO result = simpleMessageWithServiceInterfaceDtoService.save(simpleMessageWithServiceInterfaceDtoDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, simpleMessageWithServiceInterfaceDtoDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /simple-message-with-service-interface-dtos} : get all the simpleMessageWithServiceInterfaceDtos.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of simpleMessageWithServiceInterfaceDtos in body.
     */
    @GetMapping("/simple-message-with-service-interface-dtos")
    public List<SimpleMessageWithServiceInterfaceDtoDTO> getAllSimpleMessageWithServiceInterfaceDtos() {
        log.debug("REST request to get all SimpleMessageWithServiceInterfaceDtos");
        return simpleMessageWithServiceInterfaceDtoService.findAll();
    }

    /**
     * {@code GET  /simple-message-with-service-interface-dtos/:id} : get the "id" simpleMessageWithServiceInterfaceDto.
     *
     * @param id the id of the simpleMessageWithServiceInterfaceDtoDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the simpleMessageWithServiceInterfaceDtoDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/simple-message-with-service-interface-dtos/{id}")
    public ResponseEntity<SimpleMessageWithServiceInterfaceDtoDTO> getSimpleMessageWithServiceInterfaceDto(@PathVariable Long id) {
        log.debug("REST request to get SimpleMessageWithServiceInterfaceDto : {}", id);
        Optional<SimpleMessageWithServiceInterfaceDtoDTO> simpleMessageWithServiceInterfaceDtoDTO = simpleMessageWithServiceInterfaceDtoService.findOne(id);
        return ResponseUtil.wrapOrNotFound(simpleMessageWithServiceInterfaceDtoDTO);
    }

    /**
     * {@code DELETE  /simple-message-with-service-interface-dtos/:id} : delete the "id" simpleMessageWithServiceInterfaceDto.
     *
     * @param id the id of the simpleMessageWithServiceInterfaceDtoDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/simple-message-with-service-interface-dtos/{id}")
    public ResponseEntity<Void> deleteSimpleMessageWithServiceInterfaceDto(@PathVariable Long id) {
        log.debug("REST request to delete SimpleMessageWithServiceInterfaceDto : {}", id);
        simpleMessageWithServiceInterfaceDtoService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString())).build();
    }
}
