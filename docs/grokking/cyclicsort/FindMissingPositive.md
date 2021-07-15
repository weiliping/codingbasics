# Find the Smallest Missing Positive Number - Medium

Given an unsorted array containing numbers, find the smallest missing positive number in it.


##### Example 1:

```
Input: [-3, 1, 5, 4, 2]
Output: 3
Explanation: The smallest missing positive number is '3'
```

##### Example 2:

```
Input: [3, -2, 0, 1, 2]
Output: 4
```

##### Example 3:

```
Input: [3, 2, 5, 1]
Output: 4
```

#### Java Solution
```java
public class FirstMissingPositive {

    int firstMissingPositive(int[] nums) {
        if (nums == null) {
            return 1;
        }
        int n = nums.length;
        for (int i = 0; i < n; ++i) {
            while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                int tmp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = tmp;
            }
        }
        for (int i = 0; i < n; ++i) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return n + 1;
    }
}
```

#### [Java Source Code](../../../src/main/java/com/algorithm/arrays/FirstMissingPositive.java)