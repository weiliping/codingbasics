# 703. Kth Largest Element in a Stream - Easy

Design a class to find the <b>k<sup>th</sup></b> largest element in a stream. Note that it is the <b>k<sup>th</sup></b> largest element in the sorted order, not the <b>k<sup>th</sup></b> distinct element.

Implement <b>KthLargest</b> class:

- ```KthLargest(int k, int[] nums)``` Initializes the object with the integer k and the stream of integers nums.
- ```int add(int val)``` Returns the element representing the <b>k<sup>th</sup></b> largest element in the stream.
 

##### Example 1:

```
Input
["KthLargest", "add", "add", "add", "add", "add"]
[[3, [4, 5, 8, 2]], [3], [5], [10], [9], [4]]
Output
[null, 4, 5, 5, 8, 8]

Explanation
KthLargest kthLargest = new KthLargest(3, [4, 5, 8, 2]);
kthLargest.add(3);   // return 4
kthLargest.add(5);   // return 5
kthLargest.add(10);  // return 5
kthLargest.add(9);   // return 8
kthLargest.add(4);   // return 8
```
 

##### Constraints:

- 1 <= k <= 10<sup>4</sup>
- 0 <= nums.length <= 10<sup>4</sup>
- -10<sup>4</sup> <= nums[i] <= 10<sup>4</sup>
- -10<sup>4</sup> <= val <= 10<sup>4</sup>
- At most 10<sup>4</sup> calls will be made to ```add```.
- It is guaranteed that there will be at least k elements in the array when you search for the <b>k<sup>th</sup></b> element.

#### Java Solution
```java
public class KthLargest {
    PriorityQueue<Integer> queue;
    int s;

    public KthLargest(int k, int[] nums) {
        queue = new PriorityQueue<>(k);
        s = k;
        for (int i = 0; i < nums.length; i++) {
            addNum(nums[i]);
        }
    }

    private void addNum(int val) {
        if (queue.size() < s) {
            queue.offer(val);
            return;
        }
        if (val > queue.peek()) {
            queue.poll();
            queue.offer(val);
        }
    }
    public int add(int val) {
        addNum(val);
        return queue.peek();
    }
}
```

#### [Java Source Code](../../../src/main/java/com/algorithm/stacksandqueues/KthLargest.java)