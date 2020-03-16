package ru.liga.service.dto;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import ru.liga.web.rest.TestUtil;

public class SimpleMessageWithServiceInterfaceDtoInfinityScrollFilteringDTOTest {

    @Test
    public void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(SimpleMessageWithServiceInterfaceDtoInfinityScrollFilteringDTO.class);
        SimpleMessageWithServiceInterfaceDtoInfinityScrollFilteringDTO simpleMessageWithServiceInterfaceDtoInfinityScrollFilteringDTO1 = new SimpleMessageWithServiceInterfaceDtoInfinityScrollFilteringDTO();
        simpleMessageWithServiceInterfaceDtoInfinityScrollFilteringDTO1.setId(1L);
        SimpleMessageWithServiceInterfaceDtoInfinityScrollFilteringDTO simpleMessageWithServiceInterfaceDtoInfinityScrollFilteringDTO2 = new SimpleMessageWithServiceInterfaceDtoInfinityScrollFilteringDTO();
        assertThat(simpleMessageWithServiceInterfaceDtoInfinityScrollFilteringDTO1).isNotEqualTo(simpleMessageWithServiceInterfaceDtoInfinityScrollFilteringDTO2);
        simpleMessageWithServiceInterfaceDtoInfinityScrollFilteringDTO2.setId(simpleMessageWithServiceInterfaceDtoInfinityScrollFilteringDTO1.getId());
        assertThat(simpleMessageWithServiceInterfaceDtoInfinityScrollFilteringDTO1).isEqualTo(simpleMessageWithServiceInterfaceDtoInfinityScrollFilteringDTO2);
        simpleMessageWithServiceInterfaceDtoInfinityScrollFilteringDTO2.setId(2L);
        assertThat(simpleMessageWithServiceInterfaceDtoInfinityScrollFilteringDTO1).isNotEqualTo(simpleMessageWithServiceInterfaceDtoInfinityScrollFilteringDTO2);
        simpleMessageWithServiceInterfaceDtoInfinityScrollFilteringDTO1.setId(null);
        assertThat(simpleMessageWithServiceInterfaceDtoInfinityScrollFilteringDTO1).isNotEqualTo(simpleMessageWithServiceInterfaceDtoInfinityScrollFilteringDTO2);
    }
}
