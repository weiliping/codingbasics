# Connect All Level Order Siblings in Binary Tree - Medium

Given a binary tree, connect each node with its level order successor. The last node of each level should point to the first node of the next level.

```
        12
       /  \
      7    1
     /    / \
    9    10  5 
Input: [12, 7, 1, 9, null, 10, 5]
Output:
12 -> 7 -> 1 -> 9 -> 10 > 5
```

#### Java Solution
```java
public class ConnectAllLevelOrderSiblings {
    private static void connect(final Node root) {
        if (root == null) {
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        Node previous = null;
        while (!queue.isEmpty()) {
            Node currentNode = queue.poll();
            if (previous != null) {
                previous.next = currentNode;
            }
            previous = currentNode;

            if (currentNode.left != null) {
                queue.offer(currentNode.left);
            }
            if (currentNode.right != null) {
                queue.offer(currentNode.right);
            }
        }
    }
}
```

#### [Java Source Code](../../../src/main/java/com/algorithm/treedatastructure/ConnectAllLevelOrderSiblings.java)