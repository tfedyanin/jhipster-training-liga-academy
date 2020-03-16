package ru.liga.service;

import java.util.List;

import javax.persistence.criteria.JoinType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.github.jhipster.service.QueryService;

import ru.liga.domain.SimpleMessageWithServiceInterfaceDtoInfinityScrollFiltering;
import ru.liga.domain.*; // for static metamodels
import ru.liga.repository.SimpleMessageWithServiceInterfaceDtoInfinityScrollFilteringRepository;
import ru.liga.service.dto.SimpleMessageWithServiceInterfaceDtoInfinityScrollFilteringCriteria;
import ru.liga.service.dto.SimpleMessageWithServiceInterfaceDtoInfinityScrollFilteringDTO;
import ru.liga.service.mapper.SimpleMessageWithServiceInterfaceDtoInfinityScrollFilteringMapper;

/**
 * Service for executing complex queries for {@link SimpleMessageWithServiceInterfaceDtoInfinityScrollFiltering} entities in the database.
 * The main input is a {@link SimpleMessageWithServiceInterfaceDtoInfinityScrollFilteringCriteria} which gets converted to {@link Specification},
 * in a way that all the filters must apply.
 * It returns a {@link List} of {@link SimpleMessageWithServiceInterfaceDtoInfinityScrollFilteringDTO} or a {@link Page} of {@link SimpleMessageWithServiceInterfaceDtoInfinityScrollFilteringDTO} which fulfills the criteria.
 */
@Service
@Transactional(readOnly = true)
public class SimpleMessageWithServiceInterfaceDtoInfinityScrollFilteringQueryService extends QueryService<SimpleMessageWithServiceInterfaceDtoInfinityScrollFiltering> {

    private final Logger log = LoggerFactory.getLogger(SimpleMessageWithServiceInterfaceDtoInfinityScrollFilteringQueryService.class);

    private final SimpleMessageWithServiceInterfaceDtoInfinityScrollFilteringRepository simpleMessageWithServiceInterfaceDtoInfinityScrollFilteringRepository;

    private final SimpleMessageWithServiceInterfaceDtoInfinityScrollFilteringMapper simpleMessageWithServiceInterfaceDtoInfinityScrollFilteringMapper;

    public SimpleMessageWithServiceInterfaceDtoInfinityScrollFilteringQueryService(SimpleMessageWithServiceInterfaceDtoInfinityScrollFilteringRepository simpleMessageWithServiceInterfaceDtoInfinityScrollFilteringRepository, SimpleMessageWithServiceInterfaceDtoInfinityScrollFilteringMapper simpleMessageWithServiceInterfaceDtoInfinityScrollFilteringMapper) {
        this.simpleMessageWithServiceInterfaceDtoInfinityScrollFilteringRepository = simpleMessageWithServiceInterfaceDtoInfinityScrollFilteringRepository;
        this.simpleMessageWithServiceInterfaceDtoInfinityScrollFilteringMapper = simpleMessageWithServiceInterfaceDtoInfinityScrollFilteringMapper;
    }

    /**
     * Return a {@link List} of {@link SimpleMessageWithServiceInterfaceDtoInfinityScrollFilteringDTO} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public List<SimpleMessageWithServiceInterfaceDtoInfinityScrollFilteringDTO> findByCriteria(SimpleMessageWithServiceInterfaceDtoInfinityScrollFilteringCriteria criteria) {
        log.debug("find by criteria : {}", criteria);
        final Specification<SimpleMessageWithServiceInterfaceDtoInfinityScrollFiltering> specification = createSpecification(criteria);
        return simpleMessageWithServiceInterfaceDtoInfinityScrollFilteringMapper.toDto(simpleMessageWithServiceInterfaceDtoInfinityScrollFilteringRepository.findAll(specification));
    }

    /**
     * Return a {@link Page} of {@link SimpleMessageWithServiceInterfaceDtoInfinityScrollFilteringDTO} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @param page The page, which should be returned.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public Page<SimpleMessageWithServiceInterfaceDtoInfinityScrollFilteringDTO> findByCriteria(SimpleMessageWithServiceInterfaceDtoInfinityScrollFilteringCriteria criteria, Pageable page) {
        log.debug("find by criteria : {}, page: {}", criteria, page);
        final Specification<SimpleMessageWithServiceInterfaceDtoInfinityScrollFiltering> specification = createSpecification(criteria);
        return simpleMessageWithServiceInterfaceDtoInfinityScrollFilteringRepository.findAll(specification, page)
            .map(simpleMessageWithServiceInterfaceDtoInfinityScrollFilteringMapper::toDto);
    }

    /**
     * Return the number of matching entities in the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the number of matching entities.
     */
    @Transactional(readOnly = true)
    public long countByCriteria(SimpleMessageWithServiceInterfaceDtoInfinityScrollFilteringCriteria criteria) {
        log.debug("count by criteria : {}", criteria);
        final Specification<SimpleMessageWithServiceInterfaceDtoInfinityScrollFiltering> specification = createSpecification(criteria);
        return simpleMessageWithServiceInterfaceDtoInfinityScrollFilteringRepository.count(specification);
    }

    /**
     * Function to convert {@link SimpleMessageWithServiceInterfaceDtoInfinityScrollFilteringCriteria} to a {@link Specification}
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching {@link Specification} of the entity.
     */
    protected Specification<SimpleMessageWithServiceInterfaceDtoInfinityScrollFiltering> createSpecification(SimpleMessageWithServiceInterfaceDtoInfinityScrollFilteringCriteria criteria) {
        Specification<SimpleMessageWithServiceInterfaceDtoInfinityScrollFiltering> specification = Specification.where(null);
        if (criteria != null) {
            if (criteria.getId() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getId(), SimpleMessageWithServiceInterfaceDtoInfinityScrollFiltering_.id));
            }
        }
        return specification;
    }
}
