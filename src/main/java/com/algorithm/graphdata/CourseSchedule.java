package com.algorithm.graphdata;

import java.util.ArrayList;
import java.util.LinkedList;

public class CourseSchedule {

    /**
     * #207
     * https://leetcode-cn.com/problems/course-schedule/
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(canFinish(2, new int[][] { { 1, 0 } }));
        System.out.println(canFinish(2, new int[][] { { 1, 0 }, { 0, 1 } }));
    }

    public static boolean canFinish(int numCourses, int[][] prerequisites) {

        ArrayList<Integer>[] graph = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<>();
        }
        int[] in = new int[numCourses];

        for (int[] a : prerequisites) {
            graph[a[1]].add(a[0]);
            in[a[0]]++;
        }

        LinkedList<Integer> q = new LinkedList<>();

        for (int i = 0; i < numCourses; i++) {
            if (in[i] == 0) {
                q.offer(i);
            }
        }

        while (!q.isEmpty()) {
            int t = q.pop();
            for (Integer a : graph[t]) {
                in[a]--;
                if (in[a] == 0) {
                    q.offer(a);
                }
            }
        }

        for (int i = 0; i < numCourses; i++) {
            if (in[i] != 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean canFinishDFS(int numCourses, int[][] prerequisites) {
        ArrayList<Integer>[] graph = new ArrayList[numCourses];
        int[] visit = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] a : prerequisites) {
            graph[a[1]].add(a[0]);
        }

        for (int i = 0; i < numCourses; i++) {
            if (!dfsHelper(graph, visit, i)) {
                return false;
            }
        }
        return true;
    }

    static boolean dfsHelper(ArrayList<Integer>[] graph, int[] visit, int i) {
        if (visit[i] == -1) {
            return false;
        }
        if (visit[i] == 1) {
            return true;
        }
        visit[i] = -1;

        for (int a : graph[i]) {
            if (!dfsHelper(graph, visit, a)) {
                return false;
            }
        }
        visit[i] = 1;
        return true;
    }
}
