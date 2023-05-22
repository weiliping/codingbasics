# 207. Course Schedule - Medium

There are a total of ```numCourses``` courses you have to take, labeled from ```0``` to ```numCourses - 1```. You are given an array ```prerequisites``` where ```prerequisites[i] = [ai, bi]``` indicates that you <b>must</b> take course <b>b<sub>i</sub></b> first if you want to take course <b>a<sub>i</sub></b>.

For example, the pair ```[0, 1]```, indicates that to take course ```0``` you have to first take course ```1```.
Return ```true``` if you can finish all courses. Otherwise, return ```false```.

 
##### Example 1:

```
Input: numCourses = 2, prerequisites = [[1,0]]
Output: true
Explanation: There are a total of 2 courses to take. 
To take course 1 you should have finished course 0. So it is possible.
```

##### Example 2:

```
Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
Output: false
Explanation: There are a total of 2 courses to take. 
To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So it is impossible.
``` 

##### Constraints:

- 1 <= numCourses <= 10<sup>5</sup>
- ```0 <= prerequisites.length <= 5000```
- ```prerequisites[i].length == 2```
- ```0 <= ai, bi < numCourses```
- ```All the pairs prerequisites[i] are unique```.

```java
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<Integer>[] graph = new ArrayList[numCourses];
        int[] visit = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] a : prerequisites) {
            graph[a[1]].add(a[0]);
        }

        for (int i = 0; i < numCourses; i++) {
            if (!dfsHelper(graph, visit, i)) {
                return false;
            }
        }
        return true;
    }

    static boolean dfsHelper(ArrayList<Integer>[] graph, int[] visit, int i) {
        if (visit[i] == -1) {
            return false;
        }
        if (visit[i] == 1) {
            return true;
        }
        visit[i] = -1;

        for (int a : graph[i]) {
            if (!dfsHelper(graph, visit, a)) {
                return false;
            }
        }
        visit[i] = 1;
        return true;
    }
}
```

[Java](../../../src/main/java/com/algorithm/graphdata/CourseSchedule.java)

