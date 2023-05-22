package com.algorithm.treedatastructure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class PostorderTraversal {

    /**
     * #145
     * https://leetcode-cn.com/problems/binary-tree-postorder-traversal/
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
        System.out.println(Arrays.toString(new PostorderTraversal().postorderTraversal(root).toArray()));
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();

        if (root == null) {
            return res;
        }
        Stack<TreeNode> s = new Stack<>();
        TreeNode p = root, lastVisit = root;

        while (p != null || !s.isEmpty()) {
            while (p != null) {
                s.push(p);
                p = p.left;
            }

            p = s.peek();

            if (p.right == null || p.right == lastVisit) {
                res.add(p.val);
                s.pop();
                lastVisit = p;
                p = null;
            } else {
                p = p.right;
            }
        }
        return res;
    }
}
