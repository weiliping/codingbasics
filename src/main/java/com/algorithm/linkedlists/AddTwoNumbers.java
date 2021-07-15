package com.algorithm.linkedlists;

import static com.algorithm.linkedlists.PrintNode.printout;

public class AddTwoNumbers {
    /**
     * #2
     * https://leetcode-cn.com/problems/add-two-numbers/
     *
     * @param args
     */
    public static void main(String[] args) {
        ListNode n1 = new ListNode(2);
        n1.next = new ListNode(4);
        n1.next.next = new ListNode(3);

        ListNode n2 = new ListNode(5);
        n2.next = new ListNode(6);
        n2.next.next = new ListNode(4);
        printout(new AddTwoNumbers().addTwoNumbers(n1, n2));
    }

    public ListNode addTwoNumbers(ListNode node1, ListNode node2) {
        ListNode p = node1, t = node2, res = new ListNode(0);

        ListNode fake = res;
        int carry = 0;
        while (p != null || t != null) {
            int sum = carry;

            if (p != null) {
                sum += p.val;
                p = p.next;
            }

            if (t != null) {
                sum += t.val;
                t = t.next;
            }

            if (sum > 9) {
                sum = sum - 10;
                carry = 1;
            } else {
                carry = 0;
            }
            fake.next = new ListNode(sum);
            fake = fake.next;
        }
        if (carry > 0) {
            fake.next = new ListNode(carry);
        }
        return res.next;
    }
}
