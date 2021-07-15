# Alien Dictionary - Hard

There is a dictionary containing words from an alien language for which we don’t know the ordering of the characters. 
Write a method to find the correct order of characters in the alien language.

##### Example 1:

```
Input: Words: ["ba", "bc", "ac", "cab"]
Output: bac
Explanation: Given that the words are sorted lexicographically by the rules of the alien language, so
from the given words we can conclude the following ordering among its characters:
 
1. From "ba" and "bc", we can conclude that 'a' comes before 'c'.
2. From "bc" and "ac", we can conclude that 'b' comes before 'a'
 
From the above two points, we can conclude that the correct character order is: "bac"
```

##### Example 2:

```
Input: Words: ["cab", "aaa", "aab"]
Output: cab
Explanation: From the given words we can conclude the following ordering among its characters:
 
1. From "cab" and "aaa", we can conclude that 'c' comes before 'a'.
2. From "aaa" and "aab", we can conclude that 'a' comes before 'b'
 
From the above two points, we can conclude that the correct character order is: "cab"
```

##### Example 3:

```
Input: Words: ["ywx", "wz", "xww", "xz", "zyy", "zwz"]
Output: ywxz
Explanation: From the given words we can conclude the following ordering among its characters:
 
1. From "ywx" and "wz", we can conclude that 'y' comes before 'w'.
2. From "wz" and "xww", we can conclude that 'w' comes before 'x'.
3. From "xww" and "xz", we can conclude that 'w' comes before 'z'
4. From "xz" and "zyy", we can conclude that 'x' comes before 'z'
5. From "zyy" and "zwz", we can conclude that 'y' comes before 'w'
 
From the above five points, we can conclude that the correct character order is: "ywxz"
```

#### Java Solution

```java
public class AlienDictionary {

    public static String alienOrder(String[] words) {
        if (words == null || words.length == 0) {
            return "";
        }

        Map<Character, HashSet> graph = new HashMap<>();
        int[] inDegree = new int[26];
        Arrays.fill(inDegree, -1);

        for (String w : words) {
            for (Character c : w.toCharArray()) {
                if (graph.containsKey(c)) {
                    continue;
                }
                graph.put(c, new HashSet<Character>());
                inDegree[c - 'a'] = 0;
            }
        }

        for (int i = 1; i < words.length; i++) {
            String parent = words[i - 1];
            String child = words[i];

            int strLen = Math.min(parent.length(), child.length());
            for (int j = 0; j < strLen; j++) {
                char c1 = parent.charAt(j);
                char c2 = child.charAt(j);
                if (c1 != c2) {
                    graph.get(c1).add(c2);
                    inDegree[c2 - 'a']++;
                    break;
                }
            }
        }

        LinkedList<Integer> queue = new LinkedList<>();
        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            int i = queue.poll();
            char c = (char) ('a' + i);
            sb.append(c);
            HashSet<Character> chs = graph.get(c);
            for (Character ch : chs) {
                inDegree[ch - 'a']--;
                if (inDegree[ch - 'a'] == 0) {
                    queue.offer(ch - 'a');
                }
            }
        }
        return sb.toString();
    }
}
```

#### [Java Source Code](../../../src/main/java/com/algorithm/graphdata/AlienDictionary.java)