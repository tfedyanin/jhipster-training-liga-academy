package ru.liga.service.mapper;


import ru.liga.domain.*;
import ru.liga.service.dto.SimpleMessageWithServiceInterfaceDtoInfinityScrollDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link SimpleMessageWithServiceInterfaceDtoInfinityScroll} and its DTO {@link SimpleMessageWithServiceInterfaceDtoInfinityScrollDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface SimpleMessageWithServiceInterfaceDtoInfinityScrollMapper extends EntityMapper<SimpleMessageWithServiceInterfaceDtoInfinityScrollDTO, SimpleMessageWithServiceInterfaceDtoInfinityScroll> {



    default SimpleMessageWithServiceInterfaceDtoInfinityScroll fromId(Long id) {
        if (id == null) {
            return null;
        }
        SimpleMessageWithServiceInterfaceDtoInfinityScroll simpleMessageWithServiceInterfaceDtoInfinityScroll = new SimpleMessageWithServiceInterfaceDtoInfinityScroll();
        simpleMessageWithServiceInterfaceDtoInfinityScroll.setId(id);
        return simpleMessageWithServiceInterfaceDtoInfinityScroll;
    }
}
