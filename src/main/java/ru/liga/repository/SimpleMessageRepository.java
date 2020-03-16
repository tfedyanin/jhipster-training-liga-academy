package ru.liga.repository;

import ru.liga.domain.SimpleMessage;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the SimpleMessage entity.
 */
@SuppressWarnings("unused")
@Repository
public interface SimpleMessageRepository extends JpaRepository<SimpleMessage, Long> {

}
