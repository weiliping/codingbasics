package com.algorithm.treedatastructure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RestoreIpAddresses {
    public static void main(String[] args) {
        RestoreIpAddresses r = new RestoreIpAddresses();
        List<String> res = r.restoreIpAddresses("25525511135");
        System.out.println(Arrays.toString(res.toArray()));
    }

    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<String>();
        dfs(res, new ArrayList<>(), s, s.length(), 0);
        return res;
    }

    void dfs(List<String> res, List<String> subStr, String s, int n, int ind) {
        if (ind == n && subStr.size() == 4) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 4; i++) {
                sb.append(subStr.get(i));
                if (i != 3) {
                    sb.append(".");
                }
            }
            res.add(sb.toString());
            return;
        }

        for (int i = 0; i < 3; i++) {
            if (ind + i + 1 <= n) {
                String ipPart = s.substring(ind, ind + i + 1);
                if (isValidString(ipPart)) {
                    subStr.add(ipPart);
                    dfs(res, subStr, s, n, ind + i + 1);
                    subStr.remove(subStr.size() - 1);
                }
            }
        }
    }

    boolean isValidString(String str) {
        Integer ip = Integer.parseInt(str);
        if (ip == 0) {
            return true;
        }

        if (String.valueOf(ip).length() != str.length()) {
            return false;
        }

        return ip > 0 && ip <= 255;
    }
}
