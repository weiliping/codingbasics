package com.algorithm.contest.biweeklycontest56;

import java.util.ArrayDeque;
import java.util.Arrays;

public class NearestExit {

    public static void main(String[] args) {
        NearestExit n = new NearestExit();
//        char[][] maze1 = new char[][] {
//                { '+', '+', '+' },
//                { '.', '.', '.' },
//                { '+', '+', '+' }
//        };
//        int[] entrance1 = new int[] { 1, 0 };
//        System.out.println(n.nearestExit(maze1, entrance1));

//        char[][] maze2 = new char[][] { { '.', '+' } };
//        int[] entrance2 = new int[] { 0, 0 };
//        System.out.println(n.nearestExit(maze2, entrance2));

//        char[][] maze3 = new char[][] {
//                { '+', '.', '+', '+', '+', '+', '+' },
//                { '+', '.', '+', '.', '.', '.', '+' },
//                { '+', '.', '+', '.', '+', '.', '+' },
//                { '+', '.', '.', '.', '+', '.', '+' },
//                { '+', '+', '+', '+', '+', '.', '+' }
//        };
//        int[] entrance3 = new int[] { 0, 1 };
//        System.out.println(n.nearestExit(maze3, entrance3));


//        char[][] maze4 = new char[][] {
//                {'+','.','+','+','+','+','+'},
//                {'+','.','+','.','.','.','+'},
//                {'+','.','+','.','+','.','+'},
//                {'+','.','.','.','.','.','+'},
//                {'+','+','+','+','.','+','.'}};
//        int[] entrance4 = new int[] {0,1};
//        System.out.println(n.nearestExit(maze4, entrance4));

        char[][] maze5 = new char[][] {
                { '.', '.', '.', '.', '.', '+', '.', '.', '.' },
                { '.', '+', '.', '.', '.', '.', '.', '.', '.' },
                { '.', '.', '+', '.', '+', '.', '+', '.', '+' },
                { '.', '.', '.', '.', '+', '.', '.', '.', '.' },
                { '.', '.', '.', '.', '+', '+', '.', '.', '.' },
                { '+', '.', '.', '.', '.', '.', '.', '.', '.' },
                { '.', '.', '.', '+', '.', '.', '.', '.', '.' },
                { '.', '.', '.', '+', '.', '.', '.', '.', '+' },
                { '+', '.', '.', '+', '.', '+', '+', '.', '.' }
        };
        int[] entrance5 = new int[]{8,4};
        System.out.println(n.nearestExit(maze5, entrance5));

        char[][] maze6 = new char[][] {{'+', '.', '+', '+'}, {'.','.','.','.'}, {'.','+','+','.'}};
        int[] entrance6 = new int[]{0,1};
        System.out.println(n.nearestExit(maze6, entrance6));
    }
    public int nearestExitI(char[][] maze, int[] entrance) {
        int n = maze.length, m = maze[0].length;
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{entrance[0], entrance[1], 0});
        int[][] inds = new int[][] { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
        maze[entrance[0]][entrance[1]] = '+';
        while (!queue.isEmpty()) {
            int[] t = queue.poll();
            for (int i = 0; i < 4; i++) {
                int x = t[0] + inds[i][0], y = t[1] + inds[i][1], d = t[2];
                if (x >= 0 && x < n && y >= 0 && y < m && maze[x][y] == '.') {
                    if (x == 0 || y == 0 || x == n - 1 || y == m - 1) {
                        return d + 1;
                    }
                    maze[x][y] = '+';
                    queue.offer(new int[] {x, y, d + 1});
                }
            }
        }
        return -1;
    }

    public int nearestExit(char[][] maze, int[] entrance) {
        int n = maze.length, m = maze[0].length;
        int steps[][] = new int[n][m];
        for (int[] s : steps) {
            Arrays.fill(s, -1);
        }

        int[] res = new int[1];
        res[0] = Integer.MAX_VALUE;
        steps[entrance[0]][entrance[1]] = 0;
        dfs(maze, entrance[0], entrance[1], n, m, steps, res, 0);
        return res[0] == Integer.MAX_VALUE ? -1 : res[0];
    }

    void dfs(char[][] maze, int i, int j, int n, int m, int steps[][], int[] res, int step) {
        if (steps[i][j] > res[0]) {
            return;
        }
        if (i == 0 || j == 0 || i == n - 1 || j == m - 1) {
            if (step > 0) {
                if (step < res[0]) {
                    res[0] = step;
                }
                return;
            }
        }
        int nextStep = step + 1;
        if (i > 0 && maze[i - 1][j] == '.' && (steps[i - 1][j] == -1 || steps[i - 1][j] > nextStep)) {
            steps[i - 1][j] = nextStep;
            dfs(maze, i - 1, j, n, m, steps, res, nextStep);
        }

        if (i < n - 1 && maze[i + 1][j] == '.' && (steps[i + 1][j] == -1 || steps[i + 1][j] > nextStep)) {
            steps[i + 1][j] = nextStep;
            dfs(maze, i + 1, j, n, m, steps, res, nextStep);
        }

        if (j > 0 && maze[i][j - 1] == '.' && (steps[i][j - 1] == -1 || steps[i][j - 1] > nextStep)) {
            steps[i][j - 1] = nextStep;
            dfs(maze, i, j - 1, n, m, steps, res, nextStep);
        }

        if (j < m - 1 && maze[i][j + 1] == '.' && (steps[i][j + 1] == -1 || steps[i][j + 1] > nextStep)) {
            steps[i][j + 1] = nextStep;
            dfs(maze, i, j + 1, n, m, steps, res, nextStep);
        }
    }
}
