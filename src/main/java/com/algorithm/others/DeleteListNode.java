package com.algorithm.others;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class DeleteListNode {

    public ListNode deleteListNode(ListNode head) {
        ListNode p = head;
        while (p != null && p.next != null) {
            p.next = p.next.next;
            p = p.next;
        }
        return head;
    }

    public static void main(String[] args) {
        DeleteListNode d = new DeleteListNode();
//        System.out.println(Arrays.toString(d.analysisHistogram(new int[]{1, 0, 3, 1, 1, 0}, 3)));
        int[][] lines = new int[][]{{1,2,3,4,5,6,7,8,9,10,11},{12,13,2,14,8,15},{16,1,17,10,18}};
        int start = 9, end = 1;
        System.out.println(Arrays.toString(d.metroRouteDesignI(lines, start, end)));
        int[][] lines1 = new int[][]{{1,2,3,4,5},{2,10,14,15,16},{10,8,12,13},{7,8,4,9,11}, {2, 6, 7, 15}};
        int start1 = 1, end1 = 7;
        System.out.println(Arrays.toString(d.metroRouteDesignI(lines1, start1, end1)));

        int[][] lines2 = new int[][]{
                {7535,1306,8941,1356,6017,6331,6181,4941},
                {8941,1356,6181,6017,7535,4941,6331,1306},
                {1356,1306,6331,6017,6181,7535,4941,8941},
                {7535,8941,6017,1356,1306,6331,6181,4941},
                {4941,6331,6181,1356,6017}};
        int start2 = 6181, end2 = 6331;
        System.out.println(Arrays.toString(d.metroRouteDesignI(lines2, start2, end2)));

        int[][] lines3 = new int[][]{{7,6,2,3,9,1,4,5},{9,2,7},{8,4,9,7,5},{7,3,9,1}};
        int start3 = 3, end3 = 8;
        System.out.println(Arrays.toString(d.metroRouteDesignI(lines3, start3, end3)));
        int[][] lines4 = new int[][]{{4165,8075,3072,6302,3747,3616,1893},{7431,3616,3747,1893,8075,3219},{3072,6302,3747},{3616,3969},{7431,3616}};
        int start4 = 4165, end4 = 3219;
        System.out.println(Arrays.toString(d.metroRouteDesignI(lines4, start4, end4)));

        int[][] lines5 = new int[][]{{7851,6448,853,9027,970,5600,2269},{4614,7539},{970,4614,2269,9906},{7851,970,4614,9906,9027,2269}};
        int start5 = 9906, end5 = 853;
        System.out.println(Arrays.toString(d.metroRouteDesignI(lines5, start5, end5)));
    }

    public int[] analysisHistogram(int[] heights, int cnt) {
        Arrays.sort(heights);
        int len = heights.length - cnt;
        int min = Integer.MAX_VALUE, j = -1;
        for (int i = 0; i <= len; i++) {
            int diff = heights[i + cnt - 1] - heights[i];
            if (min > diff) {
                min = diff;
                j = i;
            }
        }
        return Arrays.copyOfRange(heights, j, j + cnt);
    }

    public int[] metroRouteDesignI(int[][] lines, int start, int end) {
        int n = lines.length;
        List<int[]>[] graph = new ArrayList[100];
        for (int i = 0; i < 100; i++) {
            graph[i] = new ArrayList<>();
        }
        Map<Integer, List<int[]>> mp = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int[] points = lines[i];
            for(int j = 0; j < points.length; j++) {
                int p = points[j];
                List<int[]> t = mp.getOrDefault(p, new ArrayList<>());
                for (int[] po : t) {
                    graph[i].add(new int[]{po[0], po[1], j});
                    graph[po[0]].add(new int[] {i, j, po[1]});
                }
                t.add(new int[]{i, j, -1});
                mp.put(p, t);
            }
        }
        List<int[]> endLines = mp.get(end);
        Queue<Pointer> queue = new LinkedList<>();
        for (int[] s: mp.get(start)) {
            queue.offer(new Pointer(s, new ArrayList<>()));
        }
        List<List<int[]>> routes = new ArrayList<>();
        while (!queue.isEmpty()) {
            int s = queue.size();
            for (int i = 0; i < s; i++) {
                Pointer curLine = queue.poll();
                List<int[]> parent = curLine.parents;
                parent.add(curLine.p);
                List<int[]> sub;
                boolean found = false;
                for (int[] endP : endLines) {
                    if (endP[0] == curLine.p[0]) {
                        sub = new ArrayList<>(parent);
                        sub.add(endP);
                        routes.add(sub);
                        found = true;
                        break;
                    }
                }
                if (found) {
                    continue;
                }
                for (int[] nextLine : graph[curLine.p[0]]) {
                    sub = new ArrayList<>(parent);
                    Pointer p = new Pointer(nextLine, sub);
                    queue.offer(p);
                }
            }
            if (!routes.isEmpty()) {
                break;
            }
        }
        List<List<Integer>> res = new ArrayList<>();
        for (List<int[]> route : routes) {
            List<Integer> subRes = new ArrayList<>();
            int len = route.size() - 1;
            boolean isDup = false;
            for (int i = 0; i < len; i++) {
                int line = route.get(i)[0], s = route.get(i)[1];
                int e = i == len - 1 ? route.get(i + 1)[1] : route.get(i + 1)[2];
                if (s > e) {
                    int j = i != 0 ? s - 1 : s;
                    for (; j >= e; j--) {
                        if (subRes.contains(lines[line][j])) {
                            isDup = true;
                            break;
                        }
                        subRes.add(lines[line][j]);
                    }
                } else {
                    int j = i != 0 ? s + 1 : s;
                    for (; j <= e; j++) {
                        if (subRes.contains(lines[line][j])) {
                            isDup = true;
                            break;
                        }
                        subRes.add(lines[line][j]);
                    }
                }
                if (isDup) {
                    break;
                }
            }
            if (!isDup) {
                res.add(subRes);
            }
        }
        res.sort((o1, o2) -> {
            int len = Math.min(o1.size(), o2.size());
            for (int i = 0; i < len; i++) {
                int num1 = o1.get(i), num2 = o2.get(i);
                if (num1 == num2) {
                    continue;
                }
                return Integer.compare(num1, num2);
            }
            return o1.size() - o2.size();
        });
        return res.get(0).stream().mapToInt(i -> i).toArray();
    }

    class Pointer {
        int[] p;
        List<int[]> parents;
        public Pointer(int[] p, List<int[]> parents) {
            this.p = p;
            this.parents = parents;
        }
    }
}
