package com.algorithm.linkedlists;

import static com.algorithm.linkedlists.PrintNode.printout;

public class InsertionSortList {

    /**
     * #147
     * https://leetcode-cn.com/problems/insertion-sort-list/
     * https://wangxin1248.github.io/algorithm/2020/02/leetcode-147.html
     *
     * @param args
     */
    public static void main(String[] args) {
        ListNode h = new ListNode(4);
        h.next = new ListNode(2);
        h.next.next = new ListNode(1);
        h.next.next.next = new ListNode(3);
        printout(new InsertionSortList().insertionSortList(h));
    }

    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode sortedHead = new ListNode(0);

        sortedHead.next = head;
        //divides head to 2 linkedList, sort is un-sort and sorted is in order.
        ListNode sort = head.next, sorted = sortedHead;
        head.next = null;

        while (sort != null) {
            //Find the right position
            while (sorted.next != null && sorted.next.val < sort.val) {
                sorted = sorted.next;
            }
            //insert un-sort item to sorted list
            ListNode next = sort.next;
            sort.next = sorted.next;
            sorted.next = sort;
            //rollback sorted pointer to start position.
            sorted = sortedHead;
            sort = next;
        }
        return sortedHead.next;
    }
}
