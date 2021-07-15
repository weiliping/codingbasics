package com.algorithm.contest.weeklycontest200;

public class CountGoodTriplets {

    public static void main(String[] args) {
        System.out.println(countGoodTriplets(new int[] {3,0,1,1,9,7}, 7, 2, 3));
        System.out.println(countGoodTriplets(new int[] {1,1,2,2,3}, 0, 0, 1));
    }
    public static int countGoodTriplets(int[] arr, int a, int b, int c) {
        int n = arr.length;
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    boolean b1 = (Math.abs(arr[i] - arr[j]) <= a);
                    boolean b2 = (Math.abs(arr[j] - arr[k]) <= b);
                    boolean b3 = (Math.abs(arr[i] - arr[k]) <= c);
                    if (b1 && b2 && b3) {
                        res++;
                    }
                }
            }
        }
        return res;
    }
}
