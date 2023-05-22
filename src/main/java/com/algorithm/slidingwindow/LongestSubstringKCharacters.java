package com.algorithm.slidingwindow;

public class LongestSubstringKCharacters {
    /**
     * #340
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstringKDistinct("eceba", 2));
    }

    public static int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (s == null || s.length() == 0 || k <= 0) {
            return 0;
        }

        int[] countArr = new int[256];
        int count = 0;

        int left = 0;
        int maxLen = 0;

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            if (countArr[c] == 0) {
                count++;
            }

            countArr[c]++;
            if (count <= k) {
                maxLen = Math.max(maxLen, right - left + 1);
            }

            while (count > k) {
                char leftChar = s.charAt(left);
                countArr[leftChar]--;

                if (countArr[leftChar] == 0) {
                    count--;
                }

                left++;
            }
        }

        return maxLen;
    }
}
