package com.algorithm.contest.weeklycontest324;

public class SmallestValue {

    public static void main(String[] args) {
        System.out.println(smallestValue(15));
    }

    public static int smallestValue(int n) {
        int preSum = primeFactorsSum(n);
        if (preSum == n) {
            return n;
        }
        while (preSum != 0) {
            n = preSum;
            preSum = primeFactorsSum(n);
            if (preSum == n) {
                break;
            }
        }
        return n;
    }

    public static int primeFactorsSum(int n) {
        int sum = 0;

        while ((n & 1) == 0) {
            n >>= 1;
            sum += 2;
        }

        int m = (int) Math.ceil(Math.sqrt((double) n));
        for (int i = 3; i <= m; i += 2) {
            while (n % i == 0) {
                n /= i;
                sum += i;
            }
        }
        if (n > 2) {
            sum += n;
        }
        return sum;
    }
}
