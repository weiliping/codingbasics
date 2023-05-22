# Kth smallest number - Easy
Given an unsorted array of numbers, find <b>Kth smallest number</b> in it.
Please note that it is the <b>K<sup>th</sup></b> smallest number in the sorted order, not the <b>K<sup>th</sup></b> distinct element.

<b>Note:</b> For a detailed discussion about different approaches to solve this problem, take a look at <b>K<sup>th</sup></b> Smallest Number.

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
Explanation: The 4th smallest number is '5', as the first three small numbers are [1, 2, 5].
```

##### Example 3:

```
Input: [5, 12, 11, -1, 12], K = 3
Output: 11
Explanation: The 3rd smallest number is '11', as the first two small numbers are [5, -1].
```

#### Java Solution
```java
public class KthSmallestI {

    public static int kthSmallest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(k, (a, b) -> b - a);

        for (int i = 0; i < k; i++) {
            queue.offer(nums[i]);
        }

        for (int i = k; i < nums.length; i++) {
            if (nums[i] < queue.peek()) {
                queue.poll();
                queue.offer(nums[i]);
            }
        }
        return queue.peek();
    }
}
```

#### [Java Source Code](../../../src/main/java/com/algorithm/stacksandqueues/KthSmallestI.java)