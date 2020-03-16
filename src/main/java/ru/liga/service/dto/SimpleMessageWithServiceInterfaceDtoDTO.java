package ru.liga.service.dto;

import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link ru.liga.domain.SimpleMessageWithServiceInterfaceDto} entity.
 */
public class SimpleMessageWithServiceInterfaceDtoDTO implements Serializable {

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

        SimpleMessageWithServiceInterfaceDtoDTO simpleMessageWithServiceInterfaceDtoDTO = (SimpleMessageWithServiceInterfaceDtoDTO) o;
        if (simpleMessageWithServiceInterfaceDtoDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), simpleMessageWithServiceInterfaceDtoDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "SimpleMessageWithServiceInterfaceDtoDTO{" +
            "id=" + getId() +
            "}";
    }
}
