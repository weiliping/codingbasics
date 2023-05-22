package com.algorithm.contest.biweeklycontest82;

import java.util.Arrays;
import java.util.TreeSet;

public class LatestTimeCatchTheBus {

    public static void main(String[] args) {
//        int[] buses21 = new int[] {20};
//        int[] passengers21 = new int[] {7, 10, 18, 20};
//        int capacity21 = 4;
//        System.out.println(latestTimeCatchTheBusI(buses21, passengers21, capacity21));
//        int[] buses = new int[] {20, 30, 10};
//        int[] passengers = new int[] {19,13,26,4,25,11,21};
//        int capacity = 2;
//        System.out.println(latestTimeCatchTheBus(buses, passengers, capacity));
//        System.out.println(latestTimeCatchTheBusI(buses, passengers, capacity));
//
//        int[] buses1 = new int[] {10,20};
//        int[] passengers1 = new int[] {2,17,18,19};
//        int capacity1 = 2;
//        System.out.println(latestTimeCatchTheBus(buses1, passengers1, capacity1));
//        System.out.println(latestTimeCatchTheBusI(buses1, passengers1, capacity1));
//
//        int[] buses2 = new int[] {3};
//        int[] passengers2 = new int[] {2};
//        int capacity2 = 2;
//        System.out.println(latestTimeCatchTheBus(buses2, passengers2, capacity2));
//        System.out.println(latestTimeCatchTheBusI(buses2, passengers2, capacity2));
//
//        int[] buses3 = new int[] {3};
//        int[] passengers3 = new int[] {2};
//        int capacity3 = 1;
//        System.out.println(latestTimeCatchTheBus(buses3, passengers3, capacity3));
//        System.out.println(latestTimeCatchTheBusI(buses3, passengers3, capacity3));
//
//        int[] buses4 = new int[] {2};
//        int[] passengers4 = new int[] {2};
//        int capacity4 = 1;
//        System.out.println(latestTimeCatchTheBus(buses4, passengers4, capacity4));
//        System.out.println(latestTimeCatchTheBusI(buses4, passengers4, capacity4));
//
//        int[] buses5 = new int[] {18,8,3,12,9,2,7,13,20,5};
//        int[] passengers5 = new int[] {13,10,8,4,12,14,18,19,5,2,30,34};
//        int capacity5 = 1;
//        System.out.println(latestTimeCatchTheBus(buses5, passengers5, capacity5));
//        System.out.println(latestTimeCatchTheBusI(buses5, passengers5, capacity5));
//
//        int[] buses6 = new int[] {15,16,17,7,10,20,13,12};
//        int[] passengers6 = new int[] {18,15,11,17,12,13,14,10,19,16};
//        int capacity6 = 2;
//        System.out.println(latestTimeCatchTheBus(buses6, passengers6, capacity6));
//        System.out.println(latestTimeCatchTheBusI(buses6, passengers6, capacity6));
//
//        int[] buses7 = new int[] {6,8,18,17};
//        int[] passengers7 = new int[] {6,8,17};
//        int capacity7 = 1;
//        System.out.println(latestTimeCatchTheBus(buses7, passengers7, capacity7));
//        System.out.println(latestTimeCatchTheBusI(buses7, passengers7, capacity7));
//
//        int[] buses8 = new int[] {2241,1239,4280,5025,4354,1749,6310,7993,8163,9369,342,6387,9147,8985,3055,1406,42,8060,1583,5844,5553,119,8043,7836,4159,5512,9230,1220,1893,9411,8319,862,6689,7209,1305,8958,6658,8909,9351,9070,9586,7175,9251,7514,2850,6390,6355,1551,8513,843,8170,4831,6342,8849,2879,8937,2755,5890,7293,1737,4324,2034,7425,9785,1354,6476,3059,6526,8193,9537,2749,8541,5187,8219,369,8467,8140,8175,7287,2598,415,2306,1781,1555,3388,622,7574,4537,4833,1023,4841,7482,6518,4941,9758,7583,1341,5981,6687,6450};
//        int[] passengers8 = new int[] {8218,5861,7144,1315,9370,846,7541,6688,6348,3526,1343,8043,6326,8697,1738,8306,7292,9506,8537,2827,15,3310,1848,1668,8487,9785,3059,7480,5403,8165,6474,2384,8913,1914,9555,6197,4912,502,646,5837,5940,1366,3012,5074,4254,5545,4841,6520,9138,2877,1252,2755,9039,9359,4832,7185,8889,2653,7576,1512,7863,9712,2102,1239,329,1750,4787,2280,5012,7486,6662,411,6368,8098,6481,1557,8161,8449,1553,9349,9232,4284,24560,72,7276,8045,906,8942,7405,7710,8176,8172,6388,1135,6638,4325,356,9216,8959,4507,6406};
//        int capacity8 = 5;
//        System.out.println(latestTimeCatchTheBus(buses8, passengers8, capacity8));
//        System.out.println(latestTimeCatchTheBusI(buses8, passengers8, capacity8));
        int[] buses9 = new int[] {3};
        int[] passengers9 = new int[] {4};
        int capacity9 = 1;
        System.out.println(latestTimeCatchTheBus(buses9, passengers9, capacity9));
        System.out.println(latestTimeCatchTheBusI(buses9, passengers9, capacity9));
    }
    public static int latestTimeCatchTheBus(int[] buses, int[] passengers, int capacity) {
        Arrays.sort(buses);
        Arrays.sort(passengers);
        int i = 0, j = 0, m = buses.length - 1, n = passengers.length;
        while (i < m) {
            int k = capacity;
            while (k > 0 && j < n) {
                if (passengers[j] <= buses[i]) {
                    j++;
                    k--;
                } else {
                    break;
                }
            }
            i++;
        }
        if (j == n) {
            return buses[i];
        }
        int max = buses[i], sInt = passengers[j];
        if (capacity == 1 && n == 1) {
            return max >= sInt ? sInt - 1 : max;
        }
        int eInd = j + capacity - 1;
        if (eInd >= n) {
            eInd = n - 1;
        }
        if (max < sInt || (passengers[eInd] < max && capacity > eInd - j + 1)) {
            return max;
        }
        int k = eInd;
        while (passengers[k] > max) {
            k--;
        }
        if (k < eInd && passengers[k] != max) {
            return max;
        }
        while (k > 0) {
            if (passengers[k - 1] == passengers[k] - 1) {
                k--;
            } else {
                return passengers[k] - 1;
            }
        }
        return passengers[k] - 1;
    }
    public static int latestTimeCatchTheBusI(int[] buses, int[] passengers, int capacity) {
        Arrays.sort(buses);
        Arrays.sort(passengers);
        int i = 0, j = 0, m = buses.length - 1, n = passengers.length;
        while (i < m) {
            int k = capacity;
            while (k > 0 && j < n) {
                if (passengers[j] <= buses[i]) {
                    j++;
                    k--;
                } else {
                    break;
                }
            }
            i++;
        }
        if (j == n) {
            return buses[i];
        }
        int max = buses[m], k = j;
        TreeSet<Integer> s = new TreeSet<>();
        while (k < n && passengers[k] <= max) {
            if (s.size() == capacity) {
                break;
            }
            s.add(passengers[k++]);
        }

        if (s.size() == 0 || s.first() > max || (s.last() < max && s.size() < capacity)) {
            return max;
        }

        if (s.size() <= capacity) {
            int res = s.last();
            while (s.size() > 0) {
                res = s.pollLast();
                if (s.size() > 0 && !s.contains(res - 1)) {
                    return res - 1;
                }
            }
            res--;
            while (j > 0) {
                if (passengers[j - 1] == res) {
                    j--;
                    res--;
                } else {
                    break;
                }
            }
            return res;
        }
        return max;
    }
}
