package com.algorithm.contest.weeklycontest194;

public class XorOperation {
    public static void main(String[] args) {
        XorOperation x = new XorOperation();

        System.out.println(x.xorOperation(5, 0));
        System.out.println(x.xorOperation(4, 3));
        System.out.println(x.xorOperation(1, 7));
        System.out.println(x.xorOperation(10, 5));
    }
    public int xorOperation(int n, int start) {
        int r = start;
        for (int i = 1; i < n; i++) {
            r ^= (start + i * 2);
        }
        return r;
    }
}
