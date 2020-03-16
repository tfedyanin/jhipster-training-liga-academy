package ru.liga.web.rest;

import ru.liga.service.SimpleMessageWithServiceInterfaceDtoInfinityScrollFilteringService;
import ru.liga.web.rest.errors.BadRequestAlertException;
import ru.liga.service.dto.SimpleMessageWithServiceInterfaceDtoInfinityScrollFilteringDTO;
import ru.liga.service.dto.SimpleMessageWithServiceInterfaceDtoInfinityScrollFilteringCriteria;
import ru.liga.service.SimpleMessageWithServiceInterfaceDtoInfinityScrollFilteringQueryService;

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
 * REST controller for managing {@link ru.liga.domain.SimpleMessageWithServiceInterfaceDtoInfinityScrollFiltering}.
 */
@RestController
@RequestMapping("/api")
public class SimpleMessageWithServiceInterfaceDtoInfinityScrollFilteringResource {

    private final Logger log = LoggerFactory.getLogger(SimpleMessageWithServiceInterfaceDtoInfinityScrollFilteringResource.class);

    private static final String ENTITY_NAME = "simpleMessageWithServiceInterfaceDtoInfinityScrollFiltering";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final SimpleMessageWithServiceInterfaceDtoInfinityScrollFilteringService simpleMessageWithServiceInterfaceDtoInfinityScrollFilteringService;

    private final SimpleMessageWithServiceInterfaceDtoInfinityScrollFilteringQueryService simpleMessageWithServiceInterfaceDtoInfinityScrollFilteringQueryService;

    public SimpleMessageWithServiceInterfaceDtoInfinityScrollFilteringResource(SimpleMessageWithServiceInterfaceDtoInfinityScrollFilteringService simpleMessageWithServiceInterfaceDtoInfinityScrollFilteringService, SimpleMessageWithServiceInterfaceDtoInfinityScrollFilteringQueryService simpleMessageWithServiceInterfaceDtoInfinityScrollFilteringQueryService) {
        this.simpleMessageWithServiceInterfaceDtoInfinityScrollFilteringService = simpleMessageWithServiceInterfaceDtoInfinityScrollFilteringService;
        this.simpleMessageWithServiceInterfaceDtoInfinityScrollFilteringQueryService = simpleMessageWithServiceInterfaceDtoInfinityScrollFilteringQueryService;
    }

