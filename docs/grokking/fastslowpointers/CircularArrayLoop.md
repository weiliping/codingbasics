# 457. Circular Array Loop - Medium

You are playing a game involving a <b>circular</b> array of non-zero integers ```nums```. Each ```nums[i]``` denotes the number of indices forward/backward you must move if you are located at index ```i```:

- If ```nums[i]``` is positive, move ```nums[i]``` steps <b>forward</b>, and
- If ```nums[i]``` is negative, move ```nums[i]``` steps <b>backward</b>.

Since the array is <b>circular</b>, you may assume that moving forward from the last element puts you on the first element, and moving backwards from the first element puts you on the last element.

A <b>cycle</b> in the array consists of a sequence of indices ```seq``` of length ```k``` where:

- Following the movement rules above results in the repeating index sequence ```seq[0] -> seq[1] -> ... -> seq[k - 1] -> seq[0] -> ...```
- Every ```nums[seq[j]]``` is either <b>all positive</b> or <b>all negative</b>.
- ```k > 1```

Return ```true``` if there is a <b>cycle</b> in ```nums```, or ```false``` otherwise.


##### Example 1:

```
Input: nums = [2,-1,1,2,2]
Output: true
Explanation:
There is a cycle from index 0 -> 2 -> 3 -> 0 -> ...
The cycle's length is 3.
```

##### Example 2:

```
Input: nums = [-1,2]
Output: false
Explanation:
The sequence from index 1 -> 1 -> 1 -> ... is not a cycle because the sequence's length is 1.
By definition the sequence's length must be strictly greater than 1 to be a cycle.
```

##### Example 3:

```
Input: nums = [-2,1,-1,-2,-2]
Output: false
Explanation:
The sequence from index 1 -> 2 -> 1 -> ... is not a cycle because nums[1] is positive, but nums[2] is negative.
Every nums[seq[j]] must be either all positive or all negative.
``` 

##### Constraints:

- ```1 <= nums.length <= 5000```
- ```-1000 <= nums[i] <= 1000```
- ```nums[i] != 0```

#### Java Solution
```java
public class CircularArrayLoop {

    public static boolean circularArrayLoop(int[] nums) {
        if (nums == null || nums.length < 2) {
            return false;
        }
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                continue;
            }
            // slow/fast pointer
            int j = i, k = getIndex(i, nums);
            while (nums[k] * nums[i] > 0 && nums[getIndex(k, nums)] * nums[i] > 0) {
                if (j == k) {
                    // check for loop with only one element
                    if (j == getIndex(j, nums)) {
                        break;
                    }
                    return true;
                }
                j = getIndex(j, nums);
                k = getIndex(getIndex(k, nums), nums);
            }
            // loop not found, set all element along the way to 0
            j = i;
            int val = nums[i];
            while (nums[j] * val > 0) {
                int next = getIndex(j, nums);
                nums[j] = 0;
                j = next;
            }
        }
        return false;
    }

    public static int getIndex(int i, int[] nums) {
        int n = nums.length;
        return i + nums[i] >= 0 ? (i + nums[i]) % n : n + ((i + nums[i]) % n);
    }
}
```

#### [Java Source Code](../../../src/main/java/com/algorithm/linkedlists/CircularArrayLoop.java)
- [Reference](https://massivealgorithms.blogspot.com/2016/11/leetcode-457-circular-array-loop.html)