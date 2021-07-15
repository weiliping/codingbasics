# Maximum Distinct Elements - Medium

Given an array of numbers and a number <b>K</b>, we need to remove <b>K</b> numbers from the array such that we are left with <b>maximum distinct</b> numbers.

##### Example 1:

```
Input: [7, 3, 5, 8, 5, 3, 3], and K=2
Output: 3
Explanation: We can remove two occurrences of 3 to be left with 3 distinct numbers [7, 3, 8], we have 
to skip 5 because it is not distinct and occurred twice. 
Another solution could be to remove one instance of '5' and '3' each to be left with three 
distinct numbers [7, 5, 8], in this case, we have to skip 3 because it occurred twice.
```

##### Example 2:
```
Input: [3, 5, 12, 11, 12], and K=3
Output: 2
Explanation: We can remove one occurrence of 12, after which all numbers will become distinct. Then 
we can delete any two numbers which will leave us 2 distinct numbers in the result.
```

##### Example 3:

```
Input: [1, 2, 3, 3, 3, 3, 4, 4, 5, 5, 5], and K=2
Output: 3
Explanation: We can remove one occurrence of '4' to get three distinct numbers.
```

#### Java Solution
```java
public class MaximumDistinctNumbers {
    public static int maximumDistinctNum(int[] nums, int k) {
        HashSet<Integer> distNums = new HashSet<>();
        HashMap<Integer, Integer> dupNums = new HashMap<>();

        for (int num : nums) {
            if (!distNums.contains(num)) {
                distNums.add(num);
                continue;
            }
            dupNums.put(num, dupNums.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[1] == b[1] ? a[0] - b[0] : a[1] - b[1]);

        for (Map.Entry<Integer, Integer> m : dupNums.entrySet()) {
            queue.offer(new int[] {m.getKey(), m.getValue()});
        }

        while (k > 0 && !queue.isEmpty()) {
            int[] e = queue.peek();
            if (k >= e[1]) {
                queue.poll();
            }
            k -= e[1];
        }

        while (!queue.isEmpty()) {
            int[] e = queue.poll();
            if (distNums.contains(e[0])) {
                distNums.remove(e[0]);
            }
        }
        return distNums.size() - k;
    }
}
```

#### [Java Source Code](../../../src/main/java/com/algorithm/stacksandqueues/MaximumDistinctNumbers.java)