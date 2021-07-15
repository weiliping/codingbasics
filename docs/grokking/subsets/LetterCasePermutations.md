# 784. Letter Case Permutation - Medium


Given a string S, we can transform every letter individually to be lowercase or uppercase to create another string.

Return *a list of all possible strings we could create*. You can return the output in <b>any order</b>.

 

##### Example 1:

```
Input: S = "a1b2"
Output: ["a1b2","a1B2","A1b2","A1B2"]
```

##### Example 2:

```
Input: S = "3z4"
Output: ["3z4","3Z4"]
```

##### Example 3:

```
Input: S = "12345"
Output: ["12345"]
```

##### Example 4:

```
Input: S = "0"
Output: ["0"]
```

##### Constraints:

- ```S``` will be a string with length between ```1``` and ```12```.
- ```S``` will consist only of letters or digits.

#### Java Solution
```java
public class LetterCasePermutation {
    public static List<String> letterCasePermutation(String S) {
        List<String> res = new ArrayList<>();
        if (S == null) {
            return res;
        }
        letterPermHelper(res, S.toCharArray(), 0);
        return res;
    }

    static void letterPermHelper(List<String> res, char[] chars, int s) {
        if (s == chars.length) {
            res.add(new String(chars));
            return;
        }
        if (chars[s] >= '0' && chars[s] <= '9') {
            letterPermHelper(res, chars, s + 1);
            return;
        }

        chars[s] =  Character.toUpperCase(chars[s]);
        letterPermHelper(res, chars, s + 1);

        chars[s] = Character.toLowerCase(chars[s]);
        letterPermHelper(res, chars, s + 1);
    }

    public static List<String> letterPermutation(String S) {
        return helper(S, S.length());
    }

    static List<String> helper(String str, int s) {
        if (s == 0) {
            List<String> res = new ArrayList<>();
            res.add("");
            return res;
        }

        List<String> subRes = helper(str, s - 1);

        List<String> res = new ArrayList<>();
        char ch = str.charAt(s - 1);
        boolean isDigit = Character.isDigit(ch);
        for (String subStr : subRes) {
            if (!isDigit) {
                res.add(subStr + Character.toLowerCase(ch));
                res.add(subStr + Character.toUpperCase(ch));
                continue;
            }
            res.add(subStr + ch);
        }
        return res;
    }
}
```

#### [Java Source Code](../../../src/main/java/com/algorithm/subsets/LetterCasePermutation.java)
- [Reference](https://massivealgorithms.blogspot.com/2019/01/leetcode-784-letter-case-permutation.html)