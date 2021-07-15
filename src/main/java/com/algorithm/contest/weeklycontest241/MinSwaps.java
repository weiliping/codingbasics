package com.algorithm.contest.weeklycontest241;

public class MinSwaps {
    public static void main(String[] args) {
        MinSwaps m = new MinSwaps();
//        System.out.println(m.minSwaps("111000"));
//        System.out.println(m.minSwaps("010"));
//        System.out.println(m.minSwaps("1110"));
        System.out.println(m.minSwaps("00011110110110000000000110110101011101111011111101010010010000000000000001101101010010001011110000001101111111110000110101101101001011000011111011101101100110011111110001100110001110000000001100010111110100111001001111100001000110101111010011001"));
    }
    public int minSwaps(String s) {
        char[] chs = s.toCharArray();
        int[] odd = new int[2];
        int[] even = new int[2];
        for (int i = 0; i < chs.length; i++) {
            if (i % 2 == 0) {
                even[chs[i] - '0']++;
            } else {
                odd[chs[i] - '0']++;
            }
        }
        int totalZero = even[0] + odd[0];
        int totalOne = even[1] + odd[1];
        int diff = Math.abs(totalOne - totalZero);
        if (diff > 1) {
            return -1;
        }

        if (diff == 1) {
            if (totalOne > totalZero) {
                return odd[1];
            }
            return odd[0];
        }

        if (even[0] > even[1]) {
            return even[1];
        }
        return even[0];
    }
}
