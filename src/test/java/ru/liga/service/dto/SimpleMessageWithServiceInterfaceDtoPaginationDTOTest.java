package ru.liga.service.dto;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import ru.liga.web.rest.TestUtil;

public class SimpleMessageWithServiceInterfaceDtoPaginationDTOTest {

    @Test
    public void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(SimpleMessageWithServiceInterfaceDtoPaginationDTO.class);
        SimpleMessageWithServiceInterfaceDtoPaginationDTO simpleMessageWithServiceInterfaceDtoPaginationDTO1 = new SimpleMessageWithServiceInterfaceDtoPaginationDTO();
        simpleMessageWithServiceInterfaceDtoPaginationDTO1.setId(1L);
        SimpleMessageWithServiceInterfaceDtoPaginationDTO simpleMessageWithServiceInterfaceDtoPaginationDTO2 = new SimpleMessageWithServiceInterfaceDtoPaginationDTO();
        assertThat(simpleMessageWithServiceInterfaceDtoPaginationDTO1).isNotEqualTo(simpleMessageWithServiceInterfaceDtoPaginationDTO2);
        simpleMessageWithServiceInterfaceDtoPaginationDTO2.setId(simpleMessageWithServiceInterfaceDtoPaginationDTO1.getId());
        assertThat(simpleMessageWithServiceInterfaceDtoPaginationDTO1).isEqualTo(simpleMessageWithServiceInterfaceDtoPaginationDTO2);
        simpleMessageWithServiceInterfaceDtoPaginationDTO2.setId(2L);
        assertThat(simpleMessageWithServiceInterfaceDtoPaginationDTO1).isNotEqualTo(simpleMessageWithServiceInterfaceDtoPaginationDTO2);
        simpleMessageWithServiceInterfaceDtoPaginationDTO1.setId(null);
        assertThat(simpleMessageWithServiceInterfaceDtoPaginationDTO1).isNotEqualTo(simpleMessageWithServiceInterfaceDtoPaginationDTO2);
    }
}
