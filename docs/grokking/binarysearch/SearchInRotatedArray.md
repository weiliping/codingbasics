# 33. Search in Rotated Array - Medium

There is an integer array ```nums``` sorted in ascending order (with <b>distinct</b> values).

Prior to being passed to your function, ```nums``` is <b>rotated</b> at an unknown pivot index ```k``` (```0 <= k < nums.length```) such that the resulting array is ```[nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]``` (<b>0-indexed</b>). For example, ```[0,1,2,4,5,6,7]``` might be rotated at pivot index 3 and become ```[4,5,6,7,0,1,2]```.

Given the array ```nums``` <b>after</b> the rotation and an integer ```target```, return the index of ```target``` if it is in ```nums```, or ```-1``` if it is not in ```nums```.

 

##### Example 1:

```
Input: nums = [4,5,6,7,0,1,2], target = 0
Output: 4
```

##### Example 2:

```
Input: nums = [4,5,6,7,0,1,2], target = 3
Output: -1
```

##### Example 3:

```
Input: nums = [1], target = 0
Output: -1
``` 

##### Constraints:

- ```1 <= nums.length <= 5000```
- -10<sup>4</sup> <= nums[i] <= 10<sup>4</sup>
- All values of ```nums``` are <b>unique</b>.
- ```nums``` is guaranteed to be rotated at some pivot.
- -10<sup>4</sup> <= target <= 10<sup>4</sup>

#### Java Solution
```java
public class SearchInRotatedSortedArray {

    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int s = 0, n = nums.length - 1;

        while (s <= n) {
            int mid = s + (n - s) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] < nums[n]) {
                if (nums[mid] < target && nums[n] >= target) {
                    s = mid + 1;
                } else {
                    n = mid - 1;
                }
            } else {
                if (nums[s] <= target && nums[mid] > target) {
                    n = mid - 1;
                } else {
                    s = mid + 1;
                }
            }
        }
        return -1;
    }
}
```

#### [Java Source Code](../../../src/main/java/com/algorithm/binarysearch/SearchInRotatedSortedArray.java) 