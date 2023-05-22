# 90. Subsets II - Medium

Given an integer array ```nums``` that may contain duplicates, return *all possible subsets (the power set)*.

The solution set <b>must not</b> contain duplicate subsets. Return the solution in <b>any order</b>.



##### Example 1:

```
Input: nums = [1,2,2]
Output: [[],[1],[1,2],[1,2,2],[2],[2,2]]
```

##### Example 2:

```
Input: nums = [0]
Output: [[],[0]]
``` 

##### Constraints:

- 1 <= nums.length <= 10
- -10 <= nums[i] <= 10

#### Java Solution
```java
public class SubsetsII {

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> out = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        Arrays.sort(nums);
        dfs(nums, 0, nums.length, res, out);
        res.add(new ArrayList<Integer>());
        return res;
    }

    static void dfs(int[] nums, int s, int l, List<List<Integer>> res, List<Integer> out) {
        HashSet<Integer> set = new HashSet<>();
        for (int j = s; j < l; j++) {
            if (set.contains(nums[j])) {
                continue;
            }
            set.add(nums[j]);
            out.add(nums[j]);
            res.add(new ArrayList<Integer>(out));
            dfs(nums, j + 1, l, res, out);
            out.remove(out.size() - 1);
        }
    }
}
```

#### [Java Source Code](../../../src/main/java/com/algorithm/backtracking/SubsetsII.java)