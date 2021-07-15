# Level Order Successor of a node in Binary Tree - Medium

Given a binary tree and a node in the binary tree, find Levelorder successor of the given node. That is, the node that appears after the given node in the level order traversal of the tree.

<b>Note:</b> The task is not just to print the data of the node, you have to return the complete node from the tree.

##### Examples:

```
Consider the following binary tree
              20            
           /      \         
          10       26       
         /  \     /   \     
       4     18  24    27   
            /  \
           14   19
          /  \
         13  15

Levelorder traversal of given tree is:
20, 10, 26, 4, 18, 24, 27, 14, 19, 13, 15

Input : 24
Output : 27

Input : 4
Output : 18
```
#### Java Solution
```java
public class LevelOrderSuccessor {

    static Node levelOrderSuccessor(Node root, Node key) {
        // Base Case
        if (root == null)
            return null;

        // If root equals to key
        if (root == key) {
            // If left child exists it will be
            // the Postorder Successor
            if (root.left != null) {
                return root.left;
            }
            // Else if right child exists it will be
            // the Postorder Successor
            if (root.right != null) {
                return root.right;
            }
            return null; // No Successor
        }

        // Create an empty queue for level
        // order traversal
        Queue<Node> q = new LinkedList<Node>();

        // Enqueue Root
        q.add(root);

        while (!q.isEmpty()) {
            Node nd = q.peek();
            q.remove();

            if (nd.left != null) {
                q.add(nd.left);
            }

            if (nd.right != null) {
                q.add(nd.right);
            }

            if (nd == key) {
                break;
            }
        }

        return q.peek();
    }
}
```

#### [Java Source Code](../../../src/main/java/com/algorithm/treedatastructure/LevelOrderSuccessor.java)
- [Reference](https://www.geeksforgeeks.org/level-order-successor-of-a-node-in-binary-tree/)