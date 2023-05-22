# 436. Find Right Interval - Medium

You are given an array of ```intervals```, where <b>intervals[i] = [start<sub>i</sub>, end<sub>i</sub>]</b> and each <b>start<sub>i</sub></b> is unique.

The <b>right interval</b> for an interval ```i``` is an interval ```j``` such that <b>start<sub>j</sub> >= end<sub>i</sub></b> and <b>start<sub>j</sub></b> is <b>minimized</b>.

Return an array of <b>right interval</b> indices for each interval ```i```. If no <b>right interval</b> exists for interval ```i```, then put ```-1``` at index ```i```.

 

##### Example 1:
```
Input: intervals = [[1,2]]
Output: [-1]
Explanation: There is only one interval in the collection, so it outputs -1.
```

##### Example 2:
```
Input: intervals = [[3,4],[2,3],[1,2]]
Output: [-1,0,1]
Explanation: There is no right interval for [3,4].
The right interval for [2,3] is [3,4] since start0 = 3 is the smallest start that is >= end1 = 3.
The right interval for [1,2] is [2,3] since start1 = 2 is the smallest start that is >= end2 = 2.
```

##### Example 3:

```
Input: intervals = [[1,4],[2,3],[3,4]]
Output: [-1,2,-1]
Explanation: There is no right interval for [1,4] and [3,4].
The right interval for [2,3] is [3,4] since start2 = 3 is the smallest start that is >= end1 = 3.
``` 

##### Constraints:

- 1 <= intervals.length <= 2 * 10<sup>4</sup>
- ```intervals[i].length == 2```
- -10<sup>6</sup> <= start<sub>i</sub> <= end<sub>i</sub> <= 10<sup>6</sup>
- The start point of each interval is <b>unique</b>.

#### Java Solution
```java
public class RightInterval {
    public static int[] findRightInterval(int[][] intervals) {
        TreeMap<Integer, PriorityQueue<Integer>> map = new TreeMap<>();
        int[] res = new int[intervals.length];
        for (int i = 0; i < intervals.length; i++) {
            if (map.get(intervals[i][0]) == null) {
                PriorityQueue<Integer> pq = new PriorityQueue<>();
                pq.add(i);
                map.put(intervals[i][0], pq);
            } else {
                map.get(intervals[i][0]).add(i);
            }
        }
        for (int i = 0; i < intervals.length; i++) {
            Integer key = map.ceilingKey(intervals[i][1]);
            res[i] = key != null ? map.get(key).peek() : -1;
        }
        return res;
    }

    public static int[] findRightIntervalII(int[][] intervals) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int[] interval : intervals) {
            min = Math.min(min, interval[0]);
            max = Math.max(max, interval[1]);
        }
        int[] index = new int[max - min + 1];
        Arrays.fill(index, -1);
        int n = intervals.length;
        for (int i = 0; i < n; i++) {
            index[intervals[i][0] - min] = i;
        }
        for (int i = index.length - 2; i >= 0; i--) {
            if (index[i] == -1) {
                index[i] = index[i + 1];
            }
        }
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = index[intervals[i][1] - min];
        }
        return ans;
    }
}
```

#### [Java Source Code](../../../src/main/java/com/algorithm/twoheaps/RightInterval.java)