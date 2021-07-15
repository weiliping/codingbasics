package com.algorithm.math;

public class PowerOfThree {

    /**
     * #326
     * https://leetcode-cn.com/problems/power-of-three/
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(isPowerOfThree(27));
        System.out.println(isPowerOfThree(45));
        System.out.println(isPowerOfThreeII(27));
        System.out.println(isPowerOfThreeII(45));
    }

    public static boolean isPowerOfThree(int n) {
        while (n > 0 && n % 3 == 0) {
            n /= 3;
        }
        return n == 1;
    }

    public static boolean isPowerOfThreeII(int n) {
        return (n > 0 && 1162261467 % n == 0);
    }
}
