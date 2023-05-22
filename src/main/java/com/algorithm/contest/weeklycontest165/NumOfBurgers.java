package com.algorithm.contest.weeklycontest165;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NumOfBurgers {

    public static void main(String[] args) {
        int t = 16, c = 7;
        System.out.println(Arrays.toString(numOfBurgers(t, c).toArray()));
        int t1 = 17, c1 = 4;
        System.out.println(Arrays.toString(numOfBurgers(t1, c1).toArray()));
        int t2 = 4, c2 = 17;
        System.out.println(Arrays.toString(numOfBurgers(t2, c2).toArray()));
        int t3 = 0, c3 = 0;
        System.out.println(Arrays.toString(numOfBurgers(t3, c3).toArray()));
        int t4 = 2, c4 = 1;
        System.out.println(Arrays.toString(numOfBurgers(t4, c4).toArray()));
    }

    public static List<Integer> numOfBurgers(int tomatoSlices, int cheeseSlices) {
        if (tomatoSlices == 0 && cheeseSlices == 0) {
            return Arrays.asList(new Integer[] { 0, 0 });
        }
        if (tomatoSlices % 2 != 0 ) {
            return new ArrayList<>();
        }

        int a = tomatoSlices / 2 - cheeseSlices;
        int b = 2 * cheeseSlices - tomatoSlices / 2;
        if (a < 0 || b < 0) {
            return new ArrayList<>();
        }
        return Arrays.asList(new Integer[] { a, b });
    }
}
