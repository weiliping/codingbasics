package com.algorithm.others;

import java.util.Arrays;

public class SudokuSolver {
    private static int BOARD_SIZE = 9;
    private static int SUBSECTION_SIZE = 3;
    private static int NO_VALUE = 0;
    private static int CONSTRAINTS = 4;
    private static int MIN_VALUE = 1;
    private static int MAX_VALUE = 9;
    private static int COVER_START_INDEX = 1;

    private int getIndex(int row, int column, int num) {
        return (row - 1) * BOARD_SIZE * BOARD_SIZE
                + (column - 1) * BOARD_SIZE + (num - 1);
    }

    private boolean[][] createExactCoverBoard() {
        boolean[][] coverBoard = new boolean
                [BOARD_SIZE * BOARD_SIZE * MAX_VALUE]
                [BOARD_SIZE * BOARD_SIZE * CONSTRAINTS];

        int hBase = 0;
        hBase = checkCellConstraint(coverBoard, hBase);
        hBase = checkRowConstraint(coverBoard, hBase);
        hBase = checkColumnConstraint(coverBoard, hBase);
        checkSubsectionConstraint(coverBoard, hBase);

        return coverBoard;
    }

    private int checkSubsectionConstraint(boolean[][] coverBoard, int hBase) {
        for (int row = COVER_START_INDEX; row <= BOARD_SIZE; row += SUBSECTION_SIZE) {
            for (int column = COVER_START_INDEX; column <= BOARD_SIZE; column += SUBSECTION_SIZE) {
                for (int n = COVER_START_INDEX; n <= BOARD_SIZE; n++, hBase++) {
                    for (int rowDelta = 0; rowDelta < SUBSECTION_SIZE; rowDelta++) {
                        for (int columnDelta = 0; columnDelta < SUBSECTION_SIZE; columnDelta++) {
                            int index = getIndex(row + rowDelta, column + columnDelta, n);
                            coverBoard[index][hBase] = true;
                        }
                    }
                }
            }
        }
        return hBase;
    }

    private int checkColumnConstraint(boolean[][] coverBoard, int hBase) {
        for (int column = COVER_START_INDEX; column <= BOARD_SIZE; column++) {
            for (int n = COVER_START_INDEX; n <= BOARD_SIZE; n++, hBase++) {
                for (int row = COVER_START_INDEX; row <= BOARD_SIZE; row++) {
                    int index = getIndex(row, column, n);
                    coverBoard[index][hBase] = true;
                }
            }
        }
        return hBase;
    }

    private int checkRowConstraint(boolean[][] coverBoard, int hBase) {
        for (int row = COVER_START_INDEX; row <= BOARD_SIZE; row++) {
            for (int n = COVER_START_INDEX; n <= BOARD_SIZE; n++, hBase++) {
                for (int column = COVER_START_INDEX; column <= BOARD_SIZE; column++) {
                    int index = getIndex(row, column, n);
                    coverBoard[index][hBase] = true;
                }
            }
        }
        return hBase;
    }

    private int checkCellConstraint(boolean[][] coverBoard, int hBase) {
        for (int row = COVER_START_INDEX; row <= BOARD_SIZE; row++) {
            for (int column = COVER_START_INDEX; column <= BOARD_SIZE; column++, hBase++) {
                for (int n = COVER_START_INDEX; n <= BOARD_SIZE; n++) {
                    int index = getIndex(row, column, n);
                    coverBoard[index][hBase] = true;
                }
            }
        }
        return hBase;
    }

    private boolean[][] initializeExactCoverBoard(int[][] board) {
        boolean[][] coverBoard = createExactCoverBoard();
        for (int row = COVER_START_INDEX; row <= BOARD_SIZE; row++) {
            for (int column = COVER_START_INDEX; column <= BOARD_SIZE; column++) {
                int n = board[row - 1][column - 1];
                if (n != NO_VALUE) {
                    for (int num = MIN_VALUE; num <= MAX_VALUE; num++) {
                        if (num != n) {
                            Arrays.fill(coverBoard[getIndex(row, column, num)], false);
                        }
                    }
                }
            }
        }
        return coverBoard;
    }

    public static void solveSudoku(char[][] board) {
        System.out.println(board.toString());
    }

    public static void main(String[] args) {
        String[][] board = new String[9][9];
        board[0] = new String[] { "5", "3", ".", ".", "7", ".", ".", ".", "." };
        board[1] = new String[] { "6", ".", ".", "1", "9", "5", ".", ".", "." };
        board[2] = new String[] { ".", "9", "8", ".", ".", ".", ".", "6", "." };
        board[3] = new String[] { "8", ".", ".", ".", "6", ".", ".", ".", "3" };
        board[4] = new String[] { "4", ".", ".", "8", ".", "3", ".", ".", "1" };
        board[5] = new String[] { "7", ".", ".", ".", "2", ".", ".", ".", "6" };
        board[6] = new String[] { ".", "6", ".", ".", ".", ".", "2", "8", "." };
        board[7] = new String[] { ".", ".", ".", "4", "1", "9", ".", ".", "5" };
        board[8] = new String[] { ".", ".", ".", ".", "8", ".", ".", "7", "9" };
    }

}
