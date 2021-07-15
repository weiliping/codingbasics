# 287. Find the Duplicate Number - Medium

Given an array of integers ```nums``` containing ```n + 1``` integers where each integer is in the range ```[1, n]``` inclusive.

There is only <b>one repeated number</b> in ```nums```, return this repeated number.


##### Example 1:

```
Input: nums = [1,3,4,2,2]
Output: 2
```

##### Example 2:

```
Input: nums = [3,1,3,4,2]
Output: 3
```

##### Example 3:

```
Input: nums = [1,1]
Output: 1
```

##### Example 4:

```
Input: nums = [1,1,2]
Output: 1
```

##### Constraints:

- 2 <= n <= 3 * 10<sup>4</sup>
- ```nums.length == n + 1```
- ```1 <= nums[i] <= n```
- All the integers in ```nums``` appear only <b>once</b> except for <b>precisely one integer</b> which appears <b>two or more</b> times.
 

##### Follow up:

- How can we prove that at least one duplicate number must exist in ```nums```?
- Can you solve the problem <b>without</b> modifying the array ```nums```?
- Can you solve the problem using only constant, ```O(1)``` extra space?
- Can you solve the problem with runtime complexity less than <b>O(n<sup>2</sup>)</b>?

#### Java Solution
```java
public class FindDuplicate {

    public static int findDuplicate(int[] nums) {
        boolean[] duplicates = new boolean[nums.length];
        for (int num : nums) {
            if (!duplicates[num]) {
                duplicates[num] = true;
                continue;
            }
            return num;
        }
        return -1;
    }

    public static int findDuplicateI(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int j = Math.abs(nums[i]) - 1;
            if (nums[j] > 0) {
                nums[j] = - nums[j];
            } else {
                return j + 1;
            }
        }
        return -1;
    }
}
```

#### [Java Source Code](../../../src/main/java/com/algorithm/binarysearch/FindDuplicate.java)