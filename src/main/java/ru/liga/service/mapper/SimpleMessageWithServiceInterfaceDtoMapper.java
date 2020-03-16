package ru.liga.service.mapper;


import ru.liga.domain.*;
import ru.liga.service.dto.SimpleMessageWithServiceInterfaceDtoDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link SimpleMessageWithServiceInterfaceDto} and its DTO {@link SimpleMessageWithServiceInterfaceDtoDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface SimpleMessageWithServiceInterfaceDtoMapper extends EntityMapper<SimpleMessageWithServiceInterfaceDtoDTO, SimpleMessageWithServiceInterfaceDto> {



    default SimpleMessageWithServiceInterfaceDto fromId(Long id) {
        if (id == null) {
            return null;
        }
        SimpleMessageWithServiceInterfaceDto simpleMessageWithServiceInterfaceDto = new SimpleMessageWithServiceInterfaceDto();
        simpleMessageWithServiceInterfaceDto.setId(id);
        return simpleMessageWithServiceInterfaceDto;
    }
}
