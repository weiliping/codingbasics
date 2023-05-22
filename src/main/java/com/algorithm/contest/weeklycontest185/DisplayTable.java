package com.algorithm.contest.weeklycontest185;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class DisplayTable {

    public static void main(String[] args) {
        DisplayTable d = new DisplayTable();
        List<List<String>> orders = new ArrayList<>();
        List<String> order = new ArrayList<>();
        order.add("David");
        order.add("3");
        order.add("Ceviche");
        orders.add(order);
        order = new ArrayList<>();
        order.add("Corina");
        order.add("10");
        order.add("Beef Burrito");
        orders.add(order);
        order = new ArrayList<>();
        order.add("David");
        order.add("3");
        order.add("Fried Chicken");
        orders.add(order);
        order = new ArrayList<>();
        order.add("Carla");
        order.add("5");
        order.add("Water");
        orders.add(order);
        order = new ArrayList<>();
        order.add("Carla");
        order.add("5");
        order.add("Ceviche");
        orders.add(order);
        order = new ArrayList<>();
        order.add("Rous");
        order.add("3");
        order.add("Ceviche");
        orders.add(order);
        List<List<String>> res = d.displayTable(orders);
        for (List<String> r : res) {
            System.out.println(Arrays.toString(r.toArray()));
        }
    }

    public List<List<String>> displayTable(List<List<String>> orders) {

        List<String> head = new ArrayList<>();
        for (List<String> order : orders) {
            if (!head.contains(order.get(2))) {
                head.add(order.get(2));
            }
        }
        Collections.sort(head);
        int n = head.size();
        Map<String, Integer> mp = new HashMap<>();
        for (int i = 0; i < n; i++) {
            mp.put(head.get(i), i);
        }

        TreeMap<Integer, int[]> cnts = new TreeMap<>();
        for (List<String> order : orders) {
            Integer num = Integer.valueOf(order.get(1));
            Integer ind = mp.get(order.get(2));
            int[] res = cnts.getOrDefault(num, new int[n]);
            res[ind]++;
            cnts.put(num, res);
        }
        List<List<String>> result = new ArrayList<>();
        List<String> h = new ArrayList<>();
        h.add("Table");
        h.addAll(head);
        result.add(h);
        while (!cnts.isEmpty()) {
            Map.Entry<Integer, int[]> m = cnts.pollFirstEntry();
            List<String> line = new ArrayList<>();
            line.add(String.valueOf(m.getKey()));
            for (int i : m.getValue()) {
                line.add(String.valueOf(i));
            }
            result.add(line);
        }
        return result;
    }
}
