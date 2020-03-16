package ru.liga.service.dto;

import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link ru.liga.domain.SimpleMessageWithServiceInterfaceDtoInfinityScroll} entity.
 */
public class SimpleMessageWithServiceInterfaceDtoInfinityScrollDTO implements Serializable {

    private Long id;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        SimpleMessageWithServiceInterfaceDtoInfinityScrollDTO simpleMessageWithServiceInterfaceDtoInfinityScrollDTO = (SimpleMessageWithServiceInterfaceDtoInfinityScrollDTO) o;
        if (simpleMessageWithServiceInterfaceDtoInfinityScrollDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), simpleMessageWithServiceInterfaceDtoInfinityScrollDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "SimpleMessageWithServiceInterfaceDtoInfinityScrollDTO{" +
            "id=" + getId() +
            "}";
    }
}
