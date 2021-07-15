package com.algorithm.treedatastructure;

import java.util.HashMap;
import java.util.Map;

public class DiameterOfBinaryTree {

    /**
     * #543
     * https://leetcode-cn.com/problems/diameter-of-binary-tree
     * @param args
     */
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        System.out.println(diameterOfBinaryTree(root));
    }

    public static int diameterOfBinaryTree(TreeNode root) {
        int[] res = new int[1];
        Map<TreeNode, Integer> m = new HashMap<>();
        diameterHelper(m, res, root);
        return res[0];
    }

    static int diameterHelper(Map<TreeNode, Integer> m, int[] res, TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (m.containsKey(root)) {
            return m.get(root);
        }
        int l = diameterHelper(m, res, root.left);
        int r = diameterHelper(m, res, root.right);
        res[0] = Math.max(res[0], l + r);
        m.put(root, Math.max(l, r) + 1);
        return m.get(root);
    }
}
