package com.algorithm.contest.weeklycontest194;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;

public class AvoidFlood {
    public static void main(String[] args) {
        AvoidFlood a = new AvoidFlood();
        System.out.println(Arrays.toString(a.avoidFlood(new int[] {1,2,3,4})));
        System.out.println(Arrays.toString(a.avoidFlood(new int[] {1,2,0,0,2,1})));
        System.out.println(Arrays.toString(a.avoidFlood(new int[] {1,2,0,1,2})));
        System.out.println(Arrays.toString(a.avoidFlood(new int[] {69,0,0,0,69})));
        System.out.println(Arrays.toString(a.avoidFlood(new int[] {10,20,20})));
        System.out.println(Arrays.toString(a.avoidFlood(new int[] {0,1,1})));
        System.out.println(Arrays.toString(a.avoidFlood(new int[] {2,3,0,0,3,1,0,1,0,2,2})));
    }

    public int[] avoidFlood(int[] rains) {
        PriorityQueue<Integer> zeroQueue = new PriorityQueue<>();
        HashMap<Integer, Integer> rainMap = new HashMap<>();
        int n = rains.length;
        int[] res = new int[n];
        Arrays.fill(res, -1);
        for (int i = 0; i < n; i++) {
            if (rains[i] == 0) {
                zeroQueue.offer(i);
                continue;
            }
            if (!rainMap.containsKey(rains[i])) {
                rainMap.put(rains[i], i);
                continue;
            }
            if (zeroQueue.isEmpty()) {
                return new int[0];
            }
            int id = rainMap.get(rains[i]);
            if (zeroQueue.peek() > id) {
                res[zeroQueue.poll()] = rains[i];
                rainMap.put(rains[i], i);
                continue;
            }
            ArrayDeque<Integer> ids = new ArrayDeque<>();
            while (!zeroQueue.isEmpty() && zeroQueue.peek() < id) {
                ids.offer(zeroQueue.poll());
            }
            if (zeroQueue.isEmpty()) {
                return new int[0];
            }
            res[zeroQueue.poll()] = rains[i];
            rainMap.put(rains[i], i);
            while(!ids.isEmpty()) {
                zeroQueue.offer(ids.poll());
            }
        }
        while (!zeroQueue.isEmpty()) {
            res[zeroQueue.poll()] = 1;
        }
        return res;
    }
}
