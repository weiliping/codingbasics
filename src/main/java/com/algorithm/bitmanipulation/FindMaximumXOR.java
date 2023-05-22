package com.algorithm.bitmanipulation;

import java.util.HashSet;

public class FindMaximumXOR {
    /**
     * #421
     * https://leetcode-cn.com/problems/maximum-xor-of-two-numbers-in-an-array
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(new FindMaximumXOR().findMaximumXOR(new int[] {3, 10, 5, 25, 2, 8}));
        System.out.println(new FindMaximumXOR().findMaximumXORI(new int[] {3, 10, 5, 25, 2, 8}));
    }


    static int MAX_DEPTH = 32;
    public int findMaximumXOR(int[] nums) {
        Trie root =  new Trie().build(nums);
        int res = Integer.MIN_VALUE;
        for (int num : nums) {
            int curr_max = 0;
            Trie curr = root;
            for (int i = MAX_DEPTH - 1; i >= 0; i--) {
                int curr_bit = num >> i & 1;
                if (curr.c[curr_bit ^ 1] != null) {
                    curr_max += 1 << i;
                    curr = curr.c[curr_bit ^ 1];
                } else {
                    curr = curr.c[curr_bit];
                }
            }
            res = Math.max(res, curr_max);
        }
        return res;
    }

    class Trie {
        Trie[] c = new Trie[2];
        Trie build(int[] nums) {
            Trie root = new Trie();
            for (int num : nums) {
                Trie curr = root;
                for (int j = MAX_DEPTH - 1; j >= 0; j--) {
                    int e = num >> j & 1;
                    if (curr.c[e] == null) {
                        curr.c[e] = new Trie();
                    }
                    curr = curr.c[e];
                }
            }
            return root;
        }
    }

    public int findMaximumXORI(int[] nums) {
        int res = 0, mask = 0;

        for (int j = MAX_DEPTH - 1; j >= 0; j--) {
            mask = mask | (1 << j);

            HashSet<Integer> s = new HashSet<>();

            for (int num : nums) {
                s.add(num & mask);
            }

            int tmp = res | (1 << j);
            for (Integer t : s) {
                if (s.contains(tmp ^ t)) {
                    res = tmp;
                    break;
                }
            }
        }
        return res;
    }
}
