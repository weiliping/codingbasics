package com.algorithm.selfpractice.round3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class WordBreak {

    public boolean wordBreakII(String s, List<String> wordDict) {
        for (String w : wordDict) {
            int slen = w.length();
            while (s.indexOf(w) > -1) {
                int start = s.indexOf(w);
                int l = s.length();
                String pre = "";
                if (start + slen == l) {
                    pre = s.substring(0, start);
                }
                s = pre + s.substring(start + slen);
            }
        }
        return s.length() == 0;
    }

    public static int[] moveZeros(int[] nums) {
        int zeroIndx = -1, n = nums.length;
        for (int j = 0; j < n; j++) {
            if (nums[j] != 0) {
                if (zeroIndx == -1) {
                    continue;
                }
                nums[zeroIndx] = nums[j];
                nums[j] = 0;
                zeroIndx++;
                continue;
            }
            if (zeroIndx != -1) {
                continue;
            }
            zeroIndx = j;
        }
        return nums;
    }

    public static List<List<String>> worldBreak(String words, List<String> dicts) {
        List<List<String>> res = new ArrayList<>();
        int n = words.length();
        boolean[] visited = new boolean[n + 1];
        dfsHelper(words, 0, res, new ArrayList<>(), dicts, n, visited);
        return res;
    }

    static void dfsHelper(String words, int index, List<List<String>> res, List<String> subRes, List<String> dicts, int len, boolean[] dp) {
        if (dp[index]) {
            return;
        }

        if (index == len) {
            res.add(new ArrayList<>(subRes));
            return;
        }
        dp[index] = true;
        for (String w : dicts) {
            int sLen = w.length();
            int nextIndex = index + sLen;
            if (nextIndex > len) {
                continue;
            }
            if (w.equals(words.substring(index, nextIndex))) {
                subRes.add(w);
                dfsHelper(words, nextIndex, res, subRes, dicts, len, dp);
                subRes.remove(subRes.size() - 1);
            }
        }
    }

    public static boolean wordBreakI(String s, List<String> wordDict) {
        int n = s.length();
        LinkedList<Integer> queue = new LinkedList<>();
        queue.offer(0);
        boolean[] dp = new boolean[n + 1];
        while(!queue.isEmpty()) {
            Integer ind = queue.poll();
            if (!dp[ind]) {
                for (String w : wordDict) {
                    int nextIndex = ind + w.length();
                    if (nextIndex > n) {
                        continue;
                    }
                    if (w.equals(s.substring(ind, nextIndex))) {
                        if (nextIndex == n) {
                            return true;
                        }
                        queue.offer(nextIndex);
                    }
                }
                dp[ind] = true;
            }
        }
        return false;
    }

    public static boolean canPartition(int[] nums) {
        int n = nums.length, sum = 0;

        for (int i = 0; i < n; i++) {
            sum += nums[i];
        }

        if ((sum & 1) != 0) {
            return false;
        }

        int target = (sum >> 1);

        boolean[] dp = new boolean[target + 1];
        dp[0] = true;
        for (int i = 0; i < n; i++) {
            for (int j = target; j >= nums[i]; j--) {
                dp[j] |= dp[j - nums[i]];
            }
        }

        return dp[target];
    }

    public static boolean canPartitionKSubsets(int[] nums, int k) {
        int n = nums.length, sum = 0;

        for (int num : nums) {
            sum += num;
        }

        if (sum % k != 0) {
            return false;
        }
        int target = sum / k;
        Arrays.sort(nums);

        if (nums[n - 1] > target) {
            return false;
        }

        int len = (1 << n);
        boolean[] dp = new boolean[len];
        dp[0] = true;
        int[] sums = new int[len];

        for (int i = 0; i < len; i++) {
            if (!dp[i]) {
                continue;
            }

            for (int j = 0; j < n; j++) {
                int t = (1 << j);
                if ((i & t) != 0) {
                    continue;
                }

                int next = (i | t);
                if (dp[next]) {
                    continue;
                }

                if ((sums[i] % target + nums[j]) > target) {
                    break;
                }
                sums[next] = sums[i] + nums[j];
                dp[next] = true;
            }
        }
        return dp[len - 1];
    }

    public static List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        dfs(res, 0, new ArrayList<>(), s.length(), s);
        return res;
    }

    static void dfs(List<List<String>> res, int start, List<String> subRes, int n, String s) {
        if (start == n) {
            res.add(new ArrayList<>(subRes));
            return;
        }

        for (int i = start; i < n; i++) {
            String sub = s.substring(start, i + 1);
            if (!isPerm(sub)) {
                continue;
            }
            subRes.add(sub);
            dfs(res, i + 1, subRes, n, s);
            subRes.remove(subRes.size() - 1);
        }
    }

    static boolean isPerm(String s) {
        int i = 0, j = s.length() - 1;
        while (i <= j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

//    public List<String> wordBreak(String s, List<String> wordDict) {
//        List<String> res = new ArrayList<>();
//
//    }

    public static void main(String[] args) {
//        WordBreak w = new WordBreak();
        //        System.out.println(w.wordBreak("leetcode", Arrays.asList("leet", "code")));
        //        System.out.println(w.wordBreak("applepenapple", Arrays.asList("apple", "pen")));
        //        System.out.println(w.wordBreak("catsanddog", Arrays.asList("cats", "dog", "sand", "cat")));
        //        System.out.println(Arrays.toString(moveZeros(new int[] {0, 1, 0, 3, 2})));
        //        System.out.println(Arrays.toString(moveZeros(new int[] {1, 0, 0, 0, 3, 5, 0, 7})));
        //        List<List<String>> res = worldBreak("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab",
        //                Arrays.asList("a", "aa", "aaa", "aaaa", "aaaaa", "aaaaaa", "aaaaaaa", "aaaaaaaa", "aaaaaaaaab",
        //                        "aaaaaaaaaa"));
        //        for (List<String> r : res) {
        //            System.out.println(Arrays.toString(r.toArray()));
        //        }
        //        System.out.println(wordBreakI(
        //                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab",
        //                Arrays.asList("a", "aa", "aaa", "aaaa", "aaaaa", "aaaaaa", "aaaaaaa", "aaaaaaaa", "aaaaaaaaab",
        //                        "aaaaaaaaaa")));
//        System.out.println(canPartition(new int[] { 1, 5, 11, 5 }));
//        System.out.println(canPartition(new int[] { 1, 2, 3, 8}));
//        System.out.println(canPartitionKSubsets(new int[]{4, 3, 2, 3, 5, 2, 1}, 4));
//        System.out.println(add(3, 3));
//        System.out.println(removeKDigits("1432219", 3));
//        System.out.println(removeKDigits("10200", 1));
//        System.out.println(removeKDigits("10", 1));
//        System.out.println(removeKDigits("9", 1));
//        System.out.println(removeKDigits("112", 1));
//        System.out.println(removeKDigits("1111111", 3));
//        System.out.println(removeKDigits("12345", 2));

//        System.out.println(multiply("123", "456"));
//        System.out.println(longestSubstring("bbbbb"));
//        System.out.println(longestSubstring("abcabcbb"));
//        System.out.println(longestSubstring("pwwkew"));
//        System.out.println(longestSubstring(" "));
//        System.out.println(longestSubstring("au"));
//        System.out.println(longestSubstring("aabaab!bb"));
//        System.out.println(shortestPalindrome("aacecaba"));
//        System.out.println(nextCloseTime("13:22"));
//        System.out.println(nextCloseTime("13:59"));
//        System.out.println(nextCloseTime("19:54"));
        System.out.println(nextCloseTime("09:59"));
        System.out.println(nextCloseTime("09:58"));
//        System.out.println(nextCloseTime("01:59"));
//        System.out.println(nextCloseTime("01:00"));
//        System.out.println(nextCloseTime("23:39"));
//        System.out.println(nextCloseTime("23:31"));
    }

    public static String shortestPalindrome(String s) {
        int l = 0, n = s.length();

        for (int j = n - 1; j >= 0; j--) {
            if (s.charAt(l) == s.charAt(j)) {
                l++;
            }
        }

        if (l == n) {
            return s;
        }

        String post = s.substring(l);
        String prefix = new StringBuilder(post).reverse().toString();
        return prefix + shortestPalindrome(s.substring(0, l)) + post;
    }

    static int[] maxHours = new int[]{9, 9, 3};

    public static String nextCloseTime(String time) {
        int[] nums = new int[4];
        int k = 0, min = 10;
        for (Character c : time.toCharArray()) {
            if (c != ':') {
                nums[k] = c - '0';
                if (min > nums[k]) {
                    min = nums[k];
                }
                k++;
            }
        }

        int next = getNextNum(nums, nums[3]);
        StringBuilder sb = new StringBuilder();
        if (next > nums[3] && next <= 9) {
            sb.append(time, 0, 4);
            sb.append(next);
            return sb.toString();
        }

        next = getNextNum(nums, nums[2]);
        if (next > nums[2] && next <= 5) {
            sb.append(time, 0, 3);
            sb.append(next);
            sb.append(min);
            return sb.toString();
        }

        next = getNextNum(nums, nums[1]);
        int max = maxHours[nums[0]];
        if (next > nums[1] && next <= max) {
            sb.append(nums[0]);
            sb.append(next);
            sb.append(':');
            sb.append(min);
            sb.append(min);
            return sb.toString();
        }

        next = getNextNum(nums, nums[0]);
        if (next > nums[0] && next <= 2) {
            sb.append(next);
            sb.append(min);
            sb.append(':');
            sb.append(min);
            sb.append(min);
            return sb.toString();
        }

        sb.append(min);
        sb.append(min);
        sb.append(':');
        sb.append(min);
        sb.append(min == 0 ? getNextNum(nums, 0) : min);
        return sb.toString();
    }

    public static int getNextNum(int num[], int curTime) {
        int next = curTime;
        for (int i = 0; i < 4; i++) {
            if (num[i] > curTime) {
                if (next == curTime || next > num[i]) {
                    next = num[i];
                }
            }
        }
        return next;
    }

    public static int longestSubstring(String s) {
        int n = s.length();
        if (n < 1) {
            return n;
        }
        Set<Character> sets = new HashSet<>();

        int l = 0, r = 0, res = 0;

        for (; r < n; r++) {
            char c = s.charAt(r);
            if (!sets.contains(c)) {
                sets.add(c);
                if (r == n - 1) {
                    res = Math.max(res, sets.size());
                }
                continue;
            }
            res = Math.max(res, sets.size());

            while (l < r) {
                char leftCh = s.charAt(l++);
                if (leftCh == c) {
                    break;
                }
                sets.remove(leftCh);
            }
        }
        return res;
    }

    public static int add(int num1, int num2) {
        if (num2 == 0) {
            return num1;
        }

        int sum = num1 ^ num2;
        int carry = (num1 & num2) << 1;
        return add(sum, carry);
    }

    public static String removeKDigits(String num, int k) {
        return dfs(removePreZero(num), k);
    }

    static String dfs(String num, int k) {
        if (num.length() == 0) {
            return "0";
        }

        if (k == 0) {
            return num;
        }

        if (num.length() == 1) {
            return "0";
        }

        int i = 0, n = num.length();
        while (i < n - 1) {
            if (num.charAt(i) > num.charAt(i + 1)) {
                break;
            }
            i++;
        }

        String nextStr = num.substring(0, i) + num.substring(i + 1);
        return dfs(removePreZero(nextStr), k - 1);
    }

    static String removePreZero(String num) {
        int i = 0, n = num.length();
        while (i < n) {
            if (num.charAt(i) != '0') {
                break;
            }
            i++;
        }
        return num.substring(i);
    }

    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length, l = matrix[0][0], r = matrix[n - 1][n - 1];

        while (l <= r) {
            int mid = l + ((r - l) >> 1);
            int[] res = countLess(matrix, mid, n, l, r);

            if (res[0] == k) {
                return res[1];
            }

            if (res[0] < k) {
                l = res[2];
            } else {
                r = res[1];
            }
        }
        return l;
    }

    static int[] countLess(int[][] matrix, int mid, int n, int l, int r) {
        int row = n - 1, col = 0, count = 0;
        while (row >= 0 && col < n) {
            while (matrix[row][col] > mid) {
                r = Math.min(matrix[row][col], r);
                row--;
                continue;
            }
            count += row + 1;
            l = Math.max(l, matrix[row][col]);
            col++;
        }
        return new int[] {count, l, r};
    }

    public static String multiply(String num1, String num2) {
        int m = num1.length(), n = num2.length(), len = m + n;

        int[] res = new int[len];

        String str1 = new StringBuilder(num1).reverse().toString();
        String str2 = new StringBuilder(num2).reverse().toString();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                res[i + j] += (str1.charAt(i) - '0') * (str2.charAt(j) - '0');
            }
        }

        for (int i = 0; i < len - 1; i++) {
            int t = res[i];
            res[i] = t % 10;
            res[i + 1] += t / 10;
        }

        StringBuilder s = new StringBuilder();
        int i = len - 1;
        while (i >= 0) {
            if (res[i] != 0) {
                break;
            }
            i--;
        }

        for (; i >= 0; i--) {
            s.append(res[i]);
        }
        return s.toString();
    }
}

