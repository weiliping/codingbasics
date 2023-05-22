package com.algorithm.greedyalgorithm;

public class CanPlaceFlowers {
    /**
     * #605
     * https://leetcode-cn.com/problems/can-place-flowers/
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(new CanPlaceFlowers().canPlaceFlowers(new int[] { 1, 0, 0, 0, 1 }, 1));
    }

    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (flowerbed == null || n == 0) {
            return true;
        }

        int canFlow = 0, l = flowerbed.length;
        for (int i = 0; i < l; i++) {
            if (flowerbed[i] == 0) {
                boolean left = true;
                if (i - 1 >= 0) {
                    left = flowerbed[i - 1] == 0;
                }
                boolean right = true;
                if (i + 1 < l) {
                    right = flowerbed[i + 1] == 0;
                }
                if (left && right) {
                    canFlow++;
                    i++;
                }
            }
        }
        return canFlow >= n;
    }
}
