# 46. Permutations - Medium

Given an array ```nums``` of distinct integers, return all the possible permutations. You can return the answer in <b>any order</b>.


##### Example 1:

```
Input: nums = [1,2,3]
Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
```

##### Example 2:

```
Input: nums = [0,1]
Output: [[0,1],[1,0]]
```

##### Example 3:

```
Input: nums = [1]
Output: [[1]]
```

##### Constraints:

- 1 <= nums.length <= 6
- -10 <= nums[i] <= 10
- All the integers of ```nums``` are <b>unique</b>.

#### Java Solution
```java
public class Permute {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        helper(0, nums, result);
        return result;
    }

    private void helper(int start, int[] nums, List<List<Integer>> result) {
        if (start == nums.length - 1) {
            ArrayList<Integer> list = new ArrayList<>();
            for (int num : nums) {
                list.add(num);
            }
            result.add(list);
            return;
        }

        for (int i = start; i < nums.length; i++) {
            swap(nums, i, start);
            helper(start + 1, nums, result);
            swap(nums, i, start);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
```

#### [Java Source Code](../../../src/main/java/com/algorithm/backtracking/Permute.java)