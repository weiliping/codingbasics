package com.algorithm.selfpractice.round3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EvaluateExpression {
//    Input: "2*3-4-5"
//    Output: 8, -12, 7, -7, -3
//    Explanation: 2*(3-(4-5)) => 8, 2*(3-4-5) => -12, 2*3-(4-5) => 7, 2*(3-4)-5 => -7, (2*3)-4-5 => -3

    public static List<Integer> evaluateExpression(String evalStr) {
        List<Integer> res = new ArrayList<>();

        if (!evalStr.contains("*") && !evalStr.contains("+") && !evalStr.contains("-")) {
            res.add(Integer.parseInt(evalStr));
            return res;
        }

        char[] chrs = evalStr.toCharArray();

        for (int i = 0; i < chrs.length; i++) {
            if (!Character.isDigit(chrs[i])) {
                List<Integer> leftNums = evaluateExpression(evalStr.substring(0, i));
                List<Integer> rightNums = evaluateExpression(evalStr.substring(i + 1));

                for (int j : leftNums) {
                    for (int k : rightNums) {
                        if (chrs[i] == '+') {
                            res.add(j + k);
                        } else if (chrs[i] == '*') {
                            res.add(j * k);
                        } else {
                            res.add(j - k);
                        }
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
//        System.out.println(mySqrt(4));
//        System.out.println(mySqrt(8));
//        System.out.println(mySqrt(16));
//        System.out.println(mySqrt(36));
//        System.out.println(mySqrt(80));
        int[] nums = new int[] {5,7,7,8,8,10};
        int[] res = searchRange(nums, 8);
        System.out.println(Arrays.toString(res));
    }
    public static int mySqrt(int x) {
        if (x <= 1) {
            return x;
        }

        int i = 1, j = (x >> 1);

        while (i < j) {
            int mid = i + ((j - i) >> 1);

            int res = mid * mid;
            if (res == x) {
                return mid;
            }

            if (res > x) {
                j = mid - 1;
            } else {
                i = mid + 1;
            }
        }
        return i - 1;
    }

    public static int[] searchRange(int[] nums, int target) {
        int[] res = new int[2];
        res[0] = searchFirstEqual(nums, target);
        res[1] = searchLastEqual(nums, target);
        return res;
    }

    static int searchFirstEqual(int[] nums, int target) {
        int i = 0, j = nums.length - 1;
        while (i <= j) {
            int mid = i + ((j - i) >> 1);

            if (nums[mid] == target) {
                if (mid == 0 || nums[mid - 1] < target) {
                    return mid;
                }
                j = mid - 1;
                continue;
            }
            if (nums[mid] > target) {
                j = mid - 1;
            } else {
                i = mid + 1;
            }
        }
        return -1;
    }

    static int searchLastEqual(int[] nums, int target) {
        int i = 0, n = nums.length, j = n - 1;
        while (i <= j) {
            int mid = i + ((j - i) >> 1);
            if (nums[mid] == target) {
                if (mid == n - 1 || nums[mid + 1] > target) {
                    return mid;
                }
                i = mid + 1;
                continue;
            }
            if (nums[mid] > target) {
                j = mid - 1;
            } else {
                i = mid + 1;
            }
        }
        return -1;
    }
}
