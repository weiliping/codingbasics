package com.algorithm.contest.weeklycontest214;

import java.util.Map;
import java.util.TreeMap;

public class MaxProfit {

    public static void main(String[] args) {
        MaxProfit m = new MaxProfit();
        System.out.println(m.maxProfit(new int[] {2, 5}, 4));
        System.out.println(m.maxProfit(new int[] {3, 5}, 6));
        System.out.println(m.maxProfit(new int[] {2,8,4,10,6}, 20));
        System.out.println(m.maxProfit(new int[] {1000000000}, 1000000000));
        System.out.println(m.maxProfit(new int[] {565259708,715164401,716563713,958255469,844600740,823949511,180479359,287829385,164248818,73361150,230686692,322986846,598720034,338241127,748922260,181241085,833659853,509571179,250093451,690995620,703292727,595636202}, 650114768));
    }

    static final int MOD = (int) 1e9 + 7;
    public int maxProfit(int[] inventory, int orders) {
        TreeMap<Integer, Integer> mp = new TreeMap<>();
        for (int i : inventory) {
            mp.put(i, mp.getOrDefault(i, 0) + 1);
        }
        long sum = 0;
        while (!mp.isEmpty()) {
            Map.Entry<Integer, Integer> top = mp.pollLastEntry();
            int mk = top.getKey(), mv = top.getValue();
            if (mp.isEmpty()) {
                int order = orders / mv, left = orders % mv;
                if (order >= mk) {
                    sum += (multiple(mk + 1, mk) * mv) / 2;
                } else {
                    int time = mk - order;
                    sum += (multiple(mk + time + 1,  order) * mv) / 2  + multiple(time , left);
                }
                continue;
            }
            int lk = mp.lastKey();
            int totalMinus = mv * (mk - lk);
            if (totalMinus < orders) {
                orders -= totalMinus;
                sum += (multiple(mk + lk + 1, mk - lk) * mv) / 2;
                mp.put(lk, mp.get(lk) + mv);
                continue;
            }
            int order = orders / mv, left = orders % mv;
            int time = mk - order;
            sum += (multiple(mk + time + 1,  order) * mv) / 2 + multiple(time, left);
            break;
        }

        return (int)(sum % MOD);
    }

    static long multiple(int n1, int n2) {
        return (long) n1 * n2;
    }

    public int maxProfitII(int[] inventory, int orders) {
        int maxVal = 0;
        for (int i : inventory) {
            maxVal = Math.max(maxVal, i);
        }
        int lo = 0, hi = maxVal;
        long cnt = 0;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            long temp = 0;
            for (int i : inventory) {
                if (i > mid)
                    temp += i - mid;
            }
            if (temp > orders)
                lo = mid + 1;
            else {
                hi = mid;
                cnt = temp;
            }
        }
        long ans = 0;
        for (int i : inventory) {
            if(i > lo) {
                ans = (ans + 1L * (lo + 1 + i) * (i - lo) / 2 % MOD) % MOD;
            }
        }
        ans = (ans + ((orders - cnt) * lo) % MOD) % MOD;
        return (int) ans;
    }
}
