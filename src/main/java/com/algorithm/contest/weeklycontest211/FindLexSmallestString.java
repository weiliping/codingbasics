package com.algorithm.contest.weeklycontest211;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

public class FindLexSmallestString {
    public static void main(String[] args) {
        FindLexSmallestString f = new FindLexSmallestString();
        System.out.println(f.findLexSmallestString("43987654", 7, 3));
        System.out.println(f.findLexSmallestString("0011", 4, 2));
        System.out.println(f.findLexSmallestString("74", 5, 1));
        System.out.println(f.findLexSmallestString("5525", 9, 2));
    }

    public String findLexSmallestString(String s, int a, int b) {
        Set<String> visits = new HashSet<>();
        Queue<String> q = new ArrayDeque<>();

        visits.add(s);
        q.offer(s);
        String res = s;

        while (!q.isEmpty()) {
            String t = q.poll();

            if (res.compareTo(t) > 0) {
                res = t;
            }

            char[] chs = t.toCharArray();

            for (int i = 1; i < chs.length; i += 2) {
                chs[i] = (char) (((chs[i] - '0') + a) % 10 + '0');
            }

            String temp = new String(chs);
            if (!visits.contains(temp)) {
                visits.add(temp);
                q.offer(temp);
            }

            String temp1 = temp.substring(b) + temp.substring(0, b);
            if (!visits.contains(temp1)) {
                visits.add(temp1);
                q.offer(temp1);
            }
        }
        return res;
    }
}
