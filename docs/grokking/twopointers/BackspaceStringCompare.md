# 844. Backspace String Compare - Easy

Given two strings ```S``` and ```T```, return if they are equal when both are typed into empty text editors. ```#``` means a backspace character.

Note that after backspacing an empty text, the text will continue empty.

##### Example 1:

Input: S = "ab#c", T = "ad#c"
Output: true
Explanation: Both S and T become "ac".
##### Example 2:

Input: S = "ab##", T = "c#d#"
Output: true
Explanation: Both S and T become "".
##### Example 3:

Input: S = "a##c", T = "#a#c"
Output: true
Explanation: Both S and T become "c".
##### Example 4:

Input: S = "a#c", T = "b"
Output: false
Explanation: S becomes "c" while T becomes "b".
##### Note:

- ```1 <= S.length <= 200```
- ```1 <= T.length <= 200```
- ```S``` and ```T``` only contain lowercase letters and ```'#'``` characters.

##### Follow up:

Can you solve it in ```O(N)``` time and ```O(1)``` space?

#### Java Solution
```java
public class BackspaceCompare {
    public static boolean compare(String S, String T) {
        int i = S.length() - 1, j = T.length() - 1, cnt1 = 0, cnt2 = 0;

        while (i >= 0 || j >= 0) {
            while (i >= 0 && (S.charAt(i) == '#' || cnt1 > 0)) {
                if (S.charAt(i--) == '#') {
                    cnt1++;
                } else {
                    cnt1--;
                }
            }
            while (j >= 0 && (T.charAt(j) == '#' || cnt2 > 0)) {
                if (T.charAt(j--) == '#') {
                    cnt2++;
                } else {
                    cnt2--;
                }
            }
            if (i < 0 || j < 0) {
                return i == j;
            }

            if (S.charAt(i--) != T.charAt(j--)) {
                return false;
            }
        }
        return i == j;
    }

    public static boolean backspaceCompare(String str1, String str2) {
        return deleteBackspace(str1).equals(deleteBackspace(str2));
    }

    public static boolean backspaceCompareII(String str1, String str2) {
        return removeBackSpace(str1).equals(removeBackSpace(str2));
    }

    static String deleteBackspace(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c == '#') {
                if (sb.length() != 0) {
                    sb.deleteCharAt(sb.length() - 1);
                }
                continue;
            }
            sb.append(c);
        }
        return sb.toString();
    }

    static String removeBackSpace(String s) {
        Stack<Character> stack = new Stack<>();
        char[] chs = s.toCharArray();
        for (int i = chs.length - 1; i >= 0; i--) {
            if (stack.isEmpty()) {
                stack.push(chs[i]);
                continue;
            }
            if (stack.peek() == '#') {
                if (chs[i] != '#') {
                    stack.pop();
                    continue;
                }
                stack.push(chs[i]);
                continue;
            }
            stack.push(chs[i]);
        }

        while (!stack.isEmpty() && stack.peek() == '#') {
            stack.pop();
        }

        StringBuilder str = new StringBuilder();
        while (!stack.isEmpty()) {
            str.append(stack.pop());
        }
        return str.toString();
    }

    static String clean(String str) {
        int n = str.length(), i = n - 1;

        while (i >= 0) {
            int count = 0;
            while (i >= 0 && str.charAt(i) == '#') {
                count++;
                i--;
            }

            if (count > 0 && i + count == n - 1) {
                str = str.substring(0, i - count + 1);
                i -= count;
            } else if (count > 0 && i - count + 1 == 0) {
                str = str.substring(i + count + 1);
                i = -1;
            } else if (count > 0) {
                str = str.substring(0, i - count + 1) + str.substring(i + count + 1);
                i = i - count;
            } else {
                i--;
            }
        }
        return str;
    }
}
```

#### [Java Source Code](../../../src/main/java/com/algorithm/twopointers/BackspaceCompare.java)