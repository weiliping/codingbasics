package com.algorithm.contest.weeklycontest179;

public class GenerateTheString {

    public static void main(String[] args) {
        GenerateTheString g = new GenerateTheString();
        System.out.println(g.generateTheString(2));
        System.out.println(g.generateTheString(3));
        System.out.println(g.generateTheString(4));
        System.out.println(g.generateTheString(5));
        System.out.println(g.generateTheString(6));
        System.out.println(g.generateTheString(500));
    }
    public String generateTheString(int n) {
        if (n == 1) {
            return "a";
        }
        StringBuilder sb = new StringBuilder();
        char c = 'z';
        sb.append(c);
        c = (char)(c - 1);
        if ((n & 1) == 1) {
            --n;
            sb.append(c);
            c = (char)(c - 1);
        }
        while (--n > 0) {
            sb.append(c);
        }
        return sb.toString();
    }
}
