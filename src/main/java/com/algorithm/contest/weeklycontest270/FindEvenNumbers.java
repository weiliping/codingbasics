package com.algorithm.contest.weeklycontest270;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindEvenNumbers {
    public static void main(String[] args) {
        FindEvenNumbers f = new FindEvenNumbers();
        int[] nums = f.findEvenNumbers(new int[]{2, 1, 3, 0});
        System.out.println(Arrays.toString(nums));
        int[] nums2 = f.findEvenNumbers(new int[]{2, 2, 8, 8, 2});
        System.out.println(Arrays.toString(nums2));
        int[] nums3 = f.findEvenNumbers(new int[]{3, 7, 5});
        System.out.println(Arrays.toString(nums3));
        int[] nums4 = f.findEvenNumbers(new int[]{0, 2, 0, 0});
        System.out.println(Arrays.toString(nums4));
        int[] nums5 = f.findEvenNumbers(new int[]{0, 0, 0});
        System.out.println(Arrays.toString(nums5));
    }
    public int[] findEvenNumbers(int[] digits) {
        int[] nums = new int[10];
        for (int d : digits) {
            nums[d]++;
        }
        List<Integer> res = new ArrayList<>();
        dfs(nums, 0, res, 0);
        return res.stream().mapToInt(i -> i).toArray();
    }

    void dfs(int[] nums, int s, List<Integer> res, int num) {
        if (s == 3) {
            res.add(num);
            return;
        }

        for (int i = 0; i < 10; i++) {
            if (nums[i] == 0) {
                continue;
            }
            if ((s == 0 && i != 0) || s == 1 || s == 2 && (i & 1) == 0) {
                nums[i]--;
                dfs(nums, s + 1, res, num * 10 + i);
                nums[i]++;
            }
        }
    }
}
