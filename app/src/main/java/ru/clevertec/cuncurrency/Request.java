package ru.clevertec.cuncurrency;

public class Request {

    private final int requestNumber;

    public Request(int requestNumber) {
        this.requestNumber = requestNumber;
    }

    public int getRequestNumber() {
        return requestNumber;
    }
}
