# Minimum Difference Element - Medium

Given an array of numbers sorted in ```ascending order```, find the element in the array that has the minimum difference with the given <b>key</b>.

##### Example 1:

```
Input: [4, 6, 10], key = 7
Output: 6
Explanation: The difference between the key '7' and '6' is minimum than any other number in the array 
```

##### Example 2:

```
Input: [4, 6, 10], key = 4
Output: 4
```

##### Example 3:

```
Input: [1, 3, 8, 10, 15], key = 12
Output: 10
```

##### Example 4:

```
Input: [4, 6, 10], key = 17
Output: 10
```
#### Java Solution
```java
public class MinimumDifferenceElement {
    public static int searchMinDiff(int[] nums, int target) {
        if (target < nums[0]) {
            return nums[0];
        }
        if (nums[nums.length - 1] < target) {
            return nums[nums.length - 1];
        }

        int i = 0, j = nums.length - 1;

        while (i <= j) {
            int mid = i + (j - i) / 2;
            if (nums[mid] == target) {
                return nums[mid];
            }
            if (nums[mid] > target) {
                j = mid - 1;
            } else {
                i = mid + 1;
            }
        }

        if (Math.abs(nums[i] - target) >= Math.abs(nums[j] - target)) {
            return nums[j];
        } else {
            return nums[i];
        }
    }
}
```

#### [Java Source Code](../../../src/main/java/com/algorithm/binarysearch/MinimumDifferenceElement.java)