package com.algorithm.treedatastructure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class PreorderTraversal {

    /**
     * https://leetcode-cn.com/problems/binary-tree-preorder-traversal/
     *
     * @param args
     */
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.left.right = new TreeNode(6);
        root.left.left.right.left = new TreeNode(7);
        root.left.left.right.right = new TreeNode(8);
        root.right.right = new TreeNode(5);
        System.out.println(Arrays.toString(preorderTraversal(root).toArray()));
    }

    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();

        if (root == null) {
            return res;
        }

        Stack<TreeNode> s = new Stack<>();
        TreeNode p = root;
        while (p != null || !s.isEmpty()) {
            while (p != null) {
                res.add(p.val);
                s.push(p);
                p = p.left;
            }
            p = s.pop();
            p = p.right;
        }
        return res;
    }
}
