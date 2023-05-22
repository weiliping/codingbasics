# 632. Smallest Range Covering Elements from K Lists - Hard

You have ```k``` lists of sorted integers in <b>non-decreasing order</b>. Find the <b>smallest</b> range that includes at least one number from each of the ```k``` lists.

We define the range ```[a, b]``` is smaller than range ```[c, d]``` if ```b - a < d - c or a < c``` if ```b - a == d - c```.

 

##### Example 1:

```
Input: nums = [[4,10,15,24,26],[0,9,12,20],[5,18,22,30]]
Output: [20,24]
Explanation: 
List 1: [4, 10, 15, 24,26], 24 is in range [20,24].
List 2: [0, 9, 12, 20], 20 is in range [20,24].
List 3: [5, 18, 22, 30], 22 is in range [20,24].
```

##### Example 2:

```
Input: nums = [[1,2,3],[1,2,3],[1,2,3]]
Output: [1,1]
```

##### Example 3:

```
Input: nums = [[10,10],[11,11]]
Output: [10,11]
```

##### Example 4:

```
Input: nums = [[10],[11]]
Output: [10,11]
```

##### Example 5:

```
Input: nums = [[1],[2],[3],[4],[5],[6],[7]]
Output: [1,7]
```

##### Constraints:

- ```nums.length == k```
- ```1 <= k <= 3500```
- ```1 <= nums[i].length <= 50```
- -10<sup>5</sup> <= nums[i][j] <= 10<sup>5</sup>
- ```nums[i]``` is sorted in <b>non-decreasing</b> order.

#### Java Solution

```java
public class SmallestRange {

    public int[] smallestRange(List<List<Integer>> nums) {
        PriorityQueue<Pair> queue = new PriorityQueue<>((a, b) -> a.k - b.k);
        int currMaxNumber = Integer.MIN_VALUE;
        for (int i = 0; i < nums.size(); i++) {
            List<Integer> subNums = nums.get(i);
            queue.offer(new Pair(subNums.get(0),0, i));
            currMaxNumber = Math.max(currMaxNumber, subNums.get(0));
        }

        int rangeS = 0, rangeE = Integer.MAX_VALUE;

        while (queue.size() == nums.size()) {
            Pair p = queue.poll();
            List<Integer> list = nums.get(p.ind);
            if (rangeE - rangeS > currMaxNumber - list.get(p.subInd)) {
                rangeE = currMaxNumber;
                rangeS = list.get(p.subInd);
            }
            if (list.size() > p.subInd + 1) {
                int curr = list.get(p.subInd + 1);
                queue.offer(new Pair(curr, p.subInd + 1, p.ind));
                currMaxNumber = Math.max(currMaxNumber, curr);
            }
        }
        return new int[] { rangeS, rangeE };
    }
    
    class Pair {
        int k;
        int ind;
        int subInd;
        public Pair(int key, int subIndex, int index) {
            k = key;
            ind = index;
            subInd = subIndex;
        }
    }
}
```

#### [Java Source Code](../../../src/main/java/com/algorithm/kmerge/SmallestRange.java)