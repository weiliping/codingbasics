package com.algorithm.hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Anagrams {

    /**
     * #49
     * https://leetcode-cn.com/problems/group-anagrams/
     *
     * @param args
     */
    public static void main(String[] args) {
        String[] strs = new String[] { "eat", "tea", "tan", "ate", "nat", "bat" };
        List<List<String>> anagramsStr = new Anagrams().groupAnagrams(strs);
        for (List<String> ss : anagramsStr) {
            System.out.println(Arrays.toString(ss.toArray()));
        }
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) {
            return new ArrayList<>();
        }
        Map<String, List<String>> tmpRes = new HashMap<>();

        for (String str : strs) {
            String hashKey = toHashKey(str);
            List<String> subList = tmpRes.get(hashKey);
            if (subList == null) {
                subList = new ArrayList<String>();
            }
            subList.add(str);
            tmpRes.put(hashKey, subList);
        }
        return new ArrayList<List<String>>(tmpRes.values());
    }

    public static String toHashKey(String str) {
        if (str == null || str.trim() == "") {
            return "";
        }

        int[] wordsCount = new int[26];
        char[] strChars = str.toCharArray();
        for (char c : strChars) {
            wordsCount[c - 'a']++;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < wordsCount.length; i++) {
            if (wordsCount[i] == 0) {
                continue;
            }
            sb.append((char) ('a' + i)).append(wordsCount[i]);
        }
        return sb.toString();
    }
}
