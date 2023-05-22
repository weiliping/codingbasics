# Find all missing numbers - Easy

We are given an unsorted array containing numbers taken from the range 1 to ‘n’. 
The array can have duplicates, which means some numbers will be missing. Find all those missing numbers.

##### Example 1:

```
Input: [2, 3, 1, 8, 2, 3, 5, 1]
Output: 4, 6, 7
Explanation: The array should have all numbers from 1 to 8, due to duplicates 4, 6, and 7 are missing.
```

##### Example 2:

```
Input: [2, 4, 1, 2]
Output: 3
```

##### Example 3:

```
Input: [2, 3, 2, 1]
Output: 4
```

#### Java Solution
```java
public class FindMissingNumbers {

    public static List<Integer> findMissingNumbers(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                int j = nums[i] - 1, t = nums[j];
                nums[j] = nums[i];
                nums[i] = t;
            }
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                res.add(i + 1);
            }
        }
        return res;
    }
}
```

#### [Java Source Code](../../../src/main/java/com/algorithm/cyclicsort/FindMissingNumbers.java)