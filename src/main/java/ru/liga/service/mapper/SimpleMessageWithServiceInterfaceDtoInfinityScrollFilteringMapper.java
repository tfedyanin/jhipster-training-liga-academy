package ru.liga.service.mapper;


import ru.liga.domain.*;
import ru.liga.service.dto.SimpleMessageWithServiceInterfaceDtoInfinityScrollFilteringDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link SimpleMessageWithServiceInterfaceDtoInfinityScrollFiltering} and its DTO {@link SimpleMessageWithServiceInterfaceDtoInfinityScrollFilteringDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface SimpleMessageWithServiceInterfaceDtoInfinityScrollFilteringMapper extends EntityMapper<SimpleMessageWithServiceInterfaceDtoInfinityScrollFilteringDTO, SimpleMessageWithServiceInterfaceDtoInfinityScrollFiltering> {



    default SimpleMessageWithServiceInterfaceDtoInfinityScrollFiltering fromId(Long id) {
        if (id == null) {
            return null;
        }
        SimpleMessageWithServiceInterfaceDtoInfinityScrollFiltering simpleMessageWithServiceInterfaceDtoInfinityScrollFiltering = new SimpleMessageWithServiceInterfaceDtoInfinityScrollFiltering();
        simpleMessageWithServiceInterfaceDtoInfinityScrollFiltering.setId(id);
        return simpleMessageWithServiceInterfaceDtoInfinityScrollFiltering;
    }
}
