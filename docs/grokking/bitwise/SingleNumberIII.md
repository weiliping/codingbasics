# 260. Single Number III - Medium
Given an integer array ```nums```, in which exactly two elements appear only once and all the other elements appear exactly twice. Find the two elements that appear only once. You can return the answer in <b>any order</b>.

<b>Follow up:</b> Your algorithm should run in linear runtime complexity. Could you implement it using only constant space complexity?

 

Example 1:

```
Input: nums = [1,2,1,3,2,5]
Output: [3,5]
Explanation:  [5, 3] is also a valid answer.
```

##### Example 2:

```
Input: nums = [-1,0]
Output: [-1,0]
```

##### Example 3:

```
Input: nums = [0,1]
Output: [1,0]
```

##### Constraints:

- 2 <= nums.length <= 3 * 10<sup>4</sup>
- -2<sup>31</sup> <= nums[i] <= 2<sup>31</sup> - 1
- Each integer in ```nums``` will appear twice, only two integers will appear once.

#### Java Solution
```java
public class SingleNumberIII {
    public static int[] singleNumberIII(int[] nums) {
        int xorNums = 0;
        for (int num : nums) {
            xorNums ^= num;
        }

        int rightBitDiff = 1;
        while ((rightBitDiff & xorNums) == 0) {
            rightBitDiff = rightBitDiff << 1;
        }

        int res[] = new int[2];
        for (int num : nums) {
            if ((num & rightBitDiff) != 0) {
                res[1] ^= num;
            } else {
                res[0] ^= num;
            }
        }
        return res;
    }
}
```

#### [Java Source Code](../../../src/main/java/com/algorithm/bitmanipulation/SingleNumberIII.java)