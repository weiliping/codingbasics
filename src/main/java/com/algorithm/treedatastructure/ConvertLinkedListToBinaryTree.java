package com.algorithm.treedatastructure;

import static com.algorithm.treedatastructure.InorderTraversal.inorderTraversalII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ConvertLinkedListToBinaryTree {

    /**
     * #109
     * https://leetcode-cn.com/problems/convert-sorted-list-to-binary-search-tree
     * @param args
     */
    public static void main(String[] args) {
        Node root = new Node(-10);
        root.next = new Node(-3);
        root.next.next = new Node(0);
        root.next.next.next = new Node(5);
        root.next.next.next.next = new Node(9);
        TreeNode t = sortedListToBST(root);
        System.out.println(Arrays.toString(inorderTraversalII(t).toArray()));

        TreeNode t2 = sortedListToBSTII(root);
        System.out.println(Arrays.toString(inorderTraversalII(t2).toArray()));
    }

    public static TreeNode sortedListToBST(Node head) {
        List<Integer> nums = new ArrayList<>();
        Node p = head;
        while (p != null) {
            nums.add(p.val);
            p = p.next;
        }
        return convertHelper(nums, 0, nums.size() - 1);
    }

    static TreeNode convertHelper(List<Integer> nums, int l, int r) {
        if (l > r) {
            return null;
        }
        int mid = l + (r - l) / 2;
        TreeNode node = new TreeNode(nums.get(mid));
        node.left = convertHelper(nums, l, mid - 1);
        node.right = convertHelper(nums, mid + 1, r);
        return node;
    }

    public static TreeNode sortedListToBSTII(Node head) {
        if (head == null) {
            return null;
        }
        return nodeHelper(head, null);
    }

    static TreeNode nodeHelper(Node head, Node tail) {
        if (head == tail) {
            return null;
        }

        Node slow = head, fast = head;

        while (fast != tail && fast.next != tail) {
            slow = slow.next;
            fast = fast.next.next;
        }

        TreeNode tree = new TreeNode(slow.val);
        tree.left = nodeHelper(head, slow);
        tree.right = nodeHelper(slow.next, tail);
        return tree;
    }
}
