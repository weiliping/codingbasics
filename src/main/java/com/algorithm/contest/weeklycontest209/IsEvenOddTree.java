package com.algorithm.contest.weeklycontest209;



import com.algorithm.treedatastructure.TreeNode;

import java.util.LinkedList;

public class IsEvenOddTree {
    public static void main(String[] args) {
//        TreeNode root = new TreeNode(5);
//        root.left = new TreeNode(9);
//        root.right = new TreeNode(1);
//        root.left.left = new TreeNode(3);
//        root.left.right = new TreeNode(5);
//        root.right.left = new TreeNode(7);
//        IsEvenOddTree i = new IsEvenOddTree();
//        System.out.println(i.isEvenOddTree(root));

        int n = 4;
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                System.out.println((1 << j) + (1 << i));
                System.out.println((1 << i) + (1 << j));
            }
        }
    }
    public boolean isEvenOddTree(TreeNode root) {
        LinkedList<TreeNode> queue = new LinkedList();
        if (root.val % 2 == 0) {
            return false;
        }
        queue.offer(root);
        queue.offer(null);
        int preVal = 0, level = 0;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            boolean isOdd = level % 2 == 1;
            if (node == null) {
                if (queue.isEmpty()) {
                    break;
                }
                level++;
                preVal = isOdd ? Integer.MIN_VALUE : Integer.MAX_VALUE;
                queue.offer(null);
                continue;
            }

            if (isOdd) {
                if (node.val % 2 == 1 || node.val >= preVal) {
                    return false;
                }
            } else {
                if (node.val % 2 == 0 || node.val <= preVal) {
                    return false;
                }
            }
            preVal = node.val;
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
        return true;
    }
}
