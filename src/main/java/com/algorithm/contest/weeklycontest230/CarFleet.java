package com.algorithm.contest.weeklycontest230;

import java.util.Arrays;

public class CarFleet {
    /**
     * #853
     * @param args
     */
    public static void main(String[] args) {
        int[] p = new int[] { 10, 8, 0, 5, 3 };
        int[] s = new int[] { 2, 4, 1, 1, 3 };
        int target = 12;
        System.out.println(countCarGroup(target, p, s));
    }

    public static int countCarGroup(int target, int[] position, int[] speed) {
        int cnt = 0, n = position.length;
        if (position.length == 1) {
            return 1;
        }
        Car[] cars = new Car[n];
        for (int i = 0; i < n; i++) {
            cars[i] = new Car(position[i], calcTime(new int[] { position[i], speed[i] }, target));
        }
        Arrays.sort(cars, (a, b) -> b.p - a.p);
        for (int i = 0; i < n; i++) {
            Car car = cars[i];
            if (car == null) {
                continue;
            }
            for (int j = i + 1; j < n; j++) {
                if (cars[j] != null && car.t >= cars[j].t) {
                    cars[j] = null;
                }
            }
            cnt++;
        }
        return cnt;
    }

    static double calcTime(int[] car, int target) {
        return (double) (target - car[0]) / car[1];
    }
}

class Car {
    int p;
    double t;

    public Car(int pos, double time) {
        p = pos;
        t = time;
    }
}
