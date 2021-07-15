package com.algorithm.linkedlists;

public class PalindromeList {

    /**
     * #234
     * https://leetcode-cn.com/problems/palindrome-linked-list
     * @param args
     */
    public static void main(String[] args) {
        ListNode n = new ListNode(6);
        n.next = new ListNode(3);
        n.next.next = new ListNode(7);
        n.next.next.next = new ListNode(3);
        n.next.next.next.next = new ListNode(6);
        System.out.println(new PalindromeList().isPalindrome(n));
    }

    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }

        ListNode s = head, f = head;

        while (f.next != null && f.next.next != null) {
            s = s.next;
            f = f.next.next;
            if (s == f) {
                break;
            }
        }

        if (f != null) {
            s = s.next;
        }

        s = reverse(s);

        while (s != null) {
            if (s.val != head.val) {
                return false;
            }
            s = s.next;
            head = head.next;
        }
        return true;
    }

    static ListNode reverse(ListNode h) {
        ListNode newHead = null, p = h;
        while (p != null) {
            ListNode tmp = p.next;
            p.next = newHead;
            newHead = p;
            p = tmp;
        }
        return newHead;
    }
}
