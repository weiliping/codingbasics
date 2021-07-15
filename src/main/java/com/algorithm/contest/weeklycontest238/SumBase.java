package com.algorithm.contest.weeklycontest238;

/**
 * https://leetcode-cn.com/problems/sum-of-digits-in-base-k/
 * #1837
 *
 * 给你一个整数 n（10 进制）和一个基数 k ，请你将 n 从 10 进制表示转换为 k 进制表示，计算并返回转换后各位数字的 总和 。
 * 转换后，各位数字应当视作是 10 进制数字，且它们的总和也应当按 10 进制表示返回。
 *  
 * 示例 1：
 * 输入：n = 34, k = 6
 * 输出：9
 * 解释：34 (10 进制) 在 6 进制下表示为 54 。5 + 4 = 9 。
 *
 * 示例 2：
 * 输入：n = 10, k = 10
 * 输出：1
 * 解释：n 本身就是 10 进制。 1 + 0 = 1 。
 */
public class SumBase {
    public static void main(String[] args) {
        int n = 34, k = 6;
        System.out.println(new SumBase().sumBase(n, k));
        System.out.println(new SumBase().sumBase(10, 10));
    }

    public int sumBase(int n, int k) {
        int sum = 0;
        while (n > 0) {
            sum += n % k;
            n /= k;
        }
        return sum;
    }
}
