package com.algorithm.kmerge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class SmallestRangeI {

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

//        List<List<Integer>> nums = new ArrayList<>();
//        List<Integer> subNums = new ArrayList<>();
//        subNums.add(1);
//        subNums.add(2);
//        subNums.add(3);
//        nums.add(subNums);
//        List<Integer> subNums1 = new ArrayList<>();
//        subNums1.add(1);
//        subNums1.add(2);
//        subNums1.add(3);
//        nums.add(subNums1);
//        List<Integer> subNums2 = new ArrayList<>();
//        subNums2.add(1);
//        subNums2.add(2);
//        subNums2.add(3);
//        nums.add(subNums2);
        System.out.println(Arrays.toString(smallestRange(nums)));
    }

    public static int[] smallestRange(List<List<Integer>> nums) {
        int n = nums.size();
        boolean arrayCount[] = new boolean[nums.size()];
        int cnt = 0;

        TreeMap<Integer, HashSet<Integer>> rangeNum = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            for (Integer num : nums.get(i)) {
                HashSet<Integer> indexes = rangeNum.getOrDefault(num, new HashSet<>());
                indexes.add(i);
                rangeNum.put(num, indexes);
            }
        }
        int minRange = Integer.MAX_VALUE;
        Iterator<Map.Entry<Integer, HashSet<Integer>>> it = rangeNum.entrySet().iterator();
        int left = rangeNum.firstKey(), right, res[] = new int[2];
        while (it.hasNext()) {
            Map.Entry<Integer, HashSet<Integer>> m = it.next();
            right = m.getKey();
            for (Integer ind : m.getValue()) {
                if (!arrayCount[ind]) {
                    arrayCount[ind] = true;
                    cnt++;
                }
            }

            while (cnt == n && left <= right) {
                int subRange = right - left;
                if (minRange > subRange) {
                    minRange = subRange;
                    res[0] = left;
                    res[1] = right;
                }

                HashSet<Integer> leftIndexes = rangeNum.get(left);
                for (Integer ind : leftIndexes) {
                    if (arrayCount[ind]) {
                        arrayCount[ind] = false;
                        cnt--;
                    }
                }
                int tl = left; boolean isChange = false;
                while (tl < right) {
                    tl = rangeNum.higherKey(tl);
                    boolean hasChange = false;
                    for (Integer ind : rangeNum.get(tl)) {
                        if (!arrayCount[ind]){
                            arrayCount[ind] = true;
                            cnt++;
                            hasChange = true;
                        }
                    }
                    if (hasChange) {
                        left = rangeNum.higherKey(left);
                        isChange = true;
                    }
                }
                if (!isChange && left != right) {
                    left = rangeNum.higherKey(left);
                }
            }
        }
        return res;
    }

    static class Pair {
        int k;
        int v;
        public Pair(int key, int val) {
            k = key;
            v = val;
        }
    }

    public static int[] smallestRangeI(List<List<Integer>> nums) {
        int n = nums.size();
        List<Pair> arrayCount = new ArrayList<>();

        int cnt = 0;

        int[] indexes = new int[nums.size()];

        for (int i = 0; i < n; i++) {
            for (Integer num : nums.get(i)) {
                arrayCount.add(new Pair(num, i));
            }
        }

        Collections.sort(arrayCount, (a, b) -> a.k - b.k);

        int minRange = Integer.MAX_VALUE;
        int left = 0, res[] = new int[2];

        for (int right = 0; right < arrayCount.size(); right++) {
            if (indexes[arrayCount.get(right).v] == 0) {
                cnt++;
            }
            ++indexes[arrayCount.get(right).v];

            while (cnt == n && left <= right) {
                if (minRange > right - left) {
                    minRange = right - left;
                    res[0] = arrayCount.get(left).k;
                    res[1] = arrayCount.get(right).k;
                }

                if (--indexes[arrayCount.get(left).v] == 0) {
                    cnt--;
                }
                left++;
            }
        }

        return res;
    }
}
