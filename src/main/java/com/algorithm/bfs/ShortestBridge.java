package com.algorithm.bfs;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

public class ShortestBridge {

    static int[][] drs = new int[][] { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

    public static void main(String[] args) {
//        int[][] A = new int[][] {{0, 1}, {1, 0}};
//        int[][] A = new int[][] {{0, 1, 0}, {0, 0, 0}, {0, 0, 1}};
        int[][] A = new int[][] { { 1, 1, 1, 1, 1 }, { 1, 0, 0, 0, 1 }, { 1, 0, 1, 0, 1 }, { 1, 0, 0, 0, 1 },
                { 1, 1, 1, 1, 1 } };
        System.out.println(shortestBridge(A));
    }

    public static int shortestBridge(int[][] A) {
        int rLen = A.length, cLen = A[0].length;
        Queue<Integer> queue = new ArrayDeque<>();
        Map<Integer, Integer> map = new HashMap<>();
        boolean[] visited = new boolean[rLen * cLen];
        for (int i = 0; i < rLen && queue.isEmpty(); i++) {
            for (int j = 0; j < cLen && queue.isEmpty(); j++) {
                if (A[i][j] == 1) {
                    boolean island = true;
                    for (int k = 0; k < 4; k++) {
                        int di = i + drs[k][0];
                        int dj = j + drs[k][1];
                        if (di >= 0 && di < rLen && dj >= 0 && dj < cLen && A[di][dj] == 1) {
                            island = false;
                            break;
                        }
                    }
                    if (island) {
                        queue.offer(i * cLen + j);
                        visited[i * cLen + j] = true;
                    }
                }
            }
        }

        while (!queue.isEmpty()) {
            Integer indx = queue.poll();
            int idi = indx / cLen;
            int idj = indx % cLen;
            for (int k = 0; k < 4; k++) {
                int di = idi + drs[k][0];
                int dj = idj + drs[k][1];
                if (di >= 0 && di < rLen && dj >= 0 && dj < cLen) {
                    int curIdx = di * cLen + dj;
                    if (!visited[curIdx]) {
                        if (A[di][dj] == 1) {
                            return map.getOrDefault(indx, 0);
                        } else {
                            queue.offer(curIdx);
                            visited[curIdx] = true;
                            map.put(curIdx, map.getOrDefault(indx, 0) + 1);
                        }
                    }
                }
            }
        }
        return 0;
    }
}
