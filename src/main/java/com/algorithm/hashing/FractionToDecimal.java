package com.algorithm.hashing;

import java.util.HashMap;

public class FractionToDecimal {
    /**
     * https://leetcode-cn.com/problems/fraction-to-recurring-decimal
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(fractionToDecimalII(12, 99));
    }

    public static String fractionToDecimalII(int n, int m) {
        if (n == 0) {
            return "0";
        }

        if (m == 0) {
            return null;
        }

        StringBuilder res = new StringBuilder();
        res.append((n < 0 ^ m < 0) ? "-" : "");

        long a = Math.abs((long) n);
        long b = Math.abs((long) m);

        long num = a / b;
        res.append(num);

        long rem = a % b;
        if (rem == 0) {
            return res.toString();
        }
        res.append(".");

        HashMap<Long, Integer> tMap = new HashMap<>();
        tMap.put(rem, res.length());
        while (rem != 0) {
            rem *= 10;
            res.append(rem / b);
            rem %= b;
            if (tMap.containsKey(rem)) {
                res.insert(tMap.get(rem), "(");
                res.append(")");
                break;
            } else {
                tMap.put(rem, res.length());
            }
        }
        return res.toString();
    }
}
