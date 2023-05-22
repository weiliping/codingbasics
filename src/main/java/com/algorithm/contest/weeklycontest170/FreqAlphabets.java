package com.algorithm.contest.weeklycontest170;

public class FreqAlphabets {

    public static void main(String[] args) {
        FreqAlphabets f = new FreqAlphabets();
        System.out.println(f.freqAlphabets("10#11#12"));
        System.out.println(f.freqAlphabets("1326#"));
        System.out.println(f.freqAlphabets("25#"));
        System.out.println(f.freqAlphabets("12345678910#11#12#13#14#15#16#17#18#19#20#21#22#23#24#25#26#"));
    }

    public String freqAlphabets(String s) {
        StringBuilder sb = new StringBuilder();
        int j = s.length() - 1;
        while (j >= 0) {
            if (s.charAt(j) == '#') {
                sb.append(toChar(s.substring(j - 2, j)));
                j -= 3;
                continue;
            }
            sb.append(toChar(s.substring(j, j + 1)));
            j--;
        }
        return sb.reverse().toString();
    }

    static char toChar(String s) {
        return (char) ('a' + Integer.parseInt(s) - 1);
    }
}
