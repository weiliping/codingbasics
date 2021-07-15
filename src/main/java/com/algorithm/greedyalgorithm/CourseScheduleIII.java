package com.algorithm.greedyalgorithm;

import java.util.Arrays;
import java.util.PriorityQueue;

public class CourseScheduleIII {

    /**
     * #630
     * https://leetcode-cn.com/problems/course-schedule-iii/
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(scheduleCourse(new int[][] { { 100, 200 }, { 200, 1300 }, { 1000, 1250 }, { 2000, 3200 } }));
        System.out.println(scheduleCourse(new int[][] { { 5, 5 }, { 4, 6 }, { 2, 6 } }));
    }

    public static int scheduleCourse(int[][] courses) {
        Arrays.sort(courses, (a, b) -> a[1] - b[1]);

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);

        int time = 0;

        for (int[] c : courses) {
            time += c[0];
            pq.offer(c[0]);
            if (time > c[1]) {
                time -= pq.poll();
            }
        }
        return pq.size();
    }
}

