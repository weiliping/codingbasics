# 41. First Missing Positive - Hard

Given an unsorted integer array ```nums```, find the smallest missing positive integer.

##### Example 1:

```
Input: nums = [1,2,0]
Output: 3
```

##### Example 2:

```
Input: nums = [3,4,-1,1]
Output: 2
```

##### Example 3:

```
Input: nums = [7,8,9,11,12]
Output: 1
```

##### Constraints:

- ```0 <= nums.length <= 300```
- -2<sup>31</sup> <= nums[i] <= 2<sup>31</sup> - 1
 

<b>Follow up:</b> Could you implement an algorithm that runs in O(n) time and uses constant extra space?

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

