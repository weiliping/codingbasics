package com.concurrency.self;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ProducerConsumerSample {
    public void execute() {
        Resource res = new Resource();
        ExecutorService executor = Executors.newFixedThreadPool(6);
        int i = 0;
        while (i < 20) {

            executor.execute(() -> {
                new ProducerThread(res).run();
            });
            i++;
        }
        int j = 0;
        while (j < 20) {
            executor.execute(() -> {
                new ConsumerThread(res).run();
            });
            j++;
        }
    }

    public static void main(String[] args) {
        ProducerConsumerSample p = new ProducerConsumerSample();
        p.execute();
    }
}
