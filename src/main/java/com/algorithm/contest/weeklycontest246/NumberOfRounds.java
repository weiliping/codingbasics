package com.algorithm.contest.weeklycontest246;

public class NumberOfRounds {
    public static void main(String[] args) {
        NumberOfRounds n = new NumberOfRounds();
        System.out.println(n.numberOfRounds("12:01", "12:44"));
        System.out.println(n.numberOfRounds("20:00", "06:00"));
        System.out.println(n.numberOfRounds("00:00", "23:59"));
        System.out.println(n.numberOfRounds("23:46", "00:01"));
    }

    public int numberOfRounds(String startTime, String finishTime) {
        return numOfRounds(toIntegers(startTime), toIntegers(finishTime));
    }

    public static int[] toIntegers(String ts) {
        String[] times = ts.split(":");
        return new int[] {Integer.valueOf(times[0]), Integer.valueOf(times[1])};
    }

    public static int numOfRounds(int[] startTime, int[] endTime) {
        if (startTime[0] > endTime[0] || (startTime[0] == endTime[0] && startTime[1] > endTime[1])) {
            return numOfRounds(startTime, new int[] {24, 0}) + numOfRounds(new int[] {0, 0}, endTime);
        }
        int t1 = startTime[0] * 4 + toStartMin(startTime[1]);
        int t2 = endTime[0] * 4 + rounds(endTime[1]);
        return t2 < t1 ? 0 : (t2 - t1);
    }

    public static int toStartMin(int min) {
        if (min == 0) {
            return 0;
        }
        if (min <= 15) {
            return 1;
        }
        if (min <= 30) {
            return 2;
        }
        if (min <= 45) {
            return 3;
        }
        if (min < 60) {
            return 4;
        }
        return 0;
    }

    public static int rounds(int min) {
        if (min < 15) {
            return 0;
        }
        if (min < 30) {
            return 1;
        }
        if (min < 45) {
            return 2;
        }
        if (min < 60) {
            return 3;
        }
        return 0;
    }
}
