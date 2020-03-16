package ru.liga.repository;

import ru.liga.domain.SimpleMessageWithService;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the SimpleMessageWithService entity.
 */
@SuppressWarnings("unused")
@Repository
public interface SimpleMessageWithServiceRepository extends JpaRepository<SimpleMessageWithService, Long> {

}
