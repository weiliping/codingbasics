package com.algorithm.selfpractice;

import com.algorithm.linkedlists.ListNode;

public class HasCycleList {
    public boolean hasCycle(ListNode node) {
        if (node == null || node.next == null) {
            return false;
        }
        ListNode slow = node, fast = node;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }
}
