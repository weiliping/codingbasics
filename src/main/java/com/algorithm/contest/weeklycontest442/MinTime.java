package com.algorithm.contest.weeklycontest442;

public class MinTime {
    public static void main(String[] args) {
        int[] skill = new int[] { 1,5,2,4 };
        int[] mana = new int[] { 5,1,4,2 };
        MinTime s = new MinTime();
        System.out.println(s.minTime(skill, mana));
    }
    public long minTime(int[] skill, int[] mana) {
        int m = mana.length;
        int n = skill.length;
        long[] lastFinished = new long[n + 1];
        for (int i = 1; i <= m; i++) {
            long[] curr = new long[n + 1];
            for (int j = 1; j <= n; j++) {
                curr[j] = Math.max(lastFinished[j], curr[j - 1]) + skill[j - 1] * mana[i - 1];
            }
            for (int j = n - 1; j > 0; j--) {
                curr[j] =  curr[j + 1] - skill[j] * mana[i - 1];
            }
            lastFinished = curr;
        }
        return lastFinished[n];  
    }    
}
