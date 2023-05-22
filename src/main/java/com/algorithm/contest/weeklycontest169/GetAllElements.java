package com.algorithm.contest.weeklycontest169;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.algorithm.treedatastructure.TreeNode;

public class GetAllElements {
    public static void main(String[] args) {
        TreeNode root1 = null;
        TreeNode root2 = new TreeNode(5);
        root2.left = new TreeNode(1);
        root2.right = new TreeNode(7);
        root2.left.left = new TreeNode(0);
        root2.left.right = new TreeNode(2);
        GetAllElements g = new GetAllElements();
        System.out.println(Arrays.toString(g.getAllElements(root1, root2).toArray()));
    }
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> res = new ArrayList<>();
        dfs(res, root1, root2);
        return res;
    }
    static void dfs(List<Integer> res, TreeNode root1) {
        if (root1 == null) {
            return;
        }
        dfs(res, root1.left);
        res.add(root1.val);
        dfs(res, root1.right);
    }
    static void dfs(List<Integer> res, TreeNode root1, TreeNode root2) {
        List<Integer> l1 = new ArrayList<>();
        dfs(l1, root1);
        List<Integer> l2 = new ArrayList<>();
        dfs(l2, root2);
        int i = 0, j = 0, n = l1.size(), m = l2.size();

        while (i < n && j < m) {
            if (l1.get(i) > l2.get(j)) {
                res.add(l2.get(j++));
            } else {
                res.add(l1.get(i++));
            }
        }

        while (i < n) {
            res.add(l1.get(i++));
        }
        while (j < m) {
            res.add(l2.get(j++));
        }
    }
}
