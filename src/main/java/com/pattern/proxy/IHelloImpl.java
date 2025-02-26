package com.pattern.proxy;

public class IHelloImpl implements IHello {

    @Override
    public void helloWorld() {
        System.out.println("Hello World");
    }

    @Override
    public void print(String name) {
        System.out.println("Initial Class method invoked. And print: " + name + ".");
    }

    @Override
    public String invokeMethod(String name) {
        if ("paul".equals(name)) {
            return "This method was invoked by Paul. invokeMethod()";
        } else {
            return "You have no permission to invoke this method. invokeMethod()";
        }
    }
}
