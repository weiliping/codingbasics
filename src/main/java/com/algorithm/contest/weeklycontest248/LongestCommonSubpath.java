package com.algorithm.contest.weeklycontest248;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LongestCommonSubpath {

    public int longestCommonSubpath(int n, int[][] paths) {
        int lsize = Integer.MAX_VALUE, i = -1, l = paths.length;
        for (int j = 0; j < l; j++) {
            if (lsize > paths[j].length) {
                i = j;
            }
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int j = 0; j < paths[i].length; j++) {
            map.put(paths[i][j], j);
        }

        List<Integer> indexes;
        int max = 0;
        for (int j = 0; j < l; j++) {
            if (j == i) {
                continue;
            }
            int k = 0, len = paths[j].length;
            indexes = new ArrayList<>();
            while (k < len) {
                if (map.containsKey(paths[j][k])) {
                    indexes.add(map.get(paths[j][k]));
                    int x = k + 1;
                    while (k < len - 1 && map.containsKey(paths[j][x])) {
                        indexes.add(map.get(paths[j][x]));
                        x++;
                    }
                    k = x;
                }
                k++;
            }
            for (int y = 0; y < paths[i].length; y++) {
                if (indexes.contains(y)) {
                    continue;
                }
                map.remove(paths[i][y]);
            }
        }
        return 0;
    }
}
