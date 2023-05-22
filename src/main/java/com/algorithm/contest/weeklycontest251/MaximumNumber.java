package com.algorithm.contest.weeklycontest251;

public class MaximumNumber {
    public static void main(String[] args) {
        MaximumNumber m = new MaximumNumber();
        String num1 = "021";
        int[] change1 = new int[]{9,4,3,5,7,2,1,9,0,6};
        System.out.println(m.maximumNumber(num1, change1));

        String num2 = "132";
        int[] change2 = new int[]{9,8,5,0,3,6,4,2,6,8};
        System.out.println(m.maximumNumber(num2, change2));

        String num3 = "5";
        int[] change3 = new int[]{1,4,7,5,3,2,5,6,9,4};
        System.out.println(m.maximumNumber(num3, change3));

        String num4 = "214010";
        int[] change4 = new int[]{6,7,9,7,4,0,3,4,4,7};
        System.out.println(m.maximumNumber(num4, change4)); //"974676"

        String num5 = "334111";
        int[] change5 = new int[]{0,9,2,3,3,2,5,5,5,5};
        System.out.println(m.maximumNumber(num5, change5)); //"334999"
    }

    public String maximumNumber(String num, int[] change) {
        char[] chrs = num.toCharArray();
        int n = chrs.length, preI = -1;
        for (int i = 0; i < n; i++) {
            int ind = chrs[i] - '0';
            if (ind > change[ind] || (ind == change[ind] && preI == -1)) {
                continue;
            }
            if (preI == -1 || preI == i - 1) {
                chrs[i] = (char) (change[ind] + '0');
                preI = i;
                continue;
            }
            break;
        }
        return new String(chrs);
    }
}
