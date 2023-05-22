package com.algorithm.contest.biweeklycontest55;

public class RemoveOccurrences {
    public static void main(String[] args) {
        RemoveOccurrences r = new RemoveOccurrences();
        System.out.println(r.removeOccurrences("daabcbaabcbc", "abc"));
        System.out.println(r.removeOccurrences("axxxxyyyyb", "xy"));
    }
    public String removeOccurrences(String s, String part) {
        int ind = s.indexOf(part), len = part.length();
        while (ind > -1) {
            s = s.substring(0, ind) + s.substring(ind + len);
            ind = s.indexOf(part);
        }
        return s;
    }
}
