package ru.liga.service.dto;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import ru.liga.web.rest.TestUtil;

public class SimpleMessageWithServiceInterfaceDtoDTOTest {

    @Test
    public void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(SimpleMessageWithServiceInterfaceDtoDTO.class);
        SimpleMessageWithServiceInterfaceDtoDTO simpleMessageWithServiceInterfaceDtoDTO1 = new SimpleMessageWithServiceInterfaceDtoDTO();
        simpleMessageWithServiceInterfaceDtoDTO1.setId(1L);
        SimpleMessageWithServiceInterfaceDtoDTO simpleMessageWithServiceInterfaceDtoDTO2 = new SimpleMessageWithServiceInterfaceDtoDTO();
        assertThat(simpleMessageWithServiceInterfaceDtoDTO1).isNotEqualTo(simpleMessageWithServiceInterfaceDtoDTO2);
        simpleMessageWithServiceInterfaceDtoDTO2.setId(simpleMessageWithServiceInterfaceDtoDTO1.getId());
        assertThat(simpleMessageWithServiceInterfaceDtoDTO1).isEqualTo(simpleMessageWithServiceInterfaceDtoDTO2);
        simpleMessageWithServiceInterfaceDtoDTO2.setId(2L);
        assertThat(simpleMessageWithServiceInterfaceDtoDTO1).isNotEqualTo(simpleMessageWithServiceInterfaceDtoDTO2);
        simpleMessageWithServiceInterfaceDtoDTO1.setId(null);
        assertThat(simpleMessageWithServiceInterfaceDtoDTO1).isNotEqualTo(simpleMessageWithServiceInterfaceDtoDTO2);
    }
}
