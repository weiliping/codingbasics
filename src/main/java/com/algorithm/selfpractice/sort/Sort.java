package com.algorithm.selfpractice.sort;

import java.util.Arrays;

public class Sort {

    public static void main(String[] args) {
        int[] nums = new int[] {3, 5, 0, 9, 1, 8, 4, 6, 7, 2 };
        heapSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void bubbleSort(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (nums[j + 1] < nums[j]) {
                    int tmp = nums[j + 1];
                    nums[j + 1] = nums[j];
                    nums[j] = tmp;
                }
            }
        }
    }

    public static void selectionSort(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int n = nums.length;
        for (int i = 0; i < n - 1; i++) {
            int index = i;
            for (int j = i + 1; j < n; j++) {
                if (nums[index] > nums[j]) {
                    index = j;
                }
            }

            if (index == i) {
                continue;
            }

            int tmp = nums[i];
            nums[i] = nums[index];
            nums[index] = tmp;
        }
    }

    public static void insertSort(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int n = nums.length;
        for (int i = 1; i < n; i++) {
            int tmp = nums[i], j;
            for (j = i - 1; j >= 0 && tmp < nums[j]; j--) {
                nums[j + 1] = nums[j];
            }
            nums[j + 1] = tmp;
        }
    }

    public static void mergeSort(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int n = nums.length;
        int[] sorts = new int[n];
        mergeSortHelper(nums, 0, n - 1, sorts);
    }

    private static void mergeSortHelper(int[] nums, int l, int r, int[] sorts) {
        if (l >= r) {
            return;
        }

        int ind = 0, mid = (l + r) / 2;
        int lStart = l, lEnd = mid, rStart = mid + 1, rEnd = r;

        mergeSortHelper(nums, lStart, lEnd, sorts);
        mergeSortHelper(nums, rStart, rEnd, sorts);
        while (lStart <= lEnd && rStart <= rEnd) {
            if (nums[lStart] < nums[rStart]) {
                sorts[ind++] = nums[lStart++];
            } else {
                sorts[ind++] = nums[rStart++];
            }
        }

        while (lStart <= lEnd) {
            sorts[ind++] = nums[lStart++];
        }

        while (rStart <= rEnd) {
            sorts[ind++] = nums[rStart++];
        }

        for (int i = 0; i < ind; i++) {
            nums[l + i] = sorts[i];
        }
    }

    public static void quickSort(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }

        int n = nums.length;
        quickSortHelper(nums, 0, n - 1);
    }

    private static void quickSortHelper(int[] nums, int l, int r) {
        if (l >= r) {
            return;
        }

        int i = l, j = r, baseVal = nums[i];

        while (i < j) {
            while (i < j && nums[j] >= baseVal) {
                j--;
            }

            if (i < j) {
                nums[i++] = nums[j];
            }

            while (i < j && nums[i] < baseVal) {
                i++;
            }

            if (i < j) {
                nums[j--] = nums[i];
            }
        }

        nums[i] = baseVal;
        quickSortHelper(nums, l, i - 1);
        quickSortHelper(nums, i + 1, r);
    }

    public static void heapSort(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int n = nums.length;
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(nums, i, n);
        }

        for(int i = n - 1; i >=0; i--) {
            int tmp = nums[i];
            nums[i] = nums[0];
            nums[0] = tmp;
            heapify(nums, 0, i);
        }
    }

    private static void heapify(int[] nums, int i, int n) {
        int max = i, lChild = 2 * i, rChild = 2 * i + 1;

        if (lChild < n && nums[lChild] > nums[max]) {
            max = lChild;
        }

        if (rChild < n && nums[rChild] > nums[max]) {
            max = rChild;
        }

        if (max != i) {
            int tmp = nums[max];
            nums[max] = nums[i];
            nums[i] = tmp;
            heapify(nums, max, n);
        }
    }
}
