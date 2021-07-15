package com.algorithm.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GaryCode {

    /**
     * #89
     * https://zh.wikipedia.org/zh-cn/%E6%A0%BC%E9%9B%B7%E7%A0%81
     * https://www.cnblogs.com/grandyang/p/4315649.html
     * https://leetcode-cn.com/problems/gray-code
     *
     * @param args
     */
    public static void main(String[] args) {
        List<Integer> res = new GaryCode().grayCode(3);
        System.out.println(Arrays.toString(res.toArray()));
    }

    public List<Integer> grayCode(int n) {
        if (n == 0) {
            List<Integer> res = new ArrayList<>();
            res.add(0);
            return res;
        }

        List<Integer> res = grayCode(n - 1);
        int numToAdd = 1 << (n - 1);

        for (int i = res.size() - 1; i >= 0; i--) {
            res.add(numToAdd + res.get(i));
        }
        return res;
    }
}
