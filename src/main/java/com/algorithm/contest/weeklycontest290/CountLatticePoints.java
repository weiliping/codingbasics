package com.algorithm.contest.weeklycontest290;

public class CountLatticePoints {
    public static void main(String[] args) {
        int[][] circles = new int[][] { { 2, 2, 1 } };
        System.out.println(countLatticePoints(circles));
        int[][] circles2 = new int[][] { { 2, 2, 2 }, { 3, 4, 1 } };
        System.out.println(countLatticePoints(circles2));
        int[][] circles3 = new int[][] { { 8, 9, 6 }, { 9, 8, 4 }, { 4, 1, 1 }, { 8, 5, 1 }, { 7, 1, 1 }, { 6, 7, 5 },
                { 7, 1, 1 },
                { 7, 1, 1 }, { 5, 5, 3 } };
        System.out.println(countLatticePoints(circles3)); // 141

    }

    public static int countLatticePoints(int[][] circles) {
        boolean[][] points = new boolean[201][201];
        int[] cnts = new int[1];
        for (int[] c : circles) {
            countPoint(c, points, cnts);
        }
        return cnts[0];
    }

    private static void countPoint(int[] c, boolean[][] points, int[] cnts) {
        int r = c[2], dis = r * r;
        for (int i = r; i >= 0; i--) {
            for (int j = 0; j <= r; j++) {
                if (i * i + j * j <= dis) {
                    if (!points[c[0] - i][c[1] + j]) {
                        points[c[0] - i][c[1] + j] = true;
                        cnts[0]++;
                    }
                    if (!points[c[0] + i][c[1] + j]) {
                        points[c[0] + i][c[1] + j] = true;
                        cnts[0]++;
                    }
                    if (!points[c[0] + i][c[1] - j]) {
                        points[c[0] + i][c[1] - j] = true;
                        cnts[0]++;
                    }
                    if (!points[c[0] - i][c[1] - j]) {
                        points[c[0] - i][c[1] - j] = true;
                        cnts[0]++;
                    }
                    continue;
                }
                break;
            }
        }
    }
}
