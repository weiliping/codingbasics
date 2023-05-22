# 451. Sort Characters By Frequency - Medium

Given a string, sort it in decreasing order based on the frequency of characters.

##### Example 1:

```
Input:
"tree"

Output:
"eert"

Explanation:
'e' appears twice while 'r' and 't' both appear once.
So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.
```

##### Example 2:

```
Input:
"cccaaa"

Output:
"cccaaa"

Explanation:
Both 'c' and 'a' appear three times, so "aaaccc" is also a valid answer.
Note that "cacaca" is incorrect, as the same characters must be together.
```

##### Example 3:

```
Input:
"Aabb"

Output:
"bbAa"

Explanation:
"bbaA" is also a valid answer, but "Aabb" is incorrect.
Note that 'A' and 'a' are treated as two different characters.
```

#### Java Solution
```java
public class FrequencySort {

    class Pair {
        int v;
        char k;

        public Pair(char key, int val) {
            v = val;
            k = key;
        }
    }

    public String frequencySort(String s) {
        Map<Character, Integer> frequency = new HashMap<>();

        for (char c : s.toCharArray()) {
            frequency.put(c, frequency.getOrDefault(c, 0) + 1);
        }

        PriorityQueue<Pair> queue = new PriorityQueue<>((a, b) -> b.v - a.v);
        Iterator<Map.Entry<Character, Integer>> it = frequency.entrySet().iterator();

        while (it.hasNext()) {
            Map.Entry<Character, Integer> e = it.next();
            queue.offer(new Pair(e.getKey(), e.getValue()));
        }

        StringBuilder str = new StringBuilder();
        while (!queue.isEmpty()) {
            Pair p = queue.poll();
            if (p.v > 1) {
                int n = p.v;
                while (n > 0) {
                    str.append(p.k);
                    n--;
                }
            } else {
                str.append(p.k);
            }
        }
        return str.toString();
    }
}
```

#### [Java Source Code](../../../src/main/java/com/algorithm/stacksandqueues/FrequencySort.java)