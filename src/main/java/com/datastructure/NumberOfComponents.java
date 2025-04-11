package com.datastructure;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class NumberOfComponents {
    public static void main(String[] args) {
        int[][] properties = new int[][] {{2,1}, {4,4}, {1,3}, {3,4}, {2,3}, {4,3}, {2,2}};
        int k = 1;
        System.out.println(numberOfComponents(properties, k)); // 2

    }
    public static int numberOfComponents(int[][] properties, int k) {
        int m = properties.length;
        int cnt = 0;
        int[] cons = new int[m];
        for (int i = 0; i < m; i++) {
            cons[i] = i;
        }
        for (int i = 0; i < m; i++) {
            for (int j = i + 1; j < m; j++) {
                if (intersect(properties[i], properties[j]) >= k) {
                    
                }
            }
        }
        return cnt;
    }

    private void find(int[] cons, int j) {
        while (cons[j] != j) {
            j = cons[j];    
        }
        
    }
    private int intersect(int[] a, int[] b) {
        Set<Integer> h = new HashSet<Integer>();
        for (int num : a) {
            h.add(num);
        }
        int cnt = 0;
        Set<Integer> c = new HashSet<Integer>();
        for (int num : b) {
            if (!c.contains(num) && h.contains(num)) {
                cnt += 1;
            }
            c.add(num);
        }
        return cnt;
    }
}
