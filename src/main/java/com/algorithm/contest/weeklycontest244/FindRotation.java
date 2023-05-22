package com.algorithm.contest.weeklycontest244;

import java.util.Arrays;

public class FindRotation {
    public static void main(String[] args) {
        FindRotation f = new FindRotation();

//        int[][] m = new int[][] { { 0, 0, 0 }, { 0, 1, 0 }, { 1, 1, 1 } };
//        int[][] t = new int[][] { { 1, 1, 1 }, { 0, 1, 0 }, { 0, 0, 0 } };
//        System.out.println(f.findRotation(m, t));
//
//        int[][] m6 = new int[][] { { 0, 0, 1 }, { 0, 0, 0 }, { 0, 0, 0 } };
//        int[][] t6 = new int[][] { { 1, 1, 1 }, { 0, 1, 0 }, { 0, 0, 0 } };
//        System.out.println(f.findRotation(m6, t6));
//        int[][] m1 = new int[][] { { 0, 1 }, {1, 0 }};
//        int[][] t1 = new int[][] { { 1, 0}, { 0, 1}};
//        System.out.println(f.findRotation(m1, t1));
//
//        int[][] m2 = new int[][] { { 0, 1 }, {1, 1 }};
//        int[][] t2 = new int[][] { { 1, 0}, { 0, 1}};
//        System.out.println(f.findRotation(m2, t2));
//
//        int[][] m3 = new int[][] { { 0, 0 }, {1, 1 }};
//        int[][] t3 = new int[][] { { 0, 1}, { 1, 0}};
//        System.out.println(f.findRotation(m3, t3));
        int[][] m4 = new int[][] { { 0, 0 }, {0, 1 }};
        int[][] t4 = new int[][] { { 0, 0}, { 1, 0}};
//        System.out.println(f.findRotation(m4, t4));
        for (int[] a : m4) {
            System.out.println(Arrays.toString(a));
        }
        System.out.println("--------");
        rotate(m4);
        for (int[] a : m4) {
            System.out.println(Arrays.toString(a));
        }
        System.out.println("--------");
        rotate(m4);
        for (int[] a : m4) {
            System.out.println(Arrays.toString(a));
        }
        System.out.println("--------");
        rotate(m4);
        for (int[] a : m4) {
            System.out.println(Arrays.toString(a));
        }
//        fun180(m4, 2, 2);
//        fun90(m4, 2, 2);
//        fun_90(m4, 2, 2);
    }
    public boolean findRotation(int[][] mat, int[][] target) {
        int n = mat.length;
        if (isSame(mat, target, n)) {
            return true;
        }
        rotate(mat);
        if (isSame(mat, target, n)) {
            return true;
        }
        rotate(mat);
        if (isSame(mat, target, n)) {
            return true;
        }
        rotate(mat);
        if (isSame(mat, target, n)) {
            return true;
        }
        return false;
    }
    static boolean isSame(int[][] mat, int[][] target, int n) {
        for (int i = 0; i < n; i++) {
            if (!Arrays.equals(mat[i], target[i])) {
                return false;
            }
        }
        return true;
    }
    public static void rotate(int[][] matrix) {
        if (matrix == null) {
            return;
        }
        int n = matrix.length - 1, r = 0, temp;
        while(r <= n/2){
            for(int i=r; i<=n-r-1; i++){
                temp = matrix[r][i];
                matrix[r][i] = matrix[n-i][r];
                matrix[n-i][r] = matrix[n-r][n-i];
                matrix[n-r][n-i] = matrix[i][n-r];
                matrix[i][n-r] = temp;
            }
            r++;
        }
    }
}
