package com.algorithm.contest.weeklycontest159;

public class CheckStraightLine {
    public static void main(String[] args) {
//        System.out.println(checkStraightLine(new int[][]{{1,2},{2,3},{3,4},{4,5},{5,6},{6,7}}));
//        System.out.println(checkStraightLine(new int[][]{{1,1},{2,2},{3,4},{4,5},{5,6},{7,7}}));
//        System.out.println(checkStraightLine(new int[][]{{0,0},{0,1},{0,-1}}));
//        System.out.println(checkStraightLine(new int[][]{{2,1},{4,2},{6,3}}));
        System.out.println(checkStraightLine(new int[][]{{1,-8},{2,-3},{1,2}}));
    }
    public static boolean checkStraightLine(int[][] coordinates) {
        int deltaX = coordinates[0][0], deltaY = coordinates[0][1];
        int n = coordinates.length;
        for (int i = 0; i < n; i++) {
            coordinates[i][0] -= deltaX;
            coordinates[i][1] -= deltaY;
        }
        int A = coordinates[1][1], B = -coordinates[1][0];
        for (int i = 2; i < n; i++) {
            int x = coordinates[i][0], y = coordinates[i][1];
            if (A * x + B * y != 0) {
                return false;
            }
        }
        return true;
    }
}
