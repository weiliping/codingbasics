package com.algorithm.others;

import java.util.ArrayList;
import java.util.HashMap;

public class CourseScheduleDFS {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (prerequisites == null) {
            throw new IllegalArgumentException("illegal prerequisites array");
        }

        int len = prerequisites.length;

        if (numCourses == 0 || len == 0) {
            return true;
        }

        //track visited courses
        int[] visit = new int[numCourses];

        // use the map to store what courses depend on a course
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();
        for (int[] a : prerequisites) {
            if (map.containsKey(a[1])) {
                map.get(a[1]).add(a[0]);
            } else {
                ArrayList<Integer> l = new ArrayList<Integer>();
                l.add(a[0]);
                map.put(a[1], l);
            }
        }

        for (int i = 0; i < numCourses; i++) {
            if (!canFinishDFS(map, visit, i))
                return false;
        }

        return true;
    }

    private boolean canFinishDFS(HashMap<Integer, ArrayList<Integer>> map, int[] visit, int i) {
        if (visit[i] == -1)
            return false;
        if (visit[i] == 1)
            return true;

        visit[i] = -1;
        if (map.containsKey(i)) {
            for (int j : map.get(i)) {
                if (!canFinishDFS(map, visit, j))
                    return false;
            }
        }

        visit[i] = 1;

        return true;
    }
}
