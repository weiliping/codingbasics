package com.algorithm.contest.weeklycontest216;

public class GetSmallestString {
    public static void main(String[] args) {
        GetSmallestString g = new GetSmallestString();
        System.out.println(g.getSmallestString(3, 27));
        System.out.println(g.getSmallestString(5, 73));
    }

    public String getSmallestString(int n, int k) {
        StringBuilder sb = new StringBuilder();
        int c;
        while (n > 0) {
            c = k - (n - 1) * 26;
            if (c <= 0) {
                sb.append('a');
                k--;
                n--;
                continue;
            }

            sb.append((char) ('a' + c - 1));
            k -= c;
            n--;
        }
        return sb.toString();
    }
}
