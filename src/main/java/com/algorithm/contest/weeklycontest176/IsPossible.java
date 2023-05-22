package com.algorithm.contest.weeklycontest176;

public class IsPossible {

    public static void main(String[] args) {
        IsPossible is = new IsPossible();
        System.out.println(is.isPossible(new int[] {9, 3, 5}));
        System.out.println(is.isPossible(new int[] {1, 1, 1, 2}));
        System.out.println(is.isPossible(new int[] {18, 5}));
        System.out.println(is.isPossible(new int[] {9, 9, 9}));
        System.out.println(is.isPossible(new int[] {1,1000000000}));
        System.out.println(is.isPossible(new int[] {5, 50}));
        System.out.println(is.isPossible(new int[] {2}));
    }
    public boolean isPossible(int[] target) {
        int sum = 0;
        int n = target.length;
        for (int num : target) {
            sum += num;
        }
        while (sum > n) {
            int[] max = maxNum(target, 0, n - 1);

            int leftPart = sum - max[1];
            if (leftPart >= max[1] || leftPart == 0) {
                return false;
            }
            if (leftPart == 1) {
                target[max[0]] = 1;
                break;
            }
            if (max[1] % leftPart == 0) {
                return false;
            }
            target[max[0]] = max[1] % leftPart;
            sum -= leftPart * (max[1] / leftPart);
        }
        for (int i = 0; i < n; i++) {
            if (target[i] != 1) {
                return false;
            }
        }
        return true;
    }

    int[] maxNum(int[] target, int i, int j) {
        if (i > j) {
            return new int[] {-1, Integer.MIN_VALUE};
        }
        if (i == j) {
            return new int[] {i, target[i]};
        }
        if (i + 1 == j) {
            if (target[i] > target[j]) {
                return new int[] {i, target[i]};
            }
            return new int[] {j, target[j]};
        }
        int mid = i + ((j - i) >> 1);
        int[] left = maxNum(target, i, mid);
        int[] right = maxNum(target, mid + 1, j);

        if (left[1] > right[1]) {
            return left;
        }
        return right;
    }
}
