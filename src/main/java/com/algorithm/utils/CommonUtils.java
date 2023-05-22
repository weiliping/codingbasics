package com.algorithm.utils;

import java.util.Arrays;
import java.util.List;

public enum CommonUtils {
    INSTANCE;

    public static void printArrayList(List<List<String>> res) {
        for (List<String> r : res) {
            System.out.println(Arrays.toString(r.toArray()));
        }
    }

    public static void printArrayInteger(List<List<Integer>> res) {
        for (List<Integer> r : res) {
            System.out.println(Arrays.toString(r.toArray()));
        }
    }
}
