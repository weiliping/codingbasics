package com.algorithm.treedatastructure;

import java.util.PriorityQueue;

public class KthSmallest {
    /**
     * #230
     * https://leetcode-cn.com/problems/kth-smallest-element-in-a-bst
     * @param root
     * @param k
     * @return
     */
    public int kthSmallest(TreeNode root, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(k, (a, b) -> b - a);
        dfs(queue, root, k);
        return queue.peek();
    }

    private static void dfs(PriorityQueue<Integer> queue, TreeNode root, int k) {
        if (root == null) {
            return;
        }

        if (queue.size() < k) {
            queue.offer(root.val);
        } else {
            if (queue.peek() > root.val) {
                queue.poll();
                queue.offer(root.val);
            }
        }
        dfs(queue, root.left, k);
        dfs(queue, root.right, k);
    }
}
