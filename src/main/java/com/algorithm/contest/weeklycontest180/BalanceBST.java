package com.algorithm.contest.weeklycontest180;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.algorithm.treedatastructure.PreorderTraversal;
import com.algorithm.treedatastructure.TreeNode;

public class BalanceBST {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.right = new TreeNode(3);
        root.right.right.right = new TreeNode(4);
        BalanceBST b = new BalanceBST();
        TreeNode node = b.balanceBST(root);
        System.out.println(Arrays.toString(new PreorderTraversal().preorderTraversal(node).toArray()));
    }
    public TreeNode balanceBST(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        dfs(root, res);
        return buildTree(res, 0, res.size() - 1);
    }

    void dfs(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        dfs(root.left, res);
        res.add(root.val);
        dfs(root.right, res);
    }

    TreeNode buildTree(List<Integer> res, int i, int j) {
        if (i > j) {
            return null;
        }
        int mid = i + ((j - i) >> 1);
        TreeNode root = new TreeNode(res.get(mid));
        root.left = buildTree(res, i, mid - 1);
        root.right = buildTree(res, mid + 1, j);
        return root;
    }
}
