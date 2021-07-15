package com.algorithm.strings;

public class CountAndSay {
    /**
     * #38
     * https://leetcode-cn.com/problems/count-and-say
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(new CountAndSay().countAndSay(4));
    }

    public String countAndSay(int n) {
        if (n <= 0) {
            return "";
        }
        String res = "1";

        while (n > 1) {
            StringBuilder cur = new StringBuilder();
            int l = res.length();
            for (int i = 0; i < l; i++) {
                int cnt = 1;
                while (i + 1 < l && res.charAt(i) == res.charAt(i + 1)) {
                    cnt++;
                    i++;
                }
                cur.append(cnt).append(res.charAt(i));
            }
            res = cur.toString();
            n--;
        }
        return res;
    }
}
