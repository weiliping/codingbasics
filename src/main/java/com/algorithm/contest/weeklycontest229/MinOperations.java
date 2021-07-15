package com.algorithm.contest.weeklycontest229;

public class MinOperations {
    public int[] minOperations(String boxes) {
        char[] str = boxes.toCharArray();
        int[] ans = new int[str.length];
        int temp = 0;
        int count = 0;
        for (int i = 1; i < str.length; i++) {
            temp += str[i - 1] == '1' ? ++count : count;
            ans[i] = temp;
        }
        temp = 0;
        count = 0;
        for(int i = str.length -2; i>= 0; i--){
            temp += str[i + 1] == '1' ? ++count : count;
            ans[i] += temp;
        }
        return ans;
    }
}
