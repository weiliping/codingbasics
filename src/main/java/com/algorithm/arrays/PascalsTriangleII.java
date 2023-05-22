package com.algorithm.arrays;

import java.util.Arrays;
import java.util.List;

public class PascalsTriangleII {

    /**
     * #119
     * https://leetcode-cn.com/problems/pascals-triangle-ii/
     *
     * @param args
     */
    public static void main(String[] args) {
        getRow(6);
    }

    public static List<Integer> getRow(int rowIndex) {
        Integer[] res = new Integer[rowIndex + 1];
        Arrays.fill(res, 0);
        res[0] = 1;
        for (int i = 1; i <= rowIndex; i++) {
            for (int j = i; j >= 1; j--) {
                res[j] += res[j - 1];
            }
            System.out.println(Arrays.toString(res));;
        }
        return Arrays.asList(res);
    }
}
