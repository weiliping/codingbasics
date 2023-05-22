package com.algorithm.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/longest-subsequence-repeated-k-times/
 * 给你一个长度为 n 的字符串 s ，和一个整数 k 。请你找出字符串 s 中 重复 k 次的 最长子序列 。
 * 子序列 是由其他字符串删除某些（或不删除）字符派生而来的一个字符串。
 * 如果 seq * k 是 s 的一个子序列，其中 seq * k 表示一个由 seq 串联 k 次构造的字符串，那么就称 seq 是字符串 s 中一个 重复 k 次 的子序列。
 * 举个例子，"bba" 是字符串 "bababcba" 中的一个重复 2 次的子序列，因为字符串 "bbabba" 是由 "bba" 串联 2 次构造的，而 "bbabba" 是字符串 "bababcba" 的一个子序列。
 * 返回字符串 s 中 重复 k 次的最长子序列  。如果存在多个满足的子序列，则返回 字典序最大 的那个。如果不存在这样的子序列，返回一个 空 字符串。
 *  
 * 示例 1：
 * 输入：s = "letsleetcode", k = 2
 * 输出："let"
 * 解释：存在两个最长子序列重复 2 次：let" 和 "ete" 。
 * "let" 是其中字典序最大的一个。
 * 示例 2：
 * 输入：s = "bb", k = 2
 * 输出："b"
 * 解释：重复 2 次的最长子序列是 "b" 。
 * 示例 3：
 * 输入：s = "ab", k = 2
 * 输出：""
 * 解释：不存在重复 2 次的最长子序列。返回空字符串。
 * 示例 4：
 * 输入：s = "bbabbabbbbabaababab", k = 3
 * 输出："bbbb"
 * 解释：在 "bbabbabbbbabaababab" 中重复 3 次的最长子序列是 "bbbb" 。
 *  
 * 提示：
 * n == s.length
 * 2 <= k <= 2000
 * 2 <= n < k * 8
 * s 由小写英文字母组成
 */
public class LongestSubsequenceRepeatedK {
    public static void main(String[] args) {
        System.out.println(longestSubsequenceRepeatedKBest("letsleetcode", 2));
        System.out.println(longestSubsequenceRepeatedKBest("bbabbabbbbabaababab", 3));
        System.out.println(longestSubsequenceRepeatedKBest("bb", 2));
        System.out.println(longestSubsequenceRepeatedKBest("ab", 2));
        System.out.println(longestSubsequenceRepeatedKBest("gbjbjigjbji", 2)); //"gjbji"
        System.out.println(longestSubsequenceRepeatedKBest("babbbaabbabab", 2));
        System.out.println(longestSubsequenceRepeatedKBest("sjnjhjjjvkake", 5));
        System.out.println(longestSubsequenceRepeatedKBest(
                "exhmepeeeeeekeeetelqyeeeeudtdsjeeyeweeeeekqeizesieqnddzeaefqeyeeezesxfreveeeeyeeeseregoneiftemerujfveysezkeeiofsbeeerheueeehedkluoedeeemeweeekeefeqaleb"
                , 65));
        System.out.println(longestSubsequenceRepeatedKBest(
                "mnmememteatmembemexnmsmhbemnemjevmremqentememzoeqmemyememememqememtylehqmemetsmemememememjemtembempeemoemsyememnjsemhemeumekldhmfememszemefememuemtedmemejmevmememejxmtpnemegyzbg",
                        54));
        System.out.println(longestSubsequenceRepeatedKBest(
                "hhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiijjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkklllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnn",
                251));
    }

    public static String longestSubsequenceRepeatedK(String s, int k) {
        char[] chrs = s.toCharArray();
        int n = chrs.length;
        if (n < k) {
            return "";
        }
        int[] cnts = new int[26];
        for (int i = 0; i < n; i++) {
            cnts[chrs[i] - 'a']++;
        }
        int cnt = 0;
        Map<Character, Integer> mp = new HashMap<>();
        for (int i = 0; i < 26; i++) {
            int t = cnts[i] / k;
            if (t > 0) {
                mp.put((char) ('a' + i), t);
                cnt += t;
            }
        }
        char[] cntChrs = new char[cnt];
        int j = 0;
        for (Character c : mp.keySet()) {
            for (int i = 0; i < mp.get(c); i++) {
                cntChrs[j++] = c;
            }
        }
        Arrays.sort(cntChrs);
        int reCnt = 0;
        while (cnt > reCnt) {
            for (int delInd = 0; delInd < n - reCnt + 1; delInd++) {
                Set<Integer> delSet = new HashSet<>();
                int t = 0;
                while (t < reCnt) {
                    delSet.add(delInd + t);
                    t++;
                }
                Set<String> set = new HashSet<>();
                dfsHelper(cntChrs, set, 0, cnt, delSet);
                List<String> subRes = new ArrayList<>(set);
                Collections.sort(subRes);
                for (int i = subRes.size() - 1; i >= 0; i--) {
                    String sub = subRes.get(i);
                    if (dfs(chrs, k, sub.toCharArray(), 0, n)) {
                        return sub;
                    }
                }
            }
            reCnt++;
        }
        return "";
    }

