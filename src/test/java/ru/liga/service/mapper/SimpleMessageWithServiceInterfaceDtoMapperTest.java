package ru.liga.service.mapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class SimpleMessageWithServiceInterfaceDtoMapperTest {

    private SimpleMessageWithServiceInterfaceDtoMapper simpleMessageWithServiceInterfaceDtoMapper;

    @BeforeEach
    public void setUp() {
        simpleMessageWithServiceInterfaceDtoMapper = new SimpleMessageWithServiceInterfaceDtoMapperImpl();
    }

    @Test
    public void testEntityFromId() {
        Long id = 1L;
        assertThat(simpleMessageWithServiceInterfaceDtoMapper.fromId(id).getId()).isEqualTo(id);
        assertThat(simpleMessageWithServiceInterfaceDtoMapper.fromId(null)).isNull();
    }
}
