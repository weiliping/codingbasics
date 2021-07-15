# 340. Longest Substring with At Most K Distinct Characters - Medium

Given a string, find the length of the longest substring T that contains at most k distinct characters.

##### Example 1:

```
Input: s = "eceba", k = 2
Output: 3

Explanation: T is "ece" which its length is 3.
```

##### Example 2:

```
Input: s = "aa", k = 1
Output: 2

Explanation: T is "aa" which its length is 2.
```

#### Java Solution
```java
public class LongestSubstringKCharacters {
    public static int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (s == null || s.length() == 0 || k <= 0) {
            return 0;
        }

        int[] countArr = new int[256];
        int count = 0;

        int left = 0;
        int maxLen = 0;

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            if (countArr[c] == 0) {
                count++;
            }

            countArr[c]++;
            if (count <= k) {
                maxLen = Math.max(maxLen, right - left + 1);
            }

            while (count > k) {
                char leftChar = s.charAt(left);
                countArr[leftChar]--;

                if (countArr[leftChar] == 0) {
                    count--;
                }

                left++;
            }
        }

        return maxLen;
    }
}
```
#### [Java Source Code](../../../src/main/java/com/algorithm/slidingwindow/LongestSubstringKCharacters.java)
- [Reference](https://www.programcreek.com/2013/02/longest-substring-which-contains-2-unique-characters/)