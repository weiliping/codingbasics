package com.algorithm.contest.weeklycontest222;

import java.util.HashMap;
import java.util.Map;

public class CountPairs {
    static final int MOD = (int)1e9 + 7;

    public static void main(String[] args) {
//        System.out.println(countPairs(new int[] {1, 3, 5, 7, 9}));
//        System.out.println(countPairs(new int[] { 64,64,64,64,64,64,64,64,64,64,64,64,64,64,64,64,64,64,64,64,64,64,64,64,64,64,64,64,64,64,64,64,64 }));
        System.out.println(countPairsI(new int[] { 2160,1936,3,29,27,5,2503,1593,2,0,16,0,3860,28908,6,2,15,49,6246,1946,23,105,7996,196,0,2,55,457,5,3,924,7268,16,48,4,0,12,116,2628,1468 }));
    }

    public static int countPairsI(int[] deliciousness) {
        Map<Integer, Integer> map = new HashMap<>();
        int answer = 0;
        for (int num : deliciousness) {
            int powerOfTwo = 1;
            for (int i = 0; i <= 21; i++) {
                if (powerOfTwo >= num && map.containsKey(powerOfTwo - num)) {
                    answer += map.get(powerOfTwo - num);
                    answer %= MOD;
                }
                powerOfTwo <<= 1;
            }
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        return (int) answer;
    }

    public static int countPairs(int[] deliciousness) {
        long cnt = 0;
        HashMap<Integer, Integer> h = new HashMap<>();
        for (int i : deliciousness) {
            h.put(i, h.getOrDefault(i, 0) + 1);
        }

        Object[] k = h.keySet().toArray();
        int n = k.length;
        for (int i = 0; i < n; i++) {
            Integer k1 = (Integer)k[i];
            Integer v1 = h.get(k1);
            if (v1 > 1 && k1 != 0 && (k1 & (k1 - 1)) == 0) {
                cnt += v1 * (v1 - 1) / 2;
            }
            for (int j = i + 1; j < n; j++) {
                Integer k2 = (Integer)k[j];
                Integer v2 = h.get(k2);
                int s = k1 + k2;
                if ((s & (s - 1)) == 0) {
                    cnt += v1 * v2;
                }
            }
        }

        return (int)cnt % MOD;
    }
}
