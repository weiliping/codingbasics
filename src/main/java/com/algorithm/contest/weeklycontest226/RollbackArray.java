package com.algorithm.contest.weeklycontest226;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class RollbackArray {

    public static void main(String[] args) {
        int[][] adjacentPairs = new int[][] {{2, 1}, {3, 4}, {3, 2}};
        System.out.println(Arrays.toString(rollback(adjacentPairs)));
        int[][] adjacentPairs1 = new int[][] {{4, -2}, {1, 4}, {-3, 1}};
        System.out.println(Arrays.toString(rollback(adjacentPairs1)));
        int[][] adjacentPairs2 = new int[][] {{100000, -100000}};
        System.out.println(Arrays.toString(rollback(adjacentPairs2)));
    }

    public static int[] rollback(int[][] adjacentPairs) {
        int n = adjacentPairs.length;
        int[] nums = new int[n + 1];
        Map<Integer, Integer> inDegrees = new HashMap<>();
        Map<Integer, List<Integer>> graph = new HashMap<>();

        for (int[] e : adjacentPairs) {
            List<Integer> l = graph.getOrDefault(e[0], new ArrayList<>());
            l.add(e[1]);
            graph.put(e[0], l);
            inDegrees.put(e[0], inDegrees.getOrDefault(e[0], 0) + 1);
            List<Integer> r = graph.getOrDefault(e[1], new ArrayList<>());
            r.add(e[0]);
            graph.put(e[1], r);
            inDegrees.put(e[1], inDegrees.getOrDefault(e[1], 0) + 1);
        }

        int[] starts = new int[2];
        int i = 0;
        Iterator<Integer> it = inDegrees.keySet().iterator();
        while (it.hasNext()) {
            int key = it.next();
            if (inDegrees.get(key) == 1) {
                starts[i++] = key;
                if (i == 2) {
                    break;
                }
            }
        }
        for (int j = 0; j < 2; j++) {
            int k = 0;
            nums[0] = starts[j];
            while (k < n) {
                List<Integer> nextNums = graph.get(nums[k]);
                if (nextNums.isEmpty() || nextNums.size() > 2) {
                    break;
                }
                if (nextNums.size() == 1) {
                    nums[++k] = nextNums.get(0);
                    continue;
                }

                if (nextNums.get(0) != nums[k - 1]) {
                    nums[++k] = nextNums.get(0);
                    continue;
                }
                nums[++k] = nextNums.get(1);
            }
            if (k == n) {
                return nums;
            }
        }
        return nums;
    }
}
