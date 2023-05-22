package com.algorithm.greedyalgorithm;

public class BrokenCalc {
    /**
     * #991
     * https://leetcode-cn.com/problems/broken-calculator/
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(brokenCalc(2, 3));
        System.out.println(brokenCalc(5, 8));
        System.out.println(brokenCalc(3, 10));
        System.out.println(brokenCalc(1024, 1));
        System.out.println(brokenCalc(1, 1000000000));
    }

    public static int brokenCalc(int X, int Y) {
        if (X >= Y) {
            return X - Y;
        }
        int res = 0;
        while (Y > X) {
            if (Y % 2 == 0) {
                Y = Y / 2;
                res += 1;
            } else {
                Y = (Y + 1)/2;
                res += 2;
            }
        }
        return res + (X - Y);
    }
}