    static void dfsHelper(char[] chrs, Set<String> res, int sInd, int n, Set<Integer> delSet) {
        if (sInd == n - 1) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < chrs.length; i++) {
                if (delSet.contains(i)) {
                    continue;
                }
                sb.append(chrs[i]);
            }
            res.add(sb.toString());
            return;
        }

        for (int i = sInd; i < n; i++) {
            if (!delSet.contains(i) && !delSet.contains(sInd)) {
                swap(chrs, sInd, i);
                dfsHelper(chrs, res, sInd + 1, n, delSet);
                swap(chrs, i, sInd);
            }
            dfsHelper(chrs, res, sInd + 1, n, delSet);
        }
    }

    static void swap(char[] chrs, int i, int j) {
        char c = chrs[i];
        chrs[i] = chrs[j];
        chrs[j] = c;
    }

    static boolean dfs(char[] s, int k, char[] chrs, int sInd, int n) {
        if (k == 0) {
            return true;
        }

        if (sInd == n) {
            return false;
        }

        int j = 0;
        for (int i = sInd; i < n; i++) {
            if (chrs[j] != s[i]) {
                continue;
            }
            j++;
            if (j == chrs.length) {
                return dfs(s, k - 1, chrs, i + 1, n);
            }
        }
        return false;
    }

    static List<String> getTargetStr(char[] chrs, Map<Character, Integer> mp, int n, int len) {
        List<Character> cs = new ArrayList<>();
        List<String> res = new ArrayList<>();
        int i = 0, j = 0;
        for (; i < n; i++) {
            if (mp.containsKey(chrs[i])) {
                if (mp.get(chrs[i]) > 0) {
                    cs.add(chrs[i]);
                    mp.put(chrs[i], mp.get(chrs[i]) - 1);
                    len--;
                    if (len == 0) {
                        StringBuilder sb = new StringBuilder();
                        for (Character c : cs) {
                            sb.append(c);
                        }
                        res.add(sb.toString());
                    }
                }
            }
            while (len == 0) {
                if (cs.contains(chrs[j])) {
                    cs.remove((Character) chrs[j]);
                    mp.put(chrs[j], mp.get(chrs[j]) + 1);
                    len++;
                }
                j++;
            }
        }
        return res;
    }

    public String longestSubsequenceRepeatedKI(String s, int k) {
        String ans = "";
        int[] count = new int[26];
        List<Character> possibleChars = new ArrayList<>();
        // store subseqs, length grows by 1 each time
        Queue<String> q = new LinkedList<>(Arrays.asList(""));

        for (final char c : s.toCharArray()) {
            ++count[c - 'a'];
        }

        for (char c = 'a'; c <= 'z'; ++c) {
            if (count[c - 'a'] >= k) {
                possibleChars.add(c);
            }
        }

        while (!q.isEmpty()) {
            for (int size = q.size(); size > 0; --size) {
                final String currSubseq = q.poll();
                if (currSubseq.length() * k > s.length())
                    return ans;
                for (final char c : possibleChars) {
                    final String newSubseq = currSubseq + c;
                    if (isSubsequence(newSubseq, s, k)) {
                        q.offer(newSubseq);
                        ans = newSubseq;
                    }
                }
            }
        }

        return ans;
    }

    private boolean isSubsequence(final String subseq, final String s, int k) {
        int i = 0; // subseq's index
        for (final char c : s.toCharArray()) {
            if (c == subseq.charAt(i)) {
                if (++i == subseq.length()) {
                    if (--k == 0) {
                        return true;
                    }
                    i = 0;
                }
            }
        }
        return false;
    }

    public static String longestSubsequenceRepeatedKBest(String s, int k) {
        char[] chars = s.toCharArray();
        int[] buc = new int[26];
        for (char ch : chars) {
            buc[ch - 'a']++;
        }
        List<Character> bases = new ArrayList<>();
        Set<String> pres = new HashSet<>();
        String res = "";
        for (int i = 0; i < 26; i++) {
            int cnt = buc[i] / k;
            if (cnt > 0) {
                bases.add((char) (i + 'a'));
                res = String.valueOf((char) (i + 'a'));
                pres.add(res);
            }
        }

        while (pres.size() > 0) {
            Set<String> cur = new HashSet<>();
            for (String pre : pres) {
                int subLen = pre.length();
                int[] subbuc = new int[26];
                for (char subCh : pre.toCharArray()) {
                    subbuc[subCh - 'a']++;
                }
                for (Character ch : bases) {
                    if (buc[ch - 'a'] >= k * (subbuc[ch - 'a'] + 1)) {
                        String newStr = pre + ch;
                        if (check(chars, k, newStr.toCharArray())) {
                            cur.add(newStr);
                            if (subLen + 1 > res.length() || res.compareTo(newStr) < 0) {
                                res = newStr;
                            }
                        }
                    }
                }
            }
            pres = cur;
        }
        return res;
    }

    private static boolean check(char[] chars, int k, char[] subChars) {
        int len = chars.length;
        int subLen = subChars.length;
        int left = 0;
        for (int i = 0; i < len; i++) {
            if (subChars[left] == chars[i]) {
                left++;
                if (left == subLen) {
                    k--;
                    if (k == 0) {
                        return true;
                    }
                    left = 0;
                }
            }
        }
        return false;
    }
}
