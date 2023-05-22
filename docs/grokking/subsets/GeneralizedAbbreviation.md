# 320. Generalized Abbreviation - Medium

Write a function to generate the generalized abbreviations of a word.

##### Example 1:

```
Given word ="word", return the following list (order does not matter):

["word", "1ord", "w1rd", "wo1d", "wor1", "2rd", "w2d", "wo2", "1o1d", "1or1", "w1r1", "1o2", "2r1", "3d", "w3", "4"]
```

#### Java Solution
```java
public class GenerateAbbreviations {
    public static List<String> generateAbbreviations(String word) {
        List<String> result = new ArrayList<>();

        result.add(word);
        generateHelper(0, word, result);

        return result;
    }

    private static void generateHelper(int start, String s, List<String> result) {
        if (start >= s.length()) {
            return;
        }

        for (int i = start; i < s.length(); i++) {
            for (int j = 1; i + j <= s.length(); j++) {
                String num = Integer.toString(j);
                String abbr = s.substring(0, i) + num + s.substring(i + j);
                result.add(abbr);
                generateHelper(i + 1 + num.length(), abbr, result); // skip 1b
            }
        }
    }
}
```

#### [Java Source Code](../../../src/main/java/com/algorithm/subsets/GenerateAbbreviations.java)
- [Reference](http://buttercola.blogspot.com/2016/01/leetcode-generalized-abbreviation.html)
- [Solution](https://protegejj.gitbook.io/algorithm-practice/leetcode/backtracking/320-generalized-abbreviation)