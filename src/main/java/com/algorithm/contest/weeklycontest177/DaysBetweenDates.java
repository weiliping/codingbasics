package com.algorithm.contest.weeklycontest177;

public class DaysBetweenDates {
    public static void main(String[] args) {
        DaysBetweenDates d = new DaysBetweenDates();
//        String date1 = "2019-06-29", date2 = "2019-06-30";
//        System.out.println(d.daysBetweenDates(date1, date2));
//
//        String date11 = "2020-01-15", date21 = "2019-12-31";
//        System.out.println(d.daysBetweenDates(date11, date21));

        String date12 = "1971-06-29", date22= "2010-09-23";

        System.out.println(d.daysBetweenDates(date12, date22));
//        String date13 = "1971-06-29", date23= "1973-01-01";
//        System.out.println(d.daysBetweenDates(date13, date23));
//        String date14 = "2010-01-01", date24= "2010-09-23";
//        System.out.println(d.daysBetweenDates(date14, date24));
    }
    static int[] months = new int[] {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    public int daysBetweenDates(String date1, String date2) {
        int[] dt1 = toDtArr(date1), dt2 = toDtArr(date2);
        if (dt1[0] == dt2[0]) {
            if (dt1[1] > dt2[1]) {
                return inOneYear(--dt2[1], dt2[2], --dt1[1], dt1[2], dt1[0]);
            } else {
                return inOneYear(--dt1[1], dt1[2], --dt2[1], dt2[2], dt1[0]);
            }
        }
        if (dt1[0] > dt2[0]) {
            return moreThanYears(dt1, dt2);
        }
        return moreThanYears(dt2, dt1);
    }

    static int inOneYear(int sMth, int sDt, int eMth, int eDt, int year) {
        if (sMth == eMth) {
            return  eDt > sDt ? eDt - sDt : sDt - eDt;
        }

        int cnt = 0;

        cnt += monthDay(sMth, year) - sDt + 1;
        while (++sMth < eMth) {
            cnt += monthDay(sMth, year);
        }
        cnt += eDt - 1;
        return cnt;
    }

    static int monthDay(int sMth, int year) {
        if (sMth != 1) {
            return months[sMth];
        }
        return isLeapYear(year) ? 29 : 28;
    }

    static int moreThanYears(int[] dt1, int[] dt2) {
        int cnt = 0, start = dt2[0] + 1;
        while (start < dt1[0]) {
            cnt += isLeapYear(start) ? 366 : 365;
            start++;
        }
        cnt += dt1[2] - 1;
        int m1 = dt1[1] - 2;
        while (m1 >= 0) {
            cnt += monthDay(m1, dt1[0]);
            m1--;
        }
        int mth = dt2[1];
        cnt += (monthDay(mth - 1, dt2[0]) - dt2[2] + 1);
        while (mth < 12) {
            cnt += monthDay(mth++, dt2[0]);
        }

        return cnt;
    }

    static int[] toDtArr(String date1) {
        String[] dts = date1.split("-");

        int[] ds = new int[3];
        ds[0] = Integer.parseInt(dts[0]);
        ds[1] = Integer.parseInt(dts[1]);
        ds[2] = Integer.parseInt(dts[2]);
        return ds;
    }

    static boolean isLeapYear(int year) {
        if (year % 4 == 0) {
            if (year % 100 == 0) {
                if (year % 400 == 0) {
                    return true;
                }
                return false;
            }
            return true;
        }
        return false;
    }
}
