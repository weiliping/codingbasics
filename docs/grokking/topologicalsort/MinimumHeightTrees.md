# 310. Minimum Height Trees - Medium

A tree is an undirected graph in which any two vertices are connected by exactly one path. In other words, any connected graph without simple cycles is a tree.

Given a tree of ```n``` nodes labelled from ```0``` to ```n - 1```, and an array of ```n - 1 edges``` where <b>edges[i] = [a<sub>i</sub>, b<sub>i</sub>]</b> indicates that there is an undirected edge between the two nodes a<sub>i</sub> and b<sub>i</sub> in the tree, you can choose any node of the tree as the root. When you select a node ```x``` as the root, the result tree has height ```h```. Among all possible rooted trees, those with minimum height (i.e. ```min(h)```)  are called <b>minimum height trees</b> (MHTs).

Return a list of all <b>MHTs'</b> root labels. You can return the answer in <b>any order</b>.

The <b>height</b> of a rooted tree is the number of edges on the longest downward path between the root and a leaf.

 

##### Example 1:
![](310_sample_01.jpeg)

```
Input: n = 4, edges = [[1,0],[1,2],[1,3]]
Output: [1]
Explanation: As shown, the height of the tree is 1 when the root is the node with label 1 which is the only MHT.
```

##### Example 2:

![](310_sample_02.jpeg)
```
Input: n = 6, edges = [[3,0],[3,1],[3,2],[3,4],[5,4]]
Output: [3,4]
```

##### Example 3:

```
Input: n = 1, edges = []
Output: [0]
```

##### Example 4:

```
Input: n = 2, edges = [[0,1]]
Output: [0,1]
``` 

##### Constraints:

- 1 <= n <= 2 * 10<sup>4</sup>
- ```edges.length == n - 1```
- ```0 <= ai, bi < n```
- a<sub>i</sub> != b<sub>i</sub>
- All the pairs (a<sub>i</sub>, b<sub>i</sub>) are distinct.
- The given input is <b>guaranteed</b> to be a tree and there will be <b>no repeated</b> edges.

#### Java Solution

```java
public class MinimumHeightTrees {

    public static List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1) {
            return Collections.singletonList(0);
        }

        List<Set<Integer>> graph = new ArrayList<>(n);

        for (int i = 0; i < n; i++) {
            graph.add(new HashSet<>());
        }

        for (int[] a : edges) {
            graph.get(a[1]).add(a[0]);
            graph.get(a[0]).add(a[1]);
        }

        List<Integer> leaves = new ArrayList<>();

        for (int i = 0; i < graph.size(); i++) {
            if (graph.get(i).size() == 1) {
                leaves.add(i);
            }
        }

        while (n > 2) {
            n -= leaves.size();
            List<Integer> newLeaves = new ArrayList<>();

            for (int i : leaves) {
                int t = graph.get(i).iterator().next();
                graph.get(t).remove(i);
                if (graph.get(t).size() == 1) {
                    newLeaves.add(t);
                }
            }
            leaves = newLeaves;
        }
        return leaves;
    }
}
```

#### [Java Source Code](../../../src/main/java/com/algorithm/graphdata/MinimumHeightTrees.java)
