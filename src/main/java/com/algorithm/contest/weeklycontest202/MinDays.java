package com.algorithm.contest.weeklycontest202;

import java.util.HashMap;
import java.util.Map;

public class MinDays {

    public static void main(String[] args) {
        System.out.println(new MinDays().minDays(10));
    }
    public int minDays(int n) {
        return getMinDay(n);

    }
    private Map<Integer, Integer> maps = new HashMap<>();

    private int getMinDay(int n){
        if(n == 1) return 1;
        if(n == 2) return 2;
        if(n == 3) return 2;
        Integer re = maps.get(n);
        if(re != null) {
            return re;
        }
        int m2 = getMinDay(n / 2) + n % 2;
        int m3 = getMinDay(n / 3) + n % 3;
        int result = Math.min(m2, m3) + 1;
        maps.put(n,result);
        return result;
    }
}
