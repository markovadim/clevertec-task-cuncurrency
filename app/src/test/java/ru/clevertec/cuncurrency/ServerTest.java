package ru.clevertec.cuncurrency;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static ru.clevertec.util.TestDataUtil.NINETY;
import static ru.clevertec.util.TestDataUtil.TEN;

class ServerTest {

    @Test
    @DisplayName("Check correct working of server function")
    void checkHandleRequestShouldReturnResponseNumberOfTen() throws InterruptedException {
        Server server = new Server();

        Response responseActual = server.handleRequest(new Request(NINETY));

        assertThat(responseActual.getResponseNumber())
                .isEqualTo(TEN);
    }
}