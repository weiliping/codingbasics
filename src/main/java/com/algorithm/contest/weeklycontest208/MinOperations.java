package com.algorithm.contest.weeklycontest208;

public class MinOperations {
    public static void main(String[] args) {
        MinOperations m = new MinOperations();
        System.out.println(m.minOperations(new String[] {"d1/","d2/","../","d21/","./"}));
        System.out.println(m.minOperations(new String[] {"d1/","d2/","./","d3/","../","d31/"}));
        System.out.println(m.minOperations(new String[] {"d1/","../","../","../"}));
    }
    public int minOperations(String[] logs) {
        int cnt = 0;
        for (String log : logs) {
            if (log.endsWith("../")) {
                if (cnt > 0) {
                    cnt--;
                }
                continue;
            } else if (log.endsWith("./")) {
                continue;
            }
            cnt++;
        }
        return cnt;
    }
}
