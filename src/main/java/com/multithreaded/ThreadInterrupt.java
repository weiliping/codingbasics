package com.multithreaded;

public class ThreadInterrupt {
    public static void main(String[] args) {
        Thread t = new Thread(new NRunnable());
        t.start();
        System.out.println("Thread is start ..... ");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t.interrupt();
        System.out.println("Thread is interrupt ....");
    }

    public static class NRunnable implements Runnable {
        @Override
        public void run() {
            while (true) {
                System.out.println("I am not interrupted.");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
