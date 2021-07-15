# 61. Rotate List - Medium

Given the ```head``` of a linked list, rotate the list to the right by ```k``` places.

 

##### Example 1:
![](61_sample_01.jpeg)

```
Input: head = [1,2,3,4,5], k = 2
Output: [4,5,1,2,3]
```

##### Example 2:
![](61_sample_02.jpeg)

```
Input: head = [0,1,2], k = 4
Output: [2,0,1]
```

##### Constraints:

- The number of nodes in the list is in the range ```[0, 500]```.
- ```-100 <= Node.val <= 100```
- 0 <= k <= 2 * 10<sup>9</sup>

#### Java Solution
```java
public class RotateList {

    public static ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        int n = 1;
        ListNode curr = head;
        while (curr.next != null) {
            n++;
            curr = curr.next;
        }

        curr.next = head;

        int m = n - k % n;
        for (int i = 0; i < m; i++) {
            curr = curr.next;
        }

        ListNode nHead = curr.next;
        curr.next = null;
        return nHead;
    }
}
```

#### [Java Source Code](../../../src/main/java/com/algorithm/linkedlists/RotateList.java)