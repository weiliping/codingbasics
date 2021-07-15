package com.algorithm.dfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.algorithm.linkedlists.ListNode;
import com.algorithm.treedatastructure.TreeNode;

public class ListOfDepth {
    /**
     * https://leetcode-cn.com/problems/list-of-depth-lcci/
     * @param args
     */
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(7);
        root.left.left.left = new TreeNode(8);
        listOfDepth(root);
    }

    public static ListNode[] listOfDepth(TreeNode tree) {
        if (tree == null) {
            return null;
        }
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        Queue<TreeNode> s = new LinkedList<>();
        s.offer(tree);
        s.offer(null);
        while (!s.isEmpty()) {
            TreeNode t = s.poll();
            if (t != null) {
                res.get(res.size() - 1).add(t.val);
                if (t.left != null) {
                    s.offer(t.left);
                }
                if (t.right != null) {
                    s.offer(t.right);
                }
            } else {
                if (s.isEmpty()) {
                    break;
                }
                res.add(new ArrayList<>());
                s.offer(null);
            }
        }
        ListNode[] nodes = new ListNode[res.size()];
        for (int i = 0; i < res.size(); i++) {
            List<Integer> sub = res.get(i);
            ListNode dummy = new ListNode(-1), p = dummy;
            int j = 0;
            while (j < sub.size()) {
                p.next = new ListNode(sub.get(j));
                p = p.next;
                j++;
            }
            nodes[i] = dummy.next;
        }
        return nodes;
    }
}
