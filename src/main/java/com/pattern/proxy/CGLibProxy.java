package com.pattern.proxy;

import net.sf.cglib.proxy.Enhancer;

public class CGLibProxy {
    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(UserService.class);
        enhancer.setCallback(new ServiceInterceptor());
        UserService proxy = (UserService) enhancer.create();

        proxy.addUser("Paul Wei");
        proxy.deleteUser("Paul Wei");
        System.out.println(proxy.updateUser("Paul Wei"));
        System.out.println(proxy.updateUser(""));
    }
}
