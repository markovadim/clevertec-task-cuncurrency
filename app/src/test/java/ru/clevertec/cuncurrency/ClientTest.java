package ru.clevertec.cuncurrency;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.clevertec.util.TestDataUtil;

import java.util.concurrent.ExecutionException;

import static org.assertj.core.api.Assertions.assertThat;
import static ru.clevertec.util.TestDataUtil.ID_EXAMPLE_ZERO;
import static ru.clevertec.util.TestDataUtil.TEN;

class ClientTest {

    private Client client;

    @BeforeEach
    public void setUp() throws ExecutionException, InterruptedException {
        Server server = new Server();
        client = new Client(TestDataUtil.requestList, server);
        client.sendRequests();
    }

    @Test
    @DisplayName("Check response list")
    void checkSendRequestsShouldReturnNotEmptyList() {
        assertThat(client.getResponseList())
                .hasSize(TestDataUtil.ONE);
    }

    @Test
    @DisplayName("Check sending of requests to server")
    void checkSendRequestsShouldReturnRightResponseNumber() {
        assertThat(client.getResponseList().get(ID_EXAMPLE_ZERO).getResponseNumber())
                .isEqualTo(TEN);
    }
}