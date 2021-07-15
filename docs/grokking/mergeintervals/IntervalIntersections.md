# 986. Interval List Intersections - Medium

You are given two lists of closed intervals, firstList and secondList, where firstList[i] = [starti, endi] and secondList[j] = [startj, endj]. Each list of intervals is pairwise disjoint and in sorted order.

Return the intersection of these two interval lists.

A closed interval [a, b] (with a < b) denotes the set of real numbers x with a <= x <= b.

The intersection of two closed intervals is a set of real numbers that are either empty or represented as a closed interval. For example, the intersection of [1, 3] and [2, 4] is [2, 3].


##### Example 1:
![](986_sample_01.png)

```
Input: firstList = [[0,2],[5,10],[13,23],[24,25]], secondList = [[1,5],[8,12],[15,24],[25,26]]
Output: [[1,2],[5,5],[8,10],[15,23],[24,24],[25,25]]
```

##### Example 2:

```
Input: firstList = [[1,3],[5,9]], secondList = []
Output: []
```

##### Example 3:

```
Input: firstList = [], secondList = [[4,8],[10,12]]
Output: []
```

##### Example 4:

```
Input: firstList = [[1,7]], secondList = [[3,10]]
Output: [[3,7]]
``` 

##### Constraints:

- ```0 <= firstList.length, secondList.length <= 1000```
- ```firstList.length + secondList.length >= 1```
- 0 <= start<sub>i</sub> < end<sub>i</sub> <= 109
- end<sub>i</sub> < start<sub>i+1</sub>
- 0 <= start<sub>j</sub> < end<sub>j</sub> <= 109
- end<sub>j</sub> < start<sub>j+1</sub>

#### Java Solution
```java
public class IntervalIntersection {

    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        int i = 0;
        int j = 0;
        List<Integer> res = new ArrayList<>();

        while (i < firstList.length && j < secondList.length) {
            int minEnd = Math.min(secondList[j][1], firstList[i][1]);
            int maxHead = Math.max(secondList[j][0], firstList[i][0]);
            if (minEnd >= maxHead) {
                res.add(maxHead);
                res.add(minEnd);
            }
            if (secondList[j][1] >= firstList[i][1]) {
                i++;
            } else {
                j++;
            }
        }
        int size = res.size() / 2;
        int[][] ans = new int[size][2];
        for (int k = 0; k < size; k++) {
            ans[k][0] = res.get(2 * k);
            ans[k][1] = res.get(2 * k + 1);

        }
        return ans;
    }

    public int[][] intervalIntersectionI(int[][] firstList, int[][] secondList) {
        if (firstList.length == 0 || secondList.length == 0) {
            return new int[0][];
        }
        ArrayList<int[]> res = new ArrayList<>();
        helper(res, firstList, secondList, 0, 0);
        return res.toArray(new int[0][]);
    }

    private void helper(ArrayList<int[]> res, int[][] firstList, int[][] secondList, int firstIdx, int secondIdx) {
        if (firstIdx == firstList.length || secondIdx == secondList.length) {
            return;
        }
        if (firstList[firstIdx][0] > secondList[secondIdx][1]) {
            helper(res, firstList, secondList, firstIdx, secondIdx + 1);
        } else if (firstList[firstIdx][1] < secondList[secondIdx][0]) {
            helper(res, firstList, secondList, firstIdx + 1, secondIdx);
        } else {
            int left = Math.max(firstList[firstIdx][0], secondList[secondIdx][0]);
            int right = Math.min(firstList[firstIdx][1], secondList[secondIdx][1]);
            res.add(new int[] { left, right });
            if (firstList[firstIdx][1] < secondList[secondIdx][1]) {
                helper(res, firstList, secondList, firstIdx + 1, secondIdx);
            } else if (firstList[firstIdx][1] > secondList[secondIdx][1]) {
                helper(res, firstList, secondList, firstIdx, secondIdx + 1);
            } else {
                helper(res, firstList, secondList, firstIdx + 1, secondIdx + 1);
            }
        }
    }
}
```

#### [Java Source Code](../../../src/main/java/com/algorithm/mergeintervals/IntervalIntersection.java)