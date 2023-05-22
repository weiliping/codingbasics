package com.algorithm.linkedlists;

public class CycleList {

    /**
     * #141
     * https://leetcode-cn.com/problems/linked-list-cycle
     *
     * @param args
     */
    public static void main(String[] args) {
        ListNode h = new ListNode(1);
        h.next = new ListNode(2);
        h.next.next = new ListNode(3);
        h.next.next.next = new ListNode(4);
        h.next.next.next.next = new ListNode(5);
        h.next.next.next.next = h.next;
        System.out.println(new CycleList().hasCycle(h));
    }

    public boolean hasCycle(ListNode head) {
        if (head != null && head.next == null) {
            return false;
        }
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (slow == fast) {
                return true;
            }
        }
        return false;
    }
}
