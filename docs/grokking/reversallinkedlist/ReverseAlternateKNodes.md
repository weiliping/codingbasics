# Reverse Alternate K Nodes - Medium

Given a linked list A of length N and an integer B.

You need to reverse every alternate B nodes in the linked list A.

##### Example 1:

```
Input: 3 -> 4 -> 7 -> 5 -> 6 -> 6 -> 15 -> 61 -> 16, 3
Output: 7 -> 4 -> 3 -> 5 -> 6 -> 6 -> 16 -> 61 -> 15
Explanation: The linked list contains 9 nodes and we need to reverse alternate 3 nodes.
    First sublist of length 3  is 3 -> 4 -> 7 so on reversing it we get 7 -> 4 -> 3.
    Second sublist of length 3 is 5 -> 6 -> 6 we don't need to reverse it.
    Third sublist of length 3 is 15 -> 61 -> 16 so on reversing it we get 16 -> 61 -> 15.
```

##### Example 2:
```
Input: 1 -> 4 -> 6 -> 6 -> 4 -> 10, 2
Output: 4 -> 1 -> 6 -> 6 -> 10 -> 4
Explanation: The linked list contains 6 nodes and we need to reverse alternate 2 nodes.
    First sublist of length 2 is 1 -> 4 so on reversing it we get 4 -> 1.
    Second sublist of length 2 is 6 -> 6 we don't need to reverse it.
    Third sublist of length 2 is 4 -> 10 so on reversing it we get 10 -> 4.
```

##### Constraints
- 1 <= N <= 105
- 1<= Value in Each Link List Node <= 103
- 1 <= B <= N
- N is divisible by B

#### Java Solution
```java
public class ReverseAlternateKListNodes {
    static ListNode head;

    ListNode kAltReverse(ListNode node, int k) {
        ListNode current = node;
        ListNode next, prev = null;
        int count = 0;

        while (current != null && count < k) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
            count++;
        }
  
        if (node != null) {
            node.next = current;
        }
  
        count = 0;
        while (count < k - 1 && current != null) {
            current = current.next;
            count++;
        }
  
        if (current != null) {
            current.next = kAltReverse(current.next, k);
        }
        return prev;
    }

    void printList(ListNode node) {
        while (node != null) {
            node = node.next;
        }
    }

    void push(int newdata) {
        ListNode myListNode = new ListNode(newdata);
        myListNode.next = head;
        head = myListNode;
    }
}
```

#### [Java Source Code](../../../src/main/java/com/algorithm/linkedlists/ReverseAlternateKListNodes.java)
- [Reference](https://www.techiedelight.com/reverse-alternate-group-k-nodes-linked-list/)