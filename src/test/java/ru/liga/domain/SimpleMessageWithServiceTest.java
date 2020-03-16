package ru.liga.domain;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import ru.liga.web.rest.TestUtil;

public class SimpleMessageWithServiceTest {

    @Test
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(SimpleMessageWithService.class);
        SimpleMessageWithService simpleMessageWithService1 = new SimpleMessageWithService();
        simpleMessageWithService1.setId(1L);
        SimpleMessageWithService simpleMessageWithService2 = new SimpleMessageWithService();
        simpleMessageWithService2.setId(simpleMessageWithService1.getId());
        assertThat(simpleMessageWithService1).isEqualTo(simpleMessageWithService2);
        simpleMessageWithService2.setId(2L);
        assertThat(simpleMessageWithService1).isNotEqualTo(simpleMessageWithService2);
        simpleMessageWithService1.setId(null);
        assertThat(simpleMessageWithService1).isNotEqualTo(simpleMessageWithService2);
    }
}
