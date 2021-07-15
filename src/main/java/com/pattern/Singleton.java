package com.pattern;

public class Singleton {
    private volatile static Singleton singleton = null;

    private Singleton(){};

    public static Singleton getInstance() {
        if (singleton == null) {
            synchronized(Singleton.class) {
                if (singleton == null) {
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }

    public static void main(String[] args) {

    }
}
