/*
 * @lc app=leetcode.cn id=3447 lang=java
 *
 * [3447] 将元素分配给有约束条件的组
 */

// @lc code=start

import java.util.Arrays;

class Solution {
    public int[] assignElements(int[] groups, int[] elements) {
        int mx = -1;
        for (int group : groups) {
            mx = Math.max(mx, group);
        }
        int[] target = new int[mx + 1];
        Arrays.fill(target, -1);
        for (int i = 0; i < elements.length; i++) {
            int x = elements[i];
            if (x > mx || target[x] != -1) {
                continue;
            }
            for (int j = x; j <= mx; j += x) {
                if (target[j] == -1) {
                    target[j] = i;
                }
            }
        }
        for (int i = 0; i < groups.length; i++) {
            groups[i] = target[groups[i]];
        }
        return groups;
    }
}
// @lc code=end

