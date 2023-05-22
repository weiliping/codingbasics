# Ceiling of a Number - Medium

Given an array of numbers sorted in an ascending order, find the ceiling of a given number <b>key</b>. The ceiling of the <b>key</b> will be the smallest element in the given array greater than or equal to the <b>key</b>.
Write a function to return the index of the ceiling of the <b>key</b>. If there isn’t any ceiling return <b>-1</b>.
##### Example 1:

```
Input: [4, 6, 10], key = 6
Output: 1
Explanation: The smallest number greater than or equal to '6' is '6' having index '1'.
```

##### Example 2:

```
Input: [1, 3, 8, 10, 15], key = 12
Output: 4
Explanation: The smallest number greater than or equal to '12' is '15' having index '4'.
```

##### Example 3:

```
Input: [4, 6, 10], key = 17
Output: -1
Explanation: There is no number greater than or equal to '17' in the given array.
```

##### Example 4:

```
Input: [4, 6, 10], key = -1
Output: 0
Explanation: The smallest number greater than or equal to '-1' is '4' having index '0'.
```
#### Java Solution
```java
public class CeilingNumber {

    public static int searchCeiling(int[] nums, int target) {
        int i = 0, j = nums.length - 1;

        while (i <= j) {
            int mid = i + (j - i) / 2;

            if (nums[mid] >= target) {
                if (mid == 0) {
                    return mid;
                } else if (nums[mid - 1] < target) {
                    return mid;
                }
                j = mid - 1;
            } else {
                i = mid + 1;
            }
        }
        return -1;
    }
}
```

#### [Java Source Code](../../../src/main/java/com/algorithm/binarysearch/CeilingNumber.java)