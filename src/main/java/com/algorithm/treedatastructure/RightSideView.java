package com.algorithm.treedatastructure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class RightSideView {

    /**
     * #199
     * https://leetcode-cn.com/problems/binary-tree-right-side-view/
     * @param args
     */
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(4);
        System.out.println(Arrays.toString(rightSideView(root).toArray()));
    }

    public static List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                TreeNode r = queue.poll();
                if (i == n - 1) {
                    res.add(r.val);
                }
                if (r.left != null) {
                    queue.offer(r.left);
                }

                if (r.right != null) {
                    queue.offer(r.right);
                }
            }
        }
        return res;
    }
}
