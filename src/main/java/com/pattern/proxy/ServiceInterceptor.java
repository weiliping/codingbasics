package com.pattern.proxy;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class ServiceInterceptor implements MethodInterceptor{
    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        System.out.println("Invoke method before: " + method.getName());
        Object result = proxy.invokeSuper(obj, args);
        System.out.println("Invoke method after:" + method.getName());
        return result;
    }
}
