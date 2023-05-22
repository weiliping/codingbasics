# Rotation Count - Medium
 
Given an array of numbers which is sorted in ascending order and is rotated ```k``` times around a pivot, find ```k```.
You can assume that the array does not have any duplicates.

##### Example 1:

```
Input: [10, 15, 1, 3, 8]
Output: 2
Explanation: The array has been rotated 2 times.
```

##### Example 2:

```
Input: [4, 5, 7, 9, 10, -1, 2]
Output: 5
Explanation: The array has been rotated 5 times.
```

##### Example 3:

```
Input: [1, 3, 8, 10]
Output: 0
Explanation: The array has been not been rotated.
```

#### Java Solution
```java
public class RotationCount {
    public static int countRotations(int[] nums) {
        int i = 0, j = nums.length - 1;

        while (i <= j) {
            int mid = i + (j - i) / 2;

            if (mid < j && nums[mid] > nums[mid + 1]) {
                return mid + 1;
            }

            if (mid > i && nums[mid] < nums[mid - 1]) {
                return mid;
            }

            if (nums[i] < nums[mid]) {
                i = mid + 1;
            } else {
                j = mid - 1;
            }
        }
        return 0;
    }
}
```

#### [Java Source Code](../../../src/main/java/com/algorithm/binarysearch/RotationCount.java)