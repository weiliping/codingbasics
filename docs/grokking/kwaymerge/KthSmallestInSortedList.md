# Kth Smallest Number in M Sorted Lists - Medium

Given ```M``` sorted arrays, find the <b>K<sup>th</sup></b> smallest number among all the arrays.

##### Example 1:

```
Input: L1=[2, 6, 8], L2=[3, 6, 7], L3=[1, 3, 4], K=5
Output: 4
Explanation: The 5th smallest number among all the arrays is 4, this can be verified from the merged 
list of all the arrays: [1, 2, 3, 3, 4, 6, 6, 7, 8]
```

##### Example 2:

```
Input: L1=[5, 8, 9], L2=[1, 7], K=3
Output: 7
Explanation: The 3rd smallest number among all the arrays is 7.
```

#### Java Solution
```java
public class KthSmallestInSortedList {

    public static int kthSmallest(List<List<Integer>> matrix, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(k, (a, b) -> b - a);

        for (List<Integer> subRes : matrix) {
            for (Integer num : subRes) {
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
#### [Java Source Code](../../../src/main/java/com/algorithm/kmerge/KthSmallestInSortedList.java)