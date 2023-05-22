# 3. Longest Substring Without Repeating Characters - Medium

Given a string ```s```, find the length of the <b>longest substring</b> without repeating characters.

##### Example 1:

```
Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
```

##### Example 2:

```
Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
```

##### Example 3:

```
Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
```

##### Example 4:
```
Input: s = ""
Output: 0
``` 

##### Constraints:

- 0 <= s.length <= 5 * 10<sup>4</sup>
- ```s``` consists of English letters, digits, symbols and spaces.

#### Java Solution
```java
public class LengthOfLongestSubstring {

    public static int solution(String s) {
        if (s == null || "".equals(s.trim())) {
            return 0;
        }
        int max = 0;
        char[] chars = s.toCharArray();
        Set<Character> uniqueChars = new HashSet<>();
        int j = 0;
        for (int i = 0; i < chars.length; i++) {
            char current = chars[i];
            if (!uniqueChars.contains(current)) {
                uniqueChars.add(chars[i]);
                max = max > uniqueChars.size() ? max : uniqueChars.size();
            } else {
                while (j < i) {
                    if (chars[j] == current) {
                        j++;
                        break;
                    }
                    uniqueChars.remove(chars[j]);
                    j++;
                }
            }
        }
        return max;
    }
}
```
#### [Java Source Code](../../../src/main/java/com/algorithm/strings/LengthOfLongestSubstring.java)
- [Reference](https://www.programcreek.com/2013/02/leetcode-longest-substring-without-repeating-characters-java/)

