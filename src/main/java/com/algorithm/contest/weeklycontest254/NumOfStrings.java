package com.algorithm.contest.weeklycontest254;

public class NumOfStrings {
    public static void main(String[] args) {
        NumOfStrings n = new NumOfStrings();
        //        int[] nums = new int[] {1, 2, 3, 4, 5};
        //        System.out.println(Arrays.toString(n.reorderArray(nums)));

        //        int[] nums2 = new int[] {1, 2, 3};
        //        System.out.println(Arrays.toString(n.reorderArray(nums2)));
        System.out.println((1 << 60));
        int p = 1 << 5;
        for (int i = 1; i < p; i++) {
            for (int j = i + 1; j < p; j++) {
                System.out.print(i & j);
                System.out.print("     ");
                System.out.print(i | j);
                System.out.println(" = " + i + " i j" + j);
            }
        }
    }

    public int numOfStrings(String[] patterns, String word) {
        int cnt = 0;
        for (String p : patterns) {
            if (word.indexOf(p) > -1) {
                cnt++;
            }
        }
        return cnt;
    }

    static final int MOD = (int) 1e9 + 7;

    public int minNonZeroProduct(int p) {
        int p1 = (int)((1 << p - 1) % MOD);
        long p2 = (pow((long)(1 << p - 2), ((1 << (p -1)) - 1)) % MOD);
        return (int)((p1 * p2) % MOD);
    }

    static long pow(long a, int b) {
        if (b == 0) {
            return 1;
        }

        if (b == 1) {
            return a;
        }
        if ((b & 1) == 0) {
            return pow(a * a, b / 2); //even a=(a^2)^b/2
        }
        return a * pow(a * a, b / 2); //odd  a=a*(a^2)^b/2
    }

}
