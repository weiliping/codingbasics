/*
 * @lc app=leetcode.cn id=3461 lang=java
 *
 * [3461] 判断操作后字符串中的数字是否相等 I
 */

// @lc code=start

import java.util.ArrayList;
import java.util.List;

class Solution {
    public boolean hasSameDigits(String s) {
        List<Integer> nums = new ArrayList<>();
        for (char c : s.toCharArray()) {
            nums.add(c - '0');
        }
        return helper(nums);
    }

    public static boolean helper(List<Integer> nums) {
        if (nums.size() == 2) {
            return nums.get(0) == nums.get(1);
        }
        List<Integer> l = new ArrayList<>();
        for (int i = 0; i < nums.size() - 1; i++) {
            l.add((nums.get(i) + nums.get(i + 1)) % 10);
        }
        return helper(l);
    }
}
// @lc code=end

