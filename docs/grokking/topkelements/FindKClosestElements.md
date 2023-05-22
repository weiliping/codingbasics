# 658. Find K Closest Elements - Medium
Given a <b>sorted</b> integer array ```arr```, two integers ```k``` and ```x```, return the ```k``` closest integers to ```x``` in the array. The result should also be sorted in ascending order.

An integer ```a``` is closer to ```x``` than an integer ```b``` if:

- ```|a - x| < |b - x|```, or
- ```|a - x| == |b - x|``` and ```a < b```
 

##### Example 1:

```
Input: arr = [1,2,3,4,5], k = 4, x = 3
Output: [1,2,3,4]
```

##### Example 2:

```
Input: arr = [1,2,3,4,5], k = 4, x = -1
Output: [1,2,3,4]
``` 

##### Constraints:

- 1 <= k <= arr.length
- 1 <= arr.length <= 104
- arr is sorted in ascending order.
- -10<sup>4</sup> <= arr[i], x <= 10<sup>4</sup>

#### Java Solution
```java
public class FindClosestElements {
    class Pair {
        int k;
        int v;
        public Pair(int key, int val) {
            k = key;
            v = val;
        }
    }

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        PriorityQueue<Pair> queue = new PriorityQueue<>(k, (a, b) -> a.k == b.k ? b.v - a.v : b.k - a.k);

        for (int num : arr) {
            int key = Math.abs(num - x);
            if (queue.size() < k) {
                queue.offer(new Pair(key, num));
                continue;
            }
            if (key < queue.peek().k) {
                queue.poll();
                queue.offer(new Pair(key, num));
            }
        }

        List<Integer> res = new ArrayList<>();
        while(!queue.isEmpty()) {
            res.add(queue.poll().v);
        }
        Collections.sort(res);
        return res;
    }
}
```

#### [Java Source Code](../../../src/main/java/com/algorithm/stacksandqueues/FindClosestElements.java)