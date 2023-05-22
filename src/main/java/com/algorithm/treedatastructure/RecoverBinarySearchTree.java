package com.algorithm.treedatastructure;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RecoverBinarySearchTree {

    /**
     * #99
     * https://leetcode-cn.com/problems/recover-binary-search-tree/
     *
     * @param args
     */
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.left.right = new TreeNode(2);
        new RecoverBinarySearchTree().recoverTree(root);

        System.out.println("root: " + root.val);
        System.out.println("root left: " + root.left.val);
        System.out.println("root right: " + root.left.right.val);
    }

    //
    public void recoverTree(TreeNode root) {
        List<TreeNode> n = new ArrayList<>();
        List<Integer> v = new ArrayList<>();
        inorderHelper(root, n, v);
        Collections.sort(v);
        for (int i = 0; i < n.size(); i++) {
            n.get(i).val = v.get(i);
        }
    }

    void inorderHelper(TreeNode r, List<TreeNode> n, List<Integer> v) {
        if (r == null) {
            return;
        }
        inorderHelper(r.left, n, v);
        n.add(r);
        v.add(r.val);
        inorderHelper(r.right, n, v);
    }

    TreeNode prev = null, f = null, s = null;

    /**
     * @param root
     */
    public void recoverTreeI(TreeNode root) {
        dfs(root);
        if (f != null && s != null) {
            int tmp = f.val;
            f.val = s.val;
            s.val = tmp;
        }
    }

    void dfs(TreeNode root) {
        if (root.left != null) {
            dfs(root.left);
        }

        if (prev != null && prev.val > root.val) {
            if (f == null) {
                f = prev;
            }
            if (f != null) {
                s = root;
            }
        }
        prev = root;

        if (root.right != null) {
            dfs(root.right);
        }
    }
}
