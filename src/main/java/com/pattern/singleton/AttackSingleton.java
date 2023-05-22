package com.pattern.singleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class AttackSingleton {
    public static void main(String[] args) {
        Class<?> singletonClass = InnerClassSingleton.class;
        try {
            Constructor<?>[] constructors = singletonClass.getDeclaredConstructors();
            constructors[0].setAccessible(true);
            InnerClassSingleton instance1 = (InnerClassSingleton) constructors[0].newInstance();
            InnerClassSingleton instance2 = (InnerClassSingleton) constructors[0].newInstance();
            if (instance1 == instance2) {
                System.out.println("attack failed,攻击Sinleton5失败");
            } else {
                System.out.println("attack success!攻击Sinleton5成功，创建了多个实例");
            }
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
