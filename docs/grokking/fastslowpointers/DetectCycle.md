# 142. Linked List Cycle II - Medium
Given a linked list, return the node where the cycle begins. If there is no cycle, return ```null```.

There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the ```next``` pointer. Internally, ```pos``` is used to denote the index of the node that tail's ```next``` pointer is connected to. <b>Note that</b> ```pos``` <b>is not passed as a parameter</b>.

Notice that you should not modify the linked list.



##### Example 1:

![](141_sample_01.png)
```
Input: head = [3,2,0,-4], pos = 1
Output: tail connects to node index 1
Explanation: There is a cycle in the linked list, where tail connects to the second node.
```

##### Example 2:

![](141_sample_02.png)
```
Input: head = [1,2], pos = 0
Output: tail connects to node index 0
Explanation: There is a cycle in the linked list, where tail connects to the first node.
```

##### Example 3:

![](141_sample_03.png)
```
Input: head = [1], pos = -1
Output: no cycle
Explanation: There is no cycle in the linked list.
```

##### Constraints:

- The number of the nodes in the list is in the range ```[0, 104]```.
- -10<sup>5</sup> <= Node.val <= 10<sup>5</sup>
- pos is -1 or a valid index in the linked-list.
 

<b>Follow up:</b> Can you solve it using O(1) (i.e. constant) memory?

#### Java Solution
```java
public class DetectCycle {

    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode slow = head, fast = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (slow == fast) {
                break;
            }
        }

        if (fast == null || fast.next == null) {
            return null;
        }
        slow = head;

        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return fast;
    }
}
```

#### [Java Source Code](../../../src/main/java/com/algorithm/linkedlists/DetectCycle.java)