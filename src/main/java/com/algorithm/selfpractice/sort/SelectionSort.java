package com.algorithm.selfpractice.sort;

import java.util.Arrays;

public class SelectionSort {

    public static void main(String[] args) {
        int[] arr = new int[] { 2, 1, 4, 9, 0, 3, 5, 8, 7, 6 };
//        insertSort(arr);
//        selectionSort(arr);
//        bubbleSort(arr);
//        mergeSort(arr);
//        quickSort(arr);
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void insertSort(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        for (int i = 1; i < nums.length; i++) {
            int j, tmp = nums[i];
            for (j = i - 1; j >= 0 && tmp < nums[j]; j--) {
                nums[j + 1] = nums[j];
            }
            nums[j + 1] = tmp;
        }
    }

    public static void selectionSort(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int index = i;
            for (int j = i + 1; j < n; j++) {
                if (nums[index] > nums[j]) {
                    index = j;
                }
            }
            if (index == i) {
                continue;
            }
            int tmp = nums[index];
            nums[index] = nums[i];
            nums[i] = tmp;
        }
    }

    public static void bubbleSort(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int n = nums.length;
        for(int i = 0; i < n; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (nums[j + 1] < nums[j]) {
                    int tmp = nums[j + 1];
                    nums[j + 1] = nums[j];
                    nums[j] = tmp;
                }
            }
        }
    }

    public static void mergeSort(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int n = nums.length;
        int sortNums[] = new int[n];
        mergeSortHelper(nums, 0, n - 1, sortNums);
    }

    private static void mergeSortHelper(int[] nums, int start, int end, int[] sortNums) {
        if (start >= end) {
            return;
        }

        int mid = (start + end) / 2;
        int sortLen = 0;
        int lStart = start, lEnd = mid, rStart = mid + 1, rEnd = end;
        mergeSortHelper(nums, lStart, lEnd, sortNums);
        mergeSortHelper(nums, rStart, rEnd, sortNums);

        while (lStart <= lEnd && rStart <= rEnd) {
            if (nums[lStart] < nums[rStart]) {
                sortNums[sortLen++] = nums[lStart++];
            } else {
                sortNums[sortLen++] = nums[rStart++];
            }
        }

        while (lStart <= lEnd) {
            sortNums[sortLen++] = nums[lStart++];
        }

        while (rStart <= rEnd) {
            sortNums[sortLen++] = nums[rStart++];
        }

        for (int i = 0; i < sortLen; i++) {
            nums[start + i] = sortNums[i];
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

    public static int binarySearch(int[] nums, int val) {
        return binarySearchHelper(nums, 0, nums.length - 1, val);
    }

    private static int binarySearchHelper(int[] nums, int l, int r, int val) {
        if (l >= r) {
            return -1;
        }

        int mid = (l + r) / 2;
        if (nums[mid] == val) {
            return val;
        } else if (nums[mid] > val) {
            return binarySearchHelper(nums, l, mid - 1, val);
        } else {
            return binarySearchHelper(nums, mid + 1, r, val);
        }
    }

    public static void heapSort(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }

        int n = nums.length;
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(nums, i, n);
        }
        for (int i = n - 1; i >= 0; i--) {
            int tmp = nums[i];
            nums[i] = nums[0];
            nums[0] = tmp;
            heapify(nums, 0, i);
        }
    }

    static void heapify(int[] nums, int i, int n) {
        int max = i, lChild = 2 * i + 1, rChild = 2 * i + 2;
        if (lChild < n && nums[lChild] < nums[max]) {
            max = lChild;
        }

        if (rChild < n && nums[rChild] < nums[max]) {
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
