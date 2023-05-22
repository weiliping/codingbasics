# 1. Two Sum - Easy

Given an array of integers ```nums``` and an integer ```target```, return indices of the two numbers such that they add up to ```target```.

You may assume that each input would have <b>exactly one solution</b>, and you may not use the same element twice.

You can return the answer in any order.

##### Example 1:

```
Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Output: Because nums[0] + nums[1] == 9, we return [0, 1].
```

##### Example 2:

```
Input: nums = [3,2,4], target = 6
Output: [1,2]
```

##### Example 3:

```
Input: nums = [3,3], target = 6
Output: [0,1]
```

##### Constraints:

- 2 <= nums.length <= 10<sup>3</sup>
- -10<sup>9</sup> <= nums[i] <= 10<sup>9</sup>
- -10<sup>9</sup> <= target <= 10<sup>9</sup>
- <b>Only one valid answer exists.</b>

#### Java Solution
```java
public class PairWithTargetSum {

    public static int[] pairWithTargetSum(int[] nums, int target) {
        int[] pair = new int[] { -1, -1 };

        int l = 0, r = nums.length - 1;

        while (l <= r) {
            if (nums[l] + nums[r] == target) {
                pair[0] = l;
                pair[1] = r;
                return pair;
            }
            if (nums[l] + nums[r] > target) {
                r--;
                continue;
            }
            l++;
        }
        return pair;
    }
}
```

#### [Java Source Code](../../../src/main/java/com/algorithm/twopointers/PairWithTargetSum.java)