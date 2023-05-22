# 567. Permutation in String - Medium

Given two strings <b>s1</b> and <b>s2</b>, write a function to return true if <b>s2</b> contains the permutation of <b>s1</b>. In other words, one of the first string's permutations is the <b>substring</b> of the second string.

##### Example 1:
```
Input: s1 = "ab" s2 = "eidbaooo"
Output: True
Explanation: s2 contains one permutation of s1 ("ba").
```

##### Example 2:

```
Input:s1= "ab" s2 = "eidboaoo"
Output: False
```

##### Constraints:

- The input strings only contain lower case letters.
- The length of both given strings is in range [1, 10,000].

#### Java Solution
```java
public class PermutationInString {

    public static boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }
        int[] s1map = new int[26];
        int[] s2map = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            s1map[s1.charAt(i) - 'a']++;
            s2map[s2.charAt(i) - 'a']++;
        }
        for (int i = 0; i < s2.length() - s1.length(); i++) {
            if (matches(s1map, s2map)) {
                return true;
            }
            s2map[s2.charAt(i + s1.length()) - 'a']++;
            s2map[s2.charAt(i) - 'a']--;
        }
        return matches(s1map, s2map);
    }

    public static boolean matches(int[] s1map, int[] s2map) {
        for (int i = 0; i < 26; i++) {
            if (s1map[i] != s2map[i]) {
                return false;
            }
        }
        return true;
    }
}
```
#### [Java Source Code](../../../src/main/java/com/algorithm/slidingwindow/PermutationInString.java)

- [Reference](https://github.com/cherryljr/LeetCode/blob/master/Permutation%20in%20String.java)