package ru.liga.domain;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import ru.liga.web.rest.TestUtil;

public class SimpleMessageWithServiceInterfaceDtoTest {

    @Test
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(SimpleMessageWithServiceInterfaceDto.class);
        SimpleMessageWithServiceInterfaceDto simpleMessageWithServiceInterfaceDto1 = new SimpleMessageWithServiceInterfaceDto();
        simpleMessageWithServiceInterfaceDto1.setId(1L);
        SimpleMessageWithServiceInterfaceDto simpleMessageWithServiceInterfaceDto2 = new SimpleMessageWithServiceInterfaceDto();
        simpleMessageWithServiceInterfaceDto2.setId(simpleMessageWithServiceInterfaceDto1.getId());
        assertThat(simpleMessageWithServiceInterfaceDto1).isEqualTo(simpleMessageWithServiceInterfaceDto2);
        simpleMessageWithServiceInterfaceDto2.setId(2L);
        assertThat(simpleMessageWithServiceInterfaceDto1).isNotEqualTo(simpleMessageWithServiceInterfaceDto2);
        simpleMessageWithServiceInterfaceDto1.setId(null);
        assertThat(simpleMessageWithServiceInterfaceDto1).isNotEqualTo(simpleMessageWithServiceInterfaceDto2);
    }
}
