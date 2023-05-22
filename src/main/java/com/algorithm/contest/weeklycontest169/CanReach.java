package com.algorithm.contest.weeklycontest169;

public class CanReach {
    public static void main(String[] args) {
        CanReach c = new CanReach();

        System.out.println(c.canReach(new int[]{4,2,3,0,3,1,2}, 5));
        System.out.println(c.canReach(new int[]{4,2,3,0,3,1,2}, 0));
        System.out.println(c.canReach(new int[]{3,0,2,1,2}, 2));
    }

    public boolean canReach(int[] arr, int start) {
        int n = arr.length;
        boolean[] visited = new boolean[n];
        boolean[] res = new boolean[1];
        dfs(visited, arr, start, res, n);
        return res[0];
    }

    void dfs(boolean[] visited, int[] arr, int ind, boolean[] res, int n) {
        if (visited[ind] || res[0]) {
            return;
        }
        visited[ind] = true;
        if (arr[ind] == 0) {
            res[0] = true;
            return;
        }
        int nInd = arr[ind] + ind;
        if (nInd < n) {
            dfs(visited, arr, nInd, res, n);
        }
        if (ind >= arr[ind]) {
            dfs(visited, arr, ind - arr[ind], res, n);
        }
    }
}
