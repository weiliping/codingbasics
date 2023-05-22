package com.algorithm.contest.weeklycontest171;

import java.util.Arrays;

public class GetNoZeroIntegers {
    public static void main(String[] args) {
        GetNoZeroIntegers g = new GetNoZeroIntegers();
        System.out.println(Arrays.toString(g.getNoZeroIntegers(2)));
        System.out.println(Arrays.toString(g.getNoZeroIntegers(11)));
        System.out.println(Arrays.toString(g.getNoZeroIntegers(10000)));
        System.out.println(Arrays.toString(g.getNoZeroIntegers(69)));
        System.out.println(Arrays.toString(g.getNoZeroIntegers(1010)));
    }

    public int[] getNoZeroIntegers(int n) {
        int h = (n >> 1), j = 1;
        int[] res = new int[2];
        while (j <= h) {
            if (!containZero(j) && (!containZero(n - j))) {
                res[0] = j;
                res[1] = n - j;
                return res;
            }
            j++;
        }
        return res;
    }

    boolean containZero(int i) {
        while (i > 0) {
            if (i % 10 == 0) {
                return true;
            }
            i /= 10;
        }
        return false;
    }
}
