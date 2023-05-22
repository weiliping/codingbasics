package com.algorithm.contest.biweeklycontest54;

public class IsCovered {
    public static void main(String[] args) {
        int[][] ranges1 = new int[][]{{1,2}, {3,4}, {5,6}};
        int left1 = 2, right1 = 5;
        IsCovered i = new IsCovered();
        System.out.println(i.isCovered(ranges1, left1, right1));
        int[][] ranges2 = new int[][]{{1,10},{10,20}};
        int left2 = 21, right2 = 21;
        System.out.println(i.isCovered(ranges2, left2, right2));
    }

    public boolean isCovered(int[][] ranges, int left, int right) {
        boolean[] nums = new boolean[51];
        for (int[] range : ranges) {
            int s = Math.max(range[0], left);
            int e = Math.min(range[1], right);
            for (int i = s; i<= e; i++) {
                nums[i] = true;
            }
        }

        for (int i = left; i <= right; i++) {
            if (!nums[i]) {
                return false;
            }
        }
        return true;
    }
}
