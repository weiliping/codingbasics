# 206. Reverse Linked List - Easy

Given the ```head``` of a singly linked list, reverse the list, and return the reversed list.


##### Example 1:
![](206_sample_01.jpeg)

```
Input: head = [1,2,3,4,5]
Output: [5,4,3,2,1]
```

##### Example 2:
![](206_sample_02.jpeg)

```
Input: head = [1,2]
Output: [2,1]
```

##### Example 3:

```
Input: head = []
Output: []
``` 

##### Constraints:

- The number of nodes in the list is the range ```[0, 5000]```.
- ```-5000 <= Node.val <= 5000```
 

<b>Follow up:</b> A linked list can be reversed either iteratively or recursively. Could you implement both?

#### Java Solution
```java
public class ReverseList {

    public ListNode reverseList(ListNode head) {
        ListNode newHead = null, p = head;
        while (p != null) {
            ListNode tmp = p.next;
            p.next = newHead;
            newHead = p;
            p = tmp;
        }
        return newHead;
    }
}
```

#### [Java Source Code](../../../src/main/java/com/algorithm/linkedlists/ReverseList.java)
- [Solution](../../../src/main/java/com/algorithm/linkedlists/ReverseSubList.java)