package com.algorithm.contest.weeklycontest212;

public class SlowestKey {
    public static void main(String[] args) {
        SlowestKey s = new SlowestKey();
        System.out.println(s.slowestKey(new int[]{9,29,49,50}, "cbcd"));
        System.out.println(s.slowestKey(new int[]{12,23,36,46,62}, "spuda"));
    }
    public char slowestKey(int[] releaseTimes, String keysPressed) {
        int maxTime = releaseTimes[0];
        char[] chrs = keysPressed.toCharArray();
        char c = chrs[0];
        for (int i = 1; i < releaseTimes.length; i++) {
            int time = releaseTimes[i] - releaseTimes[i - 1];
            if (maxTime < time) {
                maxTime = time;
                c = chrs[i];
                continue;
            }
            if (maxTime == time) {
                if (c < chrs[i]) {
                    c = chrs[i];
                }
            }
        }
        return c;
    }
}
