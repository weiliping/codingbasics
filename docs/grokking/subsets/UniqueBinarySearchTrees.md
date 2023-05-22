# 96. Unique Binary Search Trees - Medium


Given an integer ```n```, return the number of structurally unique <b>BST</b>'s (binary search trees) which has exactly ```n``` nodes of unique values from 1 to ```n```.
 

##### Example 1:
![](96_sample_01.jpeg)

```
Input: n = 3
Output: 5
```

##### Example 2:

```
Input: n = 1
Output: 1
```

##### Constraints:

- 1 <= n <= 19

#### Java Solution
```java
public class UniqueBinarySearchTrees {

    public static int numTrees(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        int[] dp = new int[n + 1];

        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] += dp[j] * dp[i - j - 1];
            }
        }
        return dp[n];
    }
}
```

#### [Java Source Code](../../../src/main/java/com/algorithm/dynamicprogramming/UniqueBinarySearchTrees.java)