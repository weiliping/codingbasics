# 116. Populating Next Right Pointers in Each Node

You are given a <b>perfect binary tree</b> where all leaves are on the same level, and every parent has two children. The binary tree has the following definition:

```
struct Node {
  int val;
  Node *left;
  Node *right;
  Node *next;
}
```

Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to ```NULL```.

Initially, all next pointers are set to ```NULL```.

 

##### Follow up:

- You may only use constant extra space.
- Recursive approach is fine, you may assume implicit stack space does not count as extra space for this problem.


Example 1:
 ![](116_sample.png)
```
Input: root = [1,2,3,4,5,6,7]
Output: [1,#,2,3,#,4,5,6,7,#]
Explanation: Given the above perfect binary tree (Figure A), your function should populate each next pointer to point to its next right node, just like in Figure B. The serialized output is in level order as connected by the next pointers, with '#' signifying the end of each level.
```

##### Constraints:

- The number of nodes in the given tree is less than ```4096```.
- ```-1000 <= node.val <= 1000```

#### Java Solution
```java
public class NodeConnect {

    public Node connect(Node root) {
        if (root == null) {
            return root;
        }

        if (root.left != null) {
            root.left.next = root.right;
        }

        if (root.right != null) {
            root.right.next = root.next != null ? root.next.left : null;
        }
        connect(root.left);
        connect(root.right);
        return root;
    }
}
```

#### [Java Source Code](../../../src/main/java/com/algorithm/treedatastructure/NodeConnect.java)