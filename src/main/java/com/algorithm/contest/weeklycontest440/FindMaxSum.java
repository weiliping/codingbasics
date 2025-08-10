package com.algorithm.contest.weeklycontest440;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.TreeMap;

/**
 * https://leetcode.cn/problems/choose-k-elements-with-maximum-sum/?slug=fruits-into-baskets-ii&region=local_v2
 * 3478. 选出和最大的 K 个元素
 */
public class FindMaxSum {
    
    public static void main(String[] args) {
        int[] nums1 = new int[] {4,2,1,5,3};
        int[] nums2 = new int[] {10,20,30,40,50};
        int k = 2;
        FindMaxSum s = new FindMaxSum();
        System.out.println(Arrays.toString(s.findMaxSum(nums1, nums2, k)));
        System.out.println(Arrays.toString(s.findMaxSumI(nums1, nums2, k)));
        int[] nums3 = new int[] {2, 2, 2, 2};
        int[] nums4 = new int[] {3,1,2,3};
        int k2 = 1;
        System.out.println(Arrays.toString(s.findMaxSum(nums3, nums4, k2)));
        System.out.println(Arrays.toString(s.findMaxSumI(nums3, nums4, k2)));
        int[] nums12 = new int[]{18,11,24,9,10,11,7,29,16};
        int[] nums22 =new int[]{28,26,27,4,2,19,23,1,2};
        int k32 = 1;
        System.out.println(Arrays.toString(s.findMaxSumI(nums12, nums22, k32)));
    }
    public long[] findMaxSumI(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        long[] ans = new long[n];
        int[][] nums = new int[n][2];
        for (int i = 0; i < n; i++) {
            nums[i][0] = nums1[i];
            nums[i][1] = i;
        }
        Arrays.sort(nums, (a, b) -> a[0] - b[0]);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        long s = 0;
        int pre = -1;
        int i = 0;
        while (i < n) {
            int ind = nums[i][1];
            if (pre != -1 && nums[pre][0] < nums[i][0]) {
                while (pq.size() > k) {
                    s -= pq.poll();
                }
                ans[ind] = s;
            }
            pq.add(nums2[ind]);
            s += nums2[ind];  
            int j = i + 1;
            while (j < n && nums[i][0] == nums[j][0]) {
                int ind2 = nums[j][1];
                ans[ind2] = ans[ind];
                pq.add(nums2[ind2]);
                s += nums2[ind2];    
                j++;
            }
            pre = i;
            i = j;
        }
        return ans;    
    }
    public long[] findMaxSum(int[] nums1, int[] nums2, int k) {
        int m = nums1.length;
        TreeMap<Integer, List<Integer>> map = new TreeMap<>();
        for (int i = 0; i < m; i++) {
            map.computeIfAbsent(nums1[i], x -> new ArrayList<Integer>()).add(i);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        long[] ans = new long[m];
        long s = 0;
        int pre = -1;
        for (Integer ind : map.keySet()) {
            if (pre != -1) {
                List<Integer> pq2 = map.get(pre);
                for (int j : pq2) {
                    if (pq.size() < k) {
                        pq.add(nums2[j]);
                        s += nums2[j];
                    } else if (pq.peek() < nums2[j]) {
                        s -= pq.poll();
                        pq.add(nums2[j]);
                        s += nums2[j];
                    }
                }
            }
            for (int j : map.get(ind)) {
                ans[j] = s;
            }
            pre = ind;
        }
        return ans;           
    }
}
