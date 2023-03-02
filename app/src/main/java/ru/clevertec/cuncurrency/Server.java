package ru.clevertec.cuncurrency;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Server {

    private final Lock lock;

    public Server() {
        this.lock = new ReentrantLock();
    }

    public Response handleRequest(Request request) throws InterruptedException {
        lock.lock();
        Thread.sleep(getRandomSleepTime());
        lock.unlock();
        int responseNumber = serverFunction(request.getRequestNumber());
        return new Response(responseNumber);
    }

    private int serverFunction(int requestNumber) {
        return 100 - requestNumber;
    }

    private int getRandomSleepTime() {
        return (int) (Math.random() * 2000);
    }
}
