package com.algorithm.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IsHappy {

    public static boolean isHappy(int n) {
        return isHappyHelper(n, new ArrayList<>());
    }

    public static boolean isHappyHelper(int n, List<Integer> nums) {
        if (n == 1) {
            return true;
        }

        int res = 0;
        while (n > 0) {
            int s = n % 10;
            res += s * s;
            n /= 10;
        }
        if (nums.contains(res)) {
            return false;
        }
        nums.add(res);
        return isHappyHelper(res, nums);
    }
    public static void main(String[] args) {
        int n = 2;
        System.out.println(isHappy(n));
        System.out.println(isHappy(19));
    }


}
