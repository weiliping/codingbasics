package com.algorithm.contest.weeklycontest333;

public class MinOperations {

    public static void main(String[] args) {
        System.out.println(minOperations(39));
        System.out.println(minOperations(54));
    }

    public static int minOperations(int n) {
        String st = Integer.toBinaryString(n);
        char[] chrs = st.toCharArray();
        int len = chrs.length;
        int cnt = 0, i = len - 1, j;
        while (i >= 0) {
            if (chrs[i] == '0') {
                i--;
                continue;
            }
            --i;
            cnt++;
            if (i >= 0 && chrs[i] == '1') {
                while (i >= 0 && chrs[i] == '1') {
                    i--;
                }
                if (i < 0) {
                    cnt++;
                } else {
                    chrs[i] = '1';
                }
            }
        }
        return cnt;
    }
}
