package com.algorithm.contest.weeklycontest182;

import java.util.Iterator;
import java.util.TreeMap;

public class FindLucky {

    public static void main(String[] args) {
        FindLucky f = new FindLucky();
        System.out.println(f.findLucky(new int[] {2, 2, 3, 4}));
        System.out.println(f.findLucky(new int[] {5}));
        System.out.println(f.findLucky(new int[] {2, 2, 2, 3, 3}));
        System.out.println(f.findLucky(new int[] {1, 2, 2, 3, 3, 3}));
    }
    public int findLucky(int[] arr) {
        TreeMap<Integer, Integer> cnts = new TreeMap<>();

        for (int num : arr) {
            cnts.put(num, cnts.getOrDefault(num, 0) + 1);
        }
        Iterator<Integer> it = cnts.descendingKeySet().iterator();
        while (it.hasNext()) {
            Integer k = it.next();
            if (k == cnts.get(k)) {
                return k;
            }
        }
        return -1;
    }
}
