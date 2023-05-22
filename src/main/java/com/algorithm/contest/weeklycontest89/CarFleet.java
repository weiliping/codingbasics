package com.algorithm.contest.weeklycontest89;

import java.util.Arrays;

public class CarFleet {
    public static void main(String[] args) {
        // int t = 12, p[] = new int[] { 10, 8, 0, 5, 3 }, s[] = new int[] { 2, 4, 1, 1,
        // 3 };
        // System.out.println(carFleet(t, p, s));

        int t1 = 10, p1[] = new int[] { 6, 8 }, s1[] = new int[] { 3, 2 };
        System.out.println(carFleet(t1, p1, s1));
    }

    public static int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        Car[] cars = new Car[n];
        for (int i = 0; i < n; i++) {
            int d = target - position[i];
            cars[i] = new Car(position[i], (double) d / speed[i]);
        }
        Arrays.sort(cars, (a, b) -> a.p - b.p);
        int cnt = 0, j = n - 1;
        for (; j > 0; j--) {
            if (cars[j].t < cars[j - 1].t) {
                cnt++;
            } else {
                cars[j - 1] = cars[j];
            }
        }
        return cnt + (j == 0 ? 1 : 0);
    }

    static class Car {
        int p;
        double t;

        public Car(int p, double t) {
            this.p = p;
            this.t = t;
        }
    }
}
