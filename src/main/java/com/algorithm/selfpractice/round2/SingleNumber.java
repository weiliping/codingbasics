package com.algorithm.selfpractice.round2;

public class SingleNumber {

    public static void main(String[] args) {
//        int x = 123;
//        System.out.println((0 ^ x) & ~0);
//        System.out.println((0 ^ x) & ~x);
//        System.out.println((x ^ x) & ~0);
//        System.out.println(singleNumber(new int[] {2, 2, 1, 1, 5, 3, 3, 5, 4}));
        System.out.println(singleNumberII(new int[] {0,1,0,1,0,1,99}));
    }

    public static int singleNumberII(int[] nums) {
        int a = 0, b = 0;
        for (int n : nums) {
            b = (b ^ n) & ~a;
            a = (a ^ n) & ~b;
        }
        return b;
    }

    public static int singleNumber(int[] nums) {
        int res = 0;

        for(int n : nums) {
            res = res ^ n;
        }
        return res;
    }
}
