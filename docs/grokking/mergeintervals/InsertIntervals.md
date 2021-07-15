# 57. Insert Interval - Medium

Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).

You may assume that the intervals were initially sorted according to their start times.

 

##### Example 1:
```
Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
Output: [[1,5],[6,9]]
```
##### Example 2:

```
Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
Output: [[1,2],[3,10],[12,16]]
Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].
```
##### Example 3:

```
Input: intervals = [], newInterval = [5,7]
Output: [[5,7]]
```
##### Example 4:

```
Input: intervals = [[1,5]], newInterval = [2,3]
Output: [[1,5]]
```
##### Example 5:

```
Input: intervals = [[1,5]], newInterval = [2,7]
Output: [[1,7]]
``` 

##### Constraints:

- 0 <= intervals.length <= 10<sup>4</sup>
- ```intervals[i].length == 2```
- 0 <= intervals[i][0] <= intervals[i][1] <= 10<sup>5</sup>
- ```intervals is sorted by intervals[i][0] in``` <b>ascending</b> ```order```.
- ```newInterval.length == 2```
- 0 <= newInterval[0] <= newInterval[1] <= 10<sup>5</sup>

#### Java Solution
```java
public class InsertInterval {

    public static int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals == null || intervals.length == 0) {
            return new int[][] { newInterval };
        }
        boolean inserted = false;
        List<int[]> res = new ArrayList<>();
        int n = intervals.length;
        for (int i = 0; i < n; i++) {
            int[] nums = intervals[i];
            if (inserted || nums[1] < newInterval[0]) {
                res.add(nums);
            } else if (nums[0] > newInterval[1]) {
                res.add(newInterval);
                res.add(nums);
                inserted = true;
            } else {
                newInterval[0] = Math.min(newInterval[0], nums[0]);
                newInterval[1] = Math.max(newInterval[1], nums[1]);
            }
        }
        if (!inserted) {
            res.add(newInterval);
        }
        int[][] resInts = new int[res.size()][res.get(0).length];
        for (int i = 0; i < res.size(); i++) {
            resInts[i] = res.get(i);
        }
        return resInts;
    }
}
```

#### [Java Source Code](../../../src/main/java/com/algorithm/mergeintervals/InsertInterval.java)