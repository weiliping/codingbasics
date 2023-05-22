package com.algorithm.contest.weeklycontest301;

public class CanChange {

    public static void main(String[] args) {
        System.out.println(canChange("_L__R__R_", "L______RR"));
        System.out.println(canChange("R_L_", "__LR"));
        System.out.println(canChange("_R", "R_"));
    }

    public static boolean canChange(String start, String target) {
        char[] sChrs = start.toCharArray();
        char[] tChrs = target.toCharArray();
        int n = sChrs.length;
        for (int i = n - 1; i >= 0; i--) {
            if (sChrs[i] == tChrs[i]) {
                continue;
            }
            if (tChrs[i] == 'R') {
                int k = i;
                while (k > 0 && sChrs[k] == '_') {
                    k--;
                }
                if (sChrs[k] != 'R') {
                    return false;
                }
                char t = sChrs[i];
                sChrs[i] = sChrs[k];
                sChrs[k] = t;
                continue;
            }
            if (tChrs[i] == 'L') {
                return false;
            }
            if (sChrs[i] == 'R') {
                return false;
            }
            int k = i;
            while (k > 0 && sChrs[k] == 'L') {
                k--;
            }
            if (sChrs[k] != '_') {
                return false;
            }
            char t = sChrs[i];
            sChrs[i] = sChrs[k];
            sChrs[k] = t;
            continue;
        }
        return true;
    }
}
