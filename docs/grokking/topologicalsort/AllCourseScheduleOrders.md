# All Tasks Scheduling Orders - Hard
There are ```N``` tasks, labeled from ```0``` to ```N-1```. 
Each task can have some prerequisite tasks which need to be completed before it can be scheduled. 
Given the number of tasks and a list of prerequisite pairs, 
write a method to print all possible ordering of tasks meeting all prerequisites.

##### Example 1:

```
Input: Tasks=3, Prerequisites=[0, 1], [1, 2]
Output: [0, 1, 2]
Explanation: There is only possible ordering of the tasks.
```

##### Example 2:
```
Input: Tasks=4, Prerequisites=[3, 2], [3, 0], [2, 0], [2, 1]
Output: 
1) [3, 2, 0, 1]
2) [3, 2, 1, 0]
Explanation: There are two possible orderings of the tasks meeting all prerequisites.
```

##### Example 3:
```
Input: Tasks=6, Prerequisites=[2, 5], [0, 5], [0, 4], [1, 4], [3, 2], [1, 3]
Output: 
1) [0, 1, 4, 3, 2, 5]
2) [0, 1, 3, 4, 2, 5]
3) [0, 1, 3, 2, 4, 5]
4) [0, 1, 3, 2, 5, 4]
5) [1, 0, 3, 4, 2, 5]
6) [1, 0, 3, 2, 4, 5]
7) [1, 0, 3, 2, 5, 4]
8) [1, 0, 4, 3, 2, 5]
9) [1, 3, 0, 2, 4, 5]
10) [1, 3, 0, 2, 5, 4]
11) [1, 3, 0, 4, 2, 5]
12) [1, 3, 2, 0, 5, 4]
13) [1, 3, 2, 0, 4, 5]
```

#### Java Solution:
```java
public class AllScheduleOrders {
    public static List<List<Integer>> allScheduleOrders(int[][] prerequisites, int n) {
        List<List<Integer>> orders = new ArrayList<>();

        ArrayList<Integer>[] graph = new ArrayList[n];
        int[] inDegree = new int[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] prerequisite : prerequisites) {
            graph[prerequisite[0]].add(prerequisite[1]);
            inDegree[prerequisite[1]]++;
        }
        LinkedList<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }
        List<Integer> subRes = new ArrayList<>();
        allOrdersHelper(orders, subRes, graph, inDegree, queue);
        return orders;
    }

    static void allOrdersHelper(List<List<Integer>> orders, List<Integer> subRes,
                ArrayList<Integer>[] graph, int[] inDegree, LinkedList<Integer> queue) {
        if (!queue.isEmpty()) {
            for (int i : queue) {
                subRes.add(i);
                LinkedList<Integer> next = (LinkedList<Integer>) queue.clone();
                next.remove(Integer.valueOf(i));
                for (int childInd : graph[i]) {
                    inDegree[childInd]--;
                    if (inDegree[childInd] == 0) {
                        next.add(childInd);
                    }
                }
                allOrdersHelper(orders, subRes, graph, inDegree, next);
                subRes.remove(subRes.size() - 1);
                for (int childInd : graph[i]) {
                    inDegree[childInd]++;
                }
            }
        }
        if (subRes.size() == inDegree.length) {
            orders.add(new ArrayList<>(subRes));
        }
    }
}
```

#### [Java Source Code](../../../src/main/java/com/algorithm/graphdata/CourseScheduleIII.java)