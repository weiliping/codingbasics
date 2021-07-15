package com.algorithm.contest.weeklycontest233;

public class Trie {
    public Trie[] f = new Trie[2];
    public int count = 0;

    public static int MAX_DEPTH = 15;

    public static Trie build(int[] arr) {
        Trie root = new Trie();
        root.count = arr.length;
        for (int i = 0; i < arr.length; ++i) {
            Trie cur = root;
            for (int j = MAX_DEPTH - 1; j >= 0; --j) {
                int bit = arr[i] >> j & 1;
                if (cur.f[bit] == null) {
                    cur.f[bit] = new Trie();
                }
                cur = cur.f[bit];
                cur.count++;
            }
        }
        return root;
    }

    public static int query(Trie root, int element, int limit) {
        Trie cur = root;
        int res = 0;
        for (int i = MAX_DEPTH - 1; i >= 0; --i) {
            int ei = element >> i & 1, li = limit >> i & 1;
            if (li == 1) {
                if (cur.f[ei] != null) {
                    res += cur.f[ei].count;
                }
                if (cur.f[ei ^ 1] != null) {
                    cur = cur.f[ei ^ 1];
                } else {
                    break;
                }
            } else {
                if (cur.f[ei] != null) {
                    cur = cur.f[ei];
                } else {
                    break;
                }
            }
        }
        return res;
    }

    public static int solve(Trie root, int[] arr, int limit) {
        int ans = 0;
        for (int i = 0; i < arr.length; ++i) {
            ans += query(root, arr[i], limit);
        }
        return ans / 2;
    }
}
