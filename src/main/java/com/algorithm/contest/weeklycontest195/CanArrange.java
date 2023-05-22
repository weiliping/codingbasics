package com.algorithm.contest.weeklycontest195;

import java.util.TreeMap;

public class CanArrange {
    public static void main(String[] args) {
        int[] arr = new int[] { 1, 2, 3, 4, 5, 10, 6, 7, 8, 9 };
        int k = 5;
        System.out.println(isSplit(arr, k));

        int[] arr1 = new int[] {1,2,3,4,5,6};
        int k1 = 7;
        System.out.println(isSplit(arr1, k1));
        int[] arr2 = new int[] {1,2,3,4,5,6};
        int k2 = 10;
        System.out.println(isSplit(arr2, k2));
        int[] arr3 = new int[] {-10,10};
        int k3 = 2;
        System.out.println(isSplit(arr3, k3));

        int[] arr4 = new int[] {-1,1,-2,2,-3,3,-4,4};
        int k4 = 3;
        System.out.println(isSplit(arr4, k4));

        int[] arr5 = new int[] {3,8,17,2,5,6};
        int k5 = 10;
        System.out.println(isSplit(arr5, k5));

        int[] arr6 = new int[] {-10,5,0,-5,7,-5,7,9,5,-2,10,7,-6,-3,4,-6,10,-1,-6,14,0,6,-4,4,-2,-4,5,4,0,-8,-6,10,-8,-4,14,10,7,7,6,-1,-10,-8,22,9,10,8,-2,8,-10,3,18,1,11,8,7,-4,2,-10,0,-8,16,13,-9,7,17,1,1,-5,10,5,0,0,-5,-7,4,0,6,14,-8,13,5,4,1,5,10,4,9,2,6,8};
        int k6 = 14;
        System.out.println(isSplit(arr6, k6));
    }

    public static boolean isSplit(int[] arr, int k) {
        TreeMap<Integer, Integer> mp = new TreeMap<>();
        for (int num : arr) {
            int key = num % k;
            mp.put(key, mp.getOrDefault(key, 0) + 1);
        }
        int len = arr.length / 2;
        while (!mp.isEmpty() && len > 0) {
            int key = mp.firstKey();
            int v = mp.get(key);
            if (key == 0) {
                if (v % 2 == 1) {
                    return false;
                }
                len -= v / 2;
                mp.remove(key);
                continue;
            }

            int k1 = ((key < 0 ? -k : k) - key), k2 = -key;
            if (k1 == key) {
                int l = v % 2;
                if (l == 0) {
                    len -= v / 2;
                    mp.remove(key);
                    continue;
                }

                int pv = mp.getOrDefault(k2, 0);
                if (l > pv) {
                    return false;
                }
                len -= l;
                mp.remove(key);
                if (pv == l) {
                    mp.remove(k2);
                } else {
                    mp.put(k2, pv - 1);
                }
                continue;
            }
            if (mp.containsKey(k1)) {
                int p1 = mp.get(k1);
                if (v <= p1) {
                    len -= v;
                    mp.remove(key);
                    if (p1 == v) {
                        mp.remove(k1);
                    } else {
                        mp.put(k1, p1 - v);
                    }
                    continue;
                }
                len -= p1;
                v -= p1;
                mp.remove(k1);
            }
            int p2 = mp.getOrDefault(k2, 0);
            if (v > p2) {
                return false;
            }
            len -= v;
            mp.remove(key);
            if (v == p2) {
                mp.remove(k2);
                continue;
            }
            mp.put(k2, p2 - v);
        }
        return len == 0;
    }
}
