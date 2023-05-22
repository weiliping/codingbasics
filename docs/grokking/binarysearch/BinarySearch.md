# 704. Binary Search - Easy
Given a sorted array of numbers, find if a given number ```key``` is present in the array. Though we know that the array is sorted, we don’t know if it’s sorted in ascending or descending order. You should assume that the array can have duplicates.

Write a function to return the index of the ```key``` if it is present in the array, otherwise return ```-1```.

##### Example 1:

```
Input: [4, 6, 10], key = 10
Output: 2
```

##### Example 2:

```
Input: [1, 2, 3, 4, 5, 6, 7], key = 5
Output: 4
```

##### Example 3:

```
Input: [10, 6, 4], key = 10
Output: 0
```

##### Example 4:

```
Input: [10, 6, 4], key = 4
Output: 2
```

#### Java Solution
```java
public class BinarySearch {

    public static int binarySearch(int[] nums, int target) {
        int i = 0, j = nums.length - 1;

        while (i <= j) {
            int mid = i + (j - i) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] > target) {
                j = mid - 1;
            } else {
                i = mid + 1;
            }
        }
        return -1;
    }
}
```

#### [Java Source Code](../../../src/main/java/com/algorithm/binarysearch/BinarySearch.java)