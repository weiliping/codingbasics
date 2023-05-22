package com.jvm;

import java.util.concurrent.atomic.AtomicInteger;

public class VolatileInc {

    public volatile int count = 0; //使用 volatile 修饰基本数据内存不能保证原子性

    public AtomicInteger countInt = new AtomicInteger(0) ;

    public void numPlus() {
//        synchronized (this) {
            count++;
//        }
    }

    public void numIncre() {
        countInt.getAndIncrement();
    }

//    @Override
//    public void run() {
//        synchronized (VolatileInc.class) {
//            for (int i = 0; i < 10000; i++) {
//                count++;
//                //            count.incrementAndGet() ;
//            }
//        }
//    }
}
