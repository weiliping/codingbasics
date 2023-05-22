package com.algorithm.contest.weeklycontest313;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class DeleteString {
    public static void main(String[] args) {
        // System.out.println(deleteString("abcabcdabc"));
        // System.out.println(deleteString1("abcabcdabc"));
        // System.out.println(deleteString("aaabaab"));
        // System.out.println(deleteString("aaaaa"));
        // System.out.println(deleteString(
        // "ilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqzuvkilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqzuvkilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqzuvkilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqzuvkilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqzuvkilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqzuvkilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqzuvkilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqzuvkilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqzuvkilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqzuvkilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqzuvkilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqzuvkilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqzuvkilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqzuvkilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqzuvkilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqzuvkeilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqzuvkilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqzuvkilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqzuvkilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqzuvkilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqzuvkilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqzuvkilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqzuvkilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqzuvkilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqzuvkilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqzuvkilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqzuvkilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqzuvkilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqzuvkilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqzuvkilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqzuvkilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqilqzuvkebqumabhsdwjesovwhqjvphhigtqubeazichenrkipozlnrjpmxojqmonwdwkeyfptfkwcwzyqglgrqoaiufbhcplnrhvljsjqvvcryxfiifzkvdwtrveehprjrycsiljusynfxtgvzhzczqhbmrfutryzguvpmsrsoudxbinfrdwadboontbjjbzbyhextdynmdwhodebxwgcdrvwtttvhuxzqweahbmfecmoawmwunzlltklrcchkvbpkbpfrupkwmbfmbmldefzichboxigbgusfyirfaypemrjqjaprtblyjdyyycqymoxuuwyvbyqeihlysakceywfjqczosimkpkiqyautfymxsgkiagshmdxgsudaijuxcrkbsrcedirltpjhrdozrghtvinqofwomywcharaabfprotzlmfhoxbzbamqypjwrlivyrytehwsmdxpdrlnxdiqagtfmuqvckqabvlmedptfaerixwsnzzzucildclmximjhpkcvvwadzwsquflhznwoeyhtiydbsivhimkynqydfkdjonicpywvtgtmwisetxsyjpuffvkhmdptagagrivjnsabgqoltdypvirauiwgjlupliioletrpthrslwyofyomldadbtqhoczvwczmfcfazncwrsvkotsognwpdcuounqhuhtstfaenrzwmhatnwqzdtqoscuxgxnsavyhplcgqczfamyyzyukfswpnjbyexesuhgmjhzfdrdmcjxcieiejwwenwnwbfxesanttgwarcykrclbzwmyj"));

        // String s =
        // "hhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh";
        // System.out.println(deleteString(s));

        // String s1 =
        // "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
        // System.out.println(deleteString(s1));

        String s3 = "cpsshdiaaaaaaa";
        System.out.println(deleteString(s3));
    }

    public final static int MOD = (int) (1e9 + 7);

    public static int deleteString(String s) {
        int sInd = 0, n = s.length();
        if (allEqual(s.toCharArray())) {
            return n;
        }

        long[] preSum = new long[n + 1];
        long[] pow = new long[n + 1];
        pow[0] = 1;
        for (int i = 0; i < n; i++) {
            preSum[i + 1] = (preSum[i] * 31 + (s.charAt(i) - 'a' + 1)) % MOD;
            pow[i + 1] = (pow[i] * 31) % MOD;
        }

        int[] cnts = new int[n + 1];
        boolean[] visit = new boolean[n];
        dfs(sInd, n, s.toCharArray(), cnts, visit, preSum, pow);
        return cnts[0];
    }

    private static void dfs(int s, int n, char[] chrs, int[] cnts, boolean[] visit, long[] preSum, long[] pow) {
        if (visit[s]) {
            return;
        }
        if (s == n) {
            cnts[s] = 1;
            return;
        }
        int mid = (n - s) >> 1;
        for (int k = 1; k <= mid; k++) {
            long iint = (preSum[s + k] - (preSum[s] * pow[k] % MOD) + MOD) % MOD;
            long jint = (preSum[s + k + k] - (preSum[s + k] * pow[k] % MOD) + MOD) % MOD;

            if (iint == jint) {
                dfs(s + k, n, chrs, cnts, visit, preSum, pow);
                cnts[s] = Math.max(cnts[s], cnts[s + k] + 1);
            }
        }
        cnts[s] = Math.max(cnts[s], 1);
        visit[s] = true;
    }

    private static boolean allEqual(char[] s) {
        for (int i = 1; i < s.length; i++) {
            if (s[i] != s[0]) {
                return false;
            }
        }
        return true;
    }

    public static Map<Integer, Integer> map = new HashMap<>();

    public static int deleteString1(String s) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            set.add(s.charAt(i));
        }
        if (set.size() == 1) {
            return s.length();
        }
        // 记忆化递归
        int start = 0;
        return dfs(s, start);
    }

    private static int dfs(String s, int start) {
        if (start == s.length()) {
            return 1;
        }
        if (map.containsKey(start)) {
            return map.get(start);
        }
        int temp = 0;
        for (int i = start + 1; i <= start + (s.length() - start) / 2; i++) {
            String substring = s.substring(start, i);
            String substring1 = s.substring(i, i + substring.length());
            if (substring.equals(substring1)) {
                temp = Math.max(temp, 1 + dfs(s, i));
            }
        }

        int res = Math.max(temp, 1);
        map.put(start, res);
        return res;
    }
}
