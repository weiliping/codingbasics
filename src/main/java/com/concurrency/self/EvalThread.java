package com.concurrency.self;

public class EvalThread extends Thread {

    public void run() {
        System.out.println("thread");
    }

    public static void main(String[] args) {
        // EvalThread th = new EvalThread();
        // th.run();
        // th.start();
        // th.start();
        // String s1 = "a";
        // String s2 = new String("a");
        // System.out.println(s1 == s2);
        // StringBuilder sb = new StringBuilder();
        // System.out.println(sb.capacity());
        // sb.append("abcd");
        // sb.append("The greatness of a man lies in his attitude");
        // System.out.println(sb.capacity());

        double a = 295.04;
        int b = 300;
        byte c = (byte) a;
        byte d = (byte) b;
        System.out.println(c + " " + d);
    }
}
