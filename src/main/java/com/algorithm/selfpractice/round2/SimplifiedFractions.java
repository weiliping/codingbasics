package com.algorithm.selfpractice.round2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SimplifiedFractions {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(simplifiedFractions(0).toArray()));
        System.out.println(Arrays.toString(simplifiedFractions(1).toArray()));
        System.out.println(Arrays.toString(simplifiedFractions(2).toArray()));
        System.out.println(Arrays.toString(simplifiedFractions(3).toArray()));
        System.out.println(Arrays.toString(simplifiedFractions(4).toArray()));
        System.out.println(Arrays.toString(simplifiedFractions(5).toArray()));
    }

    static List<String> simplifiedFractions(int n) {
        if (n <= 1) {
            return new ArrayList<>();
        }
        List<String> subRes = simplifiedFractions(n - 1);
        return getCurrentFractions(n, subRes);
    }

    static List<String> getCurrentFractions(int n, List<String> res) {
        for (int i = 1; i < n; i++) {
            String f = toFraction(i, n);
            if (res.contains(f)) {
                continue;
            }
            res.add(f);
        }
        return res;
    }

    static String toFraction(int s, int n) {
        if (s == 1) {
            return String.valueOf(s + "/" + n);
        }
        int gcd = gcd(s, n);
        if (gcd == 1) {
            return String.valueOf(s + "/" + n);
        }
        return String.valueOf(s/gcd + "/" + n/gcd);
    }

    static int gcd(int m, int n) {
        if (n == 0) {
            return m;
        }
        return gcd(n, m%n);
    }
}
