# 34. Find First and Last Position of Element in Sorted Array - Medium
Given an array of integers ```nums``` sorted in ascending order, find the starting and ending position of a given target value.

If target is not found in the array, return ```[-1, -1]```.

<b>Follow up:</b> Could you write an algorithm with ```O(log n)``` runtime complexity?


##### Example 1:

```
Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]
```

##### Example 2:

```
Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]
```

##### Example 3:

```
Input: nums = [], target = 0
Output: [-1,-1]
```

##### Constraints:

- 0 <= nums.length <= 10<sup>5</sup>
- -10<sup>9</sup> <= nums[i] <= 10<sup>9</sup>
- ```nums is a non-decreasing array.```
- -10<sup>9</sup> <= target <= 10<sup>9</sup>

#### Java Solution
```java
public class SearchRange {

    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[2];
        res[0] = leftPosition(nums, target);
        res[1] = rightPosition(nums, target);
        return res;
    }

    static int leftPosition(int[] nums, int target) {
        int start = 0, end = nums.length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (target > nums[mid]) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        if (start < nums.length && nums[start] == target) {
            return start;
        }
        return -1;
    }

    static int rightPosition(int[] nums, int target) {
        int start = 0, end = nums.length - 1;
        while (start < end) {
            int mid = start + (end - start + 1) / 2;
            if (target < nums[mid]) {
                end = mid - 1;
            } else {
                start = mid;
            }
        }
        if (end < nums.length && end >= 0 && nums[end] == target) {
            return end;
        }
        return -1;
    }
}
```

#### [Java Source Code](../../../src/main/java/com/algorithm/binarysearch/SearchRange.java)