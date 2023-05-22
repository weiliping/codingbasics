# K Pairs with Largest Sums (Hard) 
Given two sorted arrays in descending order, find ```K``` pairs with the largest sum where each pair consists of numbers from both the arrays.

##### Example 1:
```
Input: L1=[9, 8, 2], L2=[6, 3, 1], K=3
Output: [9, 3], [9, 6], [8, 6] 
Explanation: These 3 pairs have the largest sum. No other pair has a sum larger than any of these.
```
##### Example 2:

```
Input: L1=[5, 2, 1], L2=[2, -1], K=3
Output: [5, 2], [5, -1], [2, 2]
``` 

#### Java Solution
```java
public class KLargestPairs {

    public static List<List<Integer>> kLargestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> res = new ArrayList<>();

        int n1 = nums1.length, n2 = nums2.length;
        int l = Math.min(k, n1 * n2);
        PriorityQueue<int[]> queue = new PriorityQueue<>(l, (a, b) -> (a[0] + a[1]) - (b[0] + b[1]));

        for (int i = 0; i < n1; i++) {
            for (int j = 0; j < n2; j++) {
                if (queue.size() < l) {
                    queue.offer(new int[] { nums1[i], nums2[j] });
                } else {
                    int[] sub = queue.peek();

                    if (sub[0] + sub[1] < nums1[i] + nums2[j]) {
                        queue.poll();
                        queue.offer(new int[] { nums1[i], nums2[j] });
                    }
                }
            }
        }

        while (!queue.isEmpty()) {
            List<Integer> subRes = new ArrayList<>();
            int[] sub = queue.poll();
            subRes.add(sub[0]);
            subRes.add(sub[1]);
            res.add(subRes);
        }
        return res;
    }
}
```

#### [Java Source Code](../../../src/main/java/com/algorithm/kmerge/KLargestPairs.java)