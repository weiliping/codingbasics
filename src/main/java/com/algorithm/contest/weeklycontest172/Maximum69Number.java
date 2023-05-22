package com.algorithm.contest.weeklycontest172;

import java.util.LinkedList;

public class Maximum69Number {
    public static void main(String[] args) {
        Maximum69Number m = new Maximum69Number();
        System.out.println(m.maximum69Number(9669));
        System.out.println(m.maximum69Number(9996));
        System.out.println(m.maximum69Number(9999));
    }
    public int maximum69Number (int num) {
        LinkedList<Integer> stack = new LinkedList<>();
        while (num > 0) {
            stack.push(num % 10);
            num /= 10;
        }
        int res = 0, change = 0;
        while (!stack.isEmpty()) {
            int no = stack.pop();
            if (no == 9) {
                res *= 10;
                res += no;
                continue;
            }
            if (change == 0) {
                change = 1;
                no = 9;
            }
            res *= 10;
            res += no;
        }
        return res;
    }
}
