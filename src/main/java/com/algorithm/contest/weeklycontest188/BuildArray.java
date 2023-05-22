package com.algorithm.contest.weeklycontest188;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BuildArray {

    public static void main(String[] args) {
        BuildArray b = new BuildArray();
        int target1[] = new int[] {1, 3}, n1 = 3;
        System.out.println(Arrays.toString(b.buildArray(target1, n1).toArray()));

        int target2[] = new int[] {1, 2, 3}, n2 = 3;
        System.out.println(Arrays.toString(b.buildArray(target2, n2).toArray()));

        int target3[] = new int[] {1, 2}, n3 = 4;
        System.out.println(Arrays.toString(b.buildArray(target3, n3).toArray()));

        int target4[] = new int[] {2, 3, 4}, n4 = 4;
        System.out.println(Arrays.toString(b.buildArray(target4, n4).toArray()));
    }

    public List<String> buildArray(int[] target, int n) {
        List<String> res = new ArrayList<>();
        int i = 0, j = 1, m = target.length;
        while (j <= n && i < m) {
            if (j == target[i]) {
                j++;
                i++;
                res.add("Push");
                continue;
            }
            j++;
            res.add("Push");
            res.add("Pop");
        }
        return res;
    }
}
