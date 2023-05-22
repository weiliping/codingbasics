package com.datastructure.day5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class IteratorTree {

    public static void main(String[] args) {
//        List<Integer> nums = middleOrder(TreeNode.root);
//        System.out.println(Arrays.toString(nums.toArray()));

        List<Integer> numsL = levelOrder(TreeNode.root);
        System.out.println(Arrays.toString(numsL.toArray()));
    }

    public static List<Integer> middleOrder(TreeNode node) {
        List<Integer> nums = new ArrayList<>();
        preMiddleOrder(node, nums);
        return nums;
    }

    static void preMiddleOrder(TreeNode node, List<Integer> nums) {
        if (node == null) {
            return;
        }
        preMiddleOrder(node.left, nums);
        nums.add(node.val);
        preMiddleOrder(node.right, nums);
    }

    public static List<Integer> preOrder(TreeNode node) {
        List<Integer> nums = new ArrayList<>();
        preOrderHelper(node, nums);
        return nums;
    }

    static void preOrderHelper(TreeNode node, List<Integer> nums) {
        if (node == null) {
            return;
        }
        nums.add(node.val);
        preOrderHelper(node.left, nums);
        preOrderHelper(node.right, nums);
    }

    public static List<Integer> postOrder(TreeNode node) {
        List<Integer> nums = new ArrayList<>();
        postOrderHelper(node, nums);
        return nums;
    }

    static void postOrderHelper(TreeNode node, List<Integer> nums) {
        if (node == null) {
            return;
        }
        postOrderHelper(node.left, nums);
        postOrderHelper(node.right, nums);
        nums.add(node.val);
    }

    public static List<Integer> levelOrder(TreeNode node) {
        Queue<TreeNode> st = new LinkedList<>();
        List<Integer> nums = new ArrayList<>();
        TreeNode p = node;
        st.offer(p);
        while (!st.isEmpty()) {
            TreeNode t = st.poll();
            nums.add(t.val);
            if (t.left != null) {
                st.offer(t.left);
            }
            if (t.right != null) {
                st.offer(t.right);
            }
        }
        return nums;
    }
}
