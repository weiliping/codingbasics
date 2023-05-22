package com.algorithm.contest.weeklycontest167;

import com.algorithm.linkedlists.ListNode;

public class GetDecimalValue {
    public static void main(String[] args) {
        GetDecimalValue g = new GetDecimalValue();
        System.out.println(g.getDecimalValue(newNode(new int[] {1, 0, 1})));
        System.out.println(g.getDecimalValue(newNode(new int[]{0})));
        System.out.println(g.getDecimalValue(newNode(new int[]{1})));
        System.out.println(g.getDecimalValue(newNode(new int[]{1,0,0,1,0,0,1,1,1,0,0,0,0,0,0})));
        System.out.println(g.getDecimalValue(newNode(new int[] { 0, 0 })));
    }

    static ListNode newNode(int[] nums) {
        ListNode head3 = new ListNode(nums[0]), p = head3;
        int i = 1;
        while (i < nums.length) {
            p.next = new ListNode(nums[i++]);
            p = p.next;
        }

        return head3;
    }
    public int getDecimalValue(ListNode head) {
        int res = 0;
        while (head != null) {
            res <<= 1;
            res += head.val;
            head = head.next;
        }
        return res;
    }
}
