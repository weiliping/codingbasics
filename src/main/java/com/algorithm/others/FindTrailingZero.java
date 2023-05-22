package com.algorithm.others;

public class FindTrailingZero {
    public static int findTrailingZero(int n) {
        int count = 0;
        for (long i = 5; n / i >= 1; i *= 5) {
            count += n / i;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(findTrailingZero(50));
    }
}
