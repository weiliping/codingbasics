package com.algorithm.contest.weeklycontest224;

public class MinimumBoxes {
    public static void main(String[] args) {
        System.out.println(minimumBoxes(10));
    }
    public static int minimumBoxes(int n) {
        int oldSum = 0;
        int oldTem = 0;
        int sum = 1;
        int tem = 1;
        for (int i = 2; sum <= n; i++) {
            oldTem = tem;
            tem += i;
            oldSum = sum;
            sum += tem;
        }

        int index = 0;
        int add = 0;
        for (int i = 0; i < tem; i++) {
            index = i;
            add += i;
            if (oldSum + add >= n) {
                break;
            }
        }
        return oldTem + index;
    }
}
