package ru.liga.repository;

import ru.liga.domain.SimpleMessageWithServiceInterfaceDtoInfinityScroll;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the SimpleMessageWithServiceInterfaceDtoInfinityScroll entity.
 */
@SuppressWarnings("unused")
@Repository
public interface SimpleMessageWithServiceInterfaceDtoInfinityScrollRepository extends JpaRepository<SimpleMessageWithServiceInterfaceDtoInfinityScroll, Long> {

}
