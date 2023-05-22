package com.algorithm.contest.weeklycontest175;

import java.util.Arrays;

public class CheckIfExist {
    public static void main(String[] args) {
        CheckIfExist c = new CheckIfExist();
//        System.out.println(c.checkIfExist(new int[]{3,1,7,11}));
//        System.out.println(c.checkIfExist(new int[]{10,2,5,3}));
        System.out.println(c.checkIfExist(new int[] { -2, 0, 10, -19, 4, 6, -8 }));
        System.out.println(c.checkIfExist(new int[] { 0, 0 }));
    }
    public boolean checkIfExist(int[] arr) {
        int n = arr.length;
        Arrays.sort(arr);
        for (int i = n - 1; i >= 0; i--) {
            if ((arr[i] & 1) == 0) {
                int h = (arr[i] >> 1);
                int ind = Arrays.binarySearch(arr, h);
                if (ind > -1 && (arr[i] != 0 || ind != i)) {
                    return true;
                }
                if (h < arr[0]) {
                    break;
                }
                continue;
            }
        }
        return false;
    }
}
