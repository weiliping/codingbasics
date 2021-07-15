# 136. Single Number - Easy

Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.

<b>Follow up:</b> Could you implement a solution with a linear runtime complexity and without using extra memory?


##### Example 1:

```
Input: nums = [2,2,1]
Output: 1
```

##### Example 2:

```
Input: nums = [4,1,2,1,2]
Output: 4
```

##### Example 3:

```
Input: nums = [1]
Output: 1
```

##### Constraints:

- 1 <= nums.length <= 3 * 10<sup>4</sup>
- -3 * 10<sup>4</sup> <= nums[i] <= 3 * 10<sup>4</sup>
- Each element in the array appears twice except for one element which appears only once.


#### Java Solution
```java
public class SingleNumber {

    public static int singleNumber(int[] nums) {
        int res = 0;
        for (int n : nums) {
            res = res ^ n;
        }
        return res;
    }
}
```

#### [Java Source Code](../../../src/main/java/com/algorithm/bitmanipulation/SingleNumber.java)