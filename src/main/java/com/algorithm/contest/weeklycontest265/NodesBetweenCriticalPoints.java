package com.algorithm.contest.weeklycontest265;

import java.util.Arrays;

import com.algorithm.linkedlists.ListNode;

public class NodesBetweenCriticalPoints {

    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        head.next = new ListNode(1);

        NodesBetweenCriticalPoints n = new NodesBetweenCriticalPoints();
//        System.out.println(Arrays.toString(n.nodesBetweenCriticalPoints(head)));
//        ListNode head1 = new ListNode(5);
//        head1.next = new ListNode(3);
//        head1.next.next = new ListNode(1);
//        head1.next.next.next = new ListNode(2);
//        head1.next.next.next.next = new ListNode(5);
//        head1.next.next.next.next.next = new ListNode(1);
//        head1.next.next.next.next.next.next = new ListNode(2);
//        System.out.println(Arrays.toString(n.nodesBetweenCriticalPoints(head1)));
//
//        ListNode head2 = new ListNode(1);
//        head2.next = new ListNode(3);
//        head2.next.next = new ListNode(2);
//        head2.next.next.next = new ListNode(2);
//        head2.next.next.next.next = new ListNode(3);
//        head2.next.next.next.next.next = new ListNode(2);
//        head2.next.next.next.next.next.next = new ListNode(2);
//        head2.next.next.next.next.next.next.next = new ListNode(2);
//        head2.next.next.next.next.next.next.next.next = new ListNode(7);
//        System.out.println(Arrays.toString(n.nodesBetweenCriticalPoints(head2)));
//
//        ListNode head3 = new ListNode(3);
//        head3.next = new ListNode(2);
//        head3.next.next = new ListNode(2);
//        head3.next.next.next = new ListNode(3);
//        System.out.println(Arrays.toString(n.nodesBetweenCriticalPoints(head3)));

        ListNode head4 = new ListNode(6);
        head4.next = new ListNode(8);
        head4.next.next = new ListNode(4);
        head4.next.next.next = new ListNode(1);
        head4.next.next.next.next = new ListNode(9);
        head4.next.next.next.next.next = new ListNode(6);
        head4.next.next.next.next.next.next = new ListNode(6);
        head4.next.next.next.next.next.next.next = new ListNode(10);
        head4.next.next.next.next.next.next.next.next = new ListNode(6);
        System.out.println(Arrays.toString(n.nodesBetweenCriticalPoints(head4)));
    }

    public int[] nodesBetweenCriticalPoints(ListNode head) {
        int[] cnts = new int[2];
        cnts[0] = cnts[1] = -1;
        int first = -1, last = -1, s = 1, prev = head.val;

        ListNode curr = head.next;
        while (curr != null && curr.next != null) {
            if ((prev < curr.val && curr.val > curr.next.val) ||
                    (prev > curr.val && curr.val < curr.next.val)) {
                if (first == -1) {
                    first = s;
                } else {
                    cnts[1] = s - first;
                }
                if (last != -1) {
                    int sub = s - last;
                    if (cnts[0] == -1 || cnts[0] > sub) {
                        cnts[0] = sub;
                    }
                }
                last = s;
            }
            s++;
            prev = curr.val;
            curr = curr.next;
        }
        return cnts;
    }
}
