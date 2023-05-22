package com.algorithm.graphdata;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import com.algorithm.linkedlists.ListNode;

public class CourseScheduleII {

    /**
     * #210
     * https://leetcode-cn.com/problems/course-schedule-ii/
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(Arrays.toString(findOrder(4, new int[][] { { 1, 0 }, { 2, 0 }, { 3, 1 }, { 3, 2 } })));
        System.out.println(Arrays.toString(findOrderII(4, new int[][] { { 1, 0 }, { 2, 0 }, { 3, 1 }, { 3, 2 } })));
        System.out.println(Arrays.toString(findOrderIII(4, new int[][] { { 1, 0 }, { 2, 0 }, { 3, 1 }, { 3, 2 } })));
    }

    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<Integer>[] graph = new ArrayList[numCourses];
        int[] in = new int[numCourses];

        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] a : prerequisites) {
            graph[a[1]].add(a[0]);
            in[a[0]]++;
        }

        LinkedList<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (in[i] == 0) {
                queue.push(i);
            }
        }

        while (!queue.isEmpty()) {
            int t = queue.pop();
            res.add(t);

            for (Integer a : graph[t]) {
                in[a]--;
                if (in[a] == 0) {
                    queue.push(a);
                }
            }
        }

        if (res.size() != numCourses) {
            res.clear();
        }

        int[] ints = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            ints[i] = res.get(i);
        }
        return ints;
    }

    static int[] findOrderII(int numCourses, int[][] prerequisites) {
        ArrayList<Integer>[] graph = new ArrayList[numCourses];
        int[] visited = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<>();
        }

        Stack<Integer> res = new Stack<>();
        for (int[] a : prerequisites) {
            graph[a[1]].add(a[0]);
        }

        for (int i = 0; i < numCourses; i++) {
            if (!dfs(graph, visited, i, res)) {
                return new int[0];
            }
        }

        int i = 0;
        int[] result = new int[numCourses];
        while (!res.isEmpty()) {
            result[i++] = res.pop();
        }
        return result;
    }

    static boolean dfs(ArrayList<Integer>[] graph, int[] visited, int i, Stack<Integer> res) {
        if (visited[i] == -1) {
            return false;
        }

        if (visited[i] == 1) {
            return true;
        }

        visited[i] = -1;
        for (int a : graph[i]) {
            if (!dfs(graph, visited, a, res)) {
                return false;
            }
        }
        visited[i] = 1;
        res.push(i);
        return true;
    }


    public static int[] findOrderIII(int numCourses, int[][] prerequisites) {
        ListNode[] adjList = new ListNode[numCourses]; // 邻接表：adjList[i] 保存课程 i 的所有后继课程。
        int[] inDegree = new int[numCourses]; // inDegree[i] 表示修课程 i 需要先完成的课程数量。
        for (int[] pair : prerequisites) {
            adjList[pair[1]] = new ListNode(pair[0], adjList[pair[1]]); // 建图：课程 pair[1] 的后继课程中包含 pair[0]。
            inDegree[pair[0]]++;
        }
        ListNode head = new ListNode(), tail = head; // 自定义队列的头尾节点。
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) { // 将所有入度为 0 的课程加入队列。
                tail.next = new ListNode(i);
                tail = tail.next;
            }
        }
        int[] order = new int[numCourses]; // 拓扑排序结果。
        int index = 0;
        for (head = head.next; head != null; head = head.next) {
            int course = head.val; // 当前课程。
            order[index++] = course;
            for (ListNode curr = adjList[course]; curr != null; curr = curr.next) {
                if (--inDegree[curr.val] == 0) { // 将当前课程的所有后继课程的入度 -1。
                    tail.next = new ListNode(curr.val);
                    tail = tail.next;
                }
            }
        }
        return index == numCourses ? order : new int[0];
    }
}
