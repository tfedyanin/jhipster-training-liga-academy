package ru.liga.domain;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import ru.liga.web.rest.TestUtil;

public class SimpleMessageWithServiceInterfaceDtoPaginationTest {

    @Test
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(SimpleMessageWithServiceInterfaceDtoPagination.class);
        SimpleMessageWithServiceInterfaceDtoPagination simpleMessageWithServiceInterfaceDtoPagination1 = new SimpleMessageWithServiceInterfaceDtoPagination();
        simpleMessageWithServiceInterfaceDtoPagination1.setId(1L);
        SimpleMessageWithServiceInterfaceDtoPagination simpleMessageWithServiceInterfaceDtoPagination2 = new SimpleMessageWithServiceInterfaceDtoPagination();
        simpleMessageWithServiceInterfaceDtoPagination2.setId(simpleMessageWithServiceInterfaceDtoPagination1.getId());
        assertThat(simpleMessageWithServiceInterfaceDtoPagination1).isEqualTo(simpleMessageWithServiceInterfaceDtoPagination2);
        simpleMessageWithServiceInterfaceDtoPagination2.setId(2L);
        assertThat(simpleMessageWithServiceInterfaceDtoPagination1).isNotEqualTo(simpleMessageWithServiceInterfaceDtoPagination2);
        simpleMessageWithServiceInterfaceDtoPagination1.setId(null);
        assertThat(simpleMessageWithServiceInterfaceDtoPagination1).isNotEqualTo(simpleMessageWithServiceInterfaceDtoPagination2);
    }
}
