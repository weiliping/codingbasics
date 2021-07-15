package com.algorithm.strings;

public class CompareVersionNumbers {

    /**
     * #165
     * https://leetcode-cn.com/problems/compare-version-numbers
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(compareVersion("0.1", "1.1"));
        System.out.println(compareVersion("1.0.1", "1"));
        System.out.println(compareVersion("7.5.2.4", "7.5.3"));
        System.out.println(compareVersion("1.01", "1.001"));
        System.out.println(compareVersion("1.0", "1.0.0"));
        System.out.println(compareVersion("1.0", "1.1"));
        System.out.println(compareVersion("0.9.9.9.9.9.9.9.9.9.9.9.9", "1.0"));
    }

    public static int compareVersion(String version1, String version2) {
        int[] versionInt1 = toIntArray(version1);
        int[] versionInt2 = toIntArray(version2);

        for (int i = 0; i < 4; i++) {
            if (versionInt1[i] == versionInt2[i] && i != 3) {
                continue;
            }
            if (versionInt1[i] > versionInt2[i]) {
                return 1;
            } else if (versionInt1[i] < versionInt2[i] ){
                return -1;
            } else {
                return 0;
            }
        }
        return 0;
    }

    static int[] toIntArray(String version) {
        int[] res = new int[4];
        if (version.indexOf('.') == -1) {
            res[0] = Integer.valueOf(version);
            return res;
        }
        int s = 0, len = version.length();
        int i = 0, start = 0;
        while (s < len) {
            if (version.charAt(s) == '.' && i < 4) {
                res[i] = Integer.parseInt(version.substring(start, s));
                start = s + 1;
                i++;
            }
            s++;
        }

        if (start < len && i < 4) {
            res[i] = Integer.valueOf(version.substring(start, len));
        }
        return res;
    }
}
