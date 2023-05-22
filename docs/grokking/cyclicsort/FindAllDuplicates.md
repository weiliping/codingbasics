# 442. Find All Duplicates in an Array - Medium
Given an array of integers, 1 ≤ a[i] ≤ n (n = size of array), some elements appear <b>twice</b> and others appear <b>once</b>.

Find all the elements that appear twice in this array.

Could you do it without extra space and in O(n) runtime?

##### Example:

```
Input:
[4,3,2,7,8,2,3,1]

Output:
[2,3]
```

#### Java Solution
```java
public class FindAllDuplicates {

    public static List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int j = Math.abs(nums[i]) - 1;
            if (nums[j] > 0) {
                nums[j] = -nums[j];
                continue;
            }
            res.add(j + 1);
        }
        return res;
    }
}
```

#### [Java Source Code](../../../src/main/java/com/algorithm/cyclicsort/FindAllDuplicates.java)