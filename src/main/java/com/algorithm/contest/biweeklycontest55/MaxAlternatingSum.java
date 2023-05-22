package com.algorithm.contest.biweeklycontest55;

public class MaxAlternatingSum {
    public static void main(String[] args) {
        MaxAlternatingSum m = new MaxAlternatingSum();
        int[] nums = new int[] { 4, 2, 3, 7, 2, 1, 4 };
        System.out.println(m.maxAlternatingSumI(nums));
//
//        int[] nums1 = new int[] {4, 2, 5, 3};
//        System.out.println(m.maxAlternatingSum(nums1));
//
//        int[] nums2 = new int[] {5, 6, 7, 8};
//        System.out.println(m.maxAlternatingSum(nums2));
//
//        int[] nums3 = new int[] { 6, 2, 1, 2, 4, 5 };
//        System.out.println(m.maxAlternatingSum(nums3));

//        int[] nums4 = new int[] {374,126,84,237,195,139,328,353,286,113,351,167,394,398,29,118,17,162,206,138,34,109,291,368,162,109,336,256,203,330,235,74,136,72,127,382,288,276,135,383,300,220,299,205,186,113,71,261,253,47,387,25,57,79,322,82,349,217,306,33,198,196,306,240,271,129,284,6,349,370,59,350,275,385,137,394,329,175,58,151,223,81,233,2,370,369,135,257,391,92,260,55,321,153,328,260,312,102,79,192};
//        System.out.println(m.maxAlternatingSumI(nums4));
    }
    public long maxAlternatingSumI(int[] nums) {
        int n = nums.length;
        long odd = 0, even = nums[0];
        for (int i = 0; i < n; i++) {
            System.out.println("odd = " + odd + " even = " + even);
            System.out.println("-------------------------------------");
            odd = Math.max(even - nums[i], odd);
            even = Math.max(odd + nums[i], even);
        }
        return even;
    }

    public long maxAlternatingSum(int[] nums) {
        int n = nums.length;
        boolean isEven = n % 2 == 0;
        long[] eSums = new long[isEven ? n : n + 1], oSums = new long[isEven ? n + 1 : n];
        long[] ans = new long[1];
        eSums[1] = nums[0];
        oSums[2] = nums[1];
        for (int i = 2; i < n; i++) {
            if (i % 2 == 0) {
                eSums[i + 1] = eSums[i - 1] + nums[i];
                continue;
            }
            oSums[i + 1] = oSums[i - 1] + nums[i];
        }
        dfs(nums, 0, 0, 0, 0, eSums, oSums, n, ans);
        return ans[0];
    }

    void dfs(int[] nums, int s, int selected, long preESum, long preOSum, long[] eSums, long[] oSums, int n, long[] ans) {
        System.out.println(s);
        if (s == n) {
            return;
        }
        long suffixESum, suffixOsum;
        if (s % 2 == 0) {
            suffixESum = eSums[eSums.length - 1] - eSums[s + 1];
            suffixOsum = oSums[oSums.length - 1] - oSums[s];
        } else {
            suffixESum = eSums[eSums.length - 1] - eSums[s];
            suffixOsum = oSums[oSums.length - 1] - oSums[s + 1];
        }
        //no pick
        int delete = s + 1 - selected;
        boolean isEDel = delete % 2 == 0;
        if (isEDel) {
            long res = preESum + suffixESum - preOSum - suffixOsum;
            if (ans[0] < res) {
                ans[0] = res;
            }
        } else {
            long res = preESum + suffixOsum - preOSum - suffixESum;
            if (ans[0] < res) {
                ans[0] = res;
            }
        }
        if ((preESum + suffixESum) > ans[0] || preESum + suffixOsum > ans[0]) {
            dfs(nums, s + 1, selected, preESum, preOSum, eSums, oSums, n, ans);
        }
        //pick
        if (selected % 2 == 0) {
            preESum += nums[s];
        } else {
            preOSum += nums[s];
        }
        if (isEDel) {
            long res = preESum + suffixOsum - preOSum - suffixESum;
            if (ans[0] < res) {
                ans[0] = res;
            }
        } else {
            long res = preESum + suffixESum - preOSum - suffixOsum;
            if (ans[0] < res) {
                ans[0] = res;
            }
        }
        if ((preESum + suffixESum) > ans[0] || preESum + suffixOsum > ans[0]) {
            dfs(nums, s + 1, selected + 1, preESum, preOSum, eSums, oSums, n, ans);
        }
    }
}
