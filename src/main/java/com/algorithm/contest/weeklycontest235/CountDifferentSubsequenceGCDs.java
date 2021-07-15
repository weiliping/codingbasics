package com.algorithm.contest.weeklycontest235;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/number-of-different-subsequences-gcds/
 * #1819. 序列中不同最大公约数的数目
 *
 * 给你一个由正整数组成的数组 nums 。
 *
 * 数字序列的 最大公约数 定义为序列中所有整数的共有约数中的最大整数。
 *
 * 例如，序列 [4,6,16] 的最大公约数是 2 。
 * 数组的一个 子序列 本质是一个序列，可以通过删除数组中的某些元素（或者不删除）得到。
 *
 * 例如，[2,5,10] 是 [1,2,1,2,4,1,5,10] 的一个子序列。
 * 计算并返回 nums 的所有 非空 子序列中 不同 最大公约数的 数目 。
 *
 * 示例 1：
 * 输入：nums = [6,10,3]
 * 输出：5
 * 解释：上图显示了所有的非空子序列与各自的最大公约数。
 * 不同的最大公约数为 6 、10 、3 、2 和 1 。
 *
 * 示例 2：
 * 输入：nums = [5,15,40,5,6]
 * 输出：7
 *  
 *
 * 提示：
 * 1 <= nums.length <= 105
 * 1 <= nums[i] <= 2 * 105
 */
public class CountDifferentSubsequenceGCDs {

    public static void main(String[] args) {
        System.out.println(countDifferentSubsequenceGCDs(new int[] { 6, 10, 3 }));
        System.out.println(countDifferentSubsequenceGCDsI(new int[] { 6, 10, 3 }));
    }

    public static int countDifferentSubsequenceGCDs(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        subListHelper(nums, 0, res, new ArrayList<>());
        HashSet<Integer> h = new HashSet<>();
        for (List<Integer> r : res) {
            h.add(gcdList(r));
        }
        return h.size();
    }

    static void subListHelper(int[] nums, int s, List<List<Integer>> res, List<Integer> subRes) {
        if (subRes.size() != 0) {
            res.add(new ArrayList<>(subRes));
        }
        for (int i = s; i < nums.length; i++) {
            subRes.add(nums[i]);
            subListHelper(nums, i + 1, res, subRes);
            subRes.remove(subRes.size() - 1);
        }
    }

    public static int gcdList(List<Integer> res) {
        if (res.size() == 0) {
            return -1;
        }
        int gcd = res.get(0);
        if (res.size() > 1) {
            for (int i = 1; i < res.size(); i++) {
                gcd = GCD(gcd, res.get(i));
            }
        }
        return gcd;
    }

    public static int GCD(int m, int n) {
        int result = 0;
        while (n != 0) {
            result = m % n;
            m = n;
            n = result;
        }
        return m;
    }

    public static int countDifferentSubsequenceGCDsI(int[] nums) {
        boolean[] mark = new boolean[200001];
        for(int num : nums) {
            mark[num] = true;
        }
        int res = 0;
        for(int i = 1; i < 200001; i++){
            int curGcd = 0;
            for(int j = i; j < 200001; j += i){
                if(mark[j]){
                    curGcd = curGcd == 0 ? j : gcd(curGcd, j);
                    if(curGcd == i){
                        res++;
                        break;
                    }
                }
            }
        }
        return res;
    }

    public static int gcd(int a, int b){
        return a % b == 0 ? b : gcd(b, a % b);
    }
}
