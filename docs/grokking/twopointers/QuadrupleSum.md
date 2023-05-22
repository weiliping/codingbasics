# 18. 4Sum - Medium

Given an array ```nums``` of n integers and an integer ```target```, are there elements a, b, c, and d in ```nums``` such that a + b + c + d = ```target```? Find all unique quadruplets in the array which gives the sum of ```target```.

<b>Notice</b> that the solution set must not contain duplicate quadruplets.

##### Example 1:

```
Input: nums = [1,0,-1,0,-2,2], target = 0
Output: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
```
##### Example 2:

```
Input: nums = [], target = 0
Output: []
``` 

##### Constraints:

- ```0 <= nums.length <= 200```
- -10<sup>9</sup> <= nums[i] <= 10<sup>9</sup>
- -10<sup>9</sup> <= target <= 10<sup>9</sup>

#### Java Solution
```java
public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length < 4) {
            return res;
        }
        Arrays.sort(nums);
        int n = nums.length;

        for (int i = 0; i < (n - 3); i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < n - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                int l = j + 1, k = n - 1;
                int twosum = target - nums[i] - nums[j];
                while (l < k) {
                    int sum = nums[l] + nums[k];
                    if (twosum == sum) {
                        List<Integer> subRes = new ArrayList<>();
                        subRes.add(nums[i]);
                        subRes.add(nums[j]);
                        subRes.add(nums[l]);
                        subRes.add(nums[k]);
                        res.add(subRes);

                        while (l < k && nums[l + 1] == nums[l]) {
                            l++;
                        }
                        while (l < k && nums[k - 1] == nums[k]) {
                            k--;
                        }
                        l++;
                        k--;
                    } else if (twosum > sum) {
                        l++;
                    } else {
                        k--;
                    }
                }
            }
        }
        return res;
    }

    public List<List<Integer>> threeSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length < 3) {
            return res;
        }
        Arrays.sort(nums);
        int n = nums.length;
        for (int i = 0; i < n - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int j = i + 1, k = n - 1;
            int sum = target - nums[i];
            while (j < k) {
                int left = nums[j] + nums[k];
                if (sum == left) {
                    List<Integer> subRes = new ArrayList<>();
                    subRes.add(nums[i]);
                    subRes.add(nums[j]);
                    subRes.add(nums[k]);
                    res.add(subRes);
                    j++;
                    k--;
                    while (j < k && nums[j] == nums[j + 1]) {
                        j++;
                    }
                    while (j < k && nums[k - 1] == nums[k]) {
                        k--;
                    }
                } else if (sum > left) {
                    j++;
                } else {
                    k--;
                }
            }
        }
        return res;
    }
}
```

#### [Java Source Code](../../../src/main/java/com/algorithm/twopointers/FourSum.java)
