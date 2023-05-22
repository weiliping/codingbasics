# 76. Minimum Window Substring - Hard

Given two strings ```s``` and ```t```, return the minimum window in ```s``` which will contain all the characters in ```t```. If there is no such window in ```s``` that covers all characters in ```t```, return the empty string ```""```.

Note that If there is such a window, it is guaranteed that there will always be only one unique minimum window in ```s```.
 

##### Example 1:

```
Input: s = "ADOBECODEBANC", t = "ABC"
Output: "BANC"
```

##### Example 2:

```
Input: s = "a", t = "a"
Output: "a"
``` 

##### Constraints:

- 1 <= s.length, t.length <= 10<sup>5</sup>
- <b>s</b> and <b>t</b> consist of English letters.
 

<b>Follow up:</b> Could you find an algorithm that runs in O(n) time?

#### Java Solution
```java
public class MinWindow {

    public static String minWindowII(String s, String t) {
        int[] letterCnt = new int[128];
        int left = 0, cnt = 0, minLeft = -1, minLen = Integer.MAX_VALUE;
        for (char c : t.toCharArray()) {
            ++letterCnt[c];
        }
        for (int i = 0; i < s.length(); i++) {
            if (--letterCnt[s.charAt(i)] >= 0) {
                ++cnt;
            }
            while (cnt == t.length()) {
                if (minLen > i - left + 1) {
                    minLen = i - left + 1;
                    minLeft = left;
                }

                if (++letterCnt[s.charAt(left)] > 0) {
                    --cnt;
                }
                ++left;
            }
        }
        return minLeft == -1 ? "" : s.substring(minLeft, minLeft + minLen);
    }

    public static String minWindow(String s, String t) {
        if (s == null || s.length() == 0 || t == null || t.length() == 0) {
            return "";
        }
        if (s.length() < t.length()) {
            return "";
        }

        int sl = s.length(), tl = t.length();
        Map<Character, Integer> letterCnt = new HashMap<>();
        for (char c : t.toCharArray()) {
            int count = letterCnt.containsKey(c) ? letterCnt.get(c) + 1 : 1;
            letterCnt.put(c, count);
        }

        String res = "";
        int cnt = 0, left = 0, minLen = Integer.MAX_VALUE;
        for (int i = 0; i < sl; i++) {
            char sChar = s.charAt(i);
            int charCnt = letterCnt.containsKey(sChar) ? letterCnt.get(sChar) : 0;
            letterCnt.put(sChar, --charCnt);
            if (letterCnt.get(sChar) >= 0) {
                cnt++;
            }
            while (cnt == tl) {
                if (minLen > i - left + 1) {
                    minLen = i - left + 1;
                    res = s.substring(left, left + minLen);
                }
                char leftC = s.charAt(left);
                letterCnt.put(leftC, letterCnt.get(leftC) + 1);
                if (letterCnt.get(leftC) > 0) {
                    cnt--;
                }
                left++;
            }
        }
        return res;
    }
}
```
#### [Java Source Code](../../../src/main/java/com/algorithm/strings/MinWindow.java)
