# 30. Substring with Concatenation of All Words - Hard

You are given a string ```s``` and an array of strings ```words``` of <b>the same length</b>. Return all starting indices of substring(s) in ```s``` that is a concatenation of each word in ```words``` <b>exactly once, in any order</b>, and <b>without any intervening characters</b>.

You can return the answer in any order.

##### Example 1:

```
Input: s = "barfoothefoobarman", words = ["foo","bar"]
Output: [0,9]
Explanation: Substrings starting at index 0 and 9 are "barfoo" and "foobar" respectively.
The output order does not matter, returning [9,0] is fine too.
```

##### Example 2:

```
Input: s = "wordgoodgoodgoodbestword", words = ["word","good","best","word"]
Output: []
```

##### Example 3:

```
Input: s = "barfoofoobarthefoobarman", words = ["bar","foo","the"]
Output: [6,9,12]
``` 

##### Constraints:

- 1 <= s.length <= 104
- s consists of lower-case English letters.
- 1 <= words.length <= 5000
- 1 <= words[i].length <= 30
- words[i] consists of lower-case English letters.

#### Java Solution
```java
public class SubstringWithAllWordsConcatenation {

    public static List<Integer> findSubstring(String s, String[] words) {
        int stringLen = 0;
        List<Integer> res = new ArrayList<>();
        if (s == null || "".equals(s.trim()) || words == null || words.length == 0) {
            return res;
        }
        Map<String, Integer> dicWords = new HashMap<>();
        for (String word : words) {
            if (dicWords.get(word) == null) {
                dicWords.put(word, 1);
            } else {
                dicWords.put(word, dicWords.get(word) + 1);
            }
        }
        int wLength = words[0].length();
        int wArrayLength = words.length;
        stringLen += wLength * wArrayLength;
        int j = 0;
        while (j + stringLen <= s.length()) {
            String subStr = s.substring(j, j + stringLen);
            int k = 0;
            Map<String, Integer> subDic = new HashMap<>();
            while (k + wLength <= subStr.length()) {
                String subWord = subStr.substring(k, k + wLength);
                if (dicWords.get(subWord) == null) {
                    break;
                }
                if (subDic.get(subWord) == null) {
                    subDic.put(subWord, 1);
                } else {
                    subDic.put(subWord, subDic.get(subWord) + 1);
                }
                k = k + wLength;
            }
            if (dicWords.equals(subDic)) {
                res.add(j);
            }
            j++;
        }
        return res;
    }
}
```
#### [Java Source Code](../../../src/main/java/com/algorithm/strings/SubstringWithAllWordsConcatenation.java)