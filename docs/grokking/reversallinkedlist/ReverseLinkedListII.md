# 92. Reverse Linked List II - Medium

Given the ```head``` of a singly linked list and two integers ```left``` and ```right``` where ```left <= right```, reverse the nodes of the list from position ```left``` to position ```right```, and return the reversed list.

 

##### Example 1:
![](92_sample_01.jpeg)

```
Input: head = [1,2,3,4,5], left = 2, right = 4
Output: [1,4,3,2,5]
```

##### Example 2:

```
Input: head = [5], left = 1, right = 1
Output: [5]
``` 

##### Constraints:

- The number of nodes in the list is ```n```.
- ```1 <= n <= 500```
- ```-500 <= Node.val <= 500```
- ```1 <= left <= right <= n```
 

<b>Follow up:</b> Could you do it in one pass?

#### Java Solution
```java
public class ReverseListII {

    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null) {
            return head;
        }

        ListNode dummy = new ListNode(0), pre = dummy;
        dummy.next = head;
        for (int i = 0; i < m - 1; i++) {
            pre = pre.next;
        }

        ListNode curr = pre.next;
        for (int i = m; i < n; i++) {
            ListNode last = curr.next;
            curr.next = last.next;
            last.next = pre.next;
            pre.next = last;
        }
        return dummy.next;
    }
}
```

#### [Java Source Code](../../../src/main/java/com/algorithm/linkedlists/ReverseListII.java)