# Count of Subset Sum - Hard
 
Given a set of positive numbers, find the total number of subsets whose sum is equal to a given number <b>S</b>.

##### Example 1: 
```
Input: {1, 1, 2, 3}, S=4
Output: 3
The given set has '3' subsets whose sum is '4': {1, 1, 2}, {1, 3}, {1, 3}
Note that we have two similar sets {1, 3}, because we have two '1' in our input.
```

##### Example 2:
```
Input: {1, 2, 7, 1, 5}, S=9
Output: 3
The given set has '3' subsets whose sum is '9': {2, 7}, {1, 7, 1}, {1, 2, 1, 5}
```

#### Java Solution
```java
public class CountSubset {

    public static int countSubset(int[] nums, int sum) {
        int n = nums.length;
        int[] dp = new int[sum + 1];
        dp[0] = 1;

        for (int i = 0; i < n; i++) {
            for (int j = sum; j >= nums[i]; j--) {
                dp[j] += dp[j - nums[i]];
            }
        }
        return dp[sum];
    }
}
```
#### [Java Source Code](../../../src/main/java/com/algorithm/dp/CountSubset.java)