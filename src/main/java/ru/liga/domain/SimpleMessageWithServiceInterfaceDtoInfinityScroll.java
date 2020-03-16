package ru.liga.domain;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

import java.io.Serializable;

/**
 * A SimpleMessageWithServiceInterfaceDtoInfinityScroll.
 */
@Entity
@Table(name = "simple_message_with_service_interface_dto_infinity_scroll")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class SimpleMessageWithServiceInterfaceDtoInfinityScroll implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof SimpleMessageWithServiceInterfaceDtoInfinityScroll)) {
            return false;
        }
        return id != null && id.equals(((SimpleMessageWithServiceInterfaceDtoInfinityScroll) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "SimpleMessageWithServiceInterfaceDtoInfinityScroll{" +
            "id=" + getId() +
            "}";
    }
}
