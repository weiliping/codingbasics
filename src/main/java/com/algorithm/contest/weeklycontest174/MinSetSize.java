package com.algorithm.contest.weeklycontest174;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MinSetSize {
    public static void main(String[] args) {
        MinSetSize m = new MinSetSize();
        System.out.println(m.minSetSize(new int[] { 3, 3, 3, 3, 5, 5, 5, 2, 2, 7 }));
        System.out.println(m.minSetSize(new int[] { 7,7,7,7,7,7 }));
        System.out.println(m.minSetSize(new int[] { 1,9 }));
        System.out.println(m.minSetSize(new int[] { 1000,1000,3,7 }));
        System.out.println(m.minSetSize(new int[] { 1,2,3,4,5,6,7,8,9,10 }));
    }

    public int minSetSize(int[] arr) {
        int n = arr.length, h = (n >> 1);
        List<int[]> nums = new ArrayList<>();
        Map<Integer, Integer> inds = new HashMap<>();

        for (int num : arr) {
            int ind;
            if (!inds.containsKey(num)) {
                inds.put(num, nums.size());
                ind = nums.size();
                nums.add(ind, new int[] { num, 1 });
                continue;
            }
            ind = inds.get(num);
            int[] cnt = nums.get(ind);
            cnt[1]++;
            nums.set(ind, cnt);
        }

        Collections.sort(nums, (a, b) -> a[1] == b[1] ? b[0] - a[0] : a[1] - b[1]);

        int cnt = 0;
        for (int i = nums.size() - 1; i >= 0; i--) {
            if (h <= nums.get(i)[1]) {
                cnt++;
                return cnt;
            }
            h -= nums.get(i)[1];
            cnt++;
        }
        return cnt;
    }
}
