package com.algorithm.divideandconquer;

import java.math.BigDecimal;
import java.util.Arrays;

public class Test {
//    3.8615 -> 3.862
//    3.1245 -> 3.124
//    3.7377 -> 3.738
//    3.3912 -> 3.391
//    3.2475 -> 3.248
//    3.7565 -> 3.756
//    5.88501 -> 5.89
    public static void main(String[] args) {
        System.out.println(String.valueOf(3.8615));
        System.out.println(Arrays.toString("3.8615".split("\\.")));
//        System.out.println(round(3.8615, 3)); // 3.862
//        System.out.println(round(3.1245, 3)); // 3.124
        System.out.println(round(-3.7377, 3)); // 3.738

//        System.out.println(round(3.3912, 3)); // 3.391
//        System.out.println(round(3.2475, 3)); // 3.248
//        System.out.println(round(3.7565, 3)); // 3.756
//        System.out.println(round(5.88501, 2)); // 5.89
    }

    public static BigDecimal round(double f, int k) {
        String s = String.valueOf(f);
        String[] nums = s.split("\\.");

        String fl = nums[1];
        if (fl.length() <= k) {
            return new BigDecimal(f);
        }
        int lastNum = fl.charAt(k) - '0';
        if (lastNum < 5) {
            nums[1] = nums[1].substring(0, k);
            return new BigDecimal(nums[0] + "." + nums[1]);
        }

        if (lastNum > 5) {
            nums[1] = nums[1].substring(0, k);
            float c = (float) 0.1;
            int i = k;
            while (i > 0) {
                c *= 0.1;
                i--;
            }
            if (nums[1] != null) {
                return new BigDecimal(nums[0] + "." + nums[1]).add(new BigDecimal(c));
            } else {
                return new BigDecimal(nums[0]).add(new BigDecimal(c));
            }
        }


        return BigDecimal.ZERO;
    }


}
