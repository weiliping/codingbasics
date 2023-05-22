package com.algorithm.selfpractice.round2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaxNumOfSubstrings {
    public List<String> maxNumOfSubstrings(String s) {
        char[] str = s.toCharArray();

        // left[i], right[i] 表示字符 i 出现的最左/最右位置
        // left[i] = -1 表示未出现过
        int[] left = new int[26];
        int[] right = new int[26];
        Arrays.fill(left, -1);
        for (int i = 0; i < str.length; i++) {
            int c = str[i] - 'a';
            if (left[c] < 0) left[c] = i;
            right[c] = i;
        }

        // 统计出所有符合条件的子串
        // intervalR[i] 表示我们要以字符 i 为左端点时, 右端点的位置
        // intervalR[i] = -1 表示无法做左端点
        int[] intervalR = new int[str.length];
        int count = 0;
        Arrays.fill(intervalR, -1);
        for (int i = 0; i < str.length; i++) {
            int c = str[i] - 'a';
            if (i != left[c]) continue;
            int r = right[c];
            boolean ok = true;
            for (int j = i + 1; j <= r; j++) {
                int c2 = str[j] - 'a';
                if (left[c2] < i) {
                    ok = false;
                    break;
                }
                r = Math.max(r, right[c2]);
            }
            if (ok) {
                intervalR[i] = r;
                count++;
            }
        }

        int[][] intervals = new int[count][2];
        for (int i = 0, j = 0; i < str.length; i++) {
            if (intervalR[i] >= 0) {
                intervals[j][0] = i;
                intervals[j][1] = intervalR[i];
                j++;
            }
        }

        // 现在问题变成了选择最多的不相交的区间
        Arrays.sort(intervals, (o1, o2) -> o1[1] - o2[1]);
        List<String> res = new ArrayList<>();
        int R = -1;
        for (int[] interval : intervals) {
            if (interval[0] > R) {
                R = interval[1];
                res.add(s.substring(interval[0], interval[1] + 1));
            }
        }
        return res;
    }
}
