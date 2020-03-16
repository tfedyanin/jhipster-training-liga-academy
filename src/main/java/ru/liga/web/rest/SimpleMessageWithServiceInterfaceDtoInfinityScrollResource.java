package ru.liga.web.rest;

import ru.liga.service.SimpleMessageWithServiceInterfaceDtoInfinityScrollService;
import ru.liga.web.rest.errors.BadRequestAlertException;
import ru.liga.service.dto.SimpleMessageWithServiceInterfaceDtoInfinityScrollDTO;

import io.github.jhipster.web.util.HeaderUtil;
import io.github.jhipster.web.util.PaginationUtil;
import io.github.jhipster.web.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing {@link ru.liga.domain.SimpleMessageWithServiceInterfaceDtoInfinityScroll}.
 */
@RestController
@RequestMapping("/api")
public class SimpleMessageWithServiceInterfaceDtoInfinityScrollResource {

    private final Logger log = LoggerFactory.getLogger(SimpleMessageWithServiceInterfaceDtoInfinityScrollResource.class);

    private static final String ENTITY_NAME = "simpleMessageWithServiceInterfaceDtoInfinityScroll";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final SimpleMessageWithServiceInterfaceDtoInfinityScrollService simpleMessageWithServiceInterfaceDtoInfinityScrollService;

    public SimpleMessageWithServiceInterfaceDtoInfinityScrollResource(SimpleMessageWithServiceInterfaceDtoInfinityScrollService simpleMessageWithServiceInterfaceDtoInfinityScrollService) {
        this.simpleMessageWithServiceInterfaceDtoInfinityScrollService = simpleMessageWithServiceInterfaceDtoInfinityScrollService;
    }

    /**
     * {@code POST  /simple-message-with-service-interface-dto-infinity-scrolls} : Create a new simpleMessageWithServiceInterfaceDtoInfinityScroll.
     *
     * @param simpleMessageWithServiceInterfaceDtoInfinityScrollDTO the simpleMessageWithServiceInterfaceDtoInfinityScrollDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new simpleMessageWithServiceInterfaceDtoInfinityScrollDTO, or with status {@code 400 (Bad Request)} if the simpleMessageWithServiceInterfaceDtoInfinityScroll has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/simple-message-with-service-interface-dto-infinity-scrolls")
    public ResponseEntity<SimpleMessageWithServiceInterfaceDtoInfinityScrollDTO> createSimpleMessageWithServiceInterfaceDtoInfinityScroll(@RequestBody SimpleMessageWithServiceInterfaceDtoInfinityScrollDTO simpleMessageWithServiceInterfaceDtoInfinityScrollDTO) throws URISyntaxException {
        log.debug("REST request to save SimpleMessageWithServiceInterfaceDtoInfinityScroll : {}", simpleMessageWithServiceInterfaceDtoInfinityScrollDTO);
        if (simpleMessageWithServiceInterfaceDtoInfinityScrollDTO.getId() != null) {
            throw new BadRequestAlertException("A new simpleMessageWithServiceInterfaceDtoInfinityScroll cannot already have an ID", ENTITY_NAME, "idexists");
        }
        SimpleMessageWithServiceInterfaceDtoInfinityScrollDTO result = simpleMessageWithServiceInterfaceDtoInfinityScrollService.save(simpleMessageWithServiceInterfaceDtoInfinityScrollDTO);
        return ResponseEntity.created(new URI("/api/simple-message-with-service-interface-dto-infinity-scrolls/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /simple-message-with-service-interface-dto-infinity-scrolls} : Updates an existing simpleMessageWithServiceInterfaceDtoInfinityScroll.
     *
     * @param simpleMessageWithServiceInterfaceDtoInfinityScrollDTO the simpleMessageWithServiceInterfaceDtoInfinityScrollDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated simpleMessageWithServiceInterfaceDtoInfinityScrollDTO,
     * or with status {@code 400 (Bad Request)} if the simpleMessageWithServiceInterfaceDtoInfinityScrollDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the simpleMessageWithServiceInterfaceDtoInfinityScrollDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/simple-message-with-service-interface-dto-infinity-scrolls")
    public ResponseEntity<SimpleMessageWithServiceInterfaceDtoInfinityScrollDTO> updateSimpleMessageWithServiceInterfaceDtoInfinityScroll(@RequestBody SimpleMessageWithServiceInterfaceDtoInfinityScrollDTO simpleMessageWithServiceInterfaceDtoInfinityScrollDTO) throws URISyntaxException {
        log.debug("REST request to update SimpleMessageWithServiceInterfaceDtoInfinityScroll : {}", simpleMessageWithServiceInterfaceDtoInfinityScrollDTO);
        if (simpleMessageWithServiceInterfaceDtoInfinityScrollDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        SimpleMessageWithServiceInterfaceDtoInfinityScrollDTO result = simpleMessageWithServiceInterfaceDtoInfinityScrollService.save(simpleMessageWithServiceInterfaceDtoInfinityScrollDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, simpleMessageWithServiceInterfaceDtoInfinityScrollDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /simple-message-with-service-interface-dto-infinity-scrolls} : get all the simpleMessageWithServiceInterfaceDtoInfinityScrolls.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of simpleMessageWithServiceInterfaceDtoInfinityScrolls in body.
     */
    @GetMapping("/simple-message-with-service-interface-dto-infinity-scrolls")
    public ResponseEntity<List<SimpleMessageWithServiceInterfaceDtoInfinityScrollDTO>> getAllSimpleMessageWithServiceInterfaceDtoInfinityScrolls(Pageable pageable) {
        log.debug("REST request to get a page of SimpleMessageWithServiceInterfaceDtoInfinityScrolls");
        Page<SimpleMessageWithServiceInterfaceDtoInfinityScrollDTO> page = simpleMessageWithServiceInterfaceDtoInfinityScrollService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /simple-message-with-service-interface-dto-infinity-scrolls/:id} : get the "id" simpleMessageWithServiceInterfaceDtoInfinityScroll.
     *
     * @param id the id of the simpleMessageWithServiceInterfaceDtoInfinityScrollDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the simpleMessageWithServiceInterfaceDtoInfinityScrollDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/simple-message-with-service-interface-dto-infinity-scrolls/{id}")
    public ResponseEntity<SimpleMessageWithServiceInterfaceDtoInfinityScrollDTO> getSimpleMessageWithServiceInterfaceDtoInfinityScroll(@PathVariable Long id) {
        log.debug("REST request to get SimpleMessageWithServiceInterfaceDtoInfinityScroll : {}", id);
        Optional<SimpleMessageWithServiceInterfaceDtoInfinityScrollDTO> simpleMessageWithServiceInterfaceDtoInfinityScrollDTO = simpleMessageWithServiceInterfaceDtoInfinityScrollService.findOne(id);
        return ResponseUtil.wrapOrNotFound(simpleMessageWithServiceInterfaceDtoInfinityScrollDTO);
    }

    /**
     * {@code DELETE  /simple-message-with-service-interface-dto-infinity-scrolls/:id} : delete the "id" simpleMessageWithServiceInterfaceDtoInfinityScroll.
     *
     * @param id the id of the simpleMessageWithServiceInterfaceDtoInfinityScrollDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/simple-message-with-service-interface-dto-infinity-scrolls/{id}")
    public ResponseEntity<Void> deleteSimpleMessageWithServiceInterfaceDtoInfinityScroll(@PathVariable Long id) {
        log.debug("REST request to delete SimpleMessageWithServiceInterfaceDtoInfinityScroll : {}", id);
        simpleMessageWithServiceInterfaceDtoInfinityScrollService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString())).build();
    }
}
