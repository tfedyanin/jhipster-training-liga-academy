package ru.liga.repository;

import ru.liga.domain.SimpleMessageWithServiceInterfaceDtoPagination;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the SimpleMessageWithServiceInterfaceDtoPagination entity.
 */
@SuppressWarnings("unused")
@Repository
public interface SimpleMessageWithServiceInterfaceDtoPaginationRepository extends JpaRepository<SimpleMessageWithServiceInterfaceDtoPagination, Long> {

}
