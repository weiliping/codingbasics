package com.algorithm.contest.weeklycontest226;

import java.util.HashMap;
import java.util.Map;

public class CountBalls {

    public static void main(String[] args) {
//        System.out.println(countBalls(5, 15));
//        System.out.println(countBalls(1, 10));
//        System.out.println(countBalls(11, 104));
//        System.out.println(countBalls(220, 548));
        System.out.println(toKey(544));
    }
    public static int countBalls(int lowLimit, int highLimit) {
        Map<Integer, Integer> cnts = new HashMap<>();
        int i = lowLimit, res = 0;
        while (i <= highLimit) {
            int key = toKey(i);
            int val = cnts.getOrDefault(key, 0) + 1;
            cnts.put(key, val);
            if (res < val) {
                res = val;
            }
            i++;
        }
        return res;
    }

    static int toKey(int num) {
        int res = 0;
        while (num > 0) {
            res += num % 10;
            num /= 10;
        }
        return res;
    }
}
