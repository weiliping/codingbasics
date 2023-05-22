package com.algorithm.contest.weeklycontest186;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FindDiagonalOrder {

    public static void main(String[] args) {
        FindDiagonalOrder f = new FindDiagonalOrder();
//        List<List<Integer>> nums = new ArrayList<>();
        List<Integer> row1 = new ArrayList<>();
//        row1.add(1);
//        row1.add(2);
//        row1.add(3);
//        nums.add(row1);
//        List<Integer> row2 = new ArrayList<>();
//        row2.add(4);
//        row2.add(5);
//        row2.add(6);
//        nums.add(row2);
//        List<Integer> row3 = new ArrayList<>();
//        row3.add(7);
//        row3.add(8);
//        row3.add(9);
//        nums.add(row3);
//        System.out.println(Arrays.toString(f.findDiagonalOrder(nums)));
//        List<List<Integer>> nums2 = new ArrayList<>();
//        row1 = new ArrayList<>();
//        row1.add(1);
//        row1.add(2);
//        row1.add(3);
//        row1.add(4);
//        row1.add(5);
//        nums2.add(row1);
//        row2 = new ArrayList<>();
//        row2.add(6);
//        row2.add(7);
//        nums2.add(row2);
//        row3 = new ArrayList<>();
//        row3.add(8);
//        nums2.add(row3);
//        List<Integer> row4 = new ArrayList<>();
//        row4.add(9);
//        row4.add(10);
//        row4.add(11);
//        nums2.add(row4);
//        List<Integer> row5 = new ArrayList<>();
//        row5.add(12);
//        row5.add(13);
//        row5.add(14);
//        row5.add(15);
//        row5.add(16);
//        nums2.add(row5);
//        System.out.println(Arrays.toString(f.findDiagonalOrder(nums2)));
//
//        List<List<Integer>> nums3 = new ArrayList<>();
//
//        row1 = new ArrayList<>();
//        row1.add(1);
//        row1.add(2);
//        row1.add(3);
//        row1.add(4);
//        row1.add(5);
//        row1.add(6);
//        nums3.add(row1);
//        System.out.println(Arrays.toString(f.findDiagonalOrder(nums3)));

        List<List<Integer>> nums4 = new ArrayList<>();

        row1 = new ArrayList<>();
        row1.add(1);
        row1.add(2);
        row1.add(3);
        nums4.add(row1);
        row1 = new ArrayList<>();
        row1.add(4);
        nums4.add(row1);
        row1 = new ArrayList<>();
        row1.add(5);
        row1.add(6);
        row1.add(7);
        nums4.add(row1);

        row1 = new ArrayList<>();
        row1.add(8);
        nums4.add(row1);
        row1 = new ArrayList<>();
        row1.add(9);
        row1.add(10);
        row1.add(11);
        nums4.add(row1);
        System.out.println(Arrays.toString(f.findDiagonalOrderI(nums4)));
        System.out.println(Arrays.toString(f.findDiagonalOrder(nums4)));
    }

    public int[] findDiagonalOrderI(List<List<Integer>> nums) {
        int n = nums.size();
        List<Tuples> tuples = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < nums.get(i).size(); j++) {
                tuples.add(new Tuples(i + j, i, j));
            }
        }
        Collections.sort(tuples, (a, b) -> a.s == b.s ? b.i - a.i : a.s - b.s);
        int len = tuples.size();
        int[] res = new int[len];
        int i = 0;
        for (Tuples t : tuples) {
            res[i++] = nums.get(t.i).get(t.j);
        }
        return res;
    }

    class Tuples {
        int s;
        int i;
        int j;
        public Tuples(int s, int i, int j) {
            this.s = s;
            this.i = i;
            this.j = j;
        }
    }

    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        int n = nums.size(), m = max(nums, 0, n - 1);
        int iStart = 0, jStart = 0;
        List<Integer> res = new ArrayList<>();
        while (iStart < n && jStart < m) {
            int i = iStart, j = jStart;
            while (i >= 0 && j < m) {
                List<Integer> ns = nums.get(i);
                if (ns.size() > j) {
                    res.add(ns.get(j));
                }
                i--;
                j++;
            }
            if (iStart == n - 1) {
                jStart++;
            }
            if (iStart < n - 1) {
                iStart++;
            }
        }

        int[] cnt = new int[res.size()];
        for (int i = 0; i < cnt.length; i++) {
            cnt[i] = res.get(i);
        }
        return cnt;
    }

    static int max(List<List<Integer>> nums, int i, int j) {
        if (i > j) {
            return Integer.MIN_VALUE;
        }
        if (i == j) {
            return nums.get(i).size();
        }
        if (i + 1 == j) {
            return Math.max(nums.get(i).size(), nums.get(j).size());
        }
        int mid = i + ((j - i) >> 1);
        return Math.max(max(nums, i, mid - 1), max(nums, mid, j));
    }
}
