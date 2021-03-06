package com.algorithm.miscellaneous;

import java.util.Arrays;
import java.util.PriorityQueue;

public class KthSmallestNumber {

    public static void main(String[] args) {
        int nums[] = new int[] {5, 12, 11, -1, 12};
        int k = 3;
        System.out.println(kthSmallestSorting(nums, k));
        System.out.println(kthSmallestMaxHeap(nums, k));
        System.out.println(kthSmallestMinHeap(nums, k));
        System.out.println(kthSmallestQuickSort(nums, k));
    }

    //Using sorting
    public static int kthSmallestSorting(int nums[], int K) {
        Arrays.sort(nums);
        return nums[K - 1];
    }

    //Using Max-Heap
    public static int kthSmallestMaxHeap(int nums[], int K){
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int num : nums) {
            if (queue.size() < K) {
                queue.offer(-num);
            } else if (-num > queue.peek()) {
                queue.poll();
                queue.offer(-num);
            }
        }
        return -queue.poll();
    }

    //Using Min-Heap
    public static int kthSmallestMinHeap(int nums[], int K){
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);
        for (int num : nums) {
            if (queue.size() < K) {
                queue.offer(num);
            } else if (num < queue.peek()) {
                queue.poll();
                queue.offer(num);
            }
        }
        return queue.poll();
    }

    //Using Partition Scheme of Quicksort
    public static int kthSmallestQuickSort(int nums[], int K) {
        return kthSmallestQuickSortRecursive(nums, K, 0, nums.length - 1);
    }

    static int kthSmallestQuickSortRecursive(int nums[], int K, int start, int end) {
        int p = partition(nums, start, end);

        if (p == K - 1) {
            return nums[p];
        }

        if (p > K - 1) {
            return kthSmallestQuickSortRecursive(nums, K, start, p - 1);
        }
        return kthSmallestQuickSortRecursive(nums, K, p + 1, end);
    }

    static int partition(int nums[], int l, int h) {
        if (l == h) {
            return nums[l];
        }

        int pivot = nums[h];
        for (int i = l; i < h; i++) {
            if (nums[i] < pivot) {
                int t = nums[l];
                nums[l] = nums[i];
                nums[i] = t;
            }
            l++;
        }

        int t = nums[l];
        nums[l] = nums[h];
        nums[h] = t;
        return l;
    }
}
