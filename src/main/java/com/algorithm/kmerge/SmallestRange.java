package com.algorithm.kmerge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class SmallestRange {

    public static void main(String[] args) {
        List<List<Integer>> nums = new ArrayList<>();
        List<Integer> subNums = new ArrayList<>();
        subNums.add(4);
        subNums.add(10);
        subNums.add(15);
        subNums.add(24);
        subNums.add(26);
        nums.add(subNums);
        List<Integer> subNums2 = new ArrayList<>();
        subNums2.add(0);
        subNums2.add(9);
        subNums2.add(12);
        subNums2.add(20);
        nums.add(subNums2);
        List<Integer> subNums3 = new ArrayList<>();
        subNums3.add(5);
        subNums3.add(18);
        subNums3.add(22);
        subNums3.add(30);
        nums.add(subNums3);
        SmallestRange s = new SmallestRange();
        System.out.println(Arrays.toString(s.smallestRange(nums)));
    }

    public int[] smallestRange(List<List<Integer>> nums) {
        PriorityQueue<Pair> queue = new PriorityQueue<>((a, b) -> a.k - b.k);
        int currMaxNumber = Integer.MIN_VALUE;
        for (int i = 0; i < nums.size(); i++) {
            List<Integer> subNums = nums.get(i);
            queue.offer(new Pair(subNums.get(0),0, i));
            currMaxNumber = Math.max(currMaxNumber, subNums.get(0));
        }

        int rangeS = 0, rangeE = Integer.MAX_VALUE;

        while (queue.size() == nums.size()) {
            Pair p = queue.poll();
            List<Integer> list = nums.get(p.ind);
            if (rangeE - rangeS > currMaxNumber - list.get(p.subInd)) {
                rangeE = currMaxNumber;
                rangeS = list.get(p.subInd);
            }
            if (list.size() > p.subInd + 1) {
                int curr = list.get(p.subInd + 1);
                queue.offer(new Pair(curr, p.subInd + 1, p.ind));
                currMaxNumber = Math.max(currMaxNumber, curr);
            }
        }
        return new int[] { rangeS, rangeE };
    }

    class Pair {
        int k;
        int ind;
        int subInd;
        public Pair(int key, int subIndex, int index) {
            k = key;
            ind = index;
            subInd = subIndex;
        }
    }
}
