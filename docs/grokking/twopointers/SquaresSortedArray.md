# 977. Squares of a Sorted Array - Easy

Given an integer array ```nums``` sorted in <b>non-decreasing</b> order, return an array of <b>the squares of each number</b> sorted in non-decreasing order.

##### Example 1:

```
Input: nums = [-4,-1,0,3,10]
Output: [0,1,9,16,100]
Explanation: After squaring, the array becomes [16,1,0,9,100].
After sorting, it becomes [0,1,9,16,100].
```

##### Example 2:

```
Input: nums = [-7,-3,2,3,11]
Output: [4,9,9,49,121]
```

##### Constraints:

- 1 <= nums.length <= 10<sup>4</sup>
- -10<sup>4</sup> <= nums[i] <= 10<sup>4</sup>
- nums is sorted in non-decreasing order.
 

<b>Follow up:</b> Squaring each element and sorting the new array is very trivial, could you find an ```O(n)``` solution using a different approach?

#### Java Solution
```java
public class SquaringArray {

    public static int[] squares(int[] nums) {
        int[] res = new int[nums.length];
        int i = 0, j = nums.length - 1, k = j;
        while (i <= j) {
            int sRes = nums[i] * nums[i], eRes = nums[j] * nums[j];
            if (sRes >= eRes) {
                res[k--] = sRes;
                i++;
            } else {
                res[k--] = eRes;
                j--;
            }
        }
        return res;
    }
}
```

#### [Java Source Code](../../../src/main/java/com/algorithm/twopointers/SquaringArray.java)