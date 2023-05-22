package com.multithreaded;

import java.io.IOException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class TaskExecutionWebServer {

    private static final int NTHREADS = 100;
    private static final Executor exec = Executors.newFixedThreadPool(NTHREADS);

    public static void main(String[] args) throws IOException {
        // ServerSocket socket = new ServerSocket(80);
        while (true) {
            // final Socket connection = socket.accept();
            Runnable task = new Runnable() {
                @Override
                public void run() {
                    System.out.println("handle request");
                }
            };
            exec.execute(task);
        }
    }
}