    /**
     * {@code POST  /simple-message-with-service-interface-dto-infinity-scroll-filterings} : Create a new simpleMessageWithServiceInterfaceDtoInfinityScrollFiltering.
     *
     * @param simpleMessageWithServiceInterfaceDtoInfinityScrollFilteringDTO the simpleMessageWithServiceInterfaceDtoInfinityScrollFilteringDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new simpleMessageWithServiceInterfaceDtoInfinityScrollFilteringDTO, or with status {@code 400 (Bad Request)} if the simpleMessageWithServiceInterfaceDtoInfinityScrollFiltering has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/simple-message-with-service-interface-dto-infinity-scroll-filterings")
    public ResponseEntity<SimpleMessageWithServiceInterfaceDtoInfinityScrollFilteringDTO> createSimpleMessageWithServiceInterfaceDtoInfinityScrollFiltering(@RequestBody SimpleMessageWithServiceInterfaceDtoInfinityScrollFilteringDTO simpleMessageWithServiceInterfaceDtoInfinityScrollFilteringDTO) throws URISyntaxException {
        log.debug("REST request to save SimpleMessageWithServiceInterfaceDtoInfinityScrollFiltering : {}", simpleMessageWithServiceInterfaceDtoInfinityScrollFilteringDTO);
        if (simpleMessageWithServiceInterfaceDtoInfinityScrollFilteringDTO.getId() != null) {
            throw new BadRequestAlertException("A new simpleMessageWithServiceInterfaceDtoInfinityScrollFiltering cannot already have an ID", ENTITY_NAME, "idexists");
        }
        SimpleMessageWithServiceInterfaceDtoInfinityScrollFilteringDTO result = simpleMessageWithServiceInterfaceDtoInfinityScrollFilteringService.save(simpleMessageWithServiceInterfaceDtoInfinityScrollFilteringDTO);
        return ResponseEntity.created(new URI("/api/simple-message-with-service-interface-dto-infinity-scroll-filterings/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /simple-message-with-service-interface-dto-infinity-scroll-filterings} : Updates an existing simpleMessageWithServiceInterfaceDtoInfinityScrollFiltering.
     *
     * @param simpleMessageWithServiceInterfaceDtoInfinityScrollFilteringDTO the simpleMessageWithServiceInterfaceDtoInfinityScrollFilteringDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated simpleMessageWithServiceInterfaceDtoInfinityScrollFilteringDTO,
     * or with status {@code 400 (Bad Request)} if the simpleMessageWithServiceInterfaceDtoInfinityScrollFilteringDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the simpleMessageWithServiceInterfaceDtoInfinityScrollFilteringDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/simple-message-with-service-interface-dto-infinity-scroll-filterings")
    public ResponseEntity<SimpleMessageWithServiceInterfaceDtoInfinityScrollFilteringDTO> updateSimpleMessageWithServiceInterfaceDtoInfinityScrollFiltering(@RequestBody SimpleMessageWithServiceInterfaceDtoInfinityScrollFilteringDTO simpleMessageWithServiceInterfaceDtoInfinityScrollFilteringDTO) throws URISyntaxException {
        log.debug("REST request to update SimpleMessageWithServiceInterfaceDtoInfinityScrollFiltering : {}", simpleMessageWithServiceInterfaceDtoInfinityScrollFilteringDTO);
        if (simpleMessageWithServiceInterfaceDtoInfinityScrollFilteringDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        SimpleMessageWithServiceInterfaceDtoInfinityScrollFilteringDTO result = simpleMessageWithServiceInterfaceDtoInfinityScrollFilteringService.save(simpleMessageWithServiceInterfaceDtoInfinityScrollFilteringDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, simpleMessageWithServiceInterfaceDtoInfinityScrollFilteringDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /simple-message-with-service-interface-dto-infinity-scroll-filterings} : get all the simpleMessageWithServiceInterfaceDtoInfinityScrollFilterings.
     *
     * @param pageable the pagination information.
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of simpleMessageWithServiceInterfaceDtoInfinityScrollFilterings in body.
     */
    @GetMapping("/simple-message-with-service-interface-dto-infinity-scroll-filterings")
    public ResponseEntity<List<SimpleMessageWithServiceInterfaceDtoInfinityScrollFilteringDTO>> getAllSimpleMessageWithServiceInterfaceDtoInfinityScrollFilterings(SimpleMessageWithServiceInterfaceDtoInfinityScrollFilteringCriteria criteria, Pageable pageable) {
        log.debug("REST request to get SimpleMessageWithServiceInterfaceDtoInfinityScrollFilterings by criteria: {}", criteria);
        Page<SimpleMessageWithServiceInterfaceDtoInfinityScrollFilteringDTO> page = simpleMessageWithServiceInterfaceDtoInfinityScrollFilteringQueryService.findByCriteria(criteria, pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /simple-message-with-service-interface-dto-infinity-scroll-filterings/count} : count all the simpleMessageWithServiceInterfaceDtoInfinityScrollFilterings.
     *
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the count in body.
     */
    @GetMapping("/simple-message-with-service-interface-dto-infinity-scroll-filterings/count")
    public ResponseEntity<Long> countSimpleMessageWithServiceInterfaceDtoInfinityScrollFilterings(SimpleMessageWithServiceInterfaceDtoInfinityScrollFilteringCriteria criteria) {
        log.debug("REST request to count SimpleMessageWithServiceInterfaceDtoInfinityScrollFilterings by criteria: {}", criteria);
        return ResponseEntity.ok().body(simpleMessageWithServiceInterfaceDtoInfinityScrollFilteringQueryService.countByCriteria(criteria));
    }

    /**
     * {@code GET  /simple-message-with-service-interface-dto-infinity-scroll-filterings/:id} : get the "id" simpleMessageWithServiceInterfaceDtoInfinityScrollFiltering.
     *
     * @param id the id of the simpleMessageWithServiceInterfaceDtoInfinityScrollFilteringDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the simpleMessageWithServiceInterfaceDtoInfinityScrollFilteringDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/simple-message-with-service-interface-dto-infinity-scroll-filterings/{id}")
    public ResponseEntity<SimpleMessageWithServiceInterfaceDtoInfinityScrollFilteringDTO> getSimpleMessageWithServiceInterfaceDtoInfinityScrollFiltering(@PathVariable Long id) {
        log.debug("REST request to get SimpleMessageWithServiceInterfaceDtoInfinityScrollFiltering : {}", id);
        Optional<SimpleMessageWithServiceInterfaceDtoInfinityScrollFilteringDTO> simpleMessageWithServiceInterfaceDtoInfinityScrollFilteringDTO = simpleMessageWithServiceInterfaceDtoInfinityScrollFilteringService.findOne(id);
        return ResponseUtil.wrapOrNotFound(simpleMessageWithServiceInterfaceDtoInfinityScrollFilteringDTO);
    }

    /**
     * {@code DELETE  /simple-message-with-service-interface-dto-infinity-scroll-filterings/:id} : delete the "id" simpleMessageWithServiceInterfaceDtoInfinityScrollFiltering.
     *
     * @param id the id of the simpleMessageWithServiceInterfaceDtoInfinityScrollFilteringDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/simple-message-with-service-interface-dto-infinity-scroll-filterings/{id}")
    public ResponseEntity<Void> deleteSimpleMessageWithServiceInterfaceDtoInfinityScrollFiltering(@PathVariable Long id) {
        log.debug("REST request to delete SimpleMessageWithServiceInterfaceDtoInfinityScrollFiltering : {}", id);
        simpleMessageWithServiceInterfaceDtoInfinityScrollFilteringService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString())).build();
    }
}
