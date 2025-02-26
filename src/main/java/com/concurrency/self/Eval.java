package com.concurrency.self;

import java.util.*;
public class Eval {

    public static void main(String[] args) {
        // Object obj = new ArrayList().iterator();
        // System.out.println((obj instanceof List));
        // System.out.println((obj instanceof Iterator));   
        // System.out.println(obj instanceof ListIterator);
        // eval(null);
    }

    public static void eval(String s) {
        System.out.println("print s");
    }
    
    public static void eval(Object obj) {
        System.out.println("print object");
    }

    public static void eval(Integer it) {
        System.out.println("print integer");
    }
}
