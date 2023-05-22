package com.algorithm.contest.weeklycontest173;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class FilterRestaurants {

    public static void main(String[] args) {
        FilterRestaurants f = new FilterRestaurants();
        int restaurants[][] = new int[][]{{1,4,1,40,10},{2,8,0,50,5},{3,8,1,30,4},{4,10,0,10,3},{5,1,1,15,1}}, veganFriendly = 1, maxPrice = 50, maxDistance = 10;
        System.out.println(
                Arrays.toString(f.filterRestaurants(restaurants, veganFriendly, maxPrice, maxDistance).toArray()));
    }
    public List<Integer> filterRestaurants(int[][] restaurants, int veganFriendly, int maxPrice, int maxDistance) {
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[1] == b[1] ? b[0] - a[0] : b[1] - a[1]);
        for (int[] r : restaurants) {
            if (veganFriendly == 0 || r[2] == veganFriendly) {
                if (r[3] <= maxPrice  && r[4] <= maxDistance) {
                    queue.offer(new int[]{r[0], r[1]});
                }
            }
        }

        List<Integer> res = new ArrayList<>(queue.size());
        while (!queue.isEmpty()) {
            res.add(queue.poll()[0]);
        }
        return res;
    }
}
