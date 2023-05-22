package com.algorithm.treedatastructure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class InorderTraversal {
    /**
     * #94
     * https://leetcode-cn.com/problems/binary-tree-inorder-traversal/
     *
     * @param args
     */
    public static void main(String[] args) {
        TreeNode tree = new TreeNode(1);
        tree.right = new TreeNode(2);
        tree.right.left = new TreeNode(3);
        InorderTraversal inorder = new InorderTraversal();
        System.out.println(Arrays.toString(inorder.inorderTraversal(tree).toArray()));
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> s = new Stack<>();
        TreeNode p = root;

        while (p != null || !s.isEmpty()) {
            while (p != null) {
                s.push(p);
                p = p.left;
            }
            p = s.pop();
            res.add(p.val);
            p = p.right;
        }
        return res;
    }

    public static List<Integer> inorderTraversalII(TreeNode root) {
        List<Integer> s = new ArrayList<>();
        inorderHelper(root, s);
        return s;
    }

    static void inorderHelper(TreeNode root, List<Integer> s) {
        if (root == null) {
            return;
        }
        inorderHelper(root.left, s);
        s.add(root.val);
        inorderHelper(root.right, s);
    }
}
