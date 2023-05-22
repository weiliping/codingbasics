package com.algorithm.linkedlists;

public class ReverseEveryKElements {
    public static ListNode reverse(ListNode head, int k) {
        ListNode p1 = head;
        int n = 1;
        while (p1.next != null) {
            p1 = p1.next;
            n++;
        }

        int cnt = n / k;
        ListNode prev = new ListNode(-1), res = prev;
        prev.next = head;
        for (int i = 0; i < cnt; i++) {
            prev = rever(prev, k);
        }
        return res.next;
    }

    static ListNode rever(ListNode head, int k) {
        ListNode prev = head, curr = head.next;
        while (k > 1 && curr.next != null) {
            ListNode next = curr.next;
            curr.next = next.next;
            next.next = prev.next;
            prev.next = next;
            k--;
        }
        return curr;
    }

    public static void main(String[] args) {
//        ListNode head = new ListNode(1);
//        head.next = new ListNode(2);
//        head.next.next = new ListNode(3);
//        head.next.next.next = new ListNode(4);
//        head.next.next.next.next = new ListNode(5);
//        head.next.next.next.next.next = new ListNode(6);
//        head.next.next.next.next.next.next = new ListNode(7);
//        head.next.next.next.next.next.next.next = new ListNode(8);

//        ListNode result = ReverseEveryKElements.reverse(head, 2);
//        System.out.print("Nodes of the reversed LinkedList are: ");
//        while (result != null) {
//            System.out.print(result.val + " ");
//            result = result.next;
//        }

        System.out.println(sort(new int[]{3, 2, 1}));
    }

    public static int sort(int[] arr) {
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE, n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                if (min > arr[i + 1]) {
                    min = arr[i + 1];
                }
            }
        }

        for (int j = n - 1; j > 0; j--) {
            if (arr[j] < arr[j - 1]) {
                if (max < arr[j]) {
                    max = arr[j];
                }
            }
        }

        int i = 0, j = n - 1;

        for (; i < n; i++) {
            if (arr[i] > min) {
                break;
            }
        }

        for (; j >= 0; j--) {
            if (arr[j] < max) {
                break;
            }
        }
        if (j < i) {
            return 0;
        }
        return j - i + 1;
    }
}
