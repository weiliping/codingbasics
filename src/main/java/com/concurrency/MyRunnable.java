package com.concurrency;

public class MyRunnable implements Runnable{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }

//    public static void main(String[] args) {
//        MyRunnable runnable = new MyRunnable();
//        Thread th = new Thread(runnable);
//        th.start();
//    }
}
