package ru.liga.repository;

import ru.liga.domain.SimpleMessageWithServiceInterfaceDtoInfinityScrollFiltering;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the SimpleMessageWithServiceInterfaceDtoInfinityScrollFiltering entity.
 */
@SuppressWarnings("unused")
@Repository
public interface SimpleMessageWithServiceInterfaceDtoInfinityScrollFilteringRepository extends JpaRepository<SimpleMessageWithServiceInterfaceDtoInfinityScrollFiltering, Long>, JpaSpecificationExecutor<SimpleMessageWithServiceInterfaceDtoInfinityScrollFiltering> {

}
