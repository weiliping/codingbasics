package com.algorithm.contest.weeklycontest161;

public class NumberOfSubarrays {

    public static void main(String[] args) {
        System.out.println(numberOfSubarrays(new int[]{1,1,2,1,1}, 3));
        System.out.println(numberOfSubarrays(new int[]{2,2,2,1,2,2,1,2,2,2}, 2));
//        System.out.println(numberOfSubarrays(new int[]{2, 4, 6}, 1));
    }
    public static int numberOfSubarrays(int[] nums, int k) {
        int l = 0, r = 0, pr, lr, n = nums.length, cnt = 0, ans = 0;
        while (r < n) {
            if ((nums[r] & 1) == 1) {
                cnt++;
            }
            r++;
            while (cnt > k) {
                if (l < n && (nums[l] & 1) == 1) {
                    cnt--;
                }
                l++;
            }
            if (cnt == k) {
                pr = r;
                lr = l;
                while (r < n && (nums[r] & 1) == 0) {
                    r++;
                }
                while ((nums[l] & 1) == 0) {
                    l++;
                }
                ans += (r - pr + 1) * (l - lr + 1);
            }
        }
        return ans;
    }
}
