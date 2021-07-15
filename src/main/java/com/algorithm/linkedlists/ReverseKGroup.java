package com.algorithm.linkedlists;

import static com.algorithm.linkedlists.PrintNode.printout;

public class ReverseKGroup {

    /**
     * #25
     * https://leetcode-cn.com/problems/reverse-nodes-in-k-group/
     *
     * @param args
     */
    public static void main(String[] args) {
        ListNode h = new ListNode(1);
        h.next = new ListNode(2);
        h.next.next = new ListNode(3);
        h.next.next.next = new ListNode(4);
        h.next.next.next.next = new ListNode(5);
        printout(new ReverseKGroup().reverseKGroup(h, 3));
    }

    public ListNode reverseKGroup(ListNode h, int k) {

        if (h == null || k == 1) {
            return h;
        }

        int i = 0;
        ListNode dummyNode = new ListNode(-1);
        ListNode prev = dummyNode;
        dummyNode.next = h;
        ListNode p = h;

        while (p != null) {
            i++;
            if (i % k == 0) {
                prev = reverseNode(prev, p.next);
                p = prev.next;
            } else {
                p = p.next;
            }
        }
        return dummyNode.next;
    }

    public ListNode reverseNode(ListNode prev, ListNode next) {
        ListNode last = prev.next, curr = last.next;

        while (curr != next) {
            last.next = curr.next;
            curr.next = prev.next;
            prev.next = curr;
            curr = last.next;
        }
        return last;
    }
}
