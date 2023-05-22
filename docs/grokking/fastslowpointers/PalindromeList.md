# 234. Palindrome Linked List - Easy

Given the ```head``` of a singly linked list, return ```true``` if it is a palindrome.

 

##### Example 1:
![](234_sample_01.jpeg)

```
Input: head = [1,2,2,1]
Output: true
```

##### Example 2:
![](234_sample_02.jpeg)

```
Input: head = [1,2]
Output: false
```

##### Constraints:

- The number of nodes in the list is in the range ```[1, 105]```.
- ```0 <= Node.val <= 9```
 

<b>Follow up:</b> Could you do it in O(n) time and O(1) space?

#### Java Solution
```java
public class PalindromeList {

    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }

        ListNode s = head, f = head;

        while (f.next != null && f.next.next != null) {
            s = s.next;
            f = f.next.next;
            if (s == f) {
                break;
            }
        }

        if (f != null) {
            s = s.next;
        }

        s = reverse(s);

        while (s != null) {
            if (s.val != head.val) {
                return false;
            }
            s = s.next;
            head = head.next;
        }
        return true;
    }

    static ListNode reverse(ListNode h) {
        ListNode newHead = null, p = h;
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

#### [Java Source Code](../../../src/main/java/com/algorithm/linkedlists/PalindromeList.java)