package com.algorithm.twopointers;

import java.util.ArrayList;
import java.util.List;

public class ClosestElementsFromSortedArrays {

    /**
     * https://www.interviewbit.com/problems/array-3-pointers/
     * https://www.geeksforgeeks.org/find-three-closest-elements-from-given-three-sorted-arrays/
     *
     * @param args
     */
    public static void main(String[] args) {
        List<Integer> a = new ArrayList<>();
        a.add(1);
        a.add(4);
        a.add(10);
        List<Integer> b = new ArrayList<>();
        a.add(2);
        a.add(15);
        a.add(20);
        List<Integer> c = new ArrayList<>();
        a.add(10);
        a.add(12);
        System.out.println(new ClosestElementsFromSortedArrays().minimize(a, b, c));
    }

    /**
     * @param A
     * @param B
     * @param C
     * @return
     */
    public int minimize(final List<Integer> A, final List<Integer> B, final List<Integer> C) {
        int i = 0, j = 0, k = 0, m = A.size(), n = B.size(), l = C.size();

        int res = Integer.MAX_VALUE;

        while (i < m && j < n && k < l) {
            int max = Math.max(A.get(i), Math.max(B.get(j), C.get(k)));
            int min = Math.min(A.get(i), Math.min(B.get(j), C.get(k)));

            if (res > max - min) {
                res = max - min;
            }

            if (min == A.get(i)) {
                i++;
            } else if (min == B.get(j)) {
                j++;
            } else {
                k++;
            }
        }
        return res;
    }
}
