# 25. Reverse Nodes in k-Group - Hard

Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.

k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes, in the end, should remain as it is.

##### Follow up:

- Could you solve the problem in ```O(1)``` extra memory space?
- You may not alter the values in the list's nodes, only nodes itself may be changed.
 

##### Example 1:
![](25_sample_01.jpeg)

```
Input: head = [1,2,3,4,5], k = 2
Output: [2,1,4,3,5]
```

##### Example 2:
![](25_sample_02.jpeg)

```
Input: head = [1,2,3,4,5], k = 3
Output: [3,2,1,4,5]
```

##### Example 3:

```
Input: head = [1,2,3,4,5], k = 1
Output: [1,2,3,4,5]
```

##### Example 4:

```
Input: head = [1], k = 1
Output: [1]
``` 

##### Constraints:

- The number of nodes in the list is in the range ```sz```.
- ```1 <= sz <= 5000```
- ```0 <= Node.val <= 1000```
- ```1 <= k <= sz```

#### Java Solution
```java
public class ReverseKGroup {

    public ListNode reverseKGroup(ListNode h, int k) {

        if (h == null || k == 1) {
            return h;
        }

        int i = 0;
        ListNode dummyNode = new ListNode(-1);
        ListNode prev = dummyNode;
        dummyNode.next = h;
        ListNode p = h;

        while (p != null) {
            i++;
            if (i % k == 0) {
                prev = reverseNode(prev, p.next);
                p = prev.next;
            } else {
                p = p.next;
            }
        }
        return dummyNode.next;
    }

    public ListNode reverseNode(ListNode prev, ListNode next) {
        ListNode last = prev.next, curr = last.next;

        while (curr != next) {
            last.next = curr.next;
            curr.next = prev.next;
            prev.next = curr;
            curr = last.next;
        }
        return last;
    }
}
```

#### [Java Source Code](../../../src/main/java/com/algorithm/linkedlists/ReverseKGroup.java)