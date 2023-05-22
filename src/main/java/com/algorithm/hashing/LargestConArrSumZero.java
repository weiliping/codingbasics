package com.algorithm.hashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class LargestConArrSumZero {
    /**
     * https://www.interviewbit.com/problems/largest-continuous-sequence-zero-sum/
     *
     * @param args
     */
    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<Integer>();
        A.add(1);
        A.add(2);
        A.add(-3);
        A.add(3);
        System.out.println(new LargestConArrSumZero().lszero(A));
    }

    public ArrayList<Integer> lszero(ArrayList<Integer> A) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        ArrayList<Integer> result = new ArrayList<Integer>();
        int k = 0, l = 0, prefixSum = 0;

        map.put(0, -1);
        for (int i = 0; i < A.size(); i++) {

            prefixSum += A.get(i);

            if (map.containsKey(prefixSum)) {

                if (i - map.get(prefixSum) > l - k) {
                    k = map.get(prefixSum);
                    l = i;
                }

            } else {
                map.put(prefixSum, i);
            }
        }

        for (int i = k + 1; i <= l; i++) {
            result.add(A.get(i));
        }

        return result;
    }
}
