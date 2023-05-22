package com.algorithm.contest.weeklycontest219;

public class MinPartitions {
    public static void main(String[] args) {
        char c = '0';

        for (int i = 0; i < 10; i++) {
            System.out.println((int)(c + i));
        }
        MinPartitions m = new MinPartitions();
        System.out.println(m.minPartitions("27346209830709182346"));
    }
    public int minPartitions(String n) {
        char[] chs = n.toCharArray();
        char c = chs[0];
        int cnts = chs[0] - '0';
        for (int i = 1; i < chs.length; i++) {
            if (c < chs[i]) {
                c = chs[i];
                cnts = c - '0';
            }
        }
        return cnts;
    }
}
