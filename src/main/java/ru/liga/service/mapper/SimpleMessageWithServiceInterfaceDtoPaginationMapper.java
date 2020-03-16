package ru.liga.service.mapper;


import ru.liga.domain.*;
import ru.liga.service.dto.SimpleMessageWithServiceInterfaceDtoPaginationDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link SimpleMessageWithServiceInterfaceDtoPagination} and its DTO {@link SimpleMessageWithServiceInterfaceDtoPaginationDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface SimpleMessageWithServiceInterfaceDtoPaginationMapper extends EntityMapper<SimpleMessageWithServiceInterfaceDtoPaginationDTO, SimpleMessageWithServiceInterfaceDtoPagination> {



    default SimpleMessageWithServiceInterfaceDtoPagination fromId(Long id) {
        if (id == null) {
            return null;
        }
        SimpleMessageWithServiceInterfaceDtoPagination simpleMessageWithServiceInterfaceDtoPagination = new SimpleMessageWithServiceInterfaceDtoPagination();
        simpleMessageWithServiceInterfaceDtoPagination.setId(id);
        return simpleMessageWithServiceInterfaceDtoPagination;
    }
}
