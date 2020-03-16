package ru.liga.domain;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import ru.liga.web.rest.TestUtil;

public class SimpleMessageWithServiceInterfaceDtoInfinityScrollFilteringTest {

    @Test
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(SimpleMessageWithServiceInterfaceDtoInfinityScrollFiltering.class);
        SimpleMessageWithServiceInterfaceDtoInfinityScrollFiltering simpleMessageWithServiceInterfaceDtoInfinityScrollFiltering1 = new SimpleMessageWithServiceInterfaceDtoInfinityScrollFiltering();
        simpleMessageWithServiceInterfaceDtoInfinityScrollFiltering1.setId(1L);
        SimpleMessageWithServiceInterfaceDtoInfinityScrollFiltering simpleMessageWithServiceInterfaceDtoInfinityScrollFiltering2 = new SimpleMessageWithServiceInterfaceDtoInfinityScrollFiltering();
        simpleMessageWithServiceInterfaceDtoInfinityScrollFiltering2.setId(simpleMessageWithServiceInterfaceDtoInfinityScrollFiltering1.getId());
        assertThat(simpleMessageWithServiceInterfaceDtoInfinityScrollFiltering1).isEqualTo(simpleMessageWithServiceInterfaceDtoInfinityScrollFiltering2);
        simpleMessageWithServiceInterfaceDtoInfinityScrollFiltering2.setId(2L);
        assertThat(simpleMessageWithServiceInterfaceDtoInfinityScrollFiltering1).isNotEqualTo(simpleMessageWithServiceInterfaceDtoInfinityScrollFiltering2);
        simpleMessageWithServiceInterfaceDtoInfinityScrollFiltering1.setId(null);
        assertThat(simpleMessageWithServiceInterfaceDtoInfinityScrollFiltering1).isNotEqualTo(simpleMessageWithServiceInterfaceDtoInfinityScrollFiltering2);
    }
}
