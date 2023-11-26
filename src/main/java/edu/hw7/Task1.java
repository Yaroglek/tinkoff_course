package edu.hw7;

import java.util.concurrent.atomic.AtomicInteger;

public class Task1 {
    private static final int THREADS_NUMBER = 4;
    private static final int ITERATIONS_NUMBER = 10000;
    private static AtomicInteger counter = new AtomicInteger(0);

    public AtomicInteger getCounter() {
        return counter;
    }

    public static void increaseCounter() {
        Thread[] threads = new Thread[THREADS_NUMBER];

        Runnable increment = () -> {
            for (int i = 0; i < ITERATIONS_NUMBER; i++) {
                counter.incrementAndGet();
            }
        };

        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(increment);
            threads[i].start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException();
            }
        }
    }
}
