# 424. Longest Repeating Character Replacement - Medium

Given a string s that consists of only uppercase English letters, you can perform at most k operations on that string.

In one operation, you can choose <b>any</b> character of the string and change it to any other uppercase English character.

Find the length of the longest sub-string containing all repeating letters you can get after performing the above operations.

<b>Note:</b>
Both the string's length and ```k``` will not exceed 10<sup>4</sup>.

##### Example 1:

```
Input:
s = "ABAB", k = 2

Output:
4

Explanation:
Replace the two 'A's with two 'B's or vice versa.
``` 

##### Example 2:

```
Input:
s = "AABABBA", k = 1

Output:
4

Explanation:
Replace the one 'A' in the middle with 'B' and form "AABBBBA".
The substring "BBBB" has the longest repeating letters, which is 4.
``` 

#### Java Solution
```java
public class CharacterReplacement {
    public static int characterReplacement(String s, int k) {
        int[] count = new int[26];
        int maxCount = 0;
        int maxLength = 0;

        int left = 0;

        for (int right = 0; right < s.length(); right++) {
            count[s.charAt(right) - 'A'] += 1;
            maxCount = Math.max(maxCount, count[s.charAt(right) - 'A']);
            while (right - left + 1 - maxCount > k) {
                count[s.charAt(left) - 'A'] -= 1;
                left++;
            }
            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }

    public static int characterReplacementII(String s, int k) {
        if(s == null || s.length() == 0){
            return 0;
        }
        int max = 0;
        int[] ch = new int[26];
        char[] str = s.toCharArray();
        for(int i=0, j=0; i<s.length(); i++){
            while(j < s.length()){
                ch[str[j] - 'A']++;
                if(count(ch) > k){  //If exceed k, break
                    ch[str[j] - 'A']--;
                    break;
                }
                j++;
            }
            max = Math.max(max, j-i);
            ch[str[i] - 'A']--;
        }
        return max;
    }

    //Count the number of character that is different to the longest character
    public static int count(int[] ch){
        int max = 0;
        int sum = 0;
        for(int val:ch){
            sum += val;
            max = Math.max(max, val);
        }
        return sum - max;
    }
}
```
#### [Java Source Code](../../../src/main/java/com/algorithm/slidingwindow/CharacterReplacement.java)
- [Reference](https://aaronice.gitbook.io/lintcode/two_pointers/longest-repeating-character-replacement)