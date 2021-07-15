# 347. Top K Frequent Elements - Medium

Given an integer array ```nums``` and an integer ```k```, return the ```k``` most frequent elements. You may return the answer in <b>any order</b>.

 

##### Example 1:

```
Input: nums = [1,1,1,2,2,3], k = 2
Output: [1,2]
```

##### Example 2:

```
Input: nums = [1], k = 1
Output: [1]
``` 

##### Constraints:

- 1 <= nums.legth <= 10<sup>5</sup>
- ```k``` is in the range ```[1, the number of unique elements in the array]```.
- It is <b>guaranteed</b> that the answer is <b>unique</b>.
 

<b>Follow up:</b> Your algorithm's time complexity must be better than ```O(n log n)```, where n is the array's size.

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