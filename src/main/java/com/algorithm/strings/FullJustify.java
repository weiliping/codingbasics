package com.algorithm.strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FullJustify {

    /**
     * #68
     * https://leetcode-cn.com/problems/text-justification/
     *
     * @param args
     */
    public static void main(String[] args) {
        String[] words = new String[] { "This", "is", "an", "example", "of", "text", "justification." };
        System.out.println(Arrays.toString(fullJustify(words, 16).toArray()));
    }

    public static List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<>();
        if (words == null) {
            return res;
        }
        int i = 0, l = words.length;

        while (i < l) {
            int j = i + 1;
            int length = words[i].length();
            StringBuilder s = new StringBuilder(words[i]);
            while (j < l && length + words[j].length() + (j - i) <= maxWidth) {
                length += words[j].length();
                j++;
            }
            boolean isLastLine = (j == l);
            boolean isOneWord = (j == i + 1);
            int average = (isLastLine || isOneWord) ? 1 : (maxWidth - length) / (j - i - 1);
            int extra = (isLastLine || isOneWord) ? 0 : (maxWidth - length) % (j - i - 1);
            for (int k = i + 1; k < j; k++) {
                char[] tmp = new char[extra > 0 ? average + 1 : average];
                Arrays.fill(tmp, ' ');
                s.append(tmp).append(words[k]);
                extra--;
            }
            if (maxWidth > s.length()) {
                char[] tmp = new char[maxWidth - s.length()];
                Arrays.fill(tmp, ' ');
                s.append(tmp);
            }
            res.add(s.toString());
            i = j;
        }
        return res;
    }
}
