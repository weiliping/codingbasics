package com.algorithm.binarysearch;

import java.math.BigDecimal;

public class Sqrt {

    public static void main(String[] args) {
        System.out.println(getSqureRoot(20, 0.0000001));
    }

    public static int sqrt(int n) {
        if (n <= 1) {
            return n;
        }

        int l = 0, r = n;
        while (l < r) {
            int m = l + (r - l) / 2;

            if (n / m >= m) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        return r - 1;
    }

    public static double squareRoot(int a) {
        double x = 0, l = 0, r = a;

        while (l <= r) {
            x = l + (r - l) / 2;
            if (x > a/x) {
                r = x - 0.000001;
            }
            if (x < a/x) {
                l = x + 0.000001;
            }
            if (x == a/x) {
                return x + 0.000001;
            }
        }
        return new BigDecimal(x).setScale(6, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    public static double getSqureRoot(int n, double deltaThreshold) {
        double low = 1.0;
        double high = (double) n;
        while (low <= high) {
            double mid = low + ((high - low) / 2);
            double square = mid * mid;
            double delta = Math.abs(square / n - 1);
            if (delta < deltaThreshold) {
                return mid;
            } else if (square < n) {
                low = mid;
            } else {
                high = mid;
            }
        }
        return -1.0;
    }
}
