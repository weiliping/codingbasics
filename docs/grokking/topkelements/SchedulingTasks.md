621. Task Scheduler - Medium

Given a characters array ```tasks```, representing the tasks a CPU needs to do, where each letter represents a different task. Tasks could be done in any order. Each task is done in one unit of time. For each unit of time, the CPU could complete either one task or just be idle.

However, there is a non-negative integer ```n``` that represents the cooldown period between two <b>same tasks</b> (the same letter in the array), that is that there must be at least ```n``` units of time between any two same tasks.

*Return the least number of units of times that the CPU will take to finish all the given tasks.*

##### Example 1:

```
Input: tasks = ["A","A","A","B","B","B"], n = 2
Output: 8
Explanation: 
A -> B -> idle -> A -> B -> idle -> A -> B
There is at least 2 units of time between any two same tasks.
```

##### Example 2:

```
Input: tasks = ["A","A","A","B","B","B"], n = 0
Output: 6
Explanation: On this case any permutation of size 6 would work since n = 0.
["A","A","A","B","B","B"]
["A","B","A","B","A","B"]
["B","B","B","A","A","A"]
...
And so on.
```

##### Example 3:

```
Input: tasks = ["A","A","A","A","A","A","B","C","D","E","F","G"], n = 2
Output: 16
Explanation: 
One possible solution is
A -> B -> C -> A -> D -> E -> A -> F -> G -> A -> idle -> idle -> A -> idle -> idle -> A
```

##### Constraints:

- 1 <= task.length <= 10<sup>4</sup>
- ```tasks[i]``` is upper-case English letter.
- The integer ```n``` is in the range ```[0, 100]```.

#### Java Solution
```java
public class LeastInterval {

    public int leastInterval(char[] tasks, int n) {
        List<String> res = new ArrayList<>();
        if (n == 0) {
            return tasks.length;
        }

        Map<Character, Integer> cnts = new HashMap<>();
        for (char c : tasks) {
            cnts.put(c, cnts.getOrDefault(c, 0) + 1);
        }

        PriorityQueue<Pair> queue = new PriorityQueue<>((a, b) -> b.v - a.v);

        for (Map.Entry<Character, Integer> m : cnts.entrySet()) {
            queue.offer(new Pair(m.getKey(), m.getValue()));
        }

        int sum = 0;
        int len = Math.max(tasks.length, (queue.peek().v - 1) * (n + 1) + 1);
        int l = len / (n + 1);
        if (len % (n + 1) != 0) {
            l++;
        }

        for (int i = 0; i < l; i++) {
            List<Pair> tmp = new ArrayList<>();
            for (int j = 0; j < n + 1; j++) {
                if (!queue.isEmpty()) {
                    Pair p = queue.poll();
                    sum++;
                    res.add(String.valueOf(p.k));
                    p.v--;
                    if (p.v > 0) {
                        tmp.add(p);
                    }
                } else {
                    if (i != l - 1) {
                        res.add("Nil");
                        sum++;
                    }
                }
            }
            if (tmp.size() != 0) {
                for (Pair p : tmp) {
                    queue.offer(p);
                }
            }
        }
        return sum;
    }

    class Pair {
        char k;
        int v;

        public Pair(char key, int val) {
            k = key;
            v = val;
        }
    }
}
```

#### [Java Source Code](../../../src/main/java/com/algorithm/stacksandqueues/LeastInterval.java)
- [LeetCode solution](../../../src/main/java/com/algorithm/stacksandqueues/LeastIntervalI.java)
- [Reference](https://leetcode.com/problems/task-scheduler/)