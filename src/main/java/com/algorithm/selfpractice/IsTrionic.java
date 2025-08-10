package com.algorithm.selfpractice;

public class IsTrionic {
  public static void main(String[] args) {
      IsTrionic it = new IsTrionic();
      // int[] nums = {5, 9, 1, 7};
      // System.out.println(it.isTrionic(nums)); // Output: true
      int[] nums1 = {2, 4, 3, 3};
      System.out.println(it.isTrionic(nums1)); // Output: true
  }

  public boolean isTrionic(int[] nums) {
    int cnt = 1;
    for (int i = 1; i < nums.length; i++) {
        if ((cnt & 1) == 1) {
            if (nums[i - 1] < nums[i]) {
                continue;
            }
            if (i == 1) {
                break;
            }
            if (nums[i - 1] == nums[i]) {
                return false;
            }
            cnt++;
        } else {
            if (cnt == 1) {
                break;
            }
            
            if (nums[i - 1] > nums[i]) {
                continue;
            }
            if (nums[i - 1] == nums[i]) {
                return false;
            }
            cnt++;
        }
    }   
    return cnt == 3; 
  }
}