package com.algorithm.contest.weeklycontest257;

import java.util.Arrays;
import java.util.Stack;

public class NumberOfWeakCharacters {
    public static void main(String[] args) {
//        System.out.println(numberOfWeakCharacters(new int[][]{{5,5},{6,3},{3,6}}));
        System.out.println(numberOfWeakCharacters(new int[][]{{3,2},{3,3}}));
//        System.out.println(numberOfWeakCharacters(new int[][]{{2,2},{3,3}}));
//        System.out.println(numberOfWeakCharacters(new int[][]{{1,5},{10,4},{4,3}}));
//        System.out.println(numberOfWeakCharacters(new int[][]{{1,1},{2,1},{2,2},{1,2}}));
    }

    public static int numberOfWeakCharacters(int[][] properties) {
        Arrays.sort(properties, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
        int n = properties.length;
        int cnt = 0;
        Stack<int[]> stack = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek()[1] <= properties[i][1]) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                cnt++;
            }
            stack.push(properties[i]);
        }
        return cnt;
    }
}
