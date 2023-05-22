package com.algorithm.contest.weeklycontest300;

public class PeopleAwareOfSecret {
    public static final int MOD = (int) (1e9 + 7);
    public static void main(String[] args) {
        System.out.println(peopleAwareOfSecret(6, 2, 4));
        System.out.println(peopleAwareOfSecret(4, 1, 3));
    }

    public static int peopleAwareOfSecret(int n, int delay, int forget) {
        int len = n + forget + 1;
        int[] cnts = new int[len];
        int[] says = new int[len];

        for (int i = 1; i <= forget; i++) {
            cnts[i] = 1;
            if (i > delay) {
                says[i] = 1;
            }
        }
        for (int i = delay + 1; i < n + 1; i++) {
            for (int j = 0; j < forget; j++) {
                int ind = i + j;
                cnts[ind] += says[i];
                if (cnts[ind] >= MOD) {
                    cnts[ind] -= MOD;
                }
                if (j >= delay) {
                    says[ind] += says[i];
                    if (says[ind] >= MOD) {
                        says[ind] -= MOD;
                    }
                }
            }
        }
        return cnts[n];
    }
}
