package com.algorithm.linkedlists;

public class ReorderList {
    /**
     * #143
     * https://leetcode-cn.com/problems/reorder-list
     *
     * @param args
     */
    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        node.next.next.next.next = new ListNode(5);
        new ReorderList().reorderList(node);
    }

    public void reorderList(ListNode head) {
        if (head == null) {
            return;
        }
        ListNode mid = findMid(head);
        ListNode right = reverseList(mid);

        mergeLists(head, right);
    }

    static ListNode findMid(ListNode node) {
        ListNode slow = node, fast = node;

        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    static ListNode reverseList(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode reverseNode = null, curr = head;
        while (curr != null) {
            ListNode tmp = curr.next;
            curr.next = reverseNode;
            reverseNode = curr;
            curr = tmp;
        }
        return reverseNode;
    }

    static ListNode mergeLists(ListNode head1, ListNode head2) {
        if (head1 == null) {
            return head2;
        }

        if (head2 == null) {
            return head1;
        }
        ListNode p = head1;
        while (p != null && head2.next != null) {
            ListNode t = head2;
            head2 = head2.next;
            t.next = p.next;
            p.next = t;
            p = p.next.next;
        }
        return head1;
    }
}
