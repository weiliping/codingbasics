package com.algorithm.contest.weeklycontest260;

public class MaximumDifference {
    public static void main(String[] args) {
        System.out.println(maximumDifference(new int[]{999,997,980,976,948,940,938,928,924,917,907,907,881,878,864,862,859,857,848,840,824,824,824,805,802,798,788,777,775,766,755,748,735,732,727,705,700,697,693,679,676,644,634,624,599,596,588,583,562,558,553,539,537,536,509,491,485,483,454,449,438,425,403,368,345,327,287,285,270,263,255,248,235,234,224,221,201,189,187,183,179,168,155,153,150,144,107,102,102,87,80,57,55,49,48,45,26,26,23,15}));
    }
    public static int maximumDifference(int[] nums) {
        int n = nums.length;
        int[] max = new int[n];
        max[n - 1] = nums[n - 1];
        int cnt = Integer.MIN_VALUE;
        for (int i = n - 2; i >= 0; i--) {
            max[i] = Math.max(max[i + 1], nums[i]);
        }

        for (int i = 0; i < n - 1; i++) {
            if (max[i + 1] > nums[i]) {
                cnt = Math.max(cnt, max[i + 1] - nums[i]);
            }
        }
        return cnt == Integer.MIN_VALUE ? -1 : cnt;
    }
}
