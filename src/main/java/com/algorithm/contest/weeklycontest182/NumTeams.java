package com.algorithm.contest.weeklycontest182;

public class NumTeams {

    public static void main(String[] args) {
        NumTeams n = new NumTeams();
        System.out.println(n.numTeams(new int[] {2, 5, 3, 4, 1}));
        System.out.println(n.numTeams(new int[] {2,1,3}));
        System.out.println(n.numTeams(new int[] {1,2,3,4}));
    }
    public int numTeams(int[] rating) {
        int n = rating.length, cnt = 0;
        for (int i = 1; i < n - 1; i++) {
            int l1 = 0, r1 = 0, l2 = 0, r2 = 0;
            for (int j = 0; j < i; j++) {
                if (rating[j] < rating[i]) {
                    l1++;
                }
                if (rating[j] > rating[i]) {
                    l2++;
                }
            }
            for (int k = i + 1; k < n; k++) {
                if (rating[i] < rating[k]) {
                    r1++;
                }
                if (rating[i] > rating[k]) {
                    r2++;
                }
            }
            cnt += l1 * r1;
            cnt += l2 * r2;
        }
        return cnt;
    }
}
