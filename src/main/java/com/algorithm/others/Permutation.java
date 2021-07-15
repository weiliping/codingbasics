package com.algorithm.others;

import java.util.Arrays;

public class Permutation {
    public static void perm(String[] list, int n) {
        if (n == 1) {
            System.out.println(Arrays.toString(list));
        } else {
            for (int i = 0; i < n; i++) {
                perm(list, n - 1);

                int j = (n % 2 == 0) ? i : 0;

                String t = list[n - 1];
                list[n - 1] = list[j];
                list[j] = t;
            }
        }
    }

    public static void main(String[] args) {

        String[] list =
                new String[] { "dhvf", "sind", "ffsl", "yekr", "zwzq", "kpeo", "cila", "tfty", "modg", "ztjg", "ybty",
                        "heqg", "cpwo", "gdcj", "lnle", "sefg", "vimw", "bxcb" };
        System.out.println(list.length);
        //        perm(list, list.length);

    }
}
