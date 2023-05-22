package com.datastructure.day5;

import java.util.Arrays;

public class InvertTree {
    /**
     * #226
     * https://leetcode-cn.com/problems/invert-binary-tree
     * @param args
     */
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);
        TreeNode tree = new InvertTree().invertTree(root);
        System.out.println(Arrays.toString(IteratorTree.levelOrder(tree).toArray()));
    }

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode rChild = root.right;
        TreeNode lChild = root.left;

        root.left = invertTree(rChild);
        root.right = invertTree(lChild);
        return root;
    }
}
