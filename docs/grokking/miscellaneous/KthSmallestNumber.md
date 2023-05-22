# Kth Smallest Number - Hard

Given an <b>unsorted</b> array of numbers, find <b>K<sup>th</sup></b> smallest number in it.

Please note that it is the <b>K<sup>th</sup></b> smallest number in the <b>sorted</b> order, not the <b>K<sup>th</sup></b> distinct element.


##### Example 1:

```
Input: [1, 5, 12, 2, 11, 5], K = 3
Output: 5
Explanation: The 3rd smallest number is '5', as the first two smaller numbers are [1, 2].
```

##### Example 2:

```
Input: [1, 5, 12, 2, 11, 5], K = 4
Output: 5
Explanation: The 4th smallest number is '5', as the first three smaller numbers are
[1, 2, 5].
```

##### Example 3:

```
Input: [5, 12, 11, -1, 12], K = 3
Output: 11
Explanation: The 3rd smallest number is '11', as the first two small numbers are [5, -1].
```

#### Java Solution
```java
public class KthSmallestNumber {

    // Brute force approach : Using sorting
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
```

#### [Java Source Code](../../../src/main/java/com/algorithm/miscellaneous/KthSmallestNumber.java)