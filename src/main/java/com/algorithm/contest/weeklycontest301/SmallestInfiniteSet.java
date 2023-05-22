package com.algorithm.contest.weeklycontest301;

public class SmallestInfiniteSet {
    private boolean[] delNums = new boolean[1001];

    public static void main(String[] args) {
        SmallestInfiniteSet se = new SmallestInfiniteSet();
        se.popSmallest();
        se.popSmallest();
        se.addBack(3);
        se.popSmallest();
        se.addBack(2);
        se.popSmallest();
        se.popSmallest();
    }

    public SmallestInfiniteSet() {
    }

    public int popSmallest() {
        for (int i = 1; i <= 1000; i++) {
            if (!delNums[i]) {
                delNums[i] = true;
                return i;
            }
        }
        return -1;
    }

    public void addBack(int num) {
        delNums[num] = false;
    }
}
