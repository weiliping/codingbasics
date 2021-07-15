package com.datastructure.day1;

public class DivideSame {

    public static void main(String args[]) {
        System.out.println(canDivide(new int[]{1, 3, 4, 5, 7, 9, 11}));
    }

    static boolean canDivide(int a[]) {
        if (a == null || a.length < 2) {
            return false;
        }

        int sum = 0;

        for (int n : a) {
            sum += n;
        }


        if (sum % 2 != 0) {
            return false;
        }

        int target = sum / 2;
        boolean dp[] = new boolean[target + 1];
        dp[0] = true;

        for (int i = 0; i < a.length; i++) {
            for (int j = target; j >= a[i]; j--) {
                dp[j] |= dp[j - a[i]];
            }
        }
        return dp[target];
    }
}
