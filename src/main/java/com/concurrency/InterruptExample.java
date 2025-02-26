package com.concurrency;

public class InterruptExample {
    private static class MyThread1 extends Thread {
        @Override
        public void run() {
            try {
                System.out.println("Thread start to sleep");
                Thread.sleep(2000);
                System.out.println("Thread run");
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted");
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
       Thread thread1 = new MyThread1();
       thread1.start();
       thread1.interrupt();
       System.out.println("Main run");

        Thread thread2 = new MyThread2();
        thread2.start();
        thread2.interrupt();
    }

    private static class MyThread2 extends Thread {
        @Override
        public void run() {
            System.out.println("MyThread2 start");
            while (!interrupted()) {
                System.out.println("MyThread2 no interrupted");
            }
            System.out.println("Thread end");
        }
    }
}
