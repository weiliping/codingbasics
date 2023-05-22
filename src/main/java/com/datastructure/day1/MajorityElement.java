package com.datastructure.day1;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class MajorityElement {

    public static void main(String args[]) {
        // System.out.println(majorityElement(new int[] {5, 5, 5, 6, 6, 6, 6}));

        // System.out.println(firstMissingPositive(new int[] {1, 2, 0}));
        // System.out.println(firstMissingPositive(new int[] {3, 4, -1, 1}));
        // System.out.println(firstMissingPositive(new int[] {7, 8, 9, 11, 12}));
        // List<List<Integer>> res = threeSum(new int[]{-1, 0, 1, 2, -1, -4});
        // for (List<Integer> r : res) {
        // System.out.println(Arrays.toString(r.toArray()));
        // }
        // List<List<Integer>> res = permute(new int[] {1, 2, 3});
        // for (List<Integer> r : res) {
        // System.out.println(Arrays.toString(r.toArray()));
        // }
        // System.out.println(fib(5));
        // System.out.println(fibDq(5));
        System.out.println(isValid("()"));
        System.out.println(isValid("()[]{}"));
        System.out.println(isValid("(]"));
    }

    public static int majorityElementMoore(int a[]) {
        int res = 0, cnt = 0, n = a.length;

        for (int i = 0; i < n; i++) {
            if (cnt == 0) {
                res = a[i];
            } else {
                if (res == a[i]) {
                    cnt++;
                } else {
                    cnt--;
                }
            }
        }
        return res;
    }

    public static int majorityElement(int a[]) {
        if (a == null) {
            return 0;
        }

        int max = Integer.MIN_VALUE;
        for (int n : a) {
            if (n > max) {
                max = n;
            }
        }

        int maxI = 0;

        while ((1 << maxI) < max) {
            maxI++;
        }
        int res = 0, n = a.length, major = n / 2;
        for (int i = 0; i < maxI; i++) {
            int ones = 0, zeros = 0;
            for (int num : a) {
                if (ones > major || zeros > major) {
                    break;
                }

                if ((num & (1 << i)) != 0) {
                    ones++;
                } else {
                    zeros++;
                }
            }

            if (ones > zeros) {
                res |= (1 << i);
            }
        }
        return res;
    }

    static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        int n = nums.length;
        helper(0, res, nums, n);
        return res;
    }

    static void helper(int start, List<List<Integer>> res, int nums[], int n) {
        if (start + 1 == n) {
            List<Integer> subRes = new ArrayList<>();
            for (int num : nums) {
                subRes.add(num);
            }
            res.add(subRes);
            return;
        }

        for (int i = start; i < n; i++) {
            swap(start, i, nums);
            helper(start + 1, res, nums, n);
            swap(i, start, nums);
        }
    }

    static void swap(int i, int j, int nums[]) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    static int fib(int n) {
        if (n <= 2) {
            return n;
        }
        return fib(n - 1) + fib(n - 2);
    }

    static int fibDq(int n) {
        int[] dp = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            if (i <= 2) {
                dp[i] = i;
            } else {
                dp[i] = dp[i - 1] + dp[i - 2];
            }
        }
        return dp[n];
    }

    static int plusN(int n) {
        if (n < 2) {
            return n;
        }
        return n * plusN(n - 1);
    }

    static int plusNDp(int n) {
        int[] dp = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            if (i < 2) {
                dp[i] = i;
            } else {
                dp[i] = i * dp[i - 1];
            }
        }
        return dp[n];
    }

    static void helperPermute(int start, List<List<Integer>> res, int[] nums, int n) {
        if (start + 1 == n) {
            List<Integer> subRes = new ArrayList<>();
            for (int num : nums) {
                subRes.add(num);
            }
            res.add(subRes);
            return;
        }

        for (int i = start; i < n; i++) {
            swapNum(start, i, nums);
            helperPermute(start + 1, res, nums, n);
            swapNum(i, start, nums);
        }
    }

    static void swapNum(int i, int j, int[] nums) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    static boolean isValid(String str) {
        if (str == null || str.equals("")) {
            return false;
        }

        Stack<Character> st = new Stack<>();

        int n = str.length();
        char[] chrs = str.toCharArray();

        for (int i = 0; i < n; i++) {
            if (chrs[i] == '[' || chrs[i] == '{' || chrs[i] == '(') {
                st.push(chrs[i]);
                continue;
            }

            if ((chrs[i] == ')' && st.pop() != '(') ||
                    (chrs[i] == ']' && st.pop() != '[') ||
                    (chrs[i] == '}' && st.pop() != '{')) {
                return false;
            }
        }
        if (st.isEmpty()) {
            return true;
        }
        return false;
    }
}
