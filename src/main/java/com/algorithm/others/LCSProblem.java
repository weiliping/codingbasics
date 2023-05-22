package com.algorithm.others;

public class LCSProblem {
    public static void main(String[] args) {
        String[] x = { "", "A", "B", "C", "B", "D", "A", "B" };
        String[] y = { "", "B", "D", "C", "A", "B", "A" };
        int[][] b = getLength(x, y);
        display(b, x, x.length - 1, y.length - 1);
    }

    public static int[][] getLength(String[] x, String[] y) {
        int[][] b = new int[x.length][y.length];
        int[][] c = new int[x.length][y.length];
        for (int i = 1; i < x.length; i++) {
            for (int j = 1; j < y.length; j++) {
                if (x[i] == y[j]) {
                    c[i][j] = c[i - 1][j - 1] + 1;
                    b[i][j] = 1;
                } else if (c[i - 1][j] >= c[i][j - 1]) {
                    c[i][j] = c[i - 1][j];
                    b[i][j] = 0;
                } else {
                    c[i][j] = c[i][j - 1];
                    b[i][j] = -1;
                }
            }
        }
        return b;
    }

    public static void display(int[][] b, String[] x, int i, int j) {
        if (i == 0 || j == 0) {
            return;
        }
        if (b[i][j] == 1) {
            display(b, x, i - 1, j - 1);
            System.out.print(x[i] + "");
        } else if (b[i][j] == 0) {
            display(b, x, i - 1, j);
        } else if (b[i][j] == -1) {
            display(b, x, i, j - 1);
        }
    }
}
