package com.algorithm.stacksandqueues;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class NearestSmaller {
    /**
     * https://www.interviewbit.com/problems/nearest-smaller-element/
     * @param args
     */
    public static void main(String[] args) {
        ArrayList<Integer> l = new ArrayList<>();
        //        [4, 5, 2, 10, 8]
        l.add(4);
        l.add(5);
        l.add(2);
        l.add(10);
        l.add(8);
        NearestSmaller s = new NearestSmaller();
        ArrayList<Integer> r = s.prevSmallerII(l);
        System.out.println(Arrays.toString(r.toArray()));
    }

    public ArrayList<Integer> prevSmaller(ArrayList<Integer> A) {
        ArrayList<Integer> res = new ArrayList<>();
        if (A == null) {
            return res;
        }

        for (int i = 0; i < A.size(); i++) {
            int curr = A.get(i);
            int subRes = -1;
            int j;
            for (j = i - 1; j >= 0; j--) {
                if (curr > A.get(j)) {
                    subRes = A.get(j);
                    break;
                }
            }
            res.add(subRes);
        }
        return res;
    }

    public ArrayList<Integer> prevSmallerII(ArrayList<Integer> A) {
        ArrayList<Integer> res = new ArrayList<>();
        if (A == null) {
            return res;
        }

        Stack<Integer> s = new Stack<>();

        for (int i = 0; i < A.size(); i++) {
            while (!s.isEmpty() && s.peek() >= A.get(i)) {
                s.pop();
            }
            if (s.isEmpty()) {
                res.add(-1);
            } else {
                res.add(s.peek());
            }

            s.push(A.get(i));
        }

        return res;
    }
}
