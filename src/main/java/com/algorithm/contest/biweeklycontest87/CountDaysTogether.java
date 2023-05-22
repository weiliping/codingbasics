package com.algorithm.contest.biweeklycontest87;

public class CountDaysTogether {

    public static final int[] MTH_DAYS = new int[] { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

    public static void main(String[] args) {
        // String arriveAlice = "08-15", leaveAlice = "08-18", arriveBob = "08-16",
        // leaveBob = "08-19";
        // System.out.println(countDaysTogether(arriveAlice, leaveAlice, arriveBob,
        // leaveBob));
        String arriveAlice4 = "08-15", leaveAlice4 = "08-18", arriveBob4 = "08-16", leaveBob4 = "08-16";
        System.out.println(countDaysTogether(arriveAlice4, leaveAlice4, arriveBob4, leaveBob4));

        // String arriveAlice2 = "10-01", leaveAlice2 = "10-31", arriveBob2 = "11-01",
        // leaveBob2 = "12-31";
        // System.out.println(countDaysTogether(arriveAlice2, leaveAlice2, arriveBob2,
        // leaveBob2));

        // String arriveAlice3 = "07-01", leaveAlice3 = "11-30", arriveBob3 = "09-03",
        // leaveBob3 = "12-31";
        // System.out.println(countDaysTogether(arriveAlice3, leaveAlice3, arriveBob3,
        // leaveBob3));

    }

    public static int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        int[] a1 = getDayNum(arriveAlice);
        int[] l1 = getDayNum(leaveAlice);
        int[] a2 = getDayNum(arriveBob);
        int[] l2 = getDayNum(leaveBob);

        int[] arrR = getBigger(a1, a2, true);
        int[] arrL = getBigger(l1, l2, false);

        if (arrR[0] > arrL[0]) {
            return 0;
        }
        if (arrR[0] == arrL[0] && arrR[1] > arrL[1]) {
            return 0;
        }
        int days = 0;

        int k = arrR[0];
        while (k < arrL[0]) {
            days += MTH_DAYS[k];
            k++;
        }
        days += arrL[1] - arrR[1] + 1;
        return days;
    }

    public static int[] getBigger(int[] a, int[] b, boolean isBigger) {
        if (a[0] > b[0]) {
            return isBigger ? a : b;
        }
        if (a[0] == b[0] && a[1] >= b[1]) {
            return isBigger ? a : b;
        }
        return isBigger ? b : a;
    }

    public static int[] getDayNum(String mthDateStr) {
        return new int[] { Integer.parseInt(mthDateStr.substring(0, 2)), Integer.parseInt(mthDateStr.substring(3)) };
    }
}
