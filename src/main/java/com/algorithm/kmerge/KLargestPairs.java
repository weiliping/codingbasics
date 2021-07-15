package com.algorithm.kmerge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class KLargestPairs {

    public static void main(String[] args) {
        List<List<Integer>> res = kLargestPairs(new int[] { 1, 1, 2 }, new int[] { 1, 2, 3 }, 2);
        for (List<Integer> r : res) {
            System.out.println(Arrays.toString(r.toArray()));
        }
    }

    public static List<List<Integer>> kLargestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> res = new ArrayList<>();

        int n1 = nums1.length, n2 = nums2.length;
        int l = Math.min(k, n1 * n2);
        PriorityQueue<int[]> queue = new PriorityQueue<>(l, (a, b) -> (a[0] + a[1]) - (b[0] + b[1]));

        for (int i = 0; i < n1; i++) {
            for (int j = 0; j < n2; j++) {
                if (queue.size() < l) {
                    queue.offer(new int[] { nums1[i], nums2[j] });
                } else {
                    int[] sub = queue.peek();

                    if (sub[0] + sub[1] < nums1[i] + nums2[j]) {
                        queue.poll();
                        queue.offer(new int[] { nums1[i], nums2[j] });
                    }
                }
            }
        }

        while (!queue.isEmpty()) {
            List<Integer> subRes = new ArrayList<>();
            int[] sub = queue.poll();
            subRes.add(sub[0]);
            subRes.add(sub[1]);
            res.add(subRes);
        }
        return res;
    }
}
