package com.algorithm.contest.weeklycontest239;

/**
 * https://leetcode-cn.com/problems/splitting-a-string-into-descending-consecutive-values/
 * #1849. 将字符串拆分为递减的连续值
 *
 * 给你一个仅由数字组成的字符串 s 。
 *
 * 请你判断能否将 s 拆分成两个或者多个 非空子字符串 ，使子字符串的 数值 按 降序 排列，且每两个 相邻子字符串 的数值之 差 等于 1 。
 *
 * 例如，字符串 s = "0090089" 可以拆分成 ["0090", "089"] ，数值为 [90,89] 。这些数值满足按降序排列，且相邻值相差 1 ，这种拆分方法可行。
 * 另一个例子中，字符串 s = "001" 可以拆分成 ["0", "01"]、["00", "1"] 或 ["0", "0", "1"] 。然而，所有这些拆分方法都不可行，因为对应数值分别是 [0,1]、[0,1] 和 [0,0,1] ，都不满足按降序排列的要求。
 * 如果可以按要求拆分 s ，返回 true ；否则，返回 false 。
 *
 * 子字符串 是字符串中的一个连续字符序列。
 *
 * 示例 1：
 * 输入：s = "1234"
 * 输出：false
 * 解释：不存在拆分 s 的可行方法。
 *
 */
public class SplitString {
    public static void main(String[] args) {
        System.out.println(splitString("1234"));
        System.out.println(splitString("050043"));
        System.out.println(splitString("0896942443130"));
        System.out.println(splitString("504312189986794"));
        System.out.println(splitString("14188802907687215148"));
        System.out.println(splitString("001"));
    }

    public static boolean splitString(String s) {
        int n = s.length(), len = n / 2;
        int i = 1;
        while (len >= i) {
            String sub = s;
            Long num = Long.parseLong(sub.substring(n - i)) + 1;
            int[] res = new int[1];
            res[0]++;
            if (dfs(sub.substring(0, n - i), num, res)) {
                return true;
            }
            i++;
        }
        return false;
    }

    static boolean dfs(String s, Long num, int[] res) {
        if ((s.isEmpty() || isZero(s)) && res[0] > 1) {
            return true;
        }
        String numStr = String.valueOf(num);
        int idx = s.lastIndexOf(numStr), startInd = idx;
        if (idx == -1) {
            return false;
        }
        startInd += numStr.length();
        while (startInd < s.length()) {
            if (s.charAt(startInd) == '0') {
                startInd++;
                continue;
            }
            return false;
        }
        res[0]++;
        return dfs(s.substring(0, idx), num + 1, res);
    }

    static boolean isZero(String s) {
        int i = 0;
        while (i < s.length()) {
            if (s.charAt(i) == '0') {
                i++;
                continue;
            }
            return false;
        }
        return true;
    }

}
