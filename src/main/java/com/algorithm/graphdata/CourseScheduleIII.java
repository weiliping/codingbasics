package com.algorithm.graphdata;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class CourseScheduleIII {

    public static void main(String[] args) {
        int[][] prerequisites = new int[][] { { 2, 5 }, { 0, 5 }, { 0, 4 }, { 1, 4 }, { 3, 2 }, { 1, 3 } };
        int n = 6;
        List<List<Integer>> res = allScheduleOrders(prerequisites, n);
        for (List<Integer> r : res) {
            System.out.println(Arrays.toString(r.toArray()));
        }
    }

    public static List<List<Integer>> allScheduleOrders(int[][] prerequisites, int n) {
        List<List<Integer>> orders = new ArrayList<>();

        ArrayList<Integer>[] graph = new ArrayList[n];
        int[] inDegree = new int[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] prerequisite : prerequisites) {
            graph[prerequisite[0]].add(prerequisite[1]);
            inDegree[prerequisite[1]]++;
        }
        LinkedList<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }
        List<Integer> subRes = new ArrayList<>();
        allOrdersHelper(orders, subRes, graph, inDegree, queue);
        return orders;
    }

    static void allOrdersHelper(List<List<Integer>> orders, List<Integer> subRes,
            ArrayList<Integer>[] graph, int[] inDegree, LinkedList<Integer> queue) {
        if (!queue.isEmpty()) {
            for (int i : queue) {
                subRes.add(i);
                LinkedList<Integer> next = (LinkedList<Integer>) queue.clone();
                next.remove(Integer.valueOf(i));
                for (int childInd : graph[i]) {
                    inDegree[childInd]--;
                    if (inDegree[childInd] == 0) {
                        next.add(childInd);
                    }
                }
                allOrdersHelper(orders, subRes, graph, inDegree, next);
                subRes.remove(subRes.size() - 1);
                for (int childInd : graph[i]) {
                    inDegree[childInd]++;
                }
            }
        }
        if (subRes.size() == inDegree.length) {
            orders.add(new ArrayList<>(subRes));
        }
    }
}
