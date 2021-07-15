package com.algorithm.binarysearch;

public class NextLetter {

    /**
     * #744
     * https://leetcode-cn.com/problems/find-smallest-letter-greater-than-target/
     * @param args
     */
    public static void main(String[] args) {
        char[] letters = new char[] {'c', 'f', 'j'};
        System.out.println(nextGreatestLetter(letters, 'a'));
        System.out.println(nextGreatestLetter(letters, 'c'));
        System.out.println(nextGreatestLetter(letters, 'd'));
        System.out.println(nextGreatestLetter(letters, 'g'));
        System.out.println(nextGreatestLetter(letters, 'j'));
        System.out.println(nextGreatestLetter(letters, 'k'));
    }

    public static char nextGreatestLetter(char[] letters, char target) {
        int i = 0, j = letters.length - 1;
        while (i <= j) {
            int mid = i + (j - i) / 2;

            if (letters[mid] > target) {
                if (mid == 0 || letters[mid - 1] <= target) {
                    return letters[mid];
                }
                j = mid - 1;
            } else {
                i = mid + 1;
            }
        }
        return letters[0];
    }
}
