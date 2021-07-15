# Sequence Reconstruction - Medium

Check whether the original sequence ```org``` can be uniquely reconstructed from the sequences in ```seqs```. 
The org sequence is a permutation of the integers from 1 to n, with 1 ≤ n ≤ 10<sup>4</sup>​​. Reconstruction means building a shortest common supersequence of the sequences in ```seqs``` (i.e., a shortest sequence so that all sequences in ```seqs``` are subsequences of it). Determine whether there is only one sequence that can be reconstructed from ```seqs``` and it is the ```org``` sequence.

##### Example 1:

```
Input:org = [1,2,3], seqs = [[1,2],[1,3]]
Output: false
Explanation:
[1,2,3] is not the only one sequence that can be reconstructed, 
because [1,3,2] is also a valid sequence that can be reconstructed.
```

##### Example 2:

```
Input: org = [1,2,3], seqs = [[1,2]]
Output: false
Explanation:
The reconstructed sequence can only be [1,2].
```

##### Example 3:

```
Input: org = [1,2,3], seqs = [[1,2],[1,3],[2,3]]
Output: true
Explanation:
The sequences [1,2], [1,3], and [2,3] can uniquely reconstruct the original sequence [1,2,3].
```

##### Example 4:

```
Input:org = [4,1,5,2,6,3], seqs = [[5,2,6,3],[4,1,5,2]]
Output:true
```

#### Java Solution
```java
public class SequenceReconstruction {

    public static boolean canStruction(int[] originalSeq, int[][] seqs) {
        Map<Integer, HashSet> graph = new HashMap<>();
        Map<Integer, Integer> inDegree = new HashMap<>();

        for (int[] seq : seqs) {
            for (int i = 1; i < seq.length; i++) {
                HashSet<Integer> g = graph.getOrDefault(seq[i - 1], new HashSet<Integer>());
                g.add(seq[i]);
                graph.put(seq[i - 1], g);
                int degree = inDegree.getOrDefault(seq[i], 0);
                inDegree.put(seq[i], degree + 1);
                if (!inDegree.containsKey(seq[i - 1])) {
                    inDegree.put(seq[i - 1], 0);
                }
            }
        }

        if (inDegree.size() != originalSeq.length) {
            return false;
        }

        LinkedList<Integer> queue = new LinkedList<>();
        for (Map.Entry<Integer, Integer> m : inDegree.entrySet()) {
            if (m.getValue() == 0) {
                queue.offer(m.getKey());
            }
        }

        List<Integer> res = new ArrayList<>();
        while (!queue.isEmpty()) {
            if (queue.size() > 1) {
                return false;
            }

            if (originalSeq[res.size()] != queue.get(0)) {
                return false;
            }
            int i = queue.poll();
            res.add(i);
            HashSet<Integer> childs = graph.get(i);
            if (childs != null) {
                for (Integer c : childs) {
                    int degree = inDegree.get(c);
                    inDegree.put(c, degree - 1);
                    if (degree == 1) {
                        queue.offer(c);
                    }
                }
            }
        }
        return res.size() == originalSeq.length;
    }
}
```

#### [Java Source Code](../../../src/main/java/com/algorithm/graphdata/SequenceReconstruction.java)

