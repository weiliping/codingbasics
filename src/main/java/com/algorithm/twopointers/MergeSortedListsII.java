package com.algorithm.twopointers;

import java.util.ArrayList;
import java.util.Arrays;

public class MergeSortedListsII {

    /**
     * https://www.interviewbit.com/problems/merge-two-sorted-lists-ii/
     * @param args
     */
    public static void main(String[] args) {
        ArrayList<Integer> a = new ArrayList<>(Arrays.asList(new Integer[] { 1, 5, 8 }));
        ArrayList<Integer> b = new ArrayList<>(Arrays.asList(new Integer[] { 6, 9 }));
        merge(a, b);
        System.out.println(Arrays.toString(a.toArray()));
    }

    public static void merge(ArrayList<Integer> a, ArrayList<Integer> b) {
        if (a == null) {
            a = b;
            return;
        }

        if (b == null) {
            return;
        }

        int m = a.size(), n = b.size();
        for (int i = n - 1; i >= 0; i--) {
            int j, last = a.get(m - 1);
            for (j = m - 2; j >= 0 && a.get(j) > b.get(i); j--) {
                a.set(j + 1, a.get(j));
            }

            if (j != m - 2 || last > b.get(i)) {
                a.set(j + 1, b.get(i));
                b.set(i, last);
            }
        }

        for (Integer num : b) {
            a.add(num);
        }
    }
}
