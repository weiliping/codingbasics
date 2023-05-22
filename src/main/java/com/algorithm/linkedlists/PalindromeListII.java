package com.algorithm.linkedlists;

import static com.algorithm.linkedlists.PrintNode.printout;

public class PalindromeListII {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(1);
        head.next.next.next.next.next = new ListNode(1);

        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }


        printout(slow);
    }
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head, fast = head;
        int i = 0;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            i++;
        }

        ListNode after = reverseNode(slow);

        ListNode p = head;

        while (after != null && p != null) {
            if (after.next.val != p.next.val) {
                return false;
            }
            after = after.next;
            p = p.next;
            i--;
        }

        if (i != 0) {
            return false;
        }
        return true;
    }

    static ListNode reverseNode(ListNode head) {
        ListNode rev = null, p = head;
        while (p != null) {
            ListNode t = p.next;
            p.next = rev;
            rev = p;
            p = t;
        }
        return rev;
    }
}
