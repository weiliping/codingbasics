package com.algorithm.selfpractice.round2;

public class UniqueXorTriplets {
    public static void main(String[] args) {
        int[] nums = new int[]{6, 7, 8, 9};
        UniqueXorTriplets u = new UniqueXorTriplets();
        int ans = u.uniqueXorTriplets(nums);
        System.out.println(ans);
    }
    private static final int MOD = 1000000007;
    public int uniqueXorTriplets(int[] nums) {
        int n = nums.length;

        boolean[] xor = new boolean[2048];
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int k = nums[i] ^ nums[j];
                xor[k] = true;
            }
        }
        int ans = 0;
        boolean[] mor = new boolean[2048];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2048; j++) {
                if (xor[j]) {
                    int k = j ^ nums[i];
                    if (!mor[k]) {
                        ans++;
                        mor[k] = true;
                    } 
                }
            }
        }
        return ans;
    }
}
