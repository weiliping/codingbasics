package com.pattern.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DynamicProxyHandler implements InvocationHandler {
    private IHello hello;

    public DynamicProxyHandler(IHello hello) {
        this.hello = hello;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("Dynamic proxy start here");
        Object obj = method.invoke(hello, args);
        System.out.println("Dynamic proxy end here");
        return obj;
    }

    public static void main(String[] args) {
        IHelloImpl hello = new IHelloImpl();
        DynamicProxyHandler proxy = new DynamicProxyHandler(hello);
        IHello iHello = (IHello) Proxy.newProxyInstance(
                            IHelloImpl.class.getClassLoader(),
                            IHelloImpl.class.getInterfaces(),
                            proxy);
        iHello.helloWorld();
        iHello.print("Paul Wei");

        System.out.println(iHello.invokeMethod("paul"));
        System.out.println(iHello.invokeMethod("Wei"));
    }
}
