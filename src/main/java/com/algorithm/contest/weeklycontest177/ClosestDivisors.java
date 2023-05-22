package com.algorithm.contest.weeklycontest177;

import java.util.Arrays;

public class ClosestDivisors {
    public static void main(String[] args) {
        ClosestDivisors d = new ClosestDivisors();
        System.out.println(Arrays.toString(d.closestDivisors(8)));
        System.out.println(Arrays.toString(d.closestDivisors(123)));
        System.out.println(Arrays.toString(d.closestDivisors(999)));
        System.out.println(Arrays.toString(d.closestDivisors(912382423)));
        System.out.println(Arrays.toString(d.closestDivisors(1)));

    }

    public int[] closestDivisors(int num) {
        int res[] = new int[2];
        int[] closest = new int[] { Integer.MAX_VALUE };
        closest(res, num + 1, closest);
        closest(res, num + 2, closest);
        return res;
    }

    void closest(int res[], int num, int[] closest) {
        int j = 1, n = num > 4 ? (Math.round((float) Math.sqrt(num))) : num;

        while (j <= n) {
            if (num % j == 0) {
                int n1 = num / j;
                int sub = Math.abs(n1 - j);
                if (sub == 0) {
                    res[0] = j;
                    res[1] = n1;
                    closest[0] = 0;
                    return;
                }
                if (closest[0] > sub) {
                    res[0] = j;
                    res[1] = n1;
                    closest[0] = sub;
                }
            }
            j++;
        }
    }
}
