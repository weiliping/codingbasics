package com.algorithm.selfpractice.sort;

import java.util.HashMap;

public class Test2 {
     public static void main(String[] args) {
        // int[] nums = new int[] {2,2,-1,3,-2,2,1,1,1,0,-1};
        // Test2 solution = new Test2();
        // int result = solution.minimumPairRemoval(nums);
        // System.out.println(result);
        // int[] nums2 = new int[] {5, 2, 3, 1};
        // System.out.println(solution.minimumPairRemoval(nums2));

        HashMap<String, String> capitalCities = new HashMap<String, String>();
        capitalCities.put("England", "London");
        capitalCities.put("Germany", "Berlin");
        capitalCities.put("Norway", "Oslo");
        capitalCities.put("USA", "Washington DC");
        
        capitalCities.compute("England", (k, v) -> v + "(" + k + ")");
        
        System.out.println(capitalCities);
    }
    
    public int minimumPairRemoval(int[] nums) {
        int n = nums.length;
        int res = 0;
        for (int i = 0; i < n; i++) {
            boolean isValid = true;
            for (int k = 0; k < n - i - 2; k++) {
                if (nums[k] > nums[k + 1]) {
                    isValid = false;
                    break;
                }
            }
            if (isValid) {
                break;
            }

            int minI = -1;
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < n - i - 1; j++) {
                if (nums[j] + nums[j + 1] < min) {
                    min = nums[j] + nums[j + 1];
                    minI = j;
                }
            }
            if (minI == -1) {
                break;
            }
            nums[minI] = min;
            res++;
            for (int k = minI + 1; k < n - i - 1; k++) {
                nums[k] = nums[k + 1];
            }
        }
        return res;
    }
}
