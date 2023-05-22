package com.jvm;

public class VolatileTest {
    public static void main(String[] args) throws InterruptedException {
        VolatileInc volatileInc = new VolatileInc();
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    volatileInc.numPlus();
                    volatileInc.numIncre();
                }
            }, "Thread" + i).start();
        }
//        Thread.sleep(1000);
//        for (int i = 0; i < 10; i++) {
//            new Thread(() -> {
//                for (int j = 0; j < 1000; j++) {
////                    volatileInc.numIncre();
//                }
//            }, "Thread " + i).start();
//        }


        System.out.println("最终Count=" + volatileInc.count);
        System.out.println("最终Count=" + volatileInc.countInt.get());
    }
}
