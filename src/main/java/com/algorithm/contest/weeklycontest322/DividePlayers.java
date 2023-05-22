package com.algorithm.contest.weeklycontest322;

import java.util.HashMap;
import java.util.Map;

public class DividePlayers {
    public static void main(String[] args) {
        int[] skill = new int[] { 2, 3, 4, 2, 5, 5 };
        System.out.println(dividePlayers(skill));
    }

    public static long dividePlayers(int[] skill) {
        int sum = 0, n = skill.length;
        for (int sk : skill) {
            sum += sk;
        }
        int h = n >> 1;

        if (sum % h != 0) {
            return -1l;
        }
        long res = 0l;
        sum /= h;

        Map<Integer, Integer> mp = new HashMap<>();
        for (int sk : skill) {
            Integer r = Integer.valueOf(sum - sk);
            Integer k = Integer.valueOf(sk);
            if (mp.containsKey(r)) {
                res += sk * r;
                if (mp.get(r) == 1) {
                    mp.remove(r);
                } else {
                    mp.put(r, mp.get(r) - 1);
                }
                continue;
            }
            mp.put(k, mp.getOrDefault(k, 0) + 1);
        }
        if (mp.size() != 0) {
            return -1l;
        }
        return res;
    }
}
