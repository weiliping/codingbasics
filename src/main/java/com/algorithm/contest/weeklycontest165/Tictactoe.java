package com.algorithm.contest.weeklycontest165;

public class Tictactoe {

    public static void main(String[] args) {
        Tictactoe t = new Tictactoe();
        System.out.println(t.tictactoe(new int[][]{{0,0},{2,0},{1,1},{2,1},{2,2}}));
        System.out.println(t.tictactoe(new int[][]{{0,0},{1,1},{0,1},{0,2},{1,0},{2,0}}));
        System.out.println(t.tictactoe(new int[][]{{0,0},{1,1},{2,0},{1,0},{1,2},{2,1},{0,1},{0,2},{2,2}}));
        System.out.println(t.tictactoe(new int[][]{{0,0},{1,1}}));
    }
    public String tictactoe(int[][] moves) {
        Boolean[][] moved = new Boolean[3][3];
        int m = moves.length;
        for (int i = 0; i < m; i++) {
            int[] mo = moves[i];
            moved[mo[0]][mo[1]] = ((i & 1) == 0);
        }

        if (isWin(moved, true)) {
            return "A";
        }

        if (isWin(moved, false)) {
            return "B";
        }

        if (m == 9) {
            return "Draw";
        }

        return "Pending";
    }

    static boolean isWin(Boolean[][] moved, boolean isA) {
        return checkRows(moved, isA, 3) || checkColumn(moved, isA, 3) || checkCross(moved, isA);
    }
    static boolean checkCross(Boolean[][] moved, boolean isA) {
        boolean isAvail = true;
        for (int i = 0; i < 3; i++) {
            if (moved[i][i] == null || moved[i][i].booleanValue() != isA) {
                isAvail = false;
            }
        }

        if (isAvail) {
            return true;
        }

        for (int j = 2; j >= 0; j--) {
            if (moved[2 - j][j] == null || moved[2 - j][j].booleanValue() != isA) {
                return false;
            }
        }
        return true;
    }
    static boolean checkColumn(Boolean[][] moved, boolean isA, int n) {
        for (int i = 0; i < n; i++) {
            boolean isAvail = true;
            for (int j = 0; j < moved.length; j++) {
                if (moved[j][i] == null || moved[j][i].booleanValue() != isA) {
                    isAvail = false;
                    break;
                }
            }
            if (isAvail) {
                return true;
            }
        }
        return false;
    }
    static boolean checkRows(Boolean[][] moved, boolean isA, int m) {
        for (int i = 0; i < m; i++) {
            if (isWinRow(moved[i], isA)) {
                return true;
            }
        }
        return false;
    }

    static boolean isWinRow(Boolean[] moved, boolean isA) {
        for (Boolean m : moved) {
            if (m == null || m.booleanValue() != isA) {
                return false;
            }
        }
        return true;
    }
}
