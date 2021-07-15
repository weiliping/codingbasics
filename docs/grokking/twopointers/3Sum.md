# 15. 3Sum - Medium

Given an array nums of n integers, are there elements a, b, c in ```nums``` such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

Notice that the solution set must not contain duplicate triplets.

 

##### Example 1:

```
Input: nums = [-1,0,1,2,-1,-4]
Output: [[-1,-1,2],[-1,0,1]]
```
##### Example 2:

```
Input: nums = []
Output: []
```

##### Example 3:

```
Input: nums = [0]
Output: []
``` 

##### Constraints:

- ```0 <= nums.length <= 3000```
- -10<sup>5</sup> <= nums[i] <= 10<sup>5</sup>

#### Java Solution
```java
public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length < 1) {
            return res;
        }
        Arrays.sort(nums);
        int l = nums.length;
        for (int i = 0; i < l - 1; i++) {
            int j = i + 1, k = l - 1;

            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            while (j < k) {
                if (k < l - 1 && nums[k] == nums[k + 1]) {
                    k--;
                    continue;
                }
                if (nums[i] + nums[j] + nums[k] > 0) {
                    k--;
                } else if (nums[i] + nums[j] + nums[k] < 0) {
                    j++;
                } else {
                    List<Integer> sub = new ArrayList<>();
                    sub.add(nums[i]);
                    sub.add(nums[j]);
                    sub.add(nums[k]);
                    res.add(sub);
                    j++;
                    k--;
                }
            }
        }
        return res;
    }
}
```

#### [Java Source Code](../../../src/main/java/com/algorithm/twopointers/ThreeSum.java)