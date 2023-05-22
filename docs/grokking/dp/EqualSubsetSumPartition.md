# 416. Partition Equal Subset Sum - Medium

Given a <b>non-empty</b> array ```nums``` containing <b>only positive integers</b>, find if the array can be partitioned into two subsets such that the sum of elements in both subsets is equal.

##### Example 1:

```
Input: nums = [1,5,11,5]
Output: true
Explanation: The array can be partitioned as [1, 5, 5] and [11].
```

##### Example 2:

```
Input: nums = [1,2,3,5]
Output: false
Explanation: The array cannot be partitioned into equal sum subsets.
```

##### Constraints:

- ```1 <= nums.length <= 200```
- ```1 <= nums[i] <= 100```

#### Java Solution
```java
public class CanPartition {

    public static boolean canPartition(int[] nums) {
        int sum = 0;
        for (int i : nums) {
            sum += i;
        }

        if (sum % 2 != 0) {
            return false;
        }

        int target = sum / 2;

        boolean[] dp = new boolean[target + 1];

        dp[0] = true;
        for (int i = 0; i < nums.length; i++) {
            for (int j = target; j >= nums[i]; j--) {
                dp[j] |= dp[j - nums[i]];
            }
        }
        return dp[target];
    }
}
```

#### [Java Source Code](../../../src/main/java/com/algorithm/dynamicprogramming/CanPartition.java)