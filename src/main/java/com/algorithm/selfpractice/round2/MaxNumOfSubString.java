package com.algorithm.selfpractice.round2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaxNumOfSubString {
    public static void main(String[] args) {

    }
    public List<String> maxNumOfSubstrings(String s) {
        int[][] index = new int[26][2];
        for (int i = 0; i < 26; i++) {
            Arrays.fill(index[i], -1);
        }
        for (int i = 0; i < s.length(); i++) {
            if (index[s.charAt(i) - 'a'][0] == -1) {
                index[s.charAt(i) - 'a'][0] = i;
            }
            index[s.charAt(i) - 'a'][1] = i;
        }
        int[] ee = new int[s.length()];
        Arrays.fill(ee, -1);
        for (int i = 0; i < 26; i++) {
            if (index[i][0] != -1) {
                int max = index[i][1];
                for (int j = index[i][0]; j <= max; j++) {
                    if (index[s.charAt(j) - 'a'][0] >= index[i][0]) {
                        max = Math.max(max, index[s.charAt(j) - 'a'][1]);
                    } else {
                        ee[index[i][0]] = -2;
                        break;
                    }
                }
                if (ee[index[i][0]] != -2) {
                    ee[index[i][0]] = max;
                }
            }
        }
        int start = ee.length;
        ArrayList<String> list = new ArrayList<>();
        for (int i = ee.length - 1; i >= 0; i--) {
            if (ee[i] >= 0 && ee[i] < start) {
                list.add(s.substring(i, ee[i] + 1));
                start = i;
            }
        }
        return list;
    }
}
