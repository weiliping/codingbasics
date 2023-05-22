package com.algorithm.contest.weeklycontest255;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RecoverArray {
    public static void main(String[] args) {
        int[] nums = new int[] { 0, 0, 5, 5, 4, -1, 4, 9, 9, -1, 4, 3, 4, 8, 3, 8 };
        int n = 4;
        // System.out.println(Arrays.toString(recoverArray(n, nums)));

        System.out.println(Arrays.toString(recoverArrayII(n, nums)));

        // int[] nums1 = new int[] { -3,-2,-1,0,0,1,2,3 };
        // int n1 = 3;
        // System.out.println(Arrays.toString(recoverArray(n1, nums1)));

        // int[] nums2 = new int[] {0, 0, 0, 0};
        // int n2 = 2;
        // System.out.println(Arrays.toString(recoverArray(n2, nums2)));

        // int[] nums3 = new int[] { -1654, -771, -883, 0 };
        // int n3 = 2;
        // //[-771,-883]
        // System.out.println(Arrays.toString(recoverArray(n3, nums3)));

        // int n4 = 3;
        // int[] nums4 = new int[]{365,44,-355,399,409,764,10,0};
        // //[-355,365,399]
        // System.out.println(Arrays.toString(recoverArray(n4, nums4)));

        // // [-45,-80,-182,276,296,-509,-653,721]

        // // [-45,-80,182,-276,-296,-509,-1374,1111]
        // int n5 = 8;
        // int[] nums5 = new int[] { 408, -307, 86, -886, -164, 784, -377, 49, -1424,
        // 14, 0, 310, -589, 162, 735, 872, -80,
        // 557, -590, -290, 319, -51, -1173, -715, 216, -1207, -392, 333, -437, 539,
        // 276, 459, 522, -233, 527, 390,
        // -472, -388, -521, -486, -1011, -457, -278, 596, -452, -62, -145, -262, -1048,
        // -427, -852, -159, -402,
        // 171, 264, 704, -1287, -210, -126, 345, 114, 1168, 443, -263, -119, -1389,
        // -502, -347, -338, 117, 57,
        // -880, 494, 378, -897, -733, 1066, 212, 1293, -623, 137, 488, 492, 37, -165,
        // 508, -1128, -946, 201, 265,
        // -639, 167, 364, 23, -960, 710, 770, -293, 261, 30, -635, -482, -509, -911,
        // -15, 34, 284, -772, -327,
        // -698, 997, -45, -441, -57, -206, 196, -343, 952, -915, 151, 231, 458, -114,
        // 515, 82, 383, 1248, 428,
        // 344, -668, -604, -227, 363, 595, 239, -817, 721, -308, -736, -161, 986, 306,
        // -395, -691, -619, 972,
        // -270, 51, -95, -415, -664, -199, 251, 296, -11, -539, -653, 414, -835, 892,
        // -50, -460, -816, 659, -966,
        // 102, 815, 602, -190, 326, -372, -81, 94, 87, 69, 131, -125, -258, -703, -12,
        // -634, 1017, 560, -771, 755,
        // -1242, -1068, -245, -866, 1213, -176, 219, -931, -182, 246, -31, 18, 1031,
        // 68, -213, 299, -1162, 1111,
        // 572, 63, -1469, -357, 690, 182, -358, -239, -1148, 226, 447, -559, -225,
        // -540, -1113, -554, -584, -1344,
        // 281, 477, -313, 917, -422, 132, -778, 790, -475, -244, -1093, -684, -991,
        // 835, 463, -670, -495, 413,
        // 641, 937, -17, -131, 739, 676, 181, -520, 640, -440, -96, 6, -194, -1193,
        // -407, -566, -748 };
        // System.out.println(Arrays.toString(recoverArray(n5, nums5)));
    }

    public static int[] recoverArray(int n, int[] sums) {
        int[] res = new int[n];
        Arrays.sort(sums);
        List<Integer> resArr = dfsHelper(n, sums);
        for (int i = 0; i < n; i++) {
            res[i] = resArr.get(i);
        }
        return res;
    }

    public static List<Integer> dfsHelper(int n, int[] sums) {
        if (n == 1) {
            if (sums[0] == 0 || sums[1] == 0) {
                List<Integer> sub = new ArrayList<>();
                sub.add(sums[0] == 0 ? sums[1] : sums[0]);
                return sub;
            }
            return null;
        }
        int d = sums[1] - sums[0];
        int len = 1 << n, half = len >> 1;
        boolean[] used = new boolean[len];
        int[] left = new int[half], right = new int[half];
        int l = 0, r = 0, j = 0;
        while (j < half) {
            while (l < len && used[l]) {
                l++;
            }
            left[j] = sums[l];
            used[l] = true;
            while (used[r] || sums[r] != sums[l] + d) {
                r++;
            }
            used[r] = true;
            right[j] = sums[r];
            j++;
        }

        List<Integer> ans = dfsHelper(n - 1, left);
        if (ans != null) {
            ans.add(d);
            return ans;
        }

        ans = dfsHelper(n - 1, right);
        if (ans != null) {
            ans.add(-d);
            return ans;
        }
        return null;
    }

    public static int[] recoverArrayII(int n, int[] sums) {
        final int base = 10000, maxNum = 20000;
        int[] counts = new int[maxNum + 1];
        for (int sum : sums) {
            counts[sum + base]++;
        }
        for (int i = 1; i < counts.length; i++) {
            counts[i] += counts[i - 1];
        }
        int[] sorted = new int[sums.length];
        for (int i = sums.length - 1; i >= 0; i--) {
            sorted[--counts[sums[i] + base]] = sums[i];
        }

        int[] ans = new int[n];
        int[][] iter = new int[][] { sorted, sums };
        int idx = 0, cur = 0, curLen = sums.length, lst = 0;
        boolean[] vis = new boolean[curLen];
        while (idx < n) {
            int pre = cur, diff = iter[pre][1] - iter[pre][0];
            cur ^= 1;
            Arrays.fill(vis, 0, curLen, false);
            boolean lContainsZero = false;
            for (int i = 0, j = 1, l = 0, r = curLen / 2; i < curLen && j < curLen; i++) {
                if (vis[i]) {
                    continue;
                }
                while (i == j || vis[j] || iter[pre][j + lst] < iter[pre][i + lst] + diff) {
                    j++;
                }
                iter[cur][l++] = iter[pre][i + lst];
                iter[cur][r++] = iter[pre][j + lst];
                vis[i] = vis[j] = true;
                if (iter[pre][i + lst] == 0) {
                    lContainsZero = true;
                }
            }
            if (lContainsZero) {
                ans[idx++] = diff;
                lst = 0;
            } else {
                ans[idx++] = -diff;
                lst = curLen / 2;
            }
            curLen >>= 1;
        }
        return ans;
    }
}
