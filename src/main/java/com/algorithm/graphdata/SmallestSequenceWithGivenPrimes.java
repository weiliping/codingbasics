package com.algorithm.graphdata;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeSet;

public class SmallestSequenceWithGivenPrimes {

    /**
     * https://www.interviewbit.com/problems/smallest-sequence-with-given-primes/
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(Arrays.toString(smallestSequence(19, 31, 31, 9).toArray()));
    }

    public static ArrayList<Integer> smallestSequence(int A, int B, int C, int D) {
        ArrayList<Integer> res = new ArrayList<>();
        if (D == 0) {
            return res;
        }
        TreeSet<Integer> s = new TreeSet<>();
        s.add(A);
        s.add(B);
        s.add(C);

        while (!s.isEmpty()) {
            int curr = s.first();
            s.remove(curr);
            res.add(curr);
            if (res.size() == D) {
                break;
            }
            s.add(curr * A);
            s.add(curr * B);
            s.add(curr * C);
        }
        return res;
    }
}
