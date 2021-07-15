package com.algorithm.treedatastructure;

import java.util.Arrays;

public class ConvertArrayToBinaryTree {

    /**
     * #108
     * https://leetcode-cn.com/problems/convert-sorted-array-to-binary-search-tree
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] nums = new int[] { -10, -3, 0, 5, 9 };
        TreeNode root = sortedArrayToBST(nums);
        System.out.println(Arrays.toString(new InorderTraversal().inorderTraversal(root).toArray()));
    }

    public static TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null) {
            return null;
        }
        return converHelper(nums, 0, nums.length - 1);
    }

    static TreeNode converHelper(int[] nums, int l, int r) {
        if (l > r) {
            return null;
        }
        int mid = l + (r - l) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = converHelper(nums, l, mid - 1);
        root.right = converHelper(nums, mid + 1, r);
        return root;
    }
}
