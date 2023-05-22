package com.algorithm.contest.weeklycontest218;

public class Interpret {
    public static void main(String[] args) {
        Interpret i = new Interpret();
        System.out.println(i.interpret("G()()()()(al)"));
    }
    public String interpret(String command) {
        StringBuilder sb = new StringBuilder();
        char[] chrs = command.toCharArray();
        int i = 0, n = chrs.length;
        while (i < n) {
            if (chrs[i] == 'G') {
                sb.append(chrs[i++]);
                continue;
            }
            if (chrs[i] == '(' && chrs[i + 1] == ')') {
                sb.append('o');
                i += 2;
                continue;
            }
            sb.append("al");
            i += 4;
        }
        return sb.toString();
    }
}
