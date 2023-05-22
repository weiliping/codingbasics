package com.algorithm.treedatastructure;

import java.util.Arrays;

public class ConstructMaximumBinaryTree {
    public static void main(String[] args) {
        ConstructMaximumBinaryTree c = new ConstructMaximumBinaryTree();
        TreeNode node = c.constructMaximumBinaryTree(new int[]{3,2,1,6,0,5});
        InorderTraversal inorder = new InorderTraversal();
        System.out.println(Arrays.toString(inorder.inorderTraversal(node).toArray()));
    }

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return dfsHelper(nums, 0, nums.length - 1);
    }

    TreeNode dfsHelper(int[] nums, int l, int r) {
        if (l > r) {
            return null;
        }
        int maxInd = findMax(nums, l, r);
        TreeNode root = new TreeNode(nums[maxInd]);
        root.left = dfsHelper(nums, l, maxInd - 1);
        root.right = dfsHelper(nums, maxInd + 1, r);
        return root;
    }

    int findMax(int[] nums, int l, int r) {
        if (l > r) {
            return -1;
        }

        if (l == r) {
            return l;
        }

        int mid = l + ((r - l) >> 1);
        int left = findMax(nums, l, mid);
        int right = findMax(nums, mid + 1, r);
        if (left != -1 && right != -1) {
            if (nums[left] > nums[right]) {
                return left;
            }
            return right;
        }
        if (left == -1) {
            return right;
        }
        return left;
    }
}
