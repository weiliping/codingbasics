package com.algorithm.linkedlists;

public class DetectCycle {

    /**
     * #142
     * https://leetcode-cn.com/problems/linked-list-cycle-ii
     *
     * @param args
     */
    public static void main(String[] args) {
        ListNode h = new ListNode(1);
        h.next = new ListNode(2);
        h.next.next = new ListNode(3);
        h.next.next.next = new ListNode(4);
        h.next.next.next.next = new ListNode(5);
        h.next.next.next.next.next = h.next;
        System.out.println(new DetectCycle().detectCycle(h));
    }

    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode slow = head, fast = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (slow == fast) {
                break;
            }
        }

        if (fast == null || fast.next == null) {
            return null;
        }
        slow = head;

        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return fast;
    }
}
