# 895. Maximum Frequency Stack - Hard

Design a stack-like data structure to push elements to the stack and pop the most frequent element from the stack.

Implement the ```FreqStack``` class:

- FreqStack() constructs an empty frequency stack.
- void push(int val) pushes an integer val onto the top of the stack.
- ```int pop()``` removes and returns the most frequent element in the stack.
  - If there is a tie for the most frequent element, the element closest to the stack's top is removed and returned.
 

Example 1:

```
Input
["FreqStack", "push", "push", "push", "push", "push", "push", "pop", "pop", "pop", "pop"]
[[], [5], [7], [5], [7], [4], [5], [], [], [], []]
Output
[null, null, null, null, null, null, null, 5, 7, 5, 4]

Explanation
FreqStack freqStack = new FreqStack();
freqStack.push(5); // The stack is [5]
freqStack.push(7); // The stack is [5,7]
freqStack.push(5); // The stack is [5,7,5]
freqStack.push(7); // The stack is [5,7,5,7]
freqStack.push(4); // The stack is [5,7,5,7,4]
freqStack.push(5); // The stack is [5,7,5,7,4,5]
freqStack.pop();   // return 5, as 5 is the most frequent. The stack becomes [5,7,5,7,4].
freqStack.pop();   // return 7, as 5 and 7 is the most frequent, but 7 is closest to the top. The stack becomes [5,7,5,4].
freqStack.pop();   // return 5, as 5 is the most frequent. The stack becomes [5,7,4].
freqStack.pop();   // return 4, as 4, 5 and 7 is the most frequent, but 4 is closest to the top. The stack becomes [5,7].
``` 

##### Constraints:

- 0 <= val <= 10<sup>9</sup>
- At most 2 * 10<sup>4</sup> calls will be made to ```push``` and ```pop```.
- It is guaranteed that there will be at least one element in the stack before calling pop.

#### Java Solution
```java
public class FreqStack {
    int index;
    Map<Integer, Pair> frequences;
    PriorityQueue<Pair> queue;
    public FreqStack() {
        frequences = new HashMap<>();
        queue = new PriorityQueue<>((a, b) -> a.f == b.f ? b.ind - a.ind : b.f - a.f );
        index = 0;
    }

    public void push(int val) {
        index++;
        if (frequences.containsKey(val)) {
            Pair p = frequences.get(val);
            queue.remove(p);
            p.inds.add(index);
            Pair np = new Pair(val, p.f + 1, p.inds);
            frequences.put(val, np);
            queue.offer(np);
            return;
        }
        Pair p = new Pair(val, 1, index);
        frequences.put(val, p);
        queue.offer(p);
    }

    public int pop() {
        Pair p = queue.poll();
        p.f--;
        p.inds.remove(p.inds.size() - 1);
        if (p.f > 0) {
            p.ind = p.inds.get(p.inds.size() - 1);
            queue.offer(p);
        }
        return p.k;
    }

    class Pair {
        int k;
        int f;
        int ind;
        List<Integer> inds = new ArrayList<>();
        public Pair(int key, int freq, int index) {
            k = key;
            f = freq;
            inds.add(index);
            ind = index;
        }

        public Pair(int key, int freq, List<Integer> indexes) {
            k = key;
            f = freq;
            inds = indexes;
            ind = index;
        }
    }
}
```

#### [Java Source Code](../../../src/main/java/com/algorithm/stacksandqueues/FreqStack.java)
- [LeetCode solution](../../../src/main/java/com/algorithm/stacksandqueues/FreqStackI.java)
- [Reference](https://leetcode.com/problems/maximum-frequency-stack/)