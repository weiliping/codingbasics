package com.algorithm.contest.weeklycontest267;

import static com.algorithm.linkedlists.PrintNode.printout;

import com.algorithm.linkedlists.ListNode;

public class ReverseEvenLengthGroups {

    // 5,2,6,3,9,1,7,3,8,4
    public static void main(String[] args) {
        ReverseEvenLengthGroups r = new ReverseEvenLengthGroups();
        ListNode head = new ListNode(5);
        head.next = new ListNode(2);
        head.next.next = new ListNode(6);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(9);
        head.next.next.next.next.next = new ListNode(1);
        head.next.next.next.next.next.next = new ListNode(7);
        head.next.next.next.next.next.next.next = new ListNode(3);
        head.next.next.next.next.next.next.next.next = new ListNode(8);
        head.next.next.next.next.next.next.next.next.next = new ListNode(4);
        ListNode n = r.reverseEvenLengthGroups(head);
        printout(n);

        ListNode h1 = new ListNode(1);
        h1.next = new ListNode(1);
        h1.next.next = new ListNode(0);
        h1.next.next.next = new ListNode(6);
        printout(r.reverseEvenLengthGroups(h1));

        ListNode h2 = new ListNode(2);
        h2.next = new ListNode(1);
        printout(r.reverseEvenLengthGroups(h2));

        ListNode h3 = new ListNode(8);
        printout(r.reverseEvenLengthGroups(h3));

        ListNode h4 = new ListNode(0);
        h4.next = new ListNode(4);
        h4.next.next = new ListNode(2);
        h4.next.next.next = new ListNode(1);
        h4.next.next.next.next = new ListNode(3);
        printout(r.reverseEvenLengthGroups(h4));
    }

    public ListNode reverseEvenLengthGroups(ListNode head) {
        int left = 0;
        ListNode h = head;
        while (h != null) {
            left++;
            h = h.next;
        }
        int i = 1;
        ListNode node = new ListNode(-1);
        node.next = head;
        ListNode p = node;
        while (p != null) {
            int currCnt = Math.min(i, left);
            if ((currCnt & 1) == 0) {
                int j = 1;
                ListNode prev = p, curr = p.next, next;
                while (j < currCnt && curr != null && curr.next != null) {
                    next = curr.next;
                    curr.next = next.next;
                    next.next = prev.next;
                    prev.next = next;
                    j++;
                }
            }
            int j = 0;
            while (j < currCnt && p != null) {
                p = p.next;
                j++;
            }
            left -= i;
            i++;
        }
        return node.next;
    }
}
