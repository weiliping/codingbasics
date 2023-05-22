package com.algorithm.contest.biweeklycontest51;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.TreeSet;

public class ClosestRoom {
    public static void main(String[] args) {
        ClosestRoom c = new ClosestRoom();
        // int[][] rooms = new int[][] {{1,4},{2,3},{3,5},{4,1},{5,2}};
        // int[][] queries = new int[][] {{2,3},{2,4},{2,5}};
        // System.out.println(Arrays.toString(c.closestRoom(rooms, queries)));

        int[][] rooms1 = new int[][] { { 15, 19 }, { 11, 10 }, { 12, 1 }, { 17, 6 }, { 1, 6 }, { 10, 21 }, { 13, 7 },
                { 14, 25 }, { 19, 3 }, { 9, 11 } };
        int[][] queries1 = new int[][] { { 14, 14 }, { 20, 17 }, { 6, 8 }, { 1, 6 }, { 21, 4 }, { 4, 16 }, { 3, 22 },
                { 2, 21 }, { 24, 6 }, { 6, 1 } };
        // int[][] queries1 = new int[][]{{4,16},{3,22},{2,21},{24,6},{6,1}};
        System.out.println(Arrays.toString(c.closestRoom(rooms1, queries1))); // [14,15,9,1,17,10,14,10,17,9]
    }

    class Event {
        int size;
        int origin;
        int op;
        int id;

        public Event(int op, int id, int s, int origin) {
            this.op = op;
            this.id = id;
            this.size = s;
            this.origin = origin;
        }
    }

    public int[] closestRoom(int[][] rooms, int[][] queries) {

        int n = queries.length, res[] = new int[n], m = rooms.length;

        Arrays.fill(res, -1);
        List<Event> events = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            int[] room = rooms[i];
            events.add(new Event(0, room[0], room[1], i));
        }

        for (int j = 0; j < n; j++) {
            int[] q = queries[j];
            events.add(new Event(1, q[0], q[1], j));
        }

        Collections.sort(events, (a, b) -> a.size == b.size ? a.op - b.op : b.size - a.size);

        TreeSet<Integer> s = new TreeSet<>();
        for (Event event : events) {
            if (event.op == 0) {
                s.add(event.id);
                continue;
            }
            if (s.contains(event.id)) {
                res[event.origin] = event.id;
                continue;
            }
            int sub = Integer.MAX_VALUE;

            Integer h = s.higher(event.id);
            if (h != null) {
                if (h - event.id < sub) {
                    sub = h - event.id;
                    res[event.origin] = h;
                }
            }

            Integer l = s.lower(event.id);
            if (l != null) {
                if (event.id - l <= sub) {
                    res[event.origin] = l;
                }
            }
        }

        return res;
    }
}
