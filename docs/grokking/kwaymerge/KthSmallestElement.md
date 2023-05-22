# 378. Kth Smallest Element in a Sorted Matrix - Medium

Given an ```n x n matrix``` where each of the rows and columns are sorted in ascending order, return the <b>k<sup>th</sup></b> smallest element in the matrix.

Note that it is the <b>k<sup>th</sup></b> smallest element <b>in the sorted order</b>, not the <b>k<sup>th</sup></b> distinct element.

 

##### Example 1:

```
Input: matrix = [[1,5,9],[10,11,13],[12,13,15]], k = 8
Output: 13
Explanation: The elements in the matrix are [1,5,9,10,11,12,13,13,15], and the 8th smallest number is 13
```

##### Example 2:

```
Input: matrix = [[-5]], k = 1
Output: -5
``` 

##### Constraints:

- ```n == matrix.length```
- ```n == matrix[i].length```
- ```1 <= n <= 300```
- -10<sup>9</sup> <= matrix[i][j] <= -10<sup>9</sup>
- All the rows and columns of ```matrix``` are <b>guaranteed</b> to be sorted in <b>non-degreasing order</b>.
- 1 <= k <= n<sup>2</sup>

#### Java Solution

```java
public class KthSmallest {
    public static int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(k, (a, b) -> b - a);

        for (int[] nums : matrix) {
            for (int num : nums) {
                if (queue.size() < k) {
                    queue.offer(num);
                    continue;
                }
                if (num < queue.peek()) {
                    queue.poll();
                    queue.offer(num);
                }
            }
        }
        return queue.peek();
    }
}
```

#### [Java Source Code](../../../src/main/java/com/algorithm/stacksandqueues/KthSmallest.java)