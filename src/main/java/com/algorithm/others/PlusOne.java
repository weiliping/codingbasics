package com.algorithm.others;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Vector;

public class PlusOne {
    public static ArrayList<Integer> plusOne(ArrayList<Integer> nums) {
        while (nums.size() > 1 && nums.get(0) == 0) {
            nums.remove(0);
        }
        int carry = 1;

        for (int j = nums.size() - 1; j >= 0; j--) {
            int tmp = nums.get(j) + carry;
            if (tmp > 9) {
                nums.set(j, tmp % 10);
                carry = 1;
            } else {
                nums.set(j, tmp);
                carry = 0;
                break;
            }
        }

        if (carry > 0) {
            nums.set(0, carry);
        }
        return nums;
    }

    static void incrementVector(Vector<Integer> a) {
        int n = a.size();

        // Add 1 to last digit and find carry
        a.set(n - 1, a.get(n - 1) + 1);
        int carry = a.get(n - 1) / 10;
        a.set(n - 1, a.get(n - 1) % 10);

        // Traverse from second last digit
        for (int i = n - 2; i >= 0; i--) {
            if (carry == 1) {
                a.set(i, a.get(i) + 1);
                carry = a.get(i) / 10;
                a.set(i, a.get(i) % 10);
            }
        }

        // If carry is 1, we need to add
        // a 1 at the beginning of vector
        if (carry == 1)
            a.add(0, 1);
    }

    public static int[] plusOne(int[] A) {
        if (A == null || A.length == 0) {
            return new int[] {};
        }

        int zeroNums = 0;
        int startIndex = 0;

        while (zeroNums < A.length && A[startIndex] == 0) {
            startIndex++;
            zeroNums++;
        }
        int[] nums = new int[A.length - zeroNums];
        for (int j = startIndex; j < A.length; j++) {
            nums[j - zeroNums] = A[j];
        }
        int carry = 1;
        for (int j = nums.length - 1; j >= 0; j--) {
            int tmp = nums[j] + carry;
            if (tmp > 9) {
                nums[j] = tmp % 10;
                carry = 1;
            } else {
                nums[j] = tmp;
                carry = 0;
                break;
            }
        }

        if (carry > 0) {
            int[] res = new int[nums.length + 1];
            res[0] = 1;
            int i = 1;
            for (int n : nums) {
                res[i] = nums[i - 1];
                i++;
            }
            return res;
        }
        return nums;
    }

    // Driver code
    public static void main(String[] args) {
        int[] is = plusOne(new int[] { 0 });
        System.out.println(Arrays.toString(is));
    }
}
