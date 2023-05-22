# 494. Target Sum - Medium

 You are given a list of non-negative integers, a1, a2, ..., an, and a target, S. Now you have 2 symbols ```+``` and ```-```. For each integer, you should choose one from ```+``` and ```-``` as its new symbol.
 
 Find out how many ways to assign symbols to make sum of integers equal to target ```S```.
 
 ##### Example 1:
 
 ```
 Input: nums is [1, 1, 1, 1, 1], S is 3. 
 Output: 5
 Explanation: 
 
 -1+1+1+1+1 = 3
 +1-1+1+1+1 = 3
 +1+1-1+1+1 = 3
 +1+1+1-1+1 = 3
 +1+1+1+1-1 = 3
 
 There are 5 ways to assign symbols to make the sum of nums be target 3.
 ``` 
 
 ##### Constraints:
 
 - The length of the given array is positive and will not exceed 20.
 - The sum of elements in the given array will not exceed 1000.
 - Your output answer is guaranteed to be fitted in a 32-bit integer.
 
 #### Java Solution
 ```java
public class FindTargetSumWays {

    public static int findTargetSumWays(int nums[], int S) {
        return helperSumWays(nums, 0, S);
    }

    public static int helperSumWays(int nums[], int ind, int sum) {
        if (ind == nums.length) {
            return sum == 0 ? 1 : 0;
        }
        int left = helperSumWays(nums, ind + 1, sum - nums[ind]);
        int right = helperSumWays(nums, ind + 1, sum + nums[ind]);
        return left + right;
    }
}
```
#### [Java Source Code](../../../src/main/java/com/algorithm/dp/FindTargetSumWays.java)