package com.algorithm.treedatastructure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class ZigzagLevelOrder {

    /**
     * #103
     * https://leetcode-cn.com/problems/binary-tree-zigzag-level-order-traversal/
     *
     * @param args
     */
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        List<List<Integer>> res = new ZigzagLevelOrder().zigzagLevelOrder(root);
        for (List<Integer> r : res) {
            System.out.println(Arrays.toString(r.toArray()));
        }
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        LinkedList<TreeNode> s = new LinkedList<>();
        s.add(root);
        int cns = 0;
        while (!s.isEmpty()) {
            List<Integer> levelRes = new ArrayList<>();
            for (int i = s.size(); i > 0; i--) {
                TreeNode p = s.pop();
                levelRes.add(p.val);
                if (p.left != null) {
                    s.add(p.left);
                }
                if (p.right != null) {
                    s.add(p.right);
                }
            }

            if (cns % 2 == 1) {
                Collections.reverse(levelRes);
            }
            res.add(levelRes);
            cns++;
        }
        return res;
    }
}
