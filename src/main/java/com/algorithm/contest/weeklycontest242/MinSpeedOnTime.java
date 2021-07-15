package com.algorithm.contest.weeklycontest242;

public class MinSpeedOnTime {

    public static void main(String[] args) {
        MinSpeedOnTime m = new MinSpeedOnTime();
//        System.out.println(m.minSpeedOnTime(new int[] {1, 3, 2}, 6));
//        System.out.println(m.minSpeedOnTime(new int[] {1, 3, 2}, 2.7));
//        System.out.println(m.minSpeedOnTime(new int[] {1, 3, 2}, 1.9));
        System.out.println(m.minSpeedOnTime(new int[] {1,1,100000}, 2.01));
    }
    public int minSpeedOnTime(int[] dist, double hour) {
        int n = dist.length;
        if (Double.valueOf(hour).intValue() < n - 1) {
            return -1;
        }

        int total = 0, maxSpeed = 0;
        for (int d : dist) {
            if (maxSpeed < d) {
                maxSpeed = d;
            }
            total += d;
        }
        int maxS = toInt(dist[n - 1] / (hour - n + 1));
        if (maxSpeed < maxS) {
            maxSpeed = maxS;
        }
        int minSpeed = toInt(total / hour);

        for (int s = minSpeed; s <= maxSpeed; s++) {
            double h = hour;
            for (int i = 0; i < n - 1; i++) {
                double t = (double) dist[i] / s;
                double l = t - (int) t;
                h -= (int) t;
                if (l > 0) {
                    h -= 1;
                }
            }
            double t = (double) dist[n - 1] / s;
            if (h >= t) {
                return s;
            }
        }
        return -1;
    }

    int toInt(double d) {
        if (d - (int) d > 0.0) {
            return (int) d + 1;
        }
        return (int) d;
    }
}
