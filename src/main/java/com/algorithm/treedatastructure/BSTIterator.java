package com.algorithm.treedatastructure;

import java.util.Stack;

public class BSTIterator {

    /**
     * #173
     * https://leetcode-cn.com/problems/binary-search-tree-iterator
     * @param args
     */
    public static void main(String[] args) {
        TreeNode root = new TreeNode(7);
        root.left = new TreeNode(3);
        root.right = new TreeNode(15);
        root.right.left = new TreeNode(9);
        root.right.right = new TreeNode(20);
        BSTIterator bstIterator = new BSTIterator(root);
        System.out.println(bstIterator.next());
        System.out.println(bstIterator.next());
        System.out.println(bstIterator.hasNext());
        System.out.println(bstIterator.next());
        System.out.println(bstIterator.hasNext());
        System.out.println(bstIterator.next());
        System.out.println(bstIterator.hasNext());
        System.out.println(bstIterator.next());
        System.out.println(bstIterator.hasNext());
    }

    private static Stack<TreeNode> q = new Stack<>();

    public BSTIterator(TreeNode root) {
        while (root != null) {
            q.push(root);
            root = root.left;
        }
    }

    /** @return the next smallest number */
    public int next() {
        if (!q.isEmpty()) {
            TreeNode n = q.pop();
            int res = n.val;
            if (n.right != null) {
                n = n.right;
                while (n != null) {
                    q.push(n);
                    n = n.left;
                }
            }
            return res;
        }
        return Integer.MIN_VALUE;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        if (!q.isEmpty()) {
            return true;
        }
        return false;
    }
}
