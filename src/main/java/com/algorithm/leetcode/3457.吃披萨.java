/*
 * @lc app=leetcode.cn id=3457 lang=java
 *
 * [3457] 吃披萨
 */

// @lc code=start

import java.util.Arrays;

class Solution {
    public long maxWeight(int[] pizzas) {
        int n = pizzas.length;
        Arrays.sort(pizzas);
        long res = 0;
        int n1 = (n / 4 + 1) / 2;
        for (int i = n - 1; i >= n - n1; i--) {
            res += pizzas[i];
        }
        int n2 = (n / 4)/2;
        int j = 2;
        while (n2 > 0) {
            res += pizzas[n - n1 - j];
            j += 2;
            n2--;
        }
        return res;   
    }
}
// @lc code=end

