# 78. Subsets - Medium

Given an integer array ```nums``` of <b>unique</b> elements, return all possible subsets (the power set).

The solution set <b>must not</b> contain duplicate subsets. Return the solution in <b>any order</b>.
 

##### Example 1:

```
Input: nums = [1,2,3]
Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
```

##### Example 2:

```
Input: nums = [0]
Output: [[],[0]]
```

##### Constraints:

- 1 <= nums.length <= 10
- -10 <= nums[i] <= 10
- All the numbers of ```nums``` are <b>unique</b>.

#### Java Solution
```java
public class Subsets {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        helper(nums, 0, res, new ArrayList<>());
        return res;
    }

    static void helper(int[] nums, int start, List<List<Integer>> res, List<Integer> sub) {
        res.add(new ArrayList<>(sub));
        for (int j = start; j < nums.length; j++) {
            sub.add(nums[j]);
            helper(nums, j + 1, res, sub);
            sub.remove(sub.size() - 1);
        }
    }
}
```

#### [Java Source Code](../../../src/main/java/com/algorithm/backtracking/Subsets.java)