# 253. Meeting room II - Medium

Given a list of intervals representing the start and end time of āNā meetings, find the minimum number of rooms required to hold all the meetings.


##### Example 1:

```
Meetings: [[1,4], [2,5], [7,9]]
Output: 2
Explanation: Since [1,4] and [2,5] overlap, we need two rooms to hold these two meetings. [7,9] can occur in any of the two rooms later.
```

#####  Example 2:

```
Meetings: [[6,7], [2,4], [8,12]]
Output: 1
Explanation: None of the meetings overlap, therefore we only need one room to hold all meetings.
```

#####  Example 3:

```
Meetings: [[1,4], [2,3], [3,6]]
Output:2
Explanation: Since [1,4] overlaps with the other two meetings [2,3] and [3,6], we need two rooms to 
hold all the meetings.
``` 

#####  Example 4:
```
Meetings: [[4,5], [2,3], [2,4], [3,5]]
Output: 2
Explanation: We will need one room for [2,3] and [3,5], and another room for [2,4] and [4,5].
```

#### Java Solution
```java
public class MinMeetingRooms {

    public static int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> (a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]));
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int[] in : intervals) {
            if (!queue.isEmpty() && queue.peek() <= in[0]) {
                queue.poll();
            }
            queue.offer(in[1]);
        }
        return queue.size();
    }
}
```

#### [Java Source Code](../../../src/main/java/com/algorithm/mergeintervals/MinMeetingRooms.java)