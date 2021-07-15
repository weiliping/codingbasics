package com.algorithm.others;

public class DetectCycle {

    public static void main(String[] args) {
        DetectCycle cycle = new DetectCycle();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        System.out.println(cycle.detectCycle(head));
    }

    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                break;
            }
        }
        slow = head;

        while (fast != null && slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return fast;
    }
}
