# Sum of Elements - Medium

Given an array, find the sum of all numbers between the <b>K1<sup>th</sup></b> and <b>K2<sup>th</sup></b> smallest elements of that array.

##### Example 1:

```
Input: [1, 3, 12, 5, 15, 11], and K1=3, K2=6
Output: 23
Explanation: The 3rd smallest number is 5 and 6th smallest number 15. The sum of numbers coming
between 5 and 15 is 23 (11+12).
```

##### Example 2:

```
Input: [3, 5, 8, 7], and K1=1, K2=4
Output: 12
Explanation: The sum of the numbers between the 1st smallest number (3) and the 4th smallest 
number (8) is 12 (5+7).
```

#### Java Solution
```java
public class SumOfElements {

    public static int sumElements(int[] nums, int k1, int k2) {
        int sum = 0, n = nums.length;
        PriorityQueue<Integer> queue = new PriorityQueue<>(n);
        for (int num : nums) {
            queue.offer(num);
        }

        for (int j = 0; j < n; j++) {
            int num = queue.poll();
            if (j > k1 - 1 && j < k2 - 1) {
                sum += num;
            }
        }
        return sum;
    }
}
```

#### [Java Source Code](../../../src/main/java/com/algorithm/stacksandqueues/SumOfElements.java)