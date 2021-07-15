# Subset Sum - Medium

Given a set of positive numbers, determine if a subset exists whose sum is equal to a given number ‘S’.

##### Example 1: 

```
Input: {1, 2, 3, 7}, S=6
Output: True
The given set has a subset whose sum is '6': {1, 2, 3}
```

##### Example 2: 

```
Input: {1, 2, 7, 1, 5}, S=10
Output: True
The given set has a subset whose sum is '10': {1, 2, 7}
```

##### Example 3:

``` 
Input: {1, 3, 4, 8}, S=6
Output: False
The given set does not have any subset whose sum is equal to '6'.
```

#### Java Solution
```java
public class SubsetSum {

    public static boolean canPartition(int[] nums, int sum) {
        boolean dp[] = new boolean[sum + 1];
        dp[0] = true;
        for (int i = 0; i < nums.length; i++) {
            for (int j = sum; j >= nums[i]; j--) {
                dp[j] |= dp[j - nums[i]];
            }
        }
        return dp[sum];
    }
}
```

#### [Java Source Code](../../../src/main/java/com/algorithm/dp/SubsetSum.java)
