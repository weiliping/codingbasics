package com.algorithm.contest.weeklycontest313;

public class MinimizeXor {
    public static void main(String[] args) {
        System.out.println(minimizeXor(3, 5));
        System.out.println(minimizeXor(1, 12));
        System.out.println(minimizeXor(25, 72));
    }

    public static int minimizeXor(int num1, int num2) {
        int[] binNum = new int[31];
        int cnt = 0;
        for (int i = 0; i < 31; i++) {
            binNum[i] = (num1 >> i) & 1;
            cnt += binNum[i];
        }
        int oneCount = countOne(num2);
        num2 = toNum(oneCount);
        if (cnt <= oneCount && num1 <= num2) {
            return num2;
        }
        int k = 0;
        for (int i = 30; i >= 0; i--) {
            if (binNum[i] != 0) {
                oneCount--;
                cnt--;
                int j = (1 << i);
                num1 ^= j;
                k += j;
                if (oneCount == 0) {
                    return k;
                }
                num2 = toNum(oneCount);
                if (cnt <= oneCount && num1 <= num2) {
                    return k + num2;
                }
            }
        }
        return k + toNum(oneCount);
    }

    public static int toNum(int oneCount) {
        return (1 << oneCount) - 1;
    }

    public static int countOne(int num) {
        int n = 0;
        for (int i = 0; i < 31; i++) {
            n += (num >> i) & 1;
        }
        return n;
    }
}
