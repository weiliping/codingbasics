/*
 * @lc app=leetcode.cn id=3456 lang=java
 *
 * [3456] 找出长度为 K 的特殊子字符串
 */

// @lc code=start
class Solution {
    public boolean hasSpecialSubstring(String s, int k) {
        int n = s.length();
        int i = 0;
        while (i < n - k + 1) {
            int j = i + 1;
            while (j < n && s.charAt(i) == s.charAt(j)) {
                j++;
            }
            if (j - i == k) {
                return true;
            }
            i = j;
        }
        return false;      
    }
}
// @lc code=end

