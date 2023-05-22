# 75. Sort Colors - Medium

Given an array ```nums``` with ```n``` objects colored red, white, or blue, sort them <b>in-place</b> so that objects of the same color are adjacent, with the colors in the order red, white, and blue.

We will use the integers ```0```, ```1```, and ```2``` to represent the color red, white, and blue, respectively.

##### Example 1:

```
Input: nums = [2,0,2,1,1,0]
Output: [0,0,1,1,2,2]
```

##### Example 2:

```
Input: nums = [2,0,1]
Output: [0,1,2]
```

##### Example 3:

```
Input: nums = [0]
Output: [0]
```

##### Example 4:

```
Input: nums = [1]
Output: [1]
```

##### Constraints:

- ```n == nums.length```
- ```1 <= n <= 300```
- ```nums[i] is 0, 1, or 2.```
 

##### Follow up:

- Could you solve this problem without using the library's sort function?
- Could you come up with a one-pass algorithm using only ```O(1)``` constant space?


#### Java Solution
```java
public class DutchFlagSort {

    public static void sortColor(int[] nums) {
        int l = 0, i = 0, r = nums.length - 1;

        while (i <= r) {
            if (nums[i] == 0) {
                int tmp = nums[l];
                nums[l] = nums[i];
                nums[i] = tmp;
                l++;
                i++;
                continue;
            }
            if (nums[i] == 2) {
                int tmp = nums[r];
                nums[r] = nums[i];
                nums[i] = tmp;
                r--;
                continue;
            }
            i++;
        }
    }
}
```

#### [Java Source Code](../../../src/main/java/com/algorithm/twopointers/DutchFlagSort.java)
- [Solution](../../../src/main/java/com/algorithm/twopointers/SortColors.java)