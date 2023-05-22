package com.algorithm.contest.weeklycontest333;

public class SquareFreeSubsets {

    private static final int[] PRIMES = new int[] { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29 };
    private static final int MOD = (int) 1e9 + 7, MX = 30, N_PRIMES = PRIMES.length, M = 1 << N_PRIMES;
    private static final int[] SF_TO_MASK = new int[MX + 1]; // SF_TO_MASK[i] 为 i 的质因子集合（用二进制表示）

    static {
        for (int i = 2; i <= MX; ++i)
            for (int j = 0; j < N_PRIMES; ++j) {
                int p = PRIMES[j];
                if (i % p == 0) {
                    if (i % (p * p) == 0) { // 有平方因子
                        SF_TO_MASK[i] = -1;
                        break;
                    }
                    SF_TO_MASK[i] |= 1 << j; // 把 j 加到集合中
                }
            }
    }
    // private static final int MOD = (int) 1e9 + 7;
    // 4, 8, 9, 12, 16, 18, 20, 24, 25, 27, 28,
    // private static final boolean[] EVENS = new boolean[] { false, false, false,
    // false, true, false, false, false, true,
    // true, false, false, true, false, false, false, true, false, true, false,
    // true, false, false, false, true,
    // true, false, true, true, false, false };

    public static void main(String[] args) {
        add(2, 1);
        // System.out.println(squareFreeSubsets(new int[] { 3, 4, 4, 5 }));
        // System.out.println(squareFreeSubsets(new int[] { 1 }));
        // System.out.println(squareFreeSubsets(new int[] { 11, 2, 19, 7, 9, 27 }));
        // // 3
        // System.out.println(squareFreeSubsets(new int[] { 26, 6, 4, 27, 6, 18 }));
        // // 7
        // System.out.println(squareFreeSubsets(new int[] { 17, 27, 20, 1, 19 }));
        // // 39
        // System.out.println(squareFreeSubsets(new int[] { 8, 11, 17, 2, 25, 29, 21,
        // 20, 4, 22 }));
        // // 3
        // System.out.println(squareFreeSubsets(new int[] { 10, 15, 6, 25 }));
    }

    public static void add(int n, int m) {
        int i = 0;
        while (i < 8) {
            int p = 2 * n + m;
            System.out.println(p);
            n = m;
            m = p;
            i++;
        }
    }

    // int p = 2 * n + m;
    // int n = m;m=2*n+m;

    // public static int squareFreeSubsets(int[] nums) {
    // int[] cnts = new int[31];
    // for (int num : nums) {
    // if (!EVENS[num]) {
    // cnts[num]++;
    // }
    // }

    // int cnt = 0;
    // for (int i = 1; i < 31; i++) {
    // if (cnts[i] > 0) {
    // int sub = cnts[i];
    // List<Integer> pick = new ArrayList<>();
    // pick.add(Integer.valueOf(i));
    // for (int j = i + 1; j < 31; j++) {
    // if (cnts[j] > 0 && !hasCommon(pick, j)) {
    // pick.add(Integer.valueOf(j));
    // sub = (int) ((long) (sub * (cnts[j] + 1)) % MOD);
    // }
    // }
    // cnt += sub;
    // }
    // }
    // return cnt;
    // }

    // public static boolean hasCommon(List<Integer> nums, int j) {
    // for (int num : nums) {
    // if (pcd(num, j) != 1) {
    // return true;
    // }
    // }
    // return false;
    // }

    // public static int pcd(int i, int j) {
    // if (i < j) {
    // return pcd(j, i);
    // }
    // int d = i % j;
    // return d == 0 ? j : pcd(j, d);
    // }

    public static int squareFreeSubsets(int[] nums) {
        int[] f = new int[M]; // f[j] 表示恰好组成质数集合 j 的方案数
        f[0] = 1; // 质数集合是空集的方案数为 1
        for (int x : nums) {
            int mask = SF_TO_MASK[x];
            if (mask >= 0) // x 是 SF
                for (int j = M - 1; j >= mask; --j)
                    if ((j | mask) == j) // mask 是 j 的子集
                        f[j] = (f[j] + f[j ^ mask]) % MOD; // 不选 mask + 选 mask
        }
        long ans = 0L;
        for (int v : f)
            ans += v;
        return (int) ((ans - 1) % MOD); // -1 去掉空集（nums 的空子集）
    }
}
