package com.algorithm.linkedlists;

import static com.algorithm.linkedlists.PrintNode.printout;

public class SwapPairs {

    /**
     * #24
     * https://leetcode-cn.com/problems/swap-nodes-in-pairs/
     *
     * @param args
     */
    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        ListNode p = new SwapPairs().swapPairsII(node);
        printout(p);
        ListNode p2 = new SwapPairs().swapPairsI(node);
    }

    public ListNode swapPairsI(ListNode head) {
        ListNode preHead = new ListNode(-1);
        preHead.next = head;
        ListNode p = preHead, first;
        while (p.next != null && p.next.next != null) {
            first = p.next;
            p.next = first.next;
            first.next = first.next.next;
            p.next.next = first;
            p = first;
        }
        return preHead.next;
    }

    public ListNode swapPairsII(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode tmp = head.next;
        ListNode future = tmp.next;
        tmp.next = head;
        head.next = swapPairsII(future);
        return tmp;
    }
}
