package com.algorithm.contest.weeklycontest300;

import java.util.Arrays;

import com.algorithm.linkedlists.ListNode;

public class SpiralMatrix {
    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        head.next = new ListNode(0);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(6);
        head.next.next.next.next = new ListNode(8);
        head.next.next.next.next.next = new ListNode(1);
        head.next.next.next.next.next.next = new ListNode(7);
        head.next.next.next.next.next.next.next = new ListNode(9);
        head.next.next.next.next.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next.next.next.next.next = new ListNode(2);
        head.next.next.next.next.next.next.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next.next.next.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next.next.next.next.next.next.next.next = new ListNode(0);
        int[][] res = spiralMatrix(3, 5, head);
        for (int[] r : res) {
            System.out.println(Arrays.toString(r));
        }
    }

    public static int[][] spiralMatrix(int m, int n, ListNode head) {
        int[][] res = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(res[i], -1);
        }
        int il = 0, ir = m - 1, jl = 0, jh = n - 1;
        ListNode p = head;
        int i = il, j = jl;
        while (p != null) {
            res[i][j] = p.val;
            if (i == il && j < jh) {
                j++;
                if (j == jh) {
                    il++;
                }
            } else if (j == jh && i < ir) {
                i++;
                if (i == ir) {
                    jh--;
                }
            } else if (i == ir && j > jl) {
                j--;
                if (j == jl) {
                    ir--;
                }
            } else if (j == jl && i > il) {
                i--;
                if (i == il) {
                    jl++;
                }
            }

            p = p.next;
        }
        return res;
    }
}
