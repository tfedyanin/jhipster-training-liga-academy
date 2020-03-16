package ru.liga.repository;

import ru.liga.domain.SimpleMessageWithServiceInterface;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the SimpleMessageWithServiceInterface entity.
 */
@SuppressWarnings("unused")
@Repository
public interface SimpleMessageWithServiceInterfaceRepository extends JpaRepository<SimpleMessageWithServiceInterface, Long> {

}
