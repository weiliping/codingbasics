package com.algorithm.contest.weeklycontest199;

import java.util.HashMap;
import java.util.Map;

public class RestoreString {
    public static void main(String[] args) {
        System.out.println(restoreString("codeleet", new int[] {4,5,6,7,0,2,1,3}));
    }
    public static String restoreString(String s, int[] indices) {
        StringBuilder sb = new StringBuilder();
        Map<Integer, Integer> hash = new HashMap<>();
        for (int i = 0; i < indices.length; i++) {
            hash.put(indices[i], i);
        }
        for (int i = 0; i < indices.length; i++) {
            sb.append(s.charAt(hash.get(i)));
        }
        return sb.toString();
    }
}
