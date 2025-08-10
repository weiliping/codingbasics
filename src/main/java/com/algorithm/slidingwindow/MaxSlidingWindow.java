package com.algorithm.slidingwindow;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class MaxSlidingWindow {
    public static void main(String[] args) {
        int[] nums = new int[]{1,3,-1,-3,5,3,6,7};
        
        int k = 3;
        MaxSlidingWindow maxSlidingWindow = new MaxSlidingWindow();
        int[] result = maxSlidingWindow.maxSlidingWindow(nums, k);
        String caption = "FkVsgzfhQxPYKr WtaCvDuHQeo roeVHIoPorZuIuMDxhYVs jlfCrXCDqBVjgmzxxmZOpUpCc  eHMpZrNxilBPngylMcS";
        System.out.println(maxSlidingWindow.generateTag(caption));
        System.out.println(Arrays.toString(result));

    }
    public String generateTag(String caption) {
        String[] strs = caption.trim().split(" ");
        if (strs.length == 0) {
            return "#";
        }
        StringBuilder sb = new StringBuilder();

        sb.append("#").append(strs[0].toLowerCase());
        for (int i = 1; i < strs.length; i++) {
            sb.append(upperCaseFirst(strs[i]));
        }
        if (sb.length() > 100) {
            sb.setLength(100);
        }
        return sb.toString();
    }

    private String upperCaseFirst(String s) {
        if (s == null || s.isEmpty()) {
            return "";
        }
        return s.substring(0, 1).toUpperCase() + s.substring(1).toLowerCase();
    }
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] mArr = new int[nums.length - k + 1];

        LinkedList<Integer> queue = new LinkedList<>();
        for (int i = 0; i < k; i++) {
            while (!queue.isEmpty() && nums[queue.peekLast()] < nums[i]) {
                queue.pollLast();
            }
            queue.offerLast(i);
        }
        mArr[0] = nums[queue.peekFirst()];
        for (int i = k; i < nums.length; i++) {
            while (!queue.isEmpty() && nums[queue.peekLast()] < nums[i]) {
                queue.pollLast();
            }
            queue.offerLast(i);
            if (nums[queue.peekFirst()] == nums[i - k]) {
                queue.pollFirst();
            }
            mArr[i - k + 1] = nums[queue.peekFirst()];
        }
        return mArr;
    }
    
}
