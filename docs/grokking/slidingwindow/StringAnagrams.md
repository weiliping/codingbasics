# 438. Find All Anagrams in a String - Medium

Given a string s and a <b>non-empty</b> string <b>p</b>, find all the start indices of <b>p</b>'s anagrams in <b>s</b>.

Strings consists of lowercase English letters only and the length of both strings <b>s</b> and <b>p</b> will not be larger than 20,100.

The order of output does not matter.

##### Example 1:

```
Input:
s: "cbaebabacd" p: "abc"

Output:
[0, 6]

Explanation:
The substring with start index = 0 is "cba", which is an anagram of "abc".
The substring with start index = 6 is "bac", which is an anagram of "abc".
```

##### Example 2:

```
Input:
s: "abab" p: "ab"

Output:
[0, 1, 2]

Explanation:
The substring with start index = 0 is "ab", which is an anagram of "ab".
The substring with start index = 1 is "ba", which is an anagram of "ab".
The substring with start index = 2 is "ab", which is an anagram of "ab".
```

#### Java Solution
```java
public class StringAnagrams {

    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();
        if (s == null || s.length() == 0 || p == null || p.length() == 0) {
            return list;
        }
        int[] hash = new int[256]; //character hash
        for (char c : p.toCharArray()) {
            hash[c]++;
        }

        int left = 0, right = 0, count = p.length();
        while (right < s.length()) {
            if (hash[s.charAt(right++)]-- >= 1) {
                count--;
            }

            if (count == 0) {
                list.add(left);
            }

            if (right - left == p.length() && hash[s.charAt(left++)]++ >= 0) {
                count++;
            }
        }
        return list;
    }
}
```
#### [Java Source Code](../../../src/main/java/com/algorithm/slidingwindow/StringAnagrams.java)

- [Reference](https://massivealgorithms.blogspot.com/2016/10/leetcode-438-find-all-anagrams-in-string.html)
- [Solution](https://codenuclear.com/leetcode-find-all-anagrams-in-a-string/)