package com.algorithm.cyclicsort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindFirstKMissingPositive {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(findFirstKMissingPositive(new int[] {3, -1, 4, 5, 5}, 3).toArray()));
        System.out.println(Arrays.toString(findFirstKMissingPositive(new int[] {2, 3, 4}, 3).toArray()));
    }

    public static List<Integer> findFirstKMissingPositive(int[] nums, int k) {
        List<Integer> res = new ArrayList<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                int t = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = t;
            }
        }

        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                res.add(i + 1);
            }
        }

        if (res.size() >= k) {
            return res.subList(0, k);
        }

        int i = 1;
        Arrays.sort(nums);
        while (res.size() < k) {
            int maxVal = res.get(res.size() - 1) + i;
            if (Arrays.binarySearch(nums, maxVal) < 0) {
                res.add(maxVal);
                i = 1;
                continue;
            }
            i++;
        }
        return res;
    }
}
