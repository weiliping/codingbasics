/*
 * @lc app=leetcode.cn id=3458 lang=java
 *
 * [3458] 选择 K 个互不重叠的特殊子字符串
 */

// @lc code=start

import java.util.Arrays;

class Solution {
    public boolean maxSubstringLength(String s, int k) {
        if (k == 0) {
            return true;
        }
        int[] cnt = new int[26];
        Arrays.fill(cnt, -1);
        char[] chrs = s.toCharArray();
        int i = 0, n = chrs.length;
        while (i < n) {
            int j = i;
            while (j < n - 1 && chrs[i] == chrs[++j]) {
                if (j == n - 1) {
                    j++;
                    break;
                }
            }
            int ind = chrs[i] - 'a';
            if (cnt[ind] != -2) {
                cnt[ind] = cnt[ind] == -1 ? i : -2;
            }
            i = i < n - 1 ? j : i + 1;
        }
        int c = 0;
        for (int j = 0; j < 26; j++) {
            if (cnt[j] > -1) {
                c++;
            }
        }
        return c >= k;
    }
}
// @lc code=end

