package com.algorithm.dfs;

public class HasValidPath {

    /**
     * #1391
     * https://leetcode-cn.com/problems/check-if-there-is-a-valid-path-in-a-grid/
     *
     * @param args
     */
    public static void main(String[] args) {
        //true
        int[][] grid = new int[][] { { 2, 4, 3 }, { 6, 5, 2 } };
        System.out.println(hasValidPath(grid));
        //false
        int[][] grid2 = new int[][] { { 1, 2, 1 }, { 1, 2, 1 } };
        System.out.println(hasValidPath(grid2));

        //false
        int[][] grid3 = new int[][] { { 1, 1, 2 } };
        System.out.println(hasValidPath(grid3));

        //true
        int[][] grid4 = new int[][] { { 2 }, { 2 }, { 2 }, { 2 }, { 2 }, { 2 }, { 6 } };
        System.out.println(hasValidPath(grid4));
        //true
        int[][] grid5 = new int[][] { { 1, 1, 1, 1, 1, 1, 3 } };
        System.out.println(hasValidPath(grid5));

        //true
        int[][] grid6 = new int[][] { { 4, 1 }, { 6, 1 } };
        System.out.println(hasValidPath(grid6));

        //true
        int[][] grid7 = new int[][] { { 1 } };
        System.out.println(hasValidPath(grid7));

        //true
        int[][] grid8 = new int[][] { { 6, 1, 3 }, {4, 1, 5} };
        System.out.println(hasValidPath(grid8));

        //false
        int[][] grid9 = new int[][] { { 2, 6 }};
        System.out.println(hasValidPath(grid9));
    }

    static int[][] dirs = new int[][] { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
    static int[][] maps = new int[][] { { 2, 3 }, { 0, 1 }, { 1, 2 }, { 1, 3 }, { 0, 2 }, { 0, 3 } };

    public static boolean hasValidPath(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) {
            return false;
        }
        if (grid.length == 1 && grid[0].length == 1) {
            return true;
        }
        int rLen = grid.length, cLen = grid[0].length;
        int[] ports = maps[grid[0][0] - 1];
        for (int i : ports) {
            int[] s = dirs[i];
            if (s[0] >= 0 && s[1] >= 0 && s[0] < rLen && s[1] < cLen) {
                boolean[] visited = new boolean[rLen * cLen];
                boolean isValid = dfs(grid, s[0], s[1], rLen, cLen, visited, 0);
                if (isValid) {
                    return true;
                }
            }
        }
        return false;
    }

    static boolean dfs(int[][] grid, int i, int j, int rLen, int cLen, boolean[] visited, int pre) {
        int indx = toIndx(i, j, cLen);
        if (!visited[indx]) {
            visited[indx] = true;
            int[] dir = maps[grid[i][j] - 1];
            boolean canGo = false;
            int nextI = -1, nextJ = -1;
            for (int d : dir) {
                int childI = i + dirs[d][0];
                int childJ = j + dirs[d][1];
                if (childI >= 0 && childI <= rLen && childJ >= 0 && childJ <= cLen) {
                    int childIndx = toIndx(childI, childJ, cLen);
                    if (childIndx != pre) {
                        nextI = childI;
                        nextJ = childJ;
                    } else {
                        canGo = true;
                    }
                }
            }
            if (canGo) {
                if (i == rLen - 1 && j == cLen - 1) {
                    return true;
                }
                if (nextI == -1 || nextJ == -1) {
                    return false;
                }
                return dfs(grid, nextI, nextJ, rLen, cLen, visited, indx);
            }
        }
        return false;
    }

    static int toIndx(int i, int j, int rLen) {
        return i * rLen + j;
    }
}
