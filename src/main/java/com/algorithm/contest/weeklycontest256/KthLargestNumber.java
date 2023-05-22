package com.algorithm.contest.weeklycontest256;

import java.util.Arrays;
import java.util.Comparator;

public class KthLargestNumber {

    public static void main(String[] args) {
        System.out.println(kthLargestNumber(new String[] {"3","6","7","10"}, 4));
        System.out.println(kthLargestNumber(new String[] {"2","21","12","1"}, 3));
        System.out.println(kthLargestNumber(new String[] {"0", "0"}, 2));
        System.out.println(kthLargestNumber(args[0].split(","), 6498));
    }

    public static String kthLargestNumber(String[] nums, int k) {
        Arrays.sort(nums, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() != o2.length()) {
                    return o1.length() > o2.length() ? 1 : -1;
                }
                return o1.compareTo(o2);
            }
        });

        return nums[nums.length - k];
    }
}
