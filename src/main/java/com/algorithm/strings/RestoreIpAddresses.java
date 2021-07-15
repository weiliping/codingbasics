package com.algorithm.strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RestoreIpAddresses {

    /**
     * #93
     * https://leetcode-cn.com/problems/restore-ip-addresses/
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(Arrays.toString(restoreIpAddresses("25525511135").toArray()));
        System.out.println(Arrays.toString(restoreIpAddressesII("25525511135").toArray()));
    }

    public static List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        helper(s, 0, "", res);
        return res;
    }

    static void helper(String s, int n, String out, List<String> res) {
        if (n == 4) {
            if (s == null || s.length() == 0) {
                res.add(out);
            }
            return;
        }
        for (int k = 1; k < 4; k++) {
            if (s.length() < k) {
                break;
            }
            String ipPart = s.substring(0, k);
            int val = Integer.valueOf(ipPart);

            if (val > 255 || String.valueOf(val).length() != k) {
                continue;
            }
            StringBuilder sb = new StringBuilder();
            sb.append(out).append(ipPart).append(n == 3 ? "" : ".");
            helper(s.substring(k), n + 1, sb.toString(), res);
        }
    }

    public static List<String> restoreIpAddressesII(String s) {
        List<String> res = new ArrayList<>();
        helperII(s, 4, "", res);
        return res;
    }

    static void helperII(String s, int k, String out, List<String> res) {
        if (k == 0) {
            if(s == null || s.length() == 0) {
                res.add(out);
            }
            return;
        }

        for (int i = 1; i < 4; i++) {
            if (s.length() >= i) {
                String ipPart = s.substring(0, i);
                if (isValid(ipPart)) {
                    StringBuilder sb = new StringBuilder(out);
                    sb.append(ipPart);
                    if (k > 1) {
                        sb.append(".");
                    }
                    helperII(s.substring(i), k - 1, sb.toString(), res);
                }
            }
        }
    }

    static boolean isValid(String ipPart) {
        if (ipPart == null || ipPart.length() == 0) {
            return false;
        }
        int intVal = Integer.valueOf(ipPart);
        if (!ipPart.equals(String.valueOf(intVal))) {
            return false;
        }
        return intVal <= 255 && intVal >= 0;
    }
}
