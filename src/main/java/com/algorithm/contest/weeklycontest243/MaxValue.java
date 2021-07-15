package com.algorithm.contest.weeklycontest243;

public class MaxValue {
    public static void main(String[] args) {
        MaxValue m = new MaxValue();
        System.out.println(m.maxValue("99", 9));
        System.out.println(m.maxValue("-13", 2));
        System.out.println(m.maxValue("-132", 3));
        System.out.println(m.maxValue("28824579515", 8));
    }
    public String maxValue(String n, int x) {
        StringBuilder sb = new StringBuilder();
        char[] chs = n.toCharArray();
        boolean isPositive = chs[0] != '-';
        int i = isPositive ? 0 : 1;
        for (; i < chs.length; i++) {
            if (isPositive){
                if (x <= (chs[i] - '0')) {
                    continue;
                }
                break;
            }
            if (x >= (chs[i] - '0')) {
                continue;
            }
            break;
        }
        sb.append(n, 0, i);
        sb.append(x);
        sb.append(n, i, chs.length);
        return sb.toString();
    }
}
