package com.algorithm.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PascalsTriangle {

    /**
     * #118
     * https://leetcode-cn.com/problems/pascals-triangle/
     *
     * @param args
     */
    public static void main(String[] args) {
        List<List<Integer>> res = generate(5);
        for (List<Integer> r : res) {
            System.out.println(Arrays.toString(r.toArray()));
        }
    }

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        if (numRows < 1) {
            return res;
        }

        for (int i = 1; i <= numRows; i++) {
            if (i == 1) {
                res.add(new ArrayList<>(Arrays.asList(1)));
                continue;
            }
            List<Integer> subRes = new ArrayList<>();
            subRes.add(1);
            List<Integer> preNums = res.get(i - 2);
            for (int j = 1; j < preNums.size(); j++) {
                subRes.add(preNums.get(j - 1) + preNums.get(j));
            }
            subRes.add(1);
            res.add(subRes);
        }
        return res;
    }
}
