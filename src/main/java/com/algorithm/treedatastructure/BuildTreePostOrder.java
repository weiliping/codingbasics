package com.algorithm.treedatastructure;

import java.util.Arrays;

public class BuildTreePostOrder {

    /**
     * #106
     * https://leetcode-cn.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] inorder = new int[] { 9, 3, 15, 20, 7 };
        int[] postorder = new int[] { 9, 15, 7, 20, 3 };

        TreeNode node = new BuildTreePostOrder().buildTree(inorder, postorder);
        System.out.println(Arrays.toString(new InorderTraversal().inorderTraversal(node).toArray()));
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildTree(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    TreeNode buildTree(int[] inorder, int ileft, int iright, int[] postorder, int pleft, int pright) {
        if (pleft > pright || ileft > iright) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[pright]);
        int i;
        for (i = 0; i < inorder.length; i++) {
            if (root.val == inorder[i]) {
                break;
            }
        }

        root.left = buildTree(inorder, ileft, i - 1, postorder, pleft, pleft + i - ileft - 1);
        root.right = buildTree(inorder, i + 1, iright, postorder, pleft + i - ileft, pright - 1);
        return root;
    }
}
