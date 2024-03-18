package com.algorithm.contest.weeklycontest380;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MaximumLength {
    public int maximumLength(int[] nums) {
        Map<Integer, Integer> m = new HashMap<>();
        for (int num : nums) {
            if (m.containsKey(Integer.valueOf(num))) {
                m.put(num, m.get(num) + 1);
                continue;
            }
            m.put(num, 1);
        }
        Object[] keys = m.keySet().toArray();
        Arrays.sort(keys);
        int res = 1;
        int startI = 0;
        if ((Integer) keys[0] == 1) {
            int v = m.get(1);
            if ((v & 1) == 1) {
                res = Math.max(res, v);
            } else {
                res = Math.max(res, v - 1);
            }
            startI = 1;
        }

        for (; startI < keys.length; startI++) {
            int sub = 0;
            int v = (Integer) keys[startI];
            while (m.getOrDefault(v, 0) > 1) {
                v *= v;
                sub += 2;
            }
            if (1 == m.getOrDefault(v, 0)) {
                sub++;
            } else {
                sub--;
            }
            res = Math.max(res, sub);
        }
        return res;
    }

    public static void main(String[] args) {
        MaximumLength m = new MaximumLength();
        System.out.println(m.maximumLength(new int[] { 5, 4, 1, 2, 2 }));
        System.out.println(m.maximumLength(new int[] { 1, 16, 49, 16, 121 }));
    }
}
