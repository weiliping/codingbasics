# 767. Reorganize String - Medium

Given a string ```S```, check if the letters can be rearranged so that two characters that are adjacent to each other are not the same.

If possible, output any possible result.  If not possible, return the empty string.

##### Example 1:

```
Input: S = "aab"
Output: "aba"
```

##### Example 2:

```
Input: S = "aaab"
Output: ""
```

##### Note:

- ```S``` will consist of lowercase letters and have length in range ```[1, 500]```.

#### Java Solution
```java
public class ReorganizeString {
    class Pair {
        int v;
        char c;

        public Pair(char ch, int val) {
            c = ch;
            v = val;
        }
    }
    public String reorganizeString(String S) {
        Map<Character, Integer> cnts = new HashMap<>();
        for (char c : S.toCharArray()) {
            cnts.put(c, cnts.getOrDefault(c, 0) + 1);
        }
        PriorityQueue<Pair> queue = new PriorityQueue<>((a, b) -> b.v - a.v);

        for(Map.Entry<Character, Integer> m : cnts.entrySet()) {
            queue.offer(new Pair(m.getKey(), m.getValue()));
        }

        Character prevChar = null;
        int prevCnt = -1;
        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            Pair pair = queue.poll();

            if (prevChar != null && prevCnt > 0) {
                queue.offer(new Pair(prevChar, prevCnt));
            }
            sb.append(pair.c);
            prevChar = pair.c;
            prevCnt = pair.v - 1;
        }

        return sb.length() == S.length() ? sb.toString() : "";
    }
}
```

#### [Java Source Code](../../../src/main/java/com/algorithm/stacksandqueues/ReorganizeString.java)