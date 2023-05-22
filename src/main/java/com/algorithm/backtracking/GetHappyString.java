package com.algorithm.backtracking;

public class GetHappyString {

    public static void main(String[] args) {
        System.out.println(getHappyString(1, 3));
        System.out.println(getHappyString(1, 4));
        System.out.println(getHappyString(2, 7));
        System.out.println(getHappyString(3, 9));
        System.out.println(getHappyString(10, 100));
    }
    private static final char[] chs = new char[] {'a', 'b', 'c'};
    private static final char[][] chrs = new char[][] { { 'b', 'c' }, { 'a', 'c' }, { 'a', 'b' } };
    public static String getHappyString(int n, int k) {
        int t = 3, num = 1 << (n - 1);
        int total = t * num;
        if (total < k) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int range = (k - 1) / num;
        char ch = chs[range];
        sb.append(ch);
        if (n == 1) {
            return sb.toString();
        }
        int left = k - (range * num + 1);
        String binString = toBinaryString(left, n - 1);
        char[] binChrs = binString.toCharArray();
        for (char c : binChrs) {
            char cur = chrs[ch - 'a'][c - '0'];
            sb.append(cur);
            ch = cur;
        }
        return sb.toString();
    }

    public static String toBinaryString(int num, int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = n - 1; i >= 0; i--) {
            int mask = 1 << i;
            sb.append((num & mask) != 0 ? "1" : "0");
        }
        return sb.toString();
    }
}
