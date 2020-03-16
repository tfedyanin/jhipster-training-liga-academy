package ru.liga.repository;

import ru.liga.domain.SimpleMessageWithServiceInterfaceDto;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the SimpleMessageWithServiceInterfaceDto entity.
 */
@SuppressWarnings("unused")
@Repository
public interface SimpleMessageWithServiceInterfaceDtoRepository extends JpaRepository<SimpleMessageWithServiceInterfaceDto, Long> {

}
