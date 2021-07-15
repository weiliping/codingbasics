package com.algorithm.selfpractice.round2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GrayCode {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(grayCode(1).toArray()));
        System.out.println(Arrays.toString(grayCode(2).toArray()));
        System.out.println(Arrays.toString(grayCode(3).toArray()));
    }

    public static List<Integer> grayCode(int n) {
        if (n == 0) {
            List<Integer> res = new ArrayList<>();
            res.add(0);
            return res;
        }
        int plusNum = 1 << (n - 1);
        List<Integer> subRes = grayCode(n - 1);
        for (int j = subRes.size() - 1; j >= 0; j--) {
            subRes.add(plusNum + subRes.get(j));
        }
        return subRes;
    }
}
