# Find the First K Missing Positive Numbers - hard

Given an unsorted array containing numbers and a number ‘k’, find the first ‘k’ missing positive numbers in the array.

##### Example 1:

```
Input: [3, -1, 4, 5, 5], k=3
Output: [1, 2, 6]
Explanation: The smallest missing positive numbers are 1, 2 and 6.
```

##### Example 2:

```
Input: [2, 3, 4], k=3
Output: [1, 5, 6]
Explanation: The smallest missing positive numbers are 1, 5 and 6.
```

##### Example 3:

```
Input: [-2, -3, 4], k=2
Output: [1, 2]
Explanation: The smallest missing positive numbers are 1 and 2.
```

#### Java Solution
```java
public class FindFirstKMissingPositive {

    public static List<Integer> findFirstKMissingPositive(int[] nums, int k) {
        List<Integer> res = new ArrayList<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                int t = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = t;
            }
        }

        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                res.add(i + 1);
            }
        }

        if (res.size() >= k) {
            return res.subList(0, k);
        }

        int i = 1;
        Arrays.sort(nums);
        while (res.size() < k) {
            int maxVal = res.get(res.size() - 1) + i;
            if (Arrays.binarySearch(nums, maxVal) < 0) {
                res.add(maxVal);
                i = 1;
                continue;
            }
            i++;
        }
        return res;
    }
}
```

#### [Java Source Code](../../../src/main/java/com/algorithm/cyclicsort/FindFirstKMissingPositive.java)