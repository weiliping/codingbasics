package com.algorithm.bitmanipulation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RepeatedDnaSequences {
    static final List<Character> m = Arrays.asList('A', 'C', 'G', 'T');

    /**
     * #187
     * https://leetcode-cn.com/problems/repeated-dna-sequences
     * @param args
     */
    public static void main(String[] args) {
//        System.out.println(Arrays.toString(findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT").toArray()));
        System.out.println(Arrays.toString(findRepeatedDnaSequences("AAAAAAAAAAAA").toArray()));
    }

    public static List<String> findRepeatedDnaSequences(String s) {
        List<String> res = new ArrayList<>();
        if (s == null || s.isEmpty() || s.length() <= 10) {
            return res;
        }

        Set<Integer> count = new HashSet<>();

        int cur = 0;
        for(int i = 0; i < 9; i++) {
            cur = cur << 2 | m.indexOf(s.charAt(i));
        }

        for (int i = 9; i < s.length(); i++) {
            cur = (((cur & 0x3ffff) << 2) | m.indexOf(s.charAt(i)));
            if (count.contains(cur)) {
                String st = s.substring(i - 9, i + 1);
                if (!res.contains(st)) {
                    res.add(st);
                }
                continue;
            }
            count.add(cur);
        }
        return res;
    }
}
