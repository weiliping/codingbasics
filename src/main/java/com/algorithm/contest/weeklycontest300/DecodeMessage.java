package com.algorithm.contest.weeklycontest300;

import java.util.Arrays;

public class DecodeMessage {

    public static void main(String[] args) {

    }

    public static String decodeMessage(String key, String message) {
        int[] mapKeys = new int[26];
        Arrays.fill(mapKeys, -1);
        int i = 0;
        for (char ch : key.toCharArray()) {
            if (ch == ' ') {
                continue;
            }
            int ind = ch - 'a';
            if (mapKeys[ind] == -1) {
                mapKeys[ch - 'a'] = i++;
                if (i >= 26) {
                    break;
                }
            }
        }

        char[] mChrs = message.toCharArray();
        int n = mChrs.length;
        for (int j = 0; j < n; j++) {
            if (mChrs[j] == ' ') {
                continue;
            }
            int ind = mChrs[j] - 'a';
            mChrs[j] = (char) (mapKeys[ind] + 'a');
        }
        return String.valueOf(mChrs);
    }

}
