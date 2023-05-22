package com.algorithm.contest.biweeklycontest64;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class KthDistinct {
    public static void main(String[] args) {
        System.out.println(kthDistinct(new String[]{"d","b","c","b","c","a"}, 2));
    }
    public static String kthDistinct(String[] arr, int k) {
        List<String> list = new ArrayList<>();
        Set<String> s2 = new HashSet<>();
        for (String s : arr) {
            if (s2.contains(s)) {
                continue;
            }
            if (list.contains(s)) {
                list.remove(s);
                s2.add(s);
                continue;
            }
            list.add(s);
        }
        if (k > list.size()) {
            return "";
        }
        return list.get(k - 1);
    }
}
