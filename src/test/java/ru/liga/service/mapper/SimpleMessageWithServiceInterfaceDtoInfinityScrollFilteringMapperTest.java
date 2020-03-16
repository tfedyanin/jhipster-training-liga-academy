package ru.liga.service.mapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class SimpleMessageWithServiceInterfaceDtoInfinityScrollFilteringMapperTest {

    private SimpleMessageWithServiceInterfaceDtoInfinityScrollFilteringMapper simpleMessageWithServiceInterfaceDtoInfinityScrollFilteringMapper;

    @BeforeEach
    public void setUp() {
        simpleMessageWithServiceInterfaceDtoInfinityScrollFilteringMapper = new SimpleMessageWithServiceInterfaceDtoInfinityScrollFilteringMapperImpl();
    }

    @Test
    public void testEntityFromId() {
        Long id = 1L;
        assertThat(simpleMessageWithServiceInterfaceDtoInfinityScrollFilteringMapper.fromId(id).getId()).isEqualTo(id);
        assertThat(simpleMessageWithServiceInterfaceDtoInfinityScrollFilteringMapper.fromId(null)).isNull();
    }
}
