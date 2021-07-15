# 143. Reorder List - Medium

You are given the head of a singly linked-list. The list can be represented as:
```
L0 → L1 → … → Ln - 1 → Ln
```
Reorder the list to be on the following form:

```
L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
```
You may not modify the values in the list's nodes. Only nodes themselves may be changed.
 

##### Example 1:

```
Input: head = [1,2,3,4]
Output: [1,4,2,3]
```

##### Example 2:

```
Input: head = [1,2,3,4,5]
Output: [1,5,2,4,3]
``` 

##### Constraints:

- The number of nodes in the list is in the range ```[1, 5 * 104]```.
- ```1 <= Node.val <= 1000```

#### Java Solution
```java
public class ReorderList {

    public void reorderList(ListNode head) {
        if (head == null) {
            return;
        }
        ListNode mid = findMid(head);
        ListNode right = reverseList(mid);

        mergeLists(head, right);
    }

    static ListNode findMid(ListNode node) {
        ListNode slow = node, fast = node;

        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    static ListNode reverseList(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode reverseNode = null, curr = head;
        while (curr != null) {
            ListNode tmp = curr.next;
            curr.next = reverseNode;
            reverseNode = curr;
            curr = tmp;
        }
        return reverseNode;
    }

    static ListNode mergeLists(ListNode head1, ListNode head2) {
        if (head1 == null) {
            return head2;
        }

        if (head2 == null) {
            return head1;
        }
        ListNode p = head1;
        while (p != null && head2.next != null) {
            ListNode t = head2;
            head2 = head2.next;
            t.next = p.next;
            p.next = t;
            p = p.next.next;
        }
        return head1;
    }
}
```

#### [Java Source Code](../../../src/main/java/com/algorithm/linkedlists/ReorderList.java)