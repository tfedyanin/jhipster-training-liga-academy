package ru.liga.domain;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import ru.liga.web.rest.TestUtil;

public class SimpleMessageTest {

    @Test
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(SimpleMessage.class);
        SimpleMessage simpleMessage1 = new SimpleMessage();
        simpleMessage1.setId(1L);
        SimpleMessage simpleMessage2 = new SimpleMessage();
        simpleMessage2.setId(simpleMessage1.getId());
        assertThat(simpleMessage1).isEqualTo(simpleMessage2);
        simpleMessage2.setId(2L);
        assertThat(simpleMessage1).isNotEqualTo(simpleMessage2);
        simpleMessage1.setId(null);
        assertThat(simpleMessage1).isNotEqualTo(simpleMessage2);
    }
}
