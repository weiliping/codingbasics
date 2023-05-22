package com.algorithm.others;

public class RemoveDuplicates {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0)
            return 0;
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }

    public static void main(String[] args) {
        RemoveDuplicates r = new RemoveDuplicates();
        System.out.println(r.removeDuplicates(new int[] { 0, 0, 1, 1, 2, 3, 4 }));
    }
}
