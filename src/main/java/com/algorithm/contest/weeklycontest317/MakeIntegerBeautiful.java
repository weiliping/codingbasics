package com.algorithm.contest.weeklycontest317;

public class MakeIntegerBeautiful {
    public static void main(String[] args) {
        long n = 16;
        int target = 6;
        System.out.println(makeIntegerBeautiful(n, target));
        long n1 = 467;
        int target1 = 6;
        System.out.println(makeIntegerBeautiful(n1, target1));
        long n2 = 1;
        int target2 = 1;
        System.out.println(makeIntegerBeautiful(n2, target2));
        long n3 = 19;
        int target3 = 1;
        System.out.println(makeIntegerBeautiful(n3, target3));
    }

    public static long makeIntegerBeautiful(long n, int target) {
        int[] nums = new int[13];
        int i = 0, sum = 0;
        while (n > 0) {
            nums[i] = (int) (n % 10);
            sum += nums[i];
            i++;
            n /= 10;
        }
        long x = 1l, res = 0l;
        int j = 0;
        while (sum > target) {
            sum -= nums[j] - 1;
            int t = 10 - nums[j];
            if (j != 12) {
                nums[j + 1]++;
            }
            res += t * x;
            x *= 10;
            j++;
        }
        return res;
    }
}
