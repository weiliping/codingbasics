package com.algorithm.contest.weeklycontest218;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class MinimumIncompatibility {

    public static void main(String[] args) {
        MinimumIncompatibility m = new MinimumIncompatibility();
//        int nums[] = new int[] {1, 2, 1, 4}, k = 2;
//        System.out.println(m.minimumIncompatibility(nums, k));
//        int nums2[] = new int[] { 6, 3, 8, 1, 3, 1, 2, 2 }, k2 = 4;
//        System.out.println(m.minimumIncompatibility(nums2, k2));
//        int nums3[] = new int[] {5,3,3,6,3,3}, k3 = 3;
//        System.out.println(m.minimumIncompatibility(nums3, k3));
        int nums4[] = new int[] {10,4,4,2,11,10,8,9,1,2,2,10}, k4 = 4;
        System.out.println(m.minimumIncompatibility(nums4, k4));
    }

    public int minimumIncompatibility(int[] nums, int k) {
        int n = nums.length;
        TreeMap<Integer, Integer> mp = new TreeMap<>();
        for (int num : nums) {
            mp.put(num, mp.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> a[1] == b[1] ? a[0] - b[0] : b[1] - a[1]);
        Iterator<Map.Entry<Integer, Integer>> it = mp.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Integer, Integer> m = it.next();
            if (m.getValue() > k) {
                return -1;
            }
            q.offer(new int[]{m.getKey(), m.getValue()});
        }

        int res = 0, subLen = n / k;
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int subMin = Integer.MAX_VALUE, rs = 0, re = 0;
            int l = 1, r = 1;
            Integer key = cur[0];
            Deque<Integer> deque = new ArrayDeque<>();
            deque.addFirst(key);
            while (l < subLen) {
                key = mp.lowerKey(key);
                if (key != null) {
                    deque.addFirst(key);
                    l++;
                    continue;
                }
                break;
            }
            if (deque.size() == subLen) {
                int tre = deque.getLast();
                int trs = deque.pollFirst();
                int subRes = tre - trs;
                if (subMin > subRes) {
                    subMin = subRes;
                    re = tre;
                    rs = trs;
                }
            }
            key = cur[0];
            while (r < subLen) {
                key = mp.higherKey(key);
                if (key != null) {
                    deque.addLast(key);
                    if (deque.size() == subLen) {
                        int tre = deque.getLast();
                        int trs = deque.pollFirst();
                        int subRes = tre - trs;
                        if (subMin > subRes) {
                            subMin = subRes;
                            re = tre;
                            rs = trs;
                        }
                    }
                    r++;
                    continue;
                }
                break;
            }

            res += subMin;
            Integer curKey = rs;
            while (curKey != null && curKey <= re) {
                Integer curVal = mp.get(curKey);
                if (curVal == 1) {
                    mp.remove(curKey);
                } else {
                    mp.put(curKey, curVal - 1);
                }
                curKey = mp.higherKey(curKey);
            }

            q = new PriorityQueue<>((a, b) -> a[1] == b[1] ? a[0] - b[0] : b[1] - a[1]);
            Iterator<Map.Entry<Integer, Integer>> it1 = mp.entrySet().iterator();
            while (it1.hasNext()) {
                Map.Entry<Integer, Integer> m = it1.next();
                q.offer(new int[]{m.getKey(), m.getValue()});
            }
        }
        return res;
    }
}


