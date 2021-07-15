# Minimum Subset Sum Difference - Hard

Given a set of <b>positive</b> numbers, partition the set into <b>two subsets</b> with <b>minimum</b> difference between their subset sums.


##### Example 1:

``` 
Input: {1, 2, 3, 9}
Output: 3
Explanation: We can partition the given set into two subsets where minimum absolute difference 
between the sum of numbers is '3'. Following are the two subsets: {1, 2, 3} & {9}.
```

##### Example 2: 

```
Input: {1, 2, 7, 1, 5}
Output: 0
Explanation: We can partition the given set into two subsets where minimum absolute difference 
between the sum of number is '0'. Following are the two subsets: {1, 2, 5} & {7, 1}.
```

##### Example 3: 

```
Input: {1, 3, 100, 4}
Output: 92
Explanation: We can partition the given set into two subsets where minimum absolute difference 
between the sum of numbers is '92'. Here are the two subsets: {1, 3, 4} & {100}.
```

#### Java Solution
```java
public class MinSubsetSumDifference {

    public static int minSumDiff(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int[][] dp = new int[nums.length][sum + 1];
        for (int[] r : dp) {
            Arrays.fill(r,-1);
        }
        return sumHelper(nums, 0, 0, 0, dp);
    }

    public static int sumHelper(int[] nums, int ind, int sum1, int sum2, int[][] dp) {
        if (ind == nums.length) {
            return Math.abs(sum1 - sum2);
        }

        if (dp[ind][sum1] == -1) {
            int diff1 = sumHelper(nums, ind + 1, sum1 + nums[ind], sum2, dp);
            int diff2 = sumHelper(nums, ind + 1, sum1, sum2 + nums[ind], dp);
            dp[ind][sum1] = Math.min(diff1, diff2);
        }
        return dp[ind][sum1];
    }
}
```

#### [Java Source Code](../../../src/main/java/com/algorithm/dp/MinSubsetSumDifference.java)