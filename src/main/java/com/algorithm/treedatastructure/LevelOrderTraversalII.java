package com.algorithm.treedatastructure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversalII {

    /**
     * #107
     * https://leetcode-cn.com/problems/binary-tree-level-order-traversal-ii/
     *
     * @param args
     */
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        List<List<Integer>> res = levelOrderBottom(root);
        for (List<Integer> r : res) {
            System.out.println(Arrays.toString(r.toArray()));
        }
    }

    public static List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        q.offer(null);
        List<Integer> subRes = new ArrayList<>();
        while (true) {
            TreeNode tmp = q.poll();
            if (tmp != null) {
                subRes.add(tmp.val);
                if (tmp.left != null) {
                    q.offer(tmp.left);
                }
                if (tmp.right != null) {
                    q.offer(tmp.right);
                }
            } else {
                res.add(subRes);
                subRes = new ArrayList<>();
                if (q.isEmpty()) {
                    break;
                }
                q.offer(null);
            }
        }

        Collections.reverse(res);
        return res;
    }
}
