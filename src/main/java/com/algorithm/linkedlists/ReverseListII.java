package com.algorithm.linkedlists;

import static com.algorithm.linkedlists.PrintNode.printout;

public class ReverseListII {

    /**
     * #92
     * https://leetcode.com/articles/reverse-linked-list-ii/
     * https://leetcode-cn.com/problems/reverse-linked-list-ii/
     *
     * @param args
     */
    public static void main(String[] args) {
        ListNode h = new ListNode(1);
        h.next = new ListNode(2);
        h.next.next = new ListNode(3);
        h.next.next.next = new ListNode(4);
        h.next.next.next.next = new ListNode(5);
        printout(new ReverseListII().reverseBetween(h, 2, 4));
    }

    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null) {
            return head;
        }

        ListNode dummy = new ListNode(0), pre = dummy;
        dummy.next = head;
        for (int i = 0; i < m - 1; i++) {
            pre = pre.next;
        }

        ListNode curr = pre.next;
        for (int i = m; i < n; i++) {
            ListNode last = curr.next;
            curr.next = last.next;
            last.next = pre.next;
            pre.next = last;
        }
        return dummy.next;
    }
}
