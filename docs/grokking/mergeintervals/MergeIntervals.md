# 56. Merge Intervals - Medium

Given an array of ```intervals``` where ```intervals[i] = [starti, endi]```, merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the ```input```.

##### Example 1:
```
Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
```
##### Example 2:

```
Input: intervals = [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considered overlapping.
``` 

##### Constraints:

- 1 <= intervals.length <= 10<sup>4</sup>
- intervals[i].length == 2
- 0 <= start<sub>i</sub> <= end<sub>i</sub> <= 10<sup>4</sup>

#### Java Solution
```java
public class MergeIntervals {

    public static int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return intervals;
        }
        List<int[]> res = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            res = insert(res, intervals[i]);
        }
        return toArray(res);
    }

    static int[][] toArray(List<int[]> res) {
        if (res == null || res.size() == 0) {
            return new int[][] { {} };
        }
        int[][] nums = new int[res.size()][res.get(0).length];
        for (int i = 0; i < res.size(); i++) {
            nums[i] = res.get(i);
        }
        return nums;
    }

    static List<int[]> insert(List<int[]> intervals, int[] intvals) {
        List<int[]> res = new ArrayList<>();
        boolean inserted = false;
        for (int[] it : intervals) {
            if (inserted || it[1] < intvals[0]) {
                res.add(it);
            } else if (it[0] > intvals[1]) {
                res.add(intvals);
                res.add(it);
                inserted = true;
            } else {
                intvals[0] = Math.min(intvals[0], it[0]);
                intvals[1] = Math.max(intvals[1], it[1]);
            }
        }
        if (inserted == false) {
            res.add(intvals);
        }
        return res;
    }
}
```

#### [Java Source Code](../../../src/main/java/com/algorithm/mergeintervals/MergeIntervals.java)