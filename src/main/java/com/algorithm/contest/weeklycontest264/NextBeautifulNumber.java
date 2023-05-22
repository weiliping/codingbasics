package com.algorithm.contest.weeklycontest264;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NextBeautifulNumber {
    static int[] nums = new int[]{1, 22, 122, 212, 221, 333, 1333, 3133, 3313, 3331, 4444, 14444, 22333, 23233, 23323, 23332, 32233, 32323, 32332, 33223, 33232, 33322, 41444, 44144, 44414, 44441, 55555, 122333, 123233, 123323, 123332, 132233, 132323, 132332, 133223, 133232, 133322, 155555, 212333, 213233, 213323, 213332, 221333, 223133, 223313, 223331, 224444, 231233, 231323, 231332, 232133, 232313, 232331, 233123, 233132, 233213, 233231, 233312, 233321, 242444, 244244, 244424, 244442, 312233, 312323, 312332, 313223, 313232, 313322, 321233, 321323, 321332, 322133, 322313, 322331, 323123, 323132, 323213, 323231, 323312, 323321, 331223, 331232, 331322, 332123, 332132, 332213, 332231, 332312, 332321, 333122, 333212, 333221, 422444, 424244, 424424, 424442, 442244, 442424, 442442, 444224, 444242, 444422, 515555, 551555, 555155, 555515, 555551, 666666, 1666666};
    public static void main(String[] args) {
//        for (int i = 0; i < 10000; i++) {
//            10461
//            System.out.println(nextBeautifulNumber(i));
//        }
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
//        dfs(new int[]{1, 2, 2, 3, 3, 3}, 0, 6, new ArrayList<>());
//        generateNums();
//        List<List<Integer>> res = new ArrayList<>();
//        dfs(new int[]{2, 2, 4, 4, 4}, 0, 5, res);
//        Arrays.sort(nums);
//        System.out.println(Arrays.toString(nums));
    }

    public static int nextBeautifulNumber(int n) {
        int i = 0, len = nums.length, j = len - 1;
        while (i <= j) {
            int m = i + ((j - i) >> 1);
            if (nums[m] > n) {
                if (m == 0 || nums[m - 1] <= n) {
                    return nums[m];
                }
                j = m - 1;
            } else {
                if (nums[m] == n && m != len - 1) {
                    return nums[m + 1];
                }
                i = m + 1;
            }
        }
        return 0;
    }

    public static List<Integer> generateNums() {
        for (int i = 2; i <= 6; i++) {
            int m = i / 2;
            if ((i & 1) == 0) {
                m--;
            }
            for (int j = m; j >= 0; j--) {
                int[] nums = new int[i];
                int l = 0;
                int num = 0;
                for (int k = j; k > 0; k--) {
                    nums[l++] = j;
                }
                for (int k = i - j; k > 0; k--) {
                    nums[l++] = i - j;
                }
                if (j != 0) {
                    dfs(nums, 0, i, new ArrayList<>());
                } else {
                    print(nums);
                }
            }
        }
        return null;
    }

    static void dfs(int[] nums, int s, int n, List<List<Integer>> res) {
        if (s == n) {
            print(nums);
            List<Integer> subRes = new ArrayList<>();
            for (int num : nums) {
                subRes.add(num);
            }
            res.add(subRes);
            return;
        }
        Set<Integer> uniqueSet = new HashSet<>();
        for (int i = s; i < n; i++) {
            if (uniqueSet.contains(nums[i])) {
                continue;
            }
            uniqueSet.add(nums[i]);
            swap(nums, s, i);
            dfs(nums, s + 1, n, res);
            swap(nums, i, s);
        }
    }
    static void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    static void print(int[] nums) {
        for (int n : nums) {
            System.out.print(n);
        }
        System.out.println();
    }
}

