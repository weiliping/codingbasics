package com.algorithm.others;

import java.util.ArrayList;
import java.util.List;

public class GrayCode {

    public static void main(String[] args) {
        GrayCode graycode = new GrayCode();
        System.out.println(graycode.grayCode(4));
    }

    public List<Integer> grayCode(int n) {
        if (n == 0) {
            List<Integer> result = new ArrayList<Integer>();
            result.add(0);
            return result;
        }

        List<Integer> result = grayCode(n - 1);
        int numToAdd = 1 << (n - 1);

        for (int i = result.size() - 1; i >= 0; i--) { //iterate from last to first
            result.add(numToAdd + result.get(i));
        }

        return result;
    }
}
