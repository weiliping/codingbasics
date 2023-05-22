# 23. Merge k Sorted Lists - Hard

You are given an array of ```k``` linked-lists ```lists```, each linked-list is sorted in ascending order.

Merge all the linked-lists into one sorted linked-list and return it.



##### Example 1:

```
Input: lists = [[1,4,5],[1,3,4],[2,6]]
Output: [1,1,2,3,4,4,5,6]
Explanation: The linked-lists are:
[
  1->4->5,
  1->3->4,
  2->6
]
merging them into one sorted list:
1->1->2->3->4->4->5->6
```

##### Example 2:

```
Input: lists = []
Output: []
```

##### Example 3:

```
Input: lists = [[]]
Output: []
``` 

##### Constraints:

- ```k == lists.length```
- ```0 <= k <= 10^4```
- ```0 <= lists[i].length <= 500```
- ```-10^4 <= lists[i][j] <= 10^4```
- ```lists[i]``` is sorted in <b>ascending order</b>.
- The sum of ```lists[i].length``` won't exceed ```10^4```.

#### Java Solution
```java
public class MergeKSortedLists {

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        if (lists.length == 1) {
            return lists[0];
        }

        ListNode result = lists[0];
        for(int i=1; i<lists.length; i++) {
            result = mergeNode(result, lists[i]);
        }
        return result;
    }

    ListNode mergeNode(ListNode m, ListNode n) {
        ListNode result = null;

        if (m == null) {
            return n;
        }

        if (n == null) {
            return m;
        }

        if (m.val < n.val) {
            result = m;
            result.next = mergeNode(m.next, n);
        } else {
            result = n;
            result.next = mergeNode(m, n.next);
        }
        return result;
    }
}
```

#### [Java Source Code](../../../src/main/java/com/algorithm/linkedlists/MergeKSortedLists.java)