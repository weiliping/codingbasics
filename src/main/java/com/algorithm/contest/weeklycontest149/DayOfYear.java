package com.algorithm.contest.weeklycontest149;

public class DayOfYear {

    public static void main(String[] args) {
        System.out.println(dayOfYear("2019-01-09"));
        System.out.println(dayOfYear("2019-02-10"));
        System.out.println(dayOfYear("2003-03-01"));
        System.out.println(dayOfYear("2004-03-01"));
    }
    public static final int[] MTH_DAYS = new int[] { 0, 31, 59, 90, 120, 151, 181, 212, 243, 273, 304, 334 };
    public static int dayOfYear(String date) {
        String[] dts = date.split("-");
        int yr = Integer.parseInt(dts[0]);
        int mth = Integer.parseInt(dts[1]);
        int dt = Integer.parseInt(dts[2]);

        int dtInYear = MTH_DAYS[mth - 1] + dt;
        if (mth >= 3 && (yr % 4 == 0 && (yr % 100 != 0 || yr % 400 == 0))) {
            dtInYear++;
        }
        return dtInYear;
    }
}
