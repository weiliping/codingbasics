package com.algorithm.contest.biweeklycontest52;

import java.util.Arrays;

public class MemLeak {
    public static void main(String[] args) {
        MemLeak m = new MemLeak();
        System.out.println(Arrays.toString(m.memLeak(2, 2)));
        System.out.println(Arrays.toString(m.memLeak(8, 11)));
    }

    public int[] memLeak(int memory1, int memory2) {
        int i = 1;
        while (true) {
            if (memory2 > memory1) {
                if (i > memory2) {
                    return new int[] { i, memory1, memory2 };
                }
                memory2 -= i;
            } else {
                if (i > memory1) {
                    return new int[] { i, memory1, memory2 };
                }
                memory1 -= i;
            }
            i++;
        }
    }
}
