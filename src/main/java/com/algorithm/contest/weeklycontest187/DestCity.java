package com.algorithm.contest.weeklycontest187;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DestCity {
    public static void main(String[] args) {
        DestCity d = new DestCity();
        List<List<String>> paths = new ArrayList<>();
        List<String> p = new ArrayList<>();
        p.add("A");
        p.add("Z");
        paths.add(p);
        System.out.println(d.destCity(paths));
    }
    public String destCity(List<List<String>> paths) {
        Map<String, String> mp = new HashMap<>();

        for (List<String> p : paths) {
            mp.put(p.get(0), p.get(1));
        }

        String s = paths.get(0).get(0);

        while (mp.containsKey(s)) {
            s = mp.get(s);
        }
        return s;
    }
}
