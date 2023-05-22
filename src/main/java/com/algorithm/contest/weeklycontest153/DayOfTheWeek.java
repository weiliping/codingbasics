package com.algorithm.contest.weeklycontest153;

public class DayOfTheWeek {
    public static void main(String[] args) {
//        System.out.println(dayOfTheWeek(31, 8, 2019));
//        System.out.println(dayOfTheWeek(18, 7, 1999));
//        System.out.println(dayOfTheWeek(15, 8, 1993));
        System.out.println(dayOfTheWeek(28, 2, 2100));

    }
    private static String[] WEEKS = new String[] {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
    private static int[] monthDays = new int[] {0, 31, 59, 90, 120, 151, 181, 212, 243, 273, 304, 334};
    public static String dayOfTheWeek(int day, int month, int year) {
        int i = 5;
        int dy = year - 1971;
        if (dy >= 2) {
            i++;
            i += (dy - 2) / 4;
        }
        i = ((365 * dy + i) % 7) - 1;
        i += monthDays[month - 1];
        if (month >= 3) {
            if (year != 2100 && year % 4 == 0) {
                i++;
            }
        }
        i += day;
        return WEEKS[i % 7];
    }
}
