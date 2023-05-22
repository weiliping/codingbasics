# Topological Sort - Medium

Topological Sort of a directed graph (a graph with unidirectional edges) is a linear ordering of its vertices such that for every directed edge (U, V) from vertex U to vertex V, U comes before V in the ordering.
Given a directed graph, find the topological ordering of its vertices.

##### Example 1:

```
Input: Vertices=4, Edges=[3, 2], [3, 0], [2, 0], [2, 1]
Output: Following are the two valid topological sorts for the given graph:
1) 3, 2, 0, 1
2) 3, 2, 1, 0
```

##### Example 2:

```
Input: Vertices=5, Edges=[4, 2], [4, 3], [2, 0], [2, 1], [3, 1]
Output: Following are all valid topological sorts for the given graph:
1) 4, 2, 3, 0, 1
2) 4, 3, 2, 0, 1
3) 4, 3, 2, 1, 0
4) 4, 2, 3, 1, 0
5) 4, 2, 0, 3, 1
```

##### Example 3:

```
Input: Vertices=7, Edges=[6, 4], [6, 2], [5, 3], [5, 4], [3, 0], [3, 1], [3, 2], [4, 1]
Output: Following are all valid topological sorts for the given graph:
1) 5, 6, 3, 4, 0, 1, 2
2) 6, 5, 3, 4, 0, 1, 2
3) 5, 6, 4, 3, 0, 2, 1
4) 6, 5, 4, 3, 0, 1, 2
5) 5, 6, 3, 4, 0, 2, 1
6) 5, 6, 3, 4, 1, 2, 0
 
There are other valid topological ordering of the graph too.
```
#### Java Solution
```java
public class TopologicalSort {

    public List<Integer> allValidPath(int[][] edges, int n) {
        List<Integer> res = new ArrayList<>();

        ArrayList<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        int[] in = new int[n];

        for (int[] g : edges) {
            graph[g[0]].add(g[1]);
            in[g[1]]++;
        }

        LinkedList<Integer> q = new LinkedList<>();

        for (int i = 0; i < in.length; i++) {
            if (in[i] == 0) {
                q.offer(i);
                res.add(i);
            }
        }
        while (!q.isEmpty()) {
            int i = q.poll();
            for (int e : graph[i]) {
                in[e]--;
                if (in[e] == 0) {
                    res.add(e);
                    q.offer(e);
                }
            }
        }
        if (res.size() != n) {
            return new ArrayList<>();
        }
        return res;
    }
}
```

#### [Java Source Code](../../../src/main/java/com/algorithm/graphdata/TopologicalSort.java)