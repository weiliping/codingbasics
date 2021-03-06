# Search in a Sorted Infinite Array - Medium

Given an integer array sorted in ascending order, write a function to search ```target``` in ```nums```.  If ```target``` exists, then return its index, otherwise return ```-1```. <b>However, the array size is unknown to you.</b> You may only access the array using an ```ArrayReader``` interface, where ```ArrayReader.get(k)``` returns the element of the array at index ```k``` (0-indexed).

You may assume all integers in the array are less than ```10000```, and if you access the array out of bounds, ```ArrayReader.get``` will return ```2147483647```.

##### Example 1:

```
Input: array = [-1,0,3,5,9,12], target = 9
Output: 4
Explanation: 9 exists in nums and its index is 4
```

##### Example 2:

```
Input: array = [-1,0,3,5,9,12], target = 2
Output: -1
Explanation: 2 does not exist in nums so return -1
```

##### Note:

- You may assume that all elements in the array are unique.
- The value of each element in the array will be in the range [-9999, 9999].

#### Java Solution
```java
public class SearchSortedInfiniteArray {

    class ArrayReader {
        ArrayList<Integer> infinitArray = new ArrayList<>();

        public int get(int index) {
            return infinitArray.get(index);
        }
    }

    /**
     * @param reader
     * @param target
     * @return
     */
    public static int search(ArrayReader reader, int target) {
        int start = 0, end = Integer.MAX_VALUE;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (target == reader.get(mid)) {
                return mid;
            } else if (target < reader.get(mid)) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        if (reader.get(start) == target) {
            return start;
        } else if (reader.get(end) == target) {
            return end;
        }
        return -1;
    }

    public static int searchII(ArrayReader reader, int target) {
        int hi = 1;
        while (reader.get(hi) < target) {
            hi = hi * 2;
        }
        int low = hi / 2;
        while (low <= hi) {
            int mid = low + (hi - low) / 2;
            int val = reader.get(mid);
            if (val == target) {
                return mid;
            } else if ( val > target) {
                hi = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }
}
```

#### [Java Source Code](../../../src/main/java/com/algorithm/binarysearch/SearchSortedInfiniteArray.java)
- [Reference](https://aaronice.gitbook.io/lintcode/binary-search/search-in-a-sorted-array-of-unknown-size)