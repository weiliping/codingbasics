package com.algorithm.contest.weeklycontest184;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringMatching {

    public static void main(String[] args) {
        StringMatching s = new StringMatching();
        String[] words = new String[]{"mass","as","hero","superhero"};
        System.out.println(Arrays.toString(s.stringMatching(words).toArray()));
    }
    public List<String> stringMatching(String[] words) {
        int n = words.length;
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        List<String> res = new ArrayList<>();
        for (int i = n - 2; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                if (words[j].indexOf(words[i]) > -1) {
                    res.add(words[i]);
                    break;
                }
            }
        }
        return res;
    }
}
