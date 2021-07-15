package com.algorithm.contest.weeklycontest223;

import static com.algorithm.linkedlists.PrintNode.printout;
import static com.algorithm.linkedlists.PrintNode.toNode;

import com.algorithm.linkedlists.ListNode;

/**
 * https://leetcode-cn.com/problems/swapping-nodes-in-a-linked-list/
 * #1721. 交换链表中的节点
 *
 * 给你链表的头节点 head 和一个整数 k 。
 *
 * 交换 链表正数第 k 个节点和倒数第 k 个节点的值后，返回链表的头节点（链表 从 1 开始索引）。
 *
 * 示例 1：
 * 输入：head = [1,2,3,4,5], k = 2
 * 输出：[1,4,3,2,5]
 *
 * 示例 2：
 * 输入：head = [7,9,6,6,7,8,3,0,9,5], k = 5
 * 输出：[7,9,6,6,8,7,3,0,9,5]
 *
 * 示例 3：
 * 输入：head = [1], k = 1
 * 输出：[1]
 *
 * 示例 4：
 * 输入：head = [1,2], k = 1
 * 输出：[2,1]
 *
 * 示例 5：
 * 输入：head = [1,2,3], k = 2
 * 输出：[1,2,3]
 *
 * 提示：
 * 链表中节点的数目是 n
 * 1 <= k <= n <= 105
 * 0 <= Node.val <= 100
 *
 */
public class SwappingNodes {
    public static void main(String[] args) {
        printout(swapNodes(toNode(new int[] {1, 2, 3, 4, 5}), 2));
        printout(swapNodes(toNode(new int[] { 7, 9, 6, 6, 7, 8, 3, 0, 9, 5 }), 5));
        printout(swapNodes(toNode(new int[] {1}), 1));
        printout(swapNodes(toNode(new int[] {1, 2}), 1));
        printout(swapNodes(toNode(new int[] {1, 2, 3}), 2));
        printout(swapNodes(toNode(new int[] {100, 90}), 2));
        printout(swapNodesII(toNode(new int[] {1, 2, 3, 4, 5}), 2));
        printout(swapNodesII(toNode(new int[] { 7, 9, 6, 6, 7, 8, 3, 0, 9, 5 }), 5));
        printout(swapNodesII(toNode(new int[] {1}), 1));
        printout(swapNodesII(toNode(new int[] {1, 2}), 1));
        printout(swapNodesII(toNode(new int[] {1, 2, 3}), 2));
        printout(swapNodesII(toNode(new int[] {100, 90}), 2));
    }

    public static ListNode swapNodes(ListNode head, int k) {
        int n = 0;
        ListNode p = head;
        while (p != null) {
            p = p.next;
            n++;
        }

        if (n < k || k < 1 || n == 2*k - 1) {
            return head;
        }
        int lInd = k - 1, rInd = n - k, gap = rInd - lInd;
        ListNode prev = new ListNode(0), lNode, rNode;
        prev.next = head;
        while (lInd > 0) {
            prev = prev.next;
            lInd--;
        }
        lNode = prev.next;

        if (gap > 0) {
            while (gap > 0) {
                prev = prev.next;
                gap--;
            }
            rNode = prev.next;
        } else {
            ListNode rp = new ListNode(0);
            rp.next = head;
            while (rInd > 0) {
                rp = rp.next;
                rInd--;
            }
            rNode = rp.next;
        }

        int tmp = lNode.val;
        lNode.val = rNode.val;
        rNode.val = tmp;
        return head;
    }

    public static ListNode swapNodesII(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode lNode = head, curr = head, rNode = head;
        int cnt = 1;
        while (curr.next != null) {
            if (cnt < k) {
                lNode = lNode.next;
            } else {
                rNode = rNode.next;
            }
            cnt++;
            curr = curr.next;
        }

        int tmp = lNode.val;
        lNode.val = rNode.val;
        rNode.val = tmp;
        return head;
    }
}
