# 713. Subarray Product Less Than K - Medium

our are given an array of positive integers ```nums```.

Count and print the number of (contiguous) subarrays where the product of all the elements in the subarray is less than ```k```.

##### Example 1:

```
Input: nums = [10, 5, 2, 6], k = 100
Output: 8
Explanation: The 8 subarrays that have product less than 100 are: [10], [5], [2], [6], [10, 5], [5, 2], [2, 6], [5, 2, 6].
Note that [10, 5, 2] is not included as the product of 100 is not strictly less than k.
```

##### Note:

- 0 < nums.length <= 50000.
- 0 < nums[i] < 1000.
- 0 <= k < 10^6.

#### Java Solution
```java
public class FindSubarray {

    public static List<Integer[]> findSubarray(int[] nums, int target) {
        int p = 1, l = 0, n = nums.length;

        List<Integer[]> res = new ArrayList<>();

        for (int r = 0; r < n; r++) {
            p *= nums[r];

            while (p >= target && l < n) {
                p /= nums[l];
                l++;
            }
            List<Integer> subRes = new ArrayList<>();
            for (int i = r; i > l - 1; i--) {
                subRes.add(nums[i]);
                res.add(getIntArray(subRes));
            }
        }
        return res;
    }

    static Integer[] getIntArray(List<Integer> res) {
        Integer[] r = new Integer[res.size()];
        for (int i = 0; i < res.size(); i++) {
            r[i] = res.get(i);
        }
        return r;
    }
}
```

#### [Java Source Code](../../../src/main/java/com/algorithm/twopointers/FindSubarray.java)