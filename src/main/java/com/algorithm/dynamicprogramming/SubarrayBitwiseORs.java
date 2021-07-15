package com.algorithm.dynamicprogramming;

import java.util.HashSet;
import java.util.Set;

public class SubarrayBitwiseORs {

    /**
     * #898
     * https://leetcode-cn.com/problems/bitwise-ors-of-subarrays/
     * @param args
     */
    public static void main(String[] args) {
//        System.out.println(subarrayBitwiseORs(new int[]{0}));
//        System.out.println(subarrayBitwiseORs(new int[]{1, 1, 2}));
        System.out.println(subarrayBitwiseORs(new int[]{1, 2, 4}));
    }

    public static int subarrayBitwiseORs(int[] A) {
        Set<Integer> ans = new HashSet();
        Set<Integer> cur = new HashSet();
        cur.add(0);
        for (int x: A) {
            Set<Integer> cur2 = new HashSet();
            for (int y: cur) {
                cur2.add(x | y);
            }
            cur2.add(x);
            cur = cur2;
            ans.addAll(cur);
        }

        return ans.size();
    }
}
