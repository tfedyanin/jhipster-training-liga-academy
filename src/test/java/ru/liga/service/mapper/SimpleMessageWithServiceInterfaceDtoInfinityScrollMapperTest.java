package ru.liga.service.mapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class SimpleMessageWithServiceInterfaceDtoInfinityScrollMapperTest {

    private SimpleMessageWithServiceInterfaceDtoInfinityScrollMapper simpleMessageWithServiceInterfaceDtoInfinityScrollMapper;

    @BeforeEach
    public void setUp() {
        simpleMessageWithServiceInterfaceDtoInfinityScrollMapper = new SimpleMessageWithServiceInterfaceDtoInfinityScrollMapperImpl();
    }

    @Test
    public void testEntityFromId() {
        Long id = 1L;
        assertThat(simpleMessageWithServiceInterfaceDtoInfinityScrollMapper.fromId(id).getId()).isEqualTo(id);
        assertThat(simpleMessageWithServiceInterfaceDtoInfinityScrollMapper.fromId(null)).isNull();
    }
}
