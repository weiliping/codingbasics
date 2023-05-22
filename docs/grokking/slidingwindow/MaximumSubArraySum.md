# 53. Maximum Subarray - Easy
Given an integer array ```nums```, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.

 

##### Example 1:

```
Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
Output: 6
Explanation: [4,-1,2,1] has the largest sum = 6.
```

##### Example 2:

```
Input: nums = [1]
Output: 1
```

##### Example 3:

```
Input: nums = [5,4,-1,7,8]
Output: 23
``` 

##### Constraints:

- 1 <= nums.length <= 3 * 10<sup>4</sup>
- -10<sup>5</sup> <= nums[i] <= 10<sup>5</sup>
 

<b>Follow up:</b> If you have figured out the ```O(n)``` solution, try coding another solution using the <b>divide and conquer</b> approach, which is more subtle.

#### Java Solution
```java
public class MaximumSubarraySum {

    public int largestSubarraySum(int[] nums) {
        int maxSum = nums[0], subarraySum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            subarraySum = Math.max(nums[i], subarraySum + nums[i]);
            maxSum = Math.max(maxSum, subarraySum);
        }
        return maxSum;
    }
}
```
#### [Java Source Code](../../../src/main/java/com/algorithm/arrays/MaximumSubarraySum.java)
- [Reference](https://www.geeksforgeeks.org/find-maximum-minimum-sum-subarray-size-k/)
