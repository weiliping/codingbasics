package com.algorithm.contest.biweeklycontest144;

import java.util.ArrayList;
import java.util.List;

public class MinDominoRotations {
    public static final int MOD = (int) 1e9 + 7;
    public static void main(String[] args) {
        System.out.println(MOD);
        List<String> list = new ArrayList<>();
        list.add("909920-0930a-23ad-3aaaa");
        list.add("909920-0930a-23ad-33332");
        String[] add = list.toArray(new String[0]);
        for (String s : add) {
            System.out.println(s);
        }
        
        // MinDominoRotations mdr = new MinDominoRotations();
        // int[] tops = {2,1,2,4,2,2};
        // int[] bottoms = {5, 2, 6, 2, 3, 2};
        // System.out.println(mdr.minDominoRotations(tops, bottoms)); // Output: 2
    }
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int n = tops.length;
        int cnt = n;
        for (int i = 1; i <= 6; i++) {
            int topCount = 0;
            int bottomCount = 0;
            int j = 0;
            while (j < n && (tops[j] == i || bottoms[j] == i)) {
                if (tops[j] != i) {
                    topCount++;
                }
                if (bottoms[j] != i) {
                    bottomCount++;
                }
                j++;
            }
            if (j == n) {
                cnt = Math.min(cnt, Math.min(topCount, bottomCount));
            }
        }
        return cnt == n ? -1 : cnt;
    }
}
