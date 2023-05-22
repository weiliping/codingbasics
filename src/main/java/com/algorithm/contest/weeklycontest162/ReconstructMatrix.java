package com.algorithm.contest.weeklycontest162;

import java.util.ArrayList;
import java.util.List;

public class ReconstructMatrix {
    public static void main(String[] args) {
        ReconstructMatrix r = new ReconstructMatrix();
        System.out.println(r.reconstructMatrix(2, 1, new int[] {1, 1, 1}));
        System.out.println(r.reconstructMatrix(2, 3, new int[] {2, 2, 1, 1}));
        System.out.println(r.reconstructMatrix(5, 5, new int[] {2,1,2,0,1,0,1,2,0,1}));
    }
    public List<List<Integer>> reconstructMatrix(int upper, int lower, int[] colsum) {
        int sum = 0, twoCnt = 0;
        List<List<Integer>> res = new ArrayList<>();
        for (int c : colsum) {
            sum += c;
            if (c > 2) {
                return res;
            }
            if (c == 2) {
                twoCnt++;
            }
        }

        if (upper < twoCnt || lower < twoCnt || upper + lower != sum) {
            return res;
        }

        upper = upper - twoCnt;
        List<Integer> upperList = new ArrayList<>();
        List<Integer> lowList = new ArrayList<>();
        for (int c : colsum) {
            if (c == 2) {
                upperList.add(1);
                lowList.add(1);
                continue;
            }
            if (c == 1) {
                if (upper > 0) {
                    upperList.add(1);
                    lowList.add(0);
                    upper--;
                    continue;
                }
                lowList.add(1);
                upperList.add(0);
                continue;
            }
            lowList.add(0);
            upperList.add(0);
        }
        res.add(upperList);
        res.add(lowList);
        return res;
    }
}
