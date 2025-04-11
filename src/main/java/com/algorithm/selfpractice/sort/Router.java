package com.algorithm.selfpractice.sort;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class Router {
    public static void main(String[] args) {
        // Router router = new Router(3);
        // System.out.println(router.addPacket(1, 4, 90)); // true
        // System.out.println(router.addPacket(2, 5, 90)); // true
        // System.out.println(router.addPacket(1, 4, 90)); // false
        // System.out.println(router.addPacket(3, 5, 95)); // true
        // System.out.println(router.addPacket(4, 5, 105)); // true
        // System.out.println(Arrays.toString(router.forwardPacket())); // 1
        // System.out.println(router.addPacket(5, 2, 110)); // true
        // System.out.println(router.getCount(5, 100, 110)); // 2
        // Router router = new Router(2);
        // System.out.println(router.addPacket(3,1,3));
        // System.out.println(router.addPacket(1,2,3));
        // System.out.println(router.addPacket(4,5,3));
        // System.out.println(router.getCount(1, 2, 3));
        Router router = new Router(2);
        System.out.println(router.addPacket(5,4,1));
        System.out.println(router.addPacket(3,4,1));
        System.out.println(router.addPacket(5,2,1));
        System.out.println(router.addPacket(5,3,1));
    }

    private final int n;
    private final LinkedList<Integer[]> arr = new LinkedList<>();
    private HashSet<String> set = new HashSet<>();
    private List<Integer>[] times = new ArrayList[200001];
    public Router(int memoryLimit) {
        this.n = memoryLimit;
    }
    
    public boolean addPacket(int source, int destination, int timestamp) {
        String key = toKey(source, destination, timestamp);
        if (set.contains(key)) {
            return false;
        }
        if (arr.size() == n) {
            Integer[] first = arr.poll();
            set.remove(toKey(first[0], first[1], first[2]));
            int ind = first[1].intValue();
            if (times[ind] != null && times[ind].size() > 0) {
                times[ind].removeFirst();
            }
        }
        if (times[destination] == null) {
            times[destination] = new ArrayList<>();
        }   
        times[destination].add(timestamp);
        arr.add(new Integer[] {source, destination, timestamp});
        set.add(key);
        return true;
    }

    public String toKey(int s, int d, int t) {
        return s + "-" + d + "-" + t;
    }
    
    public int[] forwardPacket() {
        if (arr.isEmpty()) {
            return new int[] {};
        }
        Integer[] first = arr.poll();
        set.remove(toKey(first[0], first[1], first[2]));
        times[first[1]].removeFirst();
        return new int[] {first[0], first[1], first[2]};    
    }
    
    public int getCount(int destination, int startTime, int endTime) {
        List<Integer> list = times[destination];
        int i = searchInsertLeft(list, startTime);
        int j = searchInsertRight(list, endTime);
        return j - i;  
    }

    public int searchInsertRight(List<Integer> list, int target) {
        int left = 0;
        int right = list.size() - 1;
    
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (list.get(mid) <= target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    public int searchInsertLeft(List<Integer> list, int target) {
        int left = 0;
        int right = list.size() - 1;
    
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (list.get(mid) >= target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
