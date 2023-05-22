# 16. 3Sum Closest - Medium
                   
Given an array ```nums``` of n integers and an integer ```target```, find three integers in ```nums``` such that the sum is closest to ```target```. Return the sum of the three integers. You may assume that each input would have exactly one solution.


##### Example 1:

```
Input: nums = [-1,2,1,-4], target = 1
Output: 2
Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
``` 

##### Constraints:

- 3 <= nums.length <= 10^3
- -10^3 <= nums[i] <= 10^3
- -10^4 <= target <= 10^4

#### Java Solution
```java
public class TripletSumCloseToTarget {

    public static int tripletSumCloseToTarget(int[] nums, int target) {
        Arrays.sort(nums);
        int closeTarget = Integer.MIN_VALUE, min = 0, n = nums.length;
        for (int i = 0; i < n; i++) {
            int j = i + 1, k = n - 1;
            while (j < k) {
                int tmp = nums[i] + nums[j] + nums[k];
                int tmp_min = Math.abs(tmp - target);
                if (min > tmp_min) {
                    closeTarget = tmp;
                    min = tmp_min;
                }

                if (nums[i] + nums[j] + nums[k] > target) {
                    k--;
                } else {
                    j++;
                }
            }
        }
        return closeTarget;
    }
}
```

#### [Java Source Code](../../../src/main/java/com/algorithm/twopointers/TripletSumCloseToTarget.java)