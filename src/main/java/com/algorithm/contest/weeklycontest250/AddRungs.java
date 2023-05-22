package com.algorithm.contest.weeklycontest250;

public class AddRungs {
    public static void main(String[] args) {
        AddRungs a = new AddRungs();
//        System.out.println(a.addRungs(new int[] {1,3,5,10}, 2));
//        System.out.println(a.addRungs(new int[] {3,6,8,10}, 3));
//        System.out.println(a.addRungs(new int[] {3,4,6,7}, 2));
//        System.out.println(a.addRungs(new int[] {5}, 10));
        System.out.println(a.addRungs(new int[] {4, 6}, 1));
    }

    public int addRungs(int[] rungs, int dist) {
        int pre = 0, cnt = 0, n = rungs.length;
        for (int i = 0; i < n; i++) {
            int diff = rungs[i] - pre;
            if (diff > dist) {
                cnt += diff / dist - 1;
                if (diff % dist != 0) {
                    cnt += 1;
                }
            }
            pre = rungs[i];
        }
        return cnt;
    }
}
