package com.algorithm.contest.weeklycontest221;

import java.util.Arrays;

public class MaximizeXor {
    static final int MAX_DEPTH = 30;
    public static void main(String[] args) {
        MaximizeXor o = new MaximizeXor();
        int[] nums = new int[]{0,1,2,3,4};
        int[][] queries = new int[][]{{3,1},{1,3},{5,6}};
        System.out.println(Arrays.toString(o.maximizeXor(nums, queries)));

        int[] nums1 = new int[]{5,2,4,6,6,3};
        int[][] queries1 = new int[][]{{12,4},{8,1},{6,3}};
        System.out.println(Arrays.toString(o.maximizeXor(nums1, queries1)));
    }


    public int[] maximizeXor(int[] nums, int[][] queries) {
        Trie root = new Trie().build(nums);
        int n = queries.length;
        int[] res = new int[n];

        for (int i = 0; i < n; i++) {
            Trie curr = root;
            int[] q = queries[i];
            int maxOxr = 0;
            for (int j = MAX_DEPTH; j >= 0; j--) {
                int oxr = q[0] >> j & 1, ind = (oxr ^ 1);
                if (curr.child[ind] != null && curr.child[ind].limit <= q[1]) {
                    maxOxr += 1 << j;
                    curr = curr.child[ind];
                } else {
                    if (curr.child[oxr] == null || curr.child[oxr].limit > q[1]) {
                        res[i] = -1;
                        break;
                    }
                    curr = curr.child[oxr];
                }
                if (j == 0) {
                    res[i] = maxOxr;
                }
            }
        }
        return res;
    }

    class Trie {
        int limit = Integer.MAX_VALUE;
        Trie[] child = new Trie[2];

        Trie build(int nums[]) {
            Trie root = new Trie();
            for (int num : nums) {
                Trie curr = root;
                for (int i = MAX_DEPTH; i >= 0; i--) {
                    int childInd = num >> i & 1;
                    if (curr.child[childInd] == null) {
                        curr.child[childInd] = new Trie();
                    }
                    curr = curr.child[childInd];
                    if (curr.limit > num) {
                        curr.limit = num;
                    }

                }
            }
            return root;
        }
    }
}


