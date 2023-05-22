package com.algorithm.contest.weeklycontest231;

/**
 * https://leetcode-cn.com/problems/minimum-elements-to-add-to-form-a-given-sum/
 * #1785. 构成特定和需要添加的最少元素
 *
 * 给你一个整数数组 nums ，和两个整数 limit 与 goal 。数组 nums 有一条重要属性：abs(nums[i]) <= limit 。
 *
 * 返回使数组元素总和等于 goal 所需要向数组中添加的 最少元素数量 ，添加元素 不应改变 数组中 abs(nums[i]) <= limit 这一属性。
 *
 * 注意，如果 x >= 0 ，那么 abs(x) 等于 x ；否则，等于 -x 。
 *
 * 示例 1：
 * 输入：nums = [1,-1,1], limit = 3, goal = -4
 * 输出：2
 * 解释：可以将 -2 和 -3 添加到数组中，数组的元素总和变为 1 - 1 + 1 - 2 - 3 = -4 。
 *
 * 示例 2：
 * 输入：nums = [1,-10,9,1], limit = 100, goal = 0
 * 输出：1
 *
 * 提示：
 * 1 <= nums.length <= 105
 * 1 <= limit <= 106
 * -limit <= nums[i] <= limit
 * -109 <= goal <= 109
 *
 */
public class MinElements {
    public static void main(String[] args) {
        System.out.println(minElements(new int[] {1, -1, 1}, 3, -4));
        System.out.println(minElements(new int[] {1, -10, 9, 1}, 100, 0));
        System.out.println(minElements(new int[] {2,5,5,-7,4}, 7, 464680098));
        System.out.println(minElements(new int[] {1,-7,-5,9,0,14}, 14, 14));
        System.out.println(minElements(new int[] {6230,-26263,-12273,35912,17505,38275,-13799,25291,-25555}, 39242, 215185872));
    }

    public static int minElements(int[] nums, int limit, int goal) {
        int cnt = goal / limit, left = goal % limit;

        int pNumSum = 0, numCnt = 0, nNumSum = 0;
        for (int num : nums) {
            if (num >= 0) {
                pNumSum += num;
                if (pNumSum >= limit) {
                    pNumSum -=limit;
                    numCnt++;
                }
            } else {
                nNumSum += num;
                if (nNumSum <= -limit) {
                    nNumSum += limit;
                    numCnt--;
                }
            }
        }
        int numLeft = pNumSum + nNumSum;
        if (numLeft > 0 && numCnt < 0) {
            numCnt++;
            numLeft = numLeft - limit;
        }
        if (numLeft < 0 && numCnt > 0) {
            numCnt--;
            numLeft = limit + numLeft;
        }

        int res;
        if (cnt > numCnt) {
            res = cnt - numCnt;
            if (left < numLeft) {
                res--;
                left = left + limit - numLeft;
            } else {
                left = left - numLeft;
            }
            int r = Math.abs(left) / limit;
            res += left % limit == 0 ? r : r + 1;
        } else {
            res = numCnt - cnt;
            if (numLeft < left) {
                res--;
                numLeft = numLeft + limit - left;
            } else {
                numLeft = numLeft - left;
            }
            int r = Math.abs(numLeft) / limit;
            res += numLeft % limit == 0 ? r : r + 1;
        }
        return res;
    }
}
