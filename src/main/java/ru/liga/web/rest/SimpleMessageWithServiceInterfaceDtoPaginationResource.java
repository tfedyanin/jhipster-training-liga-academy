package ru.liga.web.rest;

import ru.liga.service.SimpleMessageWithServiceInterfaceDtoPaginationService;
import ru.liga.web.rest.errors.BadRequestAlertException;
import ru.liga.service.dto.SimpleMessageWithServiceInterfaceDtoPaginationDTO;

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
 * REST controller for managing {@link ru.liga.domain.SimpleMessageWithServiceInterfaceDtoPagination}.
 */
@RestController
@RequestMapping("/api")
public class SimpleMessageWithServiceInterfaceDtoPaginationResource {

    private final Logger log = LoggerFactory.getLogger(SimpleMessageWithServiceInterfaceDtoPaginationResource.class);

    private static final String ENTITY_NAME = "simpleMessageWithServiceInterfaceDtoPagination";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final SimpleMessageWithServiceInterfaceDtoPaginationService simpleMessageWithServiceInterfaceDtoPaginationService;

    public SimpleMessageWithServiceInterfaceDtoPaginationResource(SimpleMessageWithServiceInterfaceDtoPaginationService simpleMessageWithServiceInterfaceDtoPaginationService) {
        this.simpleMessageWithServiceInterfaceDtoPaginationService = simpleMessageWithServiceInterfaceDtoPaginationService;
    }

    /**
     * {@code POST  /simple-message-with-service-interface-dto-paginations} : Create a new simpleMessageWithServiceInterfaceDtoPagination.
     *
     * @param simpleMessageWithServiceInterfaceDtoPaginationDTO the simpleMessageWithServiceInterfaceDtoPaginationDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new simpleMessageWithServiceInterfaceDtoPaginationDTO, or with status {@code 400 (Bad Request)} if the simpleMessageWithServiceInterfaceDtoPagination has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/simple-message-with-service-interface-dto-paginations")
    public ResponseEntity<SimpleMessageWithServiceInterfaceDtoPaginationDTO> createSimpleMessageWithServiceInterfaceDtoPagination(@RequestBody SimpleMessageWithServiceInterfaceDtoPaginationDTO simpleMessageWithServiceInterfaceDtoPaginationDTO) throws URISyntaxException {
        log.debug("REST request to save SimpleMessageWithServiceInterfaceDtoPagination : {}", simpleMessageWithServiceInterfaceDtoPaginationDTO);
        if (simpleMessageWithServiceInterfaceDtoPaginationDTO.getId() != null) {
            throw new BadRequestAlertException("A new simpleMessageWithServiceInterfaceDtoPagination cannot already have an ID", ENTITY_NAME, "idexists");
        }
        SimpleMessageWithServiceInterfaceDtoPaginationDTO result = simpleMessageWithServiceInterfaceDtoPaginationService.save(simpleMessageWithServiceInterfaceDtoPaginationDTO);
        return ResponseEntity.created(new URI("/api/simple-message-with-service-interface-dto-paginations/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /simple-message-with-service-interface-dto-paginations} : Updates an existing simpleMessageWithServiceInterfaceDtoPagination.
     *
     * @param simpleMessageWithServiceInterfaceDtoPaginationDTO the simpleMessageWithServiceInterfaceDtoPaginationDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated simpleMessageWithServiceInterfaceDtoPaginationDTO,
     * or with status {@code 400 (Bad Request)} if the simpleMessageWithServiceInterfaceDtoPaginationDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the simpleMessageWithServiceInterfaceDtoPaginationDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/simple-message-with-service-interface-dto-paginations")
    public ResponseEntity<SimpleMessageWithServiceInterfaceDtoPaginationDTO> updateSimpleMessageWithServiceInterfaceDtoPagination(@RequestBody SimpleMessageWithServiceInterfaceDtoPaginationDTO simpleMessageWithServiceInterfaceDtoPaginationDTO) throws URISyntaxException {
        log.debug("REST request to update SimpleMessageWithServiceInterfaceDtoPagination : {}", simpleMessageWithServiceInterfaceDtoPaginationDTO);
        if (simpleMessageWithServiceInterfaceDtoPaginationDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        SimpleMessageWithServiceInterfaceDtoPaginationDTO result = simpleMessageWithServiceInterfaceDtoPaginationService.save(simpleMessageWithServiceInterfaceDtoPaginationDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, simpleMessageWithServiceInterfaceDtoPaginationDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /simple-message-with-service-interface-dto-paginations} : get all the simpleMessageWithServiceInterfaceDtoPaginations.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of simpleMessageWithServiceInterfaceDtoPaginations in body.
     */
    @GetMapping("/simple-message-with-service-interface-dto-paginations")
    public ResponseEntity<List<SimpleMessageWithServiceInterfaceDtoPaginationDTO>> getAllSimpleMessageWithServiceInterfaceDtoPaginations(Pageable pageable) {
        log.debug("REST request to get a page of SimpleMessageWithServiceInterfaceDtoPaginations");
        Page<SimpleMessageWithServiceInterfaceDtoPaginationDTO> page = simpleMessageWithServiceInterfaceDtoPaginationService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /simple-message-with-service-interface-dto-paginations/:id} : get the "id" simpleMessageWithServiceInterfaceDtoPagination.
     *
     * @param id the id of the simpleMessageWithServiceInterfaceDtoPaginationDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the simpleMessageWithServiceInterfaceDtoPaginationDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/simple-message-with-service-interface-dto-paginations/{id}")
    public ResponseEntity<SimpleMessageWithServiceInterfaceDtoPaginationDTO> getSimpleMessageWithServiceInterfaceDtoPagination(@PathVariable Long id) {
        log.debug("REST request to get SimpleMessageWithServiceInterfaceDtoPagination : {}", id);
        Optional<SimpleMessageWithServiceInterfaceDtoPaginationDTO> simpleMessageWithServiceInterfaceDtoPaginationDTO = simpleMessageWithServiceInterfaceDtoPaginationService.findOne(id);
        return ResponseUtil.wrapOrNotFound(simpleMessageWithServiceInterfaceDtoPaginationDTO);
    }

    /**
     * {@code DELETE  /simple-message-with-service-interface-dto-paginations/:id} : delete the "id" simpleMessageWithServiceInterfaceDtoPagination.
     *
     * @param id the id of the simpleMessageWithServiceInterfaceDtoPaginationDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/simple-message-with-service-interface-dto-paginations/{id}")
    public ResponseEntity<Void> deleteSimpleMessageWithServiceInterfaceDtoPagination(@PathVariable Long id) {
        log.debug("REST request to delete SimpleMessageWithServiceInterfaceDtoPagination : {}", id);
        simpleMessageWithServiceInterfaceDtoPaginationService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString())).build();
    }
}
