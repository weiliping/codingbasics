package com.jvm;

public class JavaBean {
    private int value = 1;
    public String s = "abc";
    public final static int f = 0x101;

    public static final int i = 0;

    public final static int j = 0;


    public void setValue(int v){
        final int temp = 3;
        this.value = temp + v;
    }

    public int getValue(){
        return value;
    }
}
