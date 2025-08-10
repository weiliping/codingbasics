package com.algorithm.contest.weeklycontest441;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SolveQueries {
    public static void main(String[] args) {
        SolveQueries s = new SolveQueries();
        // int[] nums = new int[]{1,3,1,4,1,3,2};
        // int[] queries = new int[]{0, 3, 5};
        // System.out.println(s.solveQueries(nums, queries));
        int[] nums1 = new int[]{2,10,20,20,20};
        int[] queries1 = new int[]{1, 4, 2};
        System.out.println(s.solveQueries(nums1, queries1));
    }
    
    public List<Integer> solveQueriesI(int[] nums, int[] queries) {
        int n = nums.length;
        Map<Integer, Node> heads = new HashMap<>();
        Map<Integer, Node> tails = new HashMap<>();
        Map<Integer, Node> nodes = new HashMap<>();
        for(int i = 0; i < n; i++) {
            Node cur = new Node(i);
            if (tails.containsKey(nums[i])) {
                Node prevNode = tails.get(nums[i]);
                cur.prev = prevNode;
                prevNode.next = cur;
                tails.put(nums[i], cur);
                nodes.put(i, cur);
                continue;
            }
            heads.put(nums[i], cur);
            tails.put(nums[i], cur);
            nodes.put(i, cur);
        }
        for (Integer k : heads.keySet()) {
            Node head = heads.get(k);
            Node tail = tails.get(k);
            if (head.i == tail.i) {
                continue;
            }
            head.prev = tail;
            tail.next = head;
            nodes.put(head.i, head);
            nodes.put(tail.i, tail);
        }

        List<Integer> res = new ArrayList<>();
        for (int j : queries) {
            Node cur = nodes.get(j);
            if (cur.next == null || cur.prev == null) {
                res.add(-1);
                continue;
            }
            int d = Integer.MAX_VALUE;
            if (cur.next != null) {
                int v = cur.next.i - cur.i;
                d = Math.min(d, v < 0 ? v + n : v);
            }
            if (cur.prev != null) {
                int v = cur.i - cur.prev.i;
                d = Math.min(d, v < 0 ? v + n : v);
            }
            res.add(d);
        }
        return res;
    }
     public List<Integer> solveQueries(int[] nums, int[] queries) {
        int n = nums.length;
        Map<Integer, Map<Integer, Integer>> m = new HashMap<>();
        Map<Integer, Integer[]> pres = new HashMap<>();
        for (int i = 0; i < n; i++) {
            Integer k = nums[i];
            Integer[] pre = pres.getOrDefault(k, new Integer[]{-1, -1});
            Map<Integer, Integer> mv = m.getOrDefault(k, new HashMap<>());
            if (pre[1] == -1) {
                pres.put(k, new Integer[]{i, i});
                continue;
            }
            //count pre next value
            mv.put(pre[1], i - pre[1]);
            m.put(k, mv);
            pre[1] = i;
            pres.put(k, pre);
        } 
        List<Integer> res = new ArrayList<>();
        for (int j = 0; j < queries.length; j++) {
            Integer k = nums[queries[j]];
            Map<Integer, Integer> mv = m.get(k);
            Integer ind = queries[j];
            if (mv != null && mv.containsKey(ind)) {
                res.add(mv.get(ind));
                continue;
            }
            Integer[] pre = pres.get(k);
            if (pre[0] != pre[1]) {
                res.add(pre[0] + n - ind);
                continue;    
            }
            res.add(-1);
        }       
        return res;
    }    
}

class Node {
    int i;
    public Node prev;
    public Node next;
    public Node(int i) {
        this.i = i;
    }
}
