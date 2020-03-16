package ru.liga.service.dto;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import ru.liga.web.rest.TestUtil;

public class SimpleMessageWithServiceInterfaceDtoInfinityScrollDTOTest {

    @Test
    public void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(SimpleMessageWithServiceInterfaceDtoInfinityScrollDTO.class);
        SimpleMessageWithServiceInterfaceDtoInfinityScrollDTO simpleMessageWithServiceInterfaceDtoInfinityScrollDTO1 = new SimpleMessageWithServiceInterfaceDtoInfinityScrollDTO();
        simpleMessageWithServiceInterfaceDtoInfinityScrollDTO1.setId(1L);
        SimpleMessageWithServiceInterfaceDtoInfinityScrollDTO simpleMessageWithServiceInterfaceDtoInfinityScrollDTO2 = new SimpleMessageWithServiceInterfaceDtoInfinityScrollDTO();
        assertThat(simpleMessageWithServiceInterfaceDtoInfinityScrollDTO1).isNotEqualTo(simpleMessageWithServiceInterfaceDtoInfinityScrollDTO2);
        simpleMessageWithServiceInterfaceDtoInfinityScrollDTO2.setId(simpleMessageWithServiceInterfaceDtoInfinityScrollDTO1.getId());
        assertThat(simpleMessageWithServiceInterfaceDtoInfinityScrollDTO1).isEqualTo(simpleMessageWithServiceInterfaceDtoInfinityScrollDTO2);
        simpleMessageWithServiceInterfaceDtoInfinityScrollDTO2.setId(2L);
        assertThat(simpleMessageWithServiceInterfaceDtoInfinityScrollDTO1).isNotEqualTo(simpleMessageWithServiceInterfaceDtoInfinityScrollDTO2);
        simpleMessageWithServiceInterfaceDtoInfinityScrollDTO1.setId(null);
        assertThat(simpleMessageWithServiceInterfaceDtoInfinityScrollDTO1).isNotEqualTo(simpleMessageWithServiceInterfaceDtoInfinityScrollDTO2);
    }
}
