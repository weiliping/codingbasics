package com.multithreaded;

public class WorkThread implements Runnable {
    private String msg;

    public WorkThread(String msg) {
        this.msg = msg;
    }

    public void run(){
        System.out.println(Thread.currentThread().getName() + " (Start) message" + msg);
        processMsg();
        System.out.println(Thread.currentThread().getName() + " End ");
    }

    private void processMsg(){
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
