# 215. Kth Largest Element in an Array - Medium

Given an integer array ```nums``` and an integer ```k```, return the <b>k<sup>th</sup></b> largest element in the array.

Note that it is the <b>k<sup>th</sup></b> largest element in the sorted order, not the <b>k<sup>th</sup></b> distinct element.

 

##### Example 1:

```
Input: nums = [3,2,1,5,6,4], k = 2
Output: 5
```

##### Example 2:

```
Input: nums = [3,2,3,1,2,4,5,5,6], k = 4
Output: 4
```

##### Constraints:

- 1 <= k <= nums.length <= 10<sup>4</sup>
- -10<sup>4</sup> <= nums[i] <= 10<sup>4</sup>

#### Java Solution
```java
public class FindKthLargest {
    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);

        for (int i : nums) {
            queue.offer(i);
        }
        while (k > 1) {
            queue.poll();
            k--;
        }
        return queue.poll();
    }
}
```

#### [Java Source Code](../../../src/main/java/com/algorithm/stacksandqueues/FindKthLargest.java)