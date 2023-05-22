package com.algorithm.contest.weeklycontest167;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SequentialDigits {
    public static void main(String[] args) {
        SequentialDigits s = new SequentialDigits();
        List<Integer> res = s.sequentialDigits(100, 300);
        System.out.println(Arrays.toString(res.toArray()));
        List<Integer> res2 = s.sequentialDigits(1000, 13000);
        System.out.println(Arrays.toString(res2.toArray()));
    }
    public List<Integer> sequentialDigits(int low, int high) {
        int min = count(low), max = count(high);
        List<Integer> res = new ArrayList<>();
        for (int i = min; i <= max; i++) {
            int j = 1;
            while (j <= 10 - i) {
                int jj = j, num = 0, k = i;
                while (k > 0) {
                    num *= 10;
                    num += jj;
                    jj++;
                    k--;
                }
                if (num > high) {
                    break;
                }
                if (num <= high && num >= low) {
                    res.add(num);
                }
                j++;
            }
        }
        return res;
    }

    static int count(int num) {
        int cnt = 0;
        while (num > 0) {
            num /= 10;
            cnt++;
        }
        return cnt;
    }
}
