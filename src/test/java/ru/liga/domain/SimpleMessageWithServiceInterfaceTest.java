package ru.liga.domain;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import ru.liga.web.rest.TestUtil;

public class SimpleMessageWithServiceInterfaceTest {

    @Test
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(SimpleMessageWithServiceInterface.class);
        SimpleMessageWithServiceInterface simpleMessageWithServiceInterface1 = new SimpleMessageWithServiceInterface();
        simpleMessageWithServiceInterface1.setId(1L);
        SimpleMessageWithServiceInterface simpleMessageWithServiceInterface2 = new SimpleMessageWithServiceInterface();
        simpleMessageWithServiceInterface2.setId(simpleMessageWithServiceInterface1.getId());
        assertThat(simpleMessageWithServiceInterface1).isEqualTo(simpleMessageWithServiceInterface2);
        simpleMessageWithServiceInterface2.setId(2L);
        assertThat(simpleMessageWithServiceInterface1).isNotEqualTo(simpleMessageWithServiceInterface2);
        simpleMessageWithServiceInterface1.setId(null);
        assertThat(simpleMessageWithServiceInterface1).isNotEqualTo(simpleMessageWithServiceInterface2);
    }
}
