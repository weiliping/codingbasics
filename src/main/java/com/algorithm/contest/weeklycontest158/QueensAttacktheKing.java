package com.algorithm.contest.weeklycontest158;

import static com.algorithm.utils.CommonUtils.printArrayInteger;

import java.util.ArrayList;
import java.util.List;

public class QueensAttacktheKing {

    public static void main(String[] args) {
        QueensAttacktheKing q = new QueensAttacktheKing();

        int[][] queens = new int[][]{{0,1},{1,0},{4,0},{0,4},{3,3},{2,4}};
        int[] king = new int[]{0, 0};
        List<List<Integer>> res = q.queensAttacktheKing(queens, king);
//        printArrayInteger(res);

        int[][] queens1 = new int[][]{{0,0},{1,1},{2,2},{3,4},{3,5},{4,4},{4,5}};
        int[] king1 = new int[]{3, 3};
        List<List<Integer>> res1 = q.queensAttacktheKing(queens1, king1);
//        printArrayInteger(res1);
        int[][] queens2 = new int[][]{{5,6},{7,7},{2,1},{0,7},{1,6},{5,1},{3,7},{0,3},{4,0},{1,2},{6,3},{5,0},{0,4},{2,2},{1,1},{6,4},{5,4},{0,0},{2,6},{4,5},{5,2},{1,4},{7,5},{2,3},{0,5},{4,2},{1,0},{2,7},{0,1},{4,6},{6,1},{0,6},{4,3},{1,7}};
        int[] king2 = new int[]{3,4};
        List<List<Integer>> res2 = q.queensAttacktheKing(queens2, king2);
        printArrayInteger(res2);
    }
    public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
        List<Integer>[] qs = new ArrayList[8];
        int n = queens.length;
        for (int i = 0; i < n; i++) {
            if (king[0] == queens[i][0]) {
                if (king[1] > queens[i][1]) {
                    List<Integer> r = qs[7];
                    if (r == null) {
                        r = new ArrayList<>();
                        r.add(queens[i][0]);
                        r.add(queens[i][1]);
                        qs[7] = r;
                    } else {
                        if (r.get(1) < queens[i][1]) {
                            r.set(0, queens[i][0]);
                            r.set(1, queens[i][1]);
                        }
                    }
                    continue;
                }
                List<Integer> r = qs[3];
                if (r == null) {
                    r = new ArrayList<>();
                    r.add(queens[i][0]);
                    r.add(queens[i][1]);
                    qs[3] = r;
                } else {
                    if (r.get(1) > queens[i][1]) {
                        r.set(0, queens[i][0]);
                        r.set(1, queens[i][1]);
                    }
                }
                continue;
            }
            if (king[1] == queens[i][1]) {
                if (king[0] > queens[i][0]) {
                    List<Integer> r = qs[1];
                    if (r == null) {
                        r = new ArrayList<>();
                        r.add(queens[i][0]);
                        r.add(queens[i][1]);
                        qs[1] = r;
                    } else {
                        if (r.get(0) < queens[i][0]) {
                            r.set(0, queens[i][0]);
                            r.set(1, queens[i][1]);
                        }
                    }
                    continue;
                }
                List<Integer> r = qs[5];
                if (r == null) {
                    r = new ArrayList<>();
                    r.add(queens[i][0]);
                    r.add(queens[i][1]);
                    qs[5] = r;
                } else {
                    if (r.get(0) > queens[i][0]) {
                        r.set(0, queens[i][0]);
                        r.set(1, queens[i][1]);
                    }
                }
                continue;
            }

            if (king[1] - queens[i][1] == king[0] - queens[i][0]) {
                if (king[0] > queens[i][0]) {
                    List<Integer> r = qs[0];
                    if (r == null) {
                        r = new ArrayList<>();
                        r.add(queens[i][0]);
                        r.add(queens[i][1]);
                        qs[0] = r;
                    } else {
                        if (r.get(0) < queens[i][0]) {
                            r.set(0, queens[i][0]);
                            r.set(1, queens[i][1]);
                        }
                    }
                    continue;
                }
                List<Integer> r = qs[4];
                if (r == null) {
                    r = new ArrayList<>();
                    r.add(queens[i][0]);
                    r.add(queens[i][1]);
                    qs[4] = r;
                } else {
                    if (r.get(0) > queens[i][0]) {
                        r.set(0, queens[i][0]);
                        r.set(1, queens[i][1]);
                    }
                }
                continue;
            }
            if (king[0] + king[1] == queens[i][0] + queens[i][1]) {
                if (king[0] > queens[i][0]) {
                    List<Integer> r = qs[2];
                    if (r == null) {
                        r = new ArrayList<>();
                        r.add(queens[i][0]);
                        r.add(queens[i][1]);
                        qs[2] = r;
                    } else {
                        if (r.get(0) < queens[i][0]) {
                            r.set(0, queens[i][0]);
                            r.set(1, queens[i][1]);
                        }
                    }
                    continue;
                }
                List<Integer> r = qs[6];
                if (r == null) {
                    r = new ArrayList<>();
                    r.add(queens[i][0]);
                    r.add(queens[i][1]);
                    qs[6] = r;
                } else {
                    if (r.get(0) > queens[i][0]) {
                        r.set(0, queens[i][0]);
                        r.set(1, queens[i][1]);
                    }
                }
            }
        }
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            if (qs[i] != null) {
                res.add(qs[i]);
            }
        }

        return res;
    }
}
