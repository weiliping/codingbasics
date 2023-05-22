package com.algorithm.contest.weeklycontest182;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UndergroundSystem {
    HashMap<String, Map<String, List<Integer>>> stations;
    HashMap<Integer, Ele> userInfo;
    public UndergroundSystem() {
        stations = new HashMap<>();
        userInfo = new HashMap<>();
    }

    public void checkIn(int id, String stationName, int t) {
        userInfo.put(id, new Ele(stationName, t));
    }

    public void checkOut(int id, String stationName, int t) {
        Ele checkIn = userInfo.get(id);
        Map<String, List<Integer>> container = stations.getOrDefault(checkIn.station, new HashMap<>());
        List<Integer> times = container.getOrDefault(stationName, new ArrayList<>());
        times.add(t - checkIn.time);
        container.put(stationName, times);
        stations.put(checkIn.station, container);
    }

    public double getAverageTime(String startStation, String endStation) {
        Map<String, List<Integer>> container = stations.get(startStation);
        List<Integer> times = container.get(endStation);

        int sum = 0, n = times.size();
        for (Integer t : times) {
            sum += t;
        }
        return (double) sum / n;
    }

    class Ele {
        String station;
        int time;
        public Ele(String station, int time) {
            this.station = station;
            this.time = time;
        }
    }
}
