package com.algorithm.contest.biweeklycontest56;

public class CountTriples {
    public static void main(String[] args) {
        CountTriples c = new CountTriples();
        System.out.println(c.countTriples(10));
        System.out.println(c.countTriples(5));
        System.out.println(c.countTriples(20));
        System.out.println(c.countTriples(250));
    }
    public int countTriples(int n) {
        int cnt = 0;
        for (int i = 1; i <= n - 2; i++) {
            for (int j = i + 1; j <= n - 1; j++) {
                for (int k = j + 1; k <= n; k++) {
                    if (i * i + j * j == k * k) {
                        cnt += 2;
                    }
                }
            }
        }
        return cnt;
    }
}
