package com.algorithm.contest.weeklycontest441;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class BeautifulNumbers {
    

    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>();
        char[] chrs = new char[3];
        chrs[0] = 'a';
        chrs[1] = 'b';
        chrs[2] = 'c';
        System.out.println(String.valueOf(chrs));
        set.add(1);
        int j = 1;
        while (j < 10) {
            Set<Integer> set1 = new HashSet<>();
            for (int k : set) {
                for (int i = 1; i < 10; i++) {
                    set1.add(k * i);
                }        
            }
            if (j < 4) {
                System.out.println(Arrays.toString(set1.toArray()));
            }
            set = set1;
            j++;
        }
        System.out.println(set.size());
    }

    public int beautifulNumbers(int l, int r) {
        // 0 1~9;
        
        // int[0][1 -] dp = new int[10][10]; 
        return 0;
    }
}
