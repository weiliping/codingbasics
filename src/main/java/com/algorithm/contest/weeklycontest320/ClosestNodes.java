package com.algorithm.contest.weeklycontest320;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.algorithm.treedatastructure.TreeNode;

public class ClosestNodes {
    public static void main(String[] args) {
        // TreeNode root = new TreeNode(6);
        // root.left = new TreeNode(2);
        // root.left.left = new TreeNode(1);
        // root.left.right = new TreeNode(4);
        // root.right = new TreeNode(13);
        // root.right.left = new TreeNode(9);
        // root.right.right = new TreeNode(15);
        // root.right.right.left = new TreeNode(14);

        // List<List<Integer>> res = closestNodes(root, Arrays.asList(2, 5, 16));
        // for (List<Integer> r : res) {
        // System.out.println(Arrays.toString(r.toArray()));
        // }
        List<List<Integer>> res = new ArrayList<>();

        List<Integer> r = new ArrayList<>();
        Integer[] tInts = new Integer[] { 144, 62, 197, 7, 132, 179, 200, null, 12, 66, 133, null, 192, null, null,
                null, 42, 63, 102, null, 141, 191, null, 34, 47, null, null, 94, 122, null, null, null, null, 33, null,
                null, 54, 72, null, 104, 128, 28, null, null, null, null, 87, null, null, null, 129 };
        for (Integer i : tInts) {
            if (i != null) {
                r.add(i);
            }
        }
        Collections.sort(r);
        binarySearch(r, res, 191, r.size() - 1);
    }

    public static List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {

        List<Integer> res = new ArrayList<>();
        dfs(root, res);
        int n = res.size() - 1;
        List<List<Integer>> queryRes = new ArrayList<>();
        int l, r;
        for (Integer q : queries) {

        }
        return queryRes;
    }

    static void binarySearch(List<Integer> res, List<List<Integer>> queryRes, Integer q, int n) {
        int l = 0;
        int r = n;
        while (l <= r) {
            int mid = l + ((r - l) >> 1);
            if (res.get(mid).equals(q)) {
                queryRes.add(Arrays.asList(q, q));
                break;
            }
            if (res.get(mid) > q) {
                if (mid == 0) {
                    queryRes.add(Arrays.asList(-1, res.get(mid)));
                    break;
                } else if (res.get(mid - 1) < q) {
                    queryRes.add(Arrays.asList(res.get(mid - 1), res.get(mid)));
                    break;
                }
                r = mid - 1;
            } else {
                if (mid == n) {
                    queryRes.add(Arrays.asList(res.get(mid), -1));
                    break;
                } else if (res.get(mid + 1) > q) {
                    queryRes.add(Arrays.asList(res.get(mid), res.get(mid + 1)));
                    break;
                }
                l = mid + 1;
            }
        }
    }

    static void dfs(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        dfs(root.left, res);
        res.add(root.val);
        dfs(root.right, res);
    }
}
