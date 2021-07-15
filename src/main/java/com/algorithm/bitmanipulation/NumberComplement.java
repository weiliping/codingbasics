package com.algorithm.bitmanipulation;

public class NumberComplement {

    public static void main(String[] args) {
        System.out.println(findComplement(8));
        System.out.println(findComplement(10));
    }
    public static int findComplement(int num) {
        int bit_count = 1, n = num;
        while (n > 0) {
            bit_count = bit_count << 1;
            n = n >> 1;
        }
        bit_count--;
        return num ^ bit_count;
    }
}
