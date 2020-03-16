package ru.liga.service.mapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class SimpleMessageWithServiceInterfaceDtoPaginationMapperTest {

    private SimpleMessageWithServiceInterfaceDtoPaginationMapper simpleMessageWithServiceInterfaceDtoPaginationMapper;

    @BeforeEach
    public void setUp() {
        simpleMessageWithServiceInterfaceDtoPaginationMapper = new SimpleMessageWithServiceInterfaceDtoPaginationMapperImpl();
    }

    @Test
    public void testEntityFromId() {
        Long id = 1L;
        assertThat(simpleMessageWithServiceInterfaceDtoPaginationMapper.fromId(id).getId()).isEqualTo(id);
        assertThat(simpleMessageWithServiceInterfaceDtoPaginationMapper.fromId(null)).isNull();
    }
}
