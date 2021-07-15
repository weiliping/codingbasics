# Bitonic Array Maximum - Easy

Find the maximum value in a given ```Bitonic``` array. An array is considered ```bitonic``` if it is monotonically increasing and then monotonically decreasing. Monotonically increasing or decreasing means that for any index i in the array arr[i] != arr[i+1].

##### Example 1:

```
Input: [1, 3, 8, 12, 4, 2]
Output: 12
Explanation: The maximum number in the input bitonic array is '12'.
```

##### Example 2:

```
Input: [3, 8, 3, 1]
Output: 8
```

##### Example 3:

```
Input: [1, 3, 8, 12]
Output: 12
```

##### Example 4:

```
Input: [10, 9, 8]
Output: 10
```

#### Java Solution
```java
public class BitonicArrayMaximum {
    public static int bitonicArrayMaximum(int[] nums) {
        int i = 0, j = nums.length - 1;

        while (i < j) {
            int mid = i + (j - i) / 2;
            if (nums[mid] > nums[mid + 1]) {
                j = mid;
            } else {
                i = mid + 1;
            }
        }
        return nums[i];
    }
}
```

#### [Java Source Code](../../../src/main/java/com/algorithm/binarysearch/BitonicArrayMaximum.java)
