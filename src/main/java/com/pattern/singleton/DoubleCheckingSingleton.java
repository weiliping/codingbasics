package com.pattern.singleton;

import java.lang.reflect.Constructor;

public class DoubleCheckingSingleton {
    private static DoubleCheckingSingleton instance;
    private static boolean isInstance = false;

    private DoubleCheckingSingleton() {
        if (!isInstance) {
            isInstance = true;
        } else {
            throw new IllegalArgumentException("can not be inflect");
        }
    }

    public static synchronized DoubleCheckingSingleton getInstance() {
        if (instance == null) {
            synchronized (DoubleCheckingSingleton.class) {
                if (instance == null) {
                    instance = new DoubleCheckingSingleton();
                }
            }
        }
        return instance;
    }

    public static void main(String[] args) throws Exception {

        Constructor<DoubleCheckingSingleton> constructor = DoubleCheckingSingleton.class.getDeclaredConstructor();

        constructor.setAccessible(true);
        DoubleCheckingSingleton reflectInstance = constructor.newInstance();
        System.out.println(reflectInstance);
        DoubleCheckingSingleton s = DoubleCheckingSingleton.getInstance();
//        DoubleCheckingSingleton s2 = DoubleCheckingSingleton.getInstance();
//        System.out.println(s == s2);
        System.out.println(s == reflectInstance);
    }
}
