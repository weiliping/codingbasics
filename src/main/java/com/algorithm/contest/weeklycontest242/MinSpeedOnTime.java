package com.algorithm.contest.weeklycontest242;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class MinSpeedOnTime {

    public static void main(String[] args) {
        MinSpeedOnTime m = new MinSpeedOnTime();
//        System.out.println(m.minSpeedOnTime(new int[] {1, 3, 2}, 6));
//        System.out.println(m.minSpeedOnTime(new int[] {1, 3, 2}, 2.7));
//        System.out.println(m.minSpeedOnTime(new int[] {1, 3, 2}, 1.9));
        System.out.println(m.minSpeedOnTimeI(new int[] {1,1,100000}, 2.01));
        System.out.println(m.minSpeedOnTimeI(new int[] { 2, 1, 5, 4, 4, 3, 2, 9, 2, 10 }, 75.12));
    }

    public int minSpeedOnTimeI(int[] dist, double hour) {
        int n = dist.length;
        long h = Math.round(hour * 100);
        if (h <= (n - 1) * 100) {
            return -1;
        }
        int l = 1;
        int r = (int)1e7;
        while (l < r) {
            int speed = l + (r - l) / 2;
            long t = 0;
            for (int i = 0; i < n - 1; i++) {
                t += (dist[i] - 1) / speed + 1;
            }
            t *= speed;
            t += dist[n - 1];

            if (t * 100 <= h * speed) {
                r = speed;
            } else {
                l = speed + 1;
            }
        }
        return l;
    }

    public int minSpeedOnTime(int[] dist, double hour) {
        int n = dist.length;
        if (Double.valueOf(hour).intValue() < n - 1) {
            return -1;
        }
        int maxSpeed = 0;
        for (int d : dist) {
            if (maxSpeed < d) {
                maxSpeed = d;
            }
        }
        int scale = BigDecimal.valueOf(hour).scale();
        double lastTime = decimalPart(hour);

        if (lastTime > 0.0) {
            int lastSpeed = toInt(dist[n - 1] / lastTime);
            if (maxSpeed < lastSpeed) {
                maxSpeed = lastSpeed;
                for (int k = 0; k < n - 1; k++) {
                    lastTime += toInt((double) dist[k] / maxSpeed);
                }
                if (lastTime == hour) {
                    return maxSpeed;
                }
            }
        }

        int i = 1, j = maxSpeed;
        while (i <= j) {
            int speed = i + ((j - i) >> 1);

            double h = 0.0;
            for (int k = 0; k < n - 1; k++) {
                h += toInt((double) dist[k] / speed);
            }
            h += format(dist[n - 1], speed, scale);
            if (h == hour) {
                return speed;
            }
            if (h > hour) {
                i = speed + 1;
                continue;
            }
            j = speed - 1;
        }
        return -1;
    }

    int toInt(double d) {
        if (d - (int) d > 0.0) {
            return (int) d + 1;
        }
        return (int) d;
    }

    double format(int i, int s, int scale) {
        double r = (double) i / s;
        return BigDecimal.valueOf(r).setScale(scale, RoundingMode.HALF_UP).doubleValue();
    }

    double decimalPart(double h) {
        BigDecimal bigDecimal = new BigDecimal(String.valueOf(h));
        int intValue = bigDecimal.intValue();
        return bigDecimal.subtract(new BigDecimal(intValue)).doubleValue();
    }
}
