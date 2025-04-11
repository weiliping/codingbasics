package com.datastructure;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] nums = new int[] {5, 2, 3, 1};
        QuickSort qs = new QuickSort();
        qs.sort(nums);
        System.out.println(Arrays.toString(nums));
    }
    public void sort(int[] nums) {
        int l = 0, r = nums.length - 1;
        sortHelper(nums, l, r);
    }
    
    private static void sortHelper(int[] nums, int l, int r) {
        if (l > r) {
            return;
        }
        
        int i = l, j = r;
        
        int baseV = nums[i];
        
        while (i < j) {
            while (i < j && nums[j] >= baseV) {
                j--;
            }
            if (i < j) {
                nums[i] = nums[j];
                i++;
            }
            
            while (i < j && nums[i] < baseV) {
                i++;
            }
            
            if (i < j) {
                nums[j] = nums[i];
                j--;
            }
        }
        nums[i] = baseV;
        
        sortHelper(nums, l, i - 1);
        sortHelper(nums, i + 1, r);
    }    
}
