package ru.liga.domain;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import ru.liga.web.rest.TestUtil;

public class SimpleMessageWithServiceInterfaceDtoInfinityScrollTest {

    @Test
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(SimpleMessageWithServiceInterfaceDtoInfinityScroll.class);
        SimpleMessageWithServiceInterfaceDtoInfinityScroll simpleMessageWithServiceInterfaceDtoInfinityScroll1 = new SimpleMessageWithServiceInterfaceDtoInfinityScroll();
        simpleMessageWithServiceInterfaceDtoInfinityScroll1.setId(1L);
        SimpleMessageWithServiceInterfaceDtoInfinityScroll simpleMessageWithServiceInterfaceDtoInfinityScroll2 = new SimpleMessageWithServiceInterfaceDtoInfinityScroll();
        simpleMessageWithServiceInterfaceDtoInfinityScroll2.setId(simpleMessageWithServiceInterfaceDtoInfinityScroll1.getId());
        assertThat(simpleMessageWithServiceInterfaceDtoInfinityScroll1).isEqualTo(simpleMessageWithServiceInterfaceDtoInfinityScroll2);
        simpleMessageWithServiceInterfaceDtoInfinityScroll2.setId(2L);
        assertThat(simpleMessageWithServiceInterfaceDtoInfinityScroll1).isNotEqualTo(simpleMessageWithServiceInterfaceDtoInfinityScroll2);
        simpleMessageWithServiceInterfaceDtoInfinityScroll1.setId(null);
        assertThat(simpleMessageWithServiceInterfaceDtoInfinityScroll1).isNotEqualTo(simpleMessageWithServiceInterfaceDtoInfinityScroll2);
    }
}
