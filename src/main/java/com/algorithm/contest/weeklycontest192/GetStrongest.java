package com.algorithm.contest.weeklycontest192;

import java.util.Arrays;

public class GetStrongest {
    public static void main(String[] args) {
        GetStrongest g = new GetStrongest();
        System.out.println(Arrays.toString(g.getStrongest(new int[]{1,2,3,4,5}, 2)));
        System.out.println(Arrays.toString(g.getStrongest(new int[]{1,1,3,5,5}, 2)));
        System.out.println(Arrays.toString(g.getStrongest(new int[]{6,7,11,7,6,8}, 5)));
        System.out.println(Arrays.toString(g.getStrongest(new int[]{6,-3,7,2,11}, 3)));
        System.out.println(Arrays.toString(g.getStrongest(new int[]{-7,22,17,3}, 2)));
        System.out.println(Arrays.toString(g.getStrongest(new int[]{513}, 1)));
    }

    public int[] getStrongest(int[] arr, int k) {
        int n = arr.length, ind = 0;
        Arrays.sort(arr);
        int midNum = arr[(n - 1) / 2];
        int[] res = new int[k];

        int i = 0, j = n - 1;
        while (i <= j) {
            int a = Math.abs(arr[j] - midNum);
            int b = Math.abs(arr[i] - midNum);
            if (a > b || (a == b && arr[i] < arr[j])) {
                res[ind++] = arr[j--];
            } else {
                res[ind++] = arr[i++];
            }
            if (ind == k) {
                break;
            }
        }
        return res;
    }
}
