package ru.clevertec.cuncurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Client {

    private final List<Request> requestList;
    private final List<Response> responseList;
    private final Server server;
    private final ExecutorService executorService;

    public Client(List<Request> requestList, Server server) {
        this.requestList = requestList;
        this.responseList = new ArrayList<>();
        this.server = server;
        this.executorService = Executors.newFixedThreadPool(requestList.size());
    }

    public void sendRequests() throws InterruptedException, ExecutionException {
        for (Request request : requestList) {
            Future<Response> responseFuture = executorService.submit(() -> server.handleRequest(request));
            putResponse(responseFuture.get());
        }
        executorService.shutdown();
    }

    private void putResponse(Response response) {
        responseList.add(response);
    }

    public List<Response> getResponseList() {
        return responseList;
    }
}
