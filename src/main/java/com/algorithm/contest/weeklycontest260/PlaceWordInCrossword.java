package com.algorithm.contest.weeklycontest260;

import java.util.HashMap;
import java.util.Map;

public class PlaceWordInCrossword {

    public static void main(String[] args) {
        PlaceWordInCrossword p = new PlaceWordInCrossword();
        char[][] board0 = new char[][] {{'#', ' ', '#'},{' ', ' ', '#'},{'#', 'c', ' '}};
        String word0 = "abc";
        System.out.println(p.placeWordInCrossword(board0, word0));

        char[][] board = new char[][] {{' ', '#', 'a'},{' ', '#', 'c'},{' ', '#', 'a'}};
        String word = "ac";
        System.out.println(p.placeWordInCrossword(board, word));

        char[][] board1 = new char[][] {{'#', ' ', '#'},{' ', ' ', '#'},{'#', ' ', 'c'}};
        String word1 = "ca";
        System.out.println(p.placeWordInCrossword(board1, word1));

        char[][] board2 = new char[][] {{'l', '#'},{' ', ' '},{' ', ' '}};
        String word2 = "qv";
        System.out.println(p.placeWordInCrossword(board2, word2));
    }
    public boolean placeWordInCrossword(char[][] board, String word) {
        Map<Integer, Point> mp = new HashMap<>();
        int m = board.length, n = board[0].length, l = word.length();

        for (int i = 0; i < m; i++) {
            int jl = -1, jr = 0;
            while (jr < n) {
                while (jr < n && board[i][jr] != '#') {
                    if (jr == n - 1) {
                        int len = jr - jl;
                        if (len == l) {
                            int key = toKey(i, jl + 1, m);
                            Point p = mp.get(key);
                            if (p == null) {
                                p = new Point(i, jl + 1);
                            }
                            p.col[0] = jl + 1;
                            p.col[1] = jr;
                            mp.put(key, p);
                        }
                    }
                    jr++;
                    continue;
                }
                int len = jr - jl - 1;
                if (len == l) {
                    int key = toKey(i, jl + 1, m);
                    Point p = mp.get(key);
                    if (p == null) {
                        p = new Point(i, jl + 1);
                    }
                    p.col[0] = jl + 1;
                    p.col[1] = jr - 1;
                    mp.put(key, p);
                }
                jl = jr;
                jr++;
            }
        }

        for (int j = 0; j < n; j++) {
            int il = -1, ir = 0;
            while (ir < m) {
                while (ir < m && board[ir][j] != '#') {
                    if (ir == m - 1) {
                        int len = ir - il;
                        if (len == l) {
                            int key = toKey(il + 1, j, m);
                            Point p = mp.get(key);
                            if (p == null) {
                                p = new Point(il + 1, j);
                            }
                            p.row[0] = il + 1;
                            p.row[1] = ir;
                            mp.put(key, p);
                        }
                    }
                    ir++;
                    continue;
                }
                int len = ir - il - 1;
                if (len == l) {
                    int key = toKey(il + 1, j, m);
                    Point p = mp.get(key);
                    if (p == null) {
                        p = new Point(il + 1, j);
                    }
                    p.row[0] = il + 1;
                    p.row[1] = ir - 1;
                    mp.put(key, p);
                }
                il = ir;
                ir++;
            }
        }
        if (mp.size() == 0) {
            return false;
        }

        for (Point p : mp.values()) {
            if (isEqual(board, p, word, l)) {
                return true;
            }
        }
        return false;
    }

    boolean isEqual(char[][] board, Point p, String word, int l) {
        int k = 0;
        if (p.col[0] != -1) {
            boolean equalFlag = true;
            for (int j = p.col[0]; j <= p.col[1] && k < l; j++) {
                if (board[p.i][j] != ' ' && board[p.i][j] != word.charAt(k)) {
                    equalFlag = false;
                    break;
                }
                k++;
            }
            if (equalFlag && k == l) {
                return true;
            }
            equalFlag = true;
            k = 0;
            for (int j = p.col[1]; j >= p.col[0]; j--) {
                if (board[p.i][j] != ' ' && board[p.i][j] != word.charAt(k)) {
                    equalFlag = false;
                    break;
                }
                k++;
            }
            if (equalFlag && k == l) {
                return true;
            }
        }
        if (p.row[0] != -1) {
            boolean equalFlag = true;
            for (int i = p.row[0]; i <= p.row[1] && k < l; i++) {
                if (board[i][p.j] != ' ' && board[i][p.j] != word.charAt(k)) {
                    equalFlag = false;
                    break;
                }
                k++;
            }
            if (equalFlag && k == l) {
                return true;
            }
            equalFlag = true;
            k = 0;
            for (int i = p.row[1]; i >= p.row[0]; i--) {
                if (board[i][p.j] != ' ' && board[i][p.j] != word.charAt(k)) {
                    equalFlag = false;
                    break;
                }
                k++;
            }
            if (equalFlag && k == l) {
                return true;
            }
        }
        return false;
    }

    static int toKey(int i, int j, int m) {
        return i * m + j;
    }
    class Point {
        int i;
        int j;

        int[] row;
        int[] col;

        public Point(int i, int j) {
            this.i = i;
            this.j = j;
            this.row = new int[] {-1, -1};
            this.col = new int[] {-1, -1};
        }
    }
}
