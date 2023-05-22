# 744. Find Smallest Letter Greater Than Target - Easy

Given a list of sorted characters ```letters``` containing only lowercase letters, and given a target letter ```target```, find the smallest element in the list that is larger than the given target.

Letters also wrap around. For example, if the target is ```target = 'z'``` and ```letters = ['a', 'b']```, the answer is ```'a'```.

##### Examples:

```
Input:
letters = ["c", "f", "j"]
target = "a"
Output: "c"

Input:
letters = ["c", "f", "j"]
target = "c"
Output: "f"

Input:
letters = ["c", "f", "j"]
target = "d"
Output: "f"

Input:
letters = ["c", "f", "j"]
target = "g"
Output: "j"

Input:
letters = ["c", "f", "j"]
target = "j"
Output: "c"

Input:
letters = ["c", "f", "j"]
target = "k"
Output: "c"
```

##### Note:
- ```letters``` has a length in range ```[2, 10000]```.
- ```letters``` consists of lowercase letters, and contains at least 2 unique letters.
- ```target``` is a lowercase letter.

#### Java Solution
```java
public class NextLetter {

    public static char nextGreatestLetter(char[] letters, char target) {
        int i = 0, j = letters.length - 1;
        while (i <= j) {
            int mid = i + (j - i) / 2;

            if (letters[mid] > target) {
                if (mid == 0 || letters[mid - 1] <= target) {
                    return letters[mid];
                }
                j = mid - 1;
            } else {
                i = mid + 1;
            }
        }
        return letters[0];
    }
}
```

#### [Java Source Code](../../../src/main/java/com/algorithm/binarysearch/NextLetter.java)