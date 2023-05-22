package com.algorithm.linkedlists;

import static com.algorithm.linkedlists.PrintNode.printout;

public class MergeKSortedLists {

    /**
     * #23
     * https://leetcode-cn.com/problems/merge-k-sorted-lists/
     *
     * @param args
     */
    public static void main(String[] args) {
        ListNode[] lists = new ListNode[3];
        lists[0] = new ListNode(1);
        lists[0].next = new ListNode(4);
        lists[0].next.next = new ListNode(5);

        lists[1] = new ListNode(1);
        lists[1].next = new ListNode(3);
        lists[1].next.next = new ListNode(4);

        lists[2] = new ListNode(2);
        lists[2].next = new ListNode(6);

        ListNode r = new MergeKSortedLists().mergeKLists(lists);
        printout(r);
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        if (lists.length == 1) {
            return lists[0];
        }

        ListNode result = lists[0];
        for(int i=1; i<lists.length; i++) {
            result = mergeNode(result, lists[i]);
        }
        return result;
    }

    ListNode mergeNode(ListNode m, ListNode n) {
        ListNode result = null;

        if (m == null) {
            return n;
        }

        if (n == null) {
            return m;
        }

        if (m.val < n.val) {
            result = m;
            result.next = mergeNode(m.next, n);
        } else {
            result = n;
            result.next = mergeNode(m, n.next);
        }
        return result;
    }
}
