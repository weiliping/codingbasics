# Find the Corrupt Pair (easy)
We are given an unsorted array containing ‘n’ numbers taken from the range 1 to ‘n’. The array originally contained all the numbers from 1 to ‘n’, but due to a data error, one of the numbers got duplicated which also resulted in one number going missing. Find both these numbers.

##### Example 1:
```
Input: [3, 1, 2, 5, 2]
Output: [2, 4]
Explanation: '2' is duplicated and '4' is missing.
```

##### Example 2:

```
Input: [3, 1, 2, 3, 6, 4]
Output: [3, 5]
Explanation: '3' is duplicated and '5' is missing.
```

#### Java Solution
```java
public class FindCorruptPair {

    public static int[] findCorruptNumbers(int[] nums) {
        int[] res = new int[2];
        int i = 0, n = nums.length;

        while (i < n) {
            int j = nums[i] - 1;
            if (i != j) {
                if (nums[i] != nums[j]) {
                    int t = nums[j];
                    nums[j] = nums[i];
                    nums[i] = t;
                } else {
                    res[0] = nums[i];
                    i += 1;
                }
                continue;
            }
            i += 1;
        }

        for (int j = 0; j < n; j++) {
            if (nums[j] - 1 != j) {
                res[1] = j + 1;
            }
        }
        return res;
    }
}
```

#### [Java Source Code](../../../src/main/java/com/algorithm/cyclicsort/FindCorruptPair.java)