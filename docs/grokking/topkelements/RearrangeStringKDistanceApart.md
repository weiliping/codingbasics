# 358. Rearrange String k Distance Apart - Hard
Given a non-empty string str and an integer k, rearrange the string such that the same characters are at least distance k from each other.

All input strings are given in lowercase letters. If it is not possible to rearrange the string, return an empty string "".

##### Example 1: 

```
Input: str = "aabbcc", k = 3
Result: "abcabc"
The same letters are at least distance 3 from each other. 
```
Example 2: 

```
Input: str = "aaabc", k = 3
Answer: ""
It is not possible to rearrange the string. 
```

##### Example 3: 

```
Input: str = "aaadbbcc", k = 2
Answer: "abacabcd"
Another possible answer is: "abcabcda"
The same letters are at least distance 2 from each other.
```

#### Java Solution
```java
public class RearrangeStringKDistance {
    public String reorganize(String S, int k) {
        if (k == 0) {
            return S;
        }
        int len = S.length();

        Map<Character, Integer> cnts = new HashMap<>();

        for (char c : S.toCharArray()) {
            cnts.put(c, cnts.getOrDefault(c, 0) + 1);
        }

        PriorityQueue<Pair> queue = new PriorityQueue<>((a, b) -> b.v - a.v);

        for (Map.Entry<Character, Integer> m : cnts.entrySet()) {
            queue.offer(new Pair(m.getKey(), m.getValue()));
        }

        StringBuilder sb = new StringBuilder();

        while (!queue.isEmpty()) {
            List<Pair> tmp = new ArrayList<>();
            int d = Math.min(k, len);

            for (int i = 0; i < d; i++) {
                if (queue.isEmpty()) {
                    return "";
                }
                Pair p = queue.poll();

                sb.append(p.k);
                p.v--;
                if (p.v > 0) {
                    tmp.add(p);
                }
                len--;
            }

            for (Pair p : tmp) {
                queue.offer(p);
            }
        }
        return sb.toString();
    }

    class Pair {
        char k;
        int v;

        Pair(char key, int val) {
            k = key;
            v = val;
        }
    }
}
```

#### [Java Source Code](../../../src/main/java/com/algorithm/stacksandqueues/RearrangeStringKDistance.java)