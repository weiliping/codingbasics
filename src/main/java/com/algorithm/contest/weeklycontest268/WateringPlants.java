package com.algorithm.contest.weeklycontest268;

public class WateringPlants {
    public static void main(String[] args) {
        System.out.println(wateringPlants(new int[] {2, 2, 3, 3}, 5));
        System.out.println(wateringPlants(new int[] {1,1,1,4,2,3}, 4));
        System.out.println(wateringPlants(new int[] {7,7,7,7,7,7,7}, 8));
    }
    public static int wateringPlants(int[] plants, int capacity) {
        int ans = 0, n = plants.length, cap = capacity;
        for (int i = 0; i < n; i++) {
            if (cap >= plants[i]) {
                ans += 1;
                cap -= plants[i];
                continue;
            }
            cap = capacity - plants[i];
            ans += 2 * i + 1;
        }
        return ans;
    }
}
