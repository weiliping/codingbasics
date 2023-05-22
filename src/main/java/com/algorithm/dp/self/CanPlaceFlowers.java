package com.algorithm.dp.self;

public class CanPlaceFlowers {

    public static void main(String[] args) {
        System.out.println(canPlaceFlowers(new int[]{1, 0, 0, 0, 1}, 1));
    }

    static boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (flowerbed == null || n == 0) {
            return false;
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
                }
            }
        }
        return canFlow >= n;
    }
}
