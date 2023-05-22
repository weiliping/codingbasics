package com.algorithm.contest.weeklycontest168;

public class FindNumbers {
    public static void main(String[] args) {
        FindNumbers f = new FindNumbers();
        System.out.println(f.findNumbers(new int[] { 555, 901, 482, 1771 }));
    }
    public int findNumbers(int[] nums) {
        int cnt = 0;
        for (int num : nums) {
            if (num >= 10 && num <= 99) {
                cnt++;
                continue;
            }
            if (num >= 1000 && num <= 9999) {
                cnt++;
                continue;
            }
            if (num == 100000) {
                cnt++;
            }
        }
        return cnt;
    }
}
