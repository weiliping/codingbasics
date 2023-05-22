package com.algorithm.contest.weeklycontest151;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;

import com.algorithm.linkedlists.ListNode;

public class RemoveZeroSumSublists {

    public static void main(String[] args) {
//        ListNode p = new ListNode(1);
//        p.next = new ListNode(2);
//        p.next.next = new ListNode(-3);
//        p.next.next.next = new ListNode(3);
//        p.next.next.next.next = new ListNode(1);
//        ListNode n = removeZeroSumSublists(p);
//        while (n != null) {
//            System.out.print(n.val);
//            System.out.print(", ");
//            n = n.next;
//        }
//        System.out.println(" ");

//        ListNode p1 = new ListNode(1);
//        p1.next = new ListNode(2);
//        p1.next.next = new ListNode(3);
//        p1.next.next.next = new ListNode(-3);
//        p1.next.next.next.next = new ListNode(4);
//        ListNode n2 = removeZeroSumSublists(p1);
//        while (n2 != null) {
//            System.out.print(n2.val);
//            System.out.print(", ");
//            n2 = n2.next;
//        }
//        System.out.println(" ");

//        ListNode p2 = new ListNode(1);
//        p2.next = new ListNode(2);
//        p2.next.next = new ListNode(3);
//        p2.next.next.next = new ListNode(-3);
//        p2.next.next.next.next = new ListNode(-2);
//        ListNode n3 = removeZeroSumSublists(p2);
//        while (n3 != null) {
//            System.out.print(n3.val);
//            System.out.print(", ");
//            n3 = n3.next;
//        }
//        System.out.println(" ");

        ListNode p3 = new ListNode(1);
        p3.next = new ListNode(3);
        p3.next.next = new ListNode(2);
        p3.next.next.next = new ListNode(-3);
        p3.next.next.next.next = new ListNode(-2);
        p3.next.next.next.next.next = new ListNode(5);
        p3.next.next.next.next.next.next = new ListNode(5);
        p3.next.next.next.next.next.next.next = new ListNode(-5);
        p3.next.next.next.next.next.next.next.next = new ListNode(1);
        ListNode n3 = removeZeroSumSublists(p3);
        while (n3 != null) {
            System.out.print(n3.val);
            System.out.print(", ");
            n3 = n3.next;
        }
        System.out.println(" ");
    }

    public static ListNode removeZeroSumSublistsI(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode pre = dummyHead;
        while (pre != null) {
            ListNode p = pre.next;
            int sum = 0;
            while (p != null) {
                sum += p.val;
                p = p.next;
                if (sum == 0) {
                    pre.next = p;
                    break;
                }
            }
            if (p == null) {
                pre = pre.next;
            }
        }
        return dummyHead.next;
    }

    public static ListNode removeZeroSumSublists(ListNode head) {
        Map<Integer, ListNode> mp = new HashMap<>();
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int sum = 0;
        ListNode p = new ListNode(0);
        p.next = head;
        ListNode dummyHead = p;
        while (p != null) {
            sum += p.val;
            if (mp.containsKey(sum)) {
                ListNode t = mp.get(sum);
                while (!stack.isEmpty() && stack.peek() != sum) {
                    mp.remove(stack.pop());
                }
                t.next = p.next;
                p = t.next;
                continue;
            }
            stack.push(sum);
            mp.put(sum, p);
            p = p.next;
        }
        return dummyHead.next;
    }
}
