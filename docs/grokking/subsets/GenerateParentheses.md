# 22. Generate Parentheses - Medium

Given ```n``` pairs of parentheses, write a function to generate all combinations of well-formed parentheses.


##### Example 1:

```
Input: n = 3
Output: ["((()))","(()())","(())()","()(())","()()()"]
```

##### Example 2:

```
Input: n = 1
Output: ["()"]
```

##### Constraints:

- 1 <= n <= 8

#### Java Solution
```java
public class GenerateParenthesis {

    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        if (n < 1) {
            return res;
        }
        dfs(n, n, "", res);
        return res;
    }

    static void dfs(int left, int right, String path, List<String> res) {
        if (left == 0 && right == 0) {
            res.add(path);
            return;
        }

        if (left > 0) {
            dfs(left - 1, right, path + "(", res);
        }

        if (left < right) {
            dfs(left, right - 1, path + ")", res);
        }
    }
}
```

#### [Java Source Code](../../../src/main/java/com/algorithm/backtracking/GenerateParenthesis.java)