/*
 * @lc app=leetcode.cn id=3458 lang=java
 *
 * [3458] 选择 K 个互不重叠的特殊子字符串
 */

// @lc code=start

import java.util.Arrays;
import java.util.LinkedList;

class Solution {
    public boolean maxSubstringLength(String s, int k) {
        if (k == 0) {
            return true;
        }
        int[][] cnts = new int[26][3];
        for (int i = 0; i < 26; i++) {
            cnts[i][0] = -1;
            cnts[i][1] = -1;
        }
        char[] chrs = s.toCharArray();
        int n = chrs.length;
        for (int i = 0; i < n; i++) {
            int idx = chrs[i] - 'a';
            if (cnts[idx][0] == -1) {
                cnts[idx][0] = i;
            }
            cnts[idx][1] = i;
            cnts[idx][2]++;
        }
        Arrays.sort(cnts, (a, b) -> a[1] == b[1] ? a[0] - b[0] : a[1] - b[1]);
        int c = 0;
        LinkedList<int[]> list = new LinkedList<>();
        for (int i = 0; i < 26; i++) {
            if (cnts[i][0] == -1 || cnts[i][2] == 0) {
                continue;
            }
            list.add(cnts[i]);
            while (list.size() > 1 && list.get(list.size() - 2)[1] > list.getLast()[0]) {
                int[] last = list.pollLast();
                int[] sec = list.pollLast();
                sec[0] = Math.min(sec[0], last[0]);
                sec[1] = Math.max(sec[1], last[1]);
                sec[2] += last[2];
                list.add(sec);
            }
            int[] l = list.getLast();
            if (l[1] - l[0] + 1 == l[2]) {
                list.pollLast();
                if (l[2] != n) {
                    c++;
                }    
            }
        }
        return c >= k;
    }
}
// @lc code=end

