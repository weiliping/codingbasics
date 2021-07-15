# 209. Minimum Size Subarray Sum - Medium

Given an array of positive integers ```nums``` and a positive integer ```target```, return the minimal length of a contiguous subarray ```[numsl, numsl+1, ..., numsr-1, numsr]``` of which the sum is greater than or equal to ```target```. If there is no such subarray, return 0 instead.

##### Example 1:

```
Input: target = 7, nums = [2,3,1,2,4,3]
Output: 2
Explanation: The subarray [4,3] has the minimal length under the problem constraint.
```

##### Example 2:

```
Input: target = 4, nums = [1,4,4]
Output: 1
```

##### Example 3:

```
Input: target = 11, nums = [1,1,1,1,1,1,1,1]
Output: 0
```

##### Constraints:

- 1 <= target <= 10<sup>9</sup>
- 1 <= nums.length <= 10<sup>5</sup>
- 1 <= nums[i] <= 10<sup>5</sup>
 

<b>Follow up:</b> If you have figured out the ```O(n)``` solution, try coding another solution of which the time complexity is ```O(n log(n))```.


#### Java Solution
```java
public class MinimumSizeSubarraySum {
    public static int minSubArrayLen(int s, int[] nums) {
        int res = Integer.MAX_VALUE, n = nums.length;
        int[] sums = new int[n + 1];

        for (int i = 1; i < n + 1; i++) {
            sums[i] = sums[i - 1] + nums[i - 1];
        }

        for (int i = 0; i < n; i++) {
            int l = i + 1, r = n, t = sums[i] + s;
            while (l <= r) {
                int mid = l + (r - l) / 2;
                if (sums[mid] < t) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
            if (l == n + 1) {
                break;
            }
            res = Math.min(res, l - i);
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }
}
```
#### [Java Source Code](../../../src/main/java/com/algorithm/arrays/MinimumSizeSubarraySum.java)

- [Reference](https://www.geeksforgeeks.org/minimum-length-subarray-sum-greater-given-value/)