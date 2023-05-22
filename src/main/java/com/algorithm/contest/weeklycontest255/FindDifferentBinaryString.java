package com.algorithm.contest.weeklycontest255;

import java.util.Arrays;
import java.util.HashSet;

public class FindDifferentBinaryString {
    public static void main(String[] args) {
        FindDifferentBinaryString f = new FindDifferentBinaryString();
//        System.out.println(f.findDifferentBinaryString(new String[] {"1"}));
//        System.out.println(f.findDifferentBinaryString(new String[] {"01","10"}));
//        System.out.println(f.findDifferentBinaryString(new String[] {"00","01"}));
//        System.out.println(f.findDifferentBinaryString(new String[] {"00","10"}));
//        System.out.println(f.findDifferentBinaryString(new String[] {"01","10"}));
//        System.out.println(f.findDifferentBinaryString(new String[] {"111","011","001"}));
//        System.out.println(f.findDifferentBinaryString(new String[] {"000","001","110"}));
        System.out.println(f.findDifferentBinaryStringI(new String[] {"1001","1000","0110","1111"}));
    }
    public String findDifferentBinaryStringI(String[] nums) {
        HashSet<String> mp = new HashSet<>(Arrays.asList(nums));
        int n = nums[0].length();
        int len = (1 << n);
        String s;
        for (int i = 0; i < len; i++) {
            s = toBinaryString(i, n);
            if (mp.contains(s)) {
                continue;
            }
            return s;
        }
        return "";
    }
    public String findDifferentBinaryString(String[] nums) {
        int n = nums[0].length();
        Integer rs = Integer.parseInt(nums[0], 2);
        if (n == 1) {
            return rs == 1 ? "0" : "1";
        }
        if (n == 2) {
            Integer rs2 = Integer.parseInt(nums[1], 2);
            boolean[] res = new boolean[4];
            res[rs] = true;
            res[rs2] = true;
            for (int j = 0; j < 4; j++) {
                if (!res[j]) {
                    return toBinaryString(j, n);
                }
            }
        }
        for (int j = 1; j < nums.length; j++) {
            rs ^= Integer.parseInt(nums[j], 2);
        }

        return toBinaryString(rs, n);
    }

    public static String toBinaryString(int num, int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = n - 1; i >= 0; i--) {
            int mask = 1 << i;
            sb.append((num & mask) != 0 ? "1" : "0");
        }
        return sb.toString();
    }
}
