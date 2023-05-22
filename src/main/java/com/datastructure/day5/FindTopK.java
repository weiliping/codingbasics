package com.datastructure.day5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class FindTopK {
    public static void main(String[] args) {
        int[] nums = new int[] {3, 2, 9, 7, 4, 5, 1, 0, 6, 8};
        System.out.println(Arrays.toString(findTopK(nums, 3).toArray()));
    }

    public static List<Integer> findTopK(int[] nums, int k) {
        List<Integer> res = new ArrayList<>();

        if (nums == null || nums.length == 0) {
            return res;
        }

        if (nums.length <= k) {
            for (int num : nums) {
                res.add(num);
            }
            return res;
        }

        PriorityQueue<Integer> queue = new PriorityQueue<>((x, y) -> x > y ? -1 : x == y ? 0 : 1);
        int cnt = 0;
        for (int num : nums) {
            if (cnt < k) {
                queue.add(num);
            } else if (queue.peek() > num){
                queue.poll();
                queue.add(num);
            }
            cnt++;
        }

        for (int num : queue) {
            res.add(num);
        }
        return res;
    }
}
