package com.pattern.singleton;

import java.lang.reflect.Constructor;

public enum EnumSingleton {
    INSTANCE;

    public static void doSomething() {
        //do something
    }

    public static void main(String[] args) throws Exception {
        EnumSingleton s = EnumSingleton.INSTANCE;
        Constructor<EnumSingleton> constructor = EnumSingleton.class.getDeclaredConstructor();

        constructor.setAccessible(true);
        EnumSingleton reflectInstance = constructor.newInstance();
        System.out.println(s == reflectInstance);
    }
}
