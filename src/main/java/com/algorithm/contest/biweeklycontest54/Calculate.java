package com.algorithm.contest.biweeklycontest54;

import java.util.ArrayDeque;

/**
 * #224
 * https://leetcode-cn.com/problems/basic-calculator/
 * 示例 1：
 * 输入：s = "1 + 1"
 * 输出：2
 *
 * 示例 2：
 * 输入：s = " 2-1 + 2 "
 * 输出：3
 *
 * 示例 3：
 * 输入：s = "(1+(4+5+2)-3)+(6+8)"
 * 输出：23
 *
 */
public class Calculate {
    public static void main(String[] args) {
        Calculate c = new Calculate();
        System.out.println(c.calculate("1 + 1"));
        System.out.println(c.calculate("(1+(4+5+2)-3)+(6+8)"));
    }

    public int calculate(String s) {
        char[] chrs = s.toCharArray();
        int n = chrs.length, cnt = 0, sign = 1, i = 0;
        ArrayDeque<Integer> ops = new ArrayDeque<>();
        ops.push(1);
        while (i < n) {
            if (chrs[i] == ' ') {
                i++;
                continue;
            }
            if (chrs[i] == '+') {
                sign = ops.peek();
                i++;
                continue;
            }
            if (chrs[i] == '-') {
                i++;
                sign = -ops.peek();
                continue;
            }
            if (chrs[i] == '(') {
                i++;
                ops.push(sign);
                continue;
            }
            if (chrs[i] == ')') {
                i++;
                ops.pop();
                continue;
            }
            int num = 0;
            while (i < n && Character.isDigit(chrs[i])) {
                num = 10 * num + chrs[i] - '0';
                i++;
            }
            cnt += sign * num;
        }
        return cnt;
    }
}
