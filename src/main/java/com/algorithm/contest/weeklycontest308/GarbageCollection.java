package com.algorithm.contest.weeklycontest308;

public class GarbageCollection {
    public static void main(String[] args) {
        System.out.println(garbageCollection(new String[] { "G", "P", "GP", "GG" }, new int[] { 2, 4, 3 }));
        System.out.println(garbageCollection(new String[] { "G", "M", "P" }, new int[] { 1, 3 }));
    }

    public static int garbageCollection(String[] garbage, int[] travel) {
        int n = garbage.length;
        int[] cntM = new int[n];
        int[] cntP = new int[n];
        int[] cntG = new int[n];
        int sumM = 0, sumP = 0, sumG = 0;
        for (int i = 0; i < n; i++) {
            for (char c : garbage[i].toCharArray()) {
                if (c == 'M') {
                    cntM[i]++;
                    sumM++;
                    continue;
                }
                if (c == 'G') {
                    cntG[i]++;
                    sumG++;
                    continue;
                }
                cntP[i]++;
                sumP++;
            }
        }
        int res = sumG + sumP + sumM;

        for (int i = 1; i < n; i++) {
            if (sumG >= cntG[i - 1]) {
                sumG -= cntG[i - 1];
                if (sumG > 0) {
                    res += travel[i - 1];
                }
            }
            if (sumP >= cntP[i - 1]) {
                sumP -= cntP[i - 1];
                if (sumP > 0) {
                    res += travel[i - 1];
                }
            }
            if (sumM >= cntM[i - 1]) {
                sumM -= cntM[i - 1];
                if (sumM > 0) {
                    res += travel[i - 1];
                }
            }
            if (sumG == 0 && sumP == 0 && sumM == 0) {
                break;
            }
        }
        return res;
    }
}
