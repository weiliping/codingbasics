package com.algorithm.contest.weeklycontest217;

import java.util.ArrayDeque;
import java.util.Arrays;

public class MostCompetitive {
    public static void main(String[] args) {
        MostCompetitive m = new MostCompetitive();
        int[] nums = new int[] {3, 5, 2, 6};
        System.out.println(Arrays.toString(m.mostCompetitive(nums, 2)));

        int[] nums2 = new int[] {2,4,3,3,5,4,9,6};
        System.out.println(Arrays.toString(m.mostCompetitive(nums2, 4)));
        int[] nums3 =
                new int[] { 84, 10, 71, 23, 66, 61, 62, 64, 34, 41, 80, 25, 91, 43, 4, 75, 65, 13, 37, 41, 46, 90, 55,
                        8, 85, 61, 95, 71 };
        System.out.println(Arrays.toString(m.mostCompetitive(nums3, 24)));
    }

//    static void dfs(int[] nums, int s, int k, int n, List<Integer> out, List<Integer>[] res) {
//        if (out.size() == k) {
//            if (res[0].size() == 0) {
//                res[0] = new ArrayList<>(out);
//                return;
//            }
//            for (int i = 0; i < k; i++) {
//                if (res[0].get(i) > out.get(i)) {
//                    res[0] = new ArrayList<>(out);
//                    break;
//                }
//            }
//            return;
//        }
//        for (int i = s; i < n; i++) {
//            out.add(nums[i]);
//            dfs(nums, i + 1, k, n, out, res);
//            out.remove(out.size() - 1);
//        }
//    }
//    public int[] mostCompetitive(int[] nums, int k) {
//        List<Integer>[] res = new ArrayList[1];
//        res[0] = new ArrayList<>();
//        dfs(nums, 0, k, nums.length, new ArrayList<>(), res);
//        int[] cnts = new int[k];
//        List<Integer> curr = res[0];
//        for (int i = 0; i < k; i++) {
//            cnts[i] = curr.get(i);
//        }
//        return cnts;
//    }

    public int[] mostCompetitive(int[] nums, int k) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        stack.push(nums[0]);
        int i = 1, n = nums.length;
        while (i < n) {
            int l = n - i;
            while (l + stack.size() > k) {
                if (!stack.isEmpty() && stack.peek() > nums[i]) {
                    stack.pop();
                    continue;
                }
                break;
            }
            if (stack.size() < k) {
                stack.push(nums[i]);
            }
            i++;
        }

        int res[] = new int[k];
        for (int j = k - 1; j >= 0; j--) {
            res[j] = stack.pop();
        }
        return res;
    }
}
