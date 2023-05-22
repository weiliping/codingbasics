package com.algorithm.treedatastructure;

import java.util.Arrays;

public class BuildTreePreOrder {
    /**
     * #105
     * https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] inorder = new int[] { 9, 3, 15, 20, 7 };
        int[] preorder = new int[] { 3, 9, 20, 15, 7 };
        TreeNode tree = new BuildTreePreOrder().buildTree(preorder, inorder);
        System.out.println(Arrays.toString(new InorderTraversal().inorderTraversal(tree).toArray()));
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    TreeNode buildTree(int[] preorder, int pLeft, int pRight, int[] inorder, int iLeft, int iRight) {
        if (pLeft > pRight || iLeft > iRight) {
            return null;
        }

        TreeNode curr = new TreeNode(preorder[pLeft]);

        int i;
        for (i = 0; i < inorder.length; i++) {
            if (curr.val == inorder[i]) {
                break;
            }
        }

        curr.left = buildTree(preorder, pLeft + 1, pLeft + i - iLeft, inorder, iLeft, i - 1);
        curr.right = buildTree(preorder, pLeft + i - iLeft + 1, pRight, inorder, i + 1, iRight);
        return curr;
    }
}
