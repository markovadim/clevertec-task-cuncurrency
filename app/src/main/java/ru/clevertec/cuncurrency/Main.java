
package ru.clevertec.cuncurrency;

import java.util.List;
import java.util.concurrent.ExecutionException;

public class Main {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        List<Request> requestList = List.of(
                new Request(13),
                new Request(98),
                new Request(43),
                new Request(65),
                new Request(11)
        );
        Server server = new Server();

        Client client = new Client(requestList, server);

        client.sendRequests();
        client.getResponseList().stream().mapToInt(Response::getResponseNumber).forEach(System.out::println);
    }
}
