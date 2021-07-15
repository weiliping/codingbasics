# 111. Minimum Depth of Binary Tree

Given a binary tree, find its minimum depth.

The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.

<b>Note:</b> A leaf is a node with no children.

 

##### Example 1:
![](111_sample.jpg)

```
Input: root = [3,9,20,null,null,15,7]
Output: 2
```
##### Example 2:

```
Input: root = [2,null,3,null,4,null,5,null,6]
Output: 5 
```

##### Constraints:

- The number of nodes in the tree is in the range [0, 105].
- -1000 <= Node.val <= 1000

#### Java Solution
```java
public class MinimumDepth {

    public static int minDepthBfs(TreeNode root) {
        int depth = 0;
        if (root == null) {
            return depth;
        }

        LinkedList<TreeNode> queue = new LinkedList<>();

        queue.offer(root);

        while (!queue.isEmpty()) {
            depth++;

            for (int i = 0; i < queue.size(); i++) {
                TreeNode node = queue.poll();
                if (node.left == null && node.right == null) {
                    return depth;
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
        return depth;
    }

    public static int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = root.left == null ? 1 : minDepth(root.left);
        int rightDepth = root.right == null ? 1 : minDepth(root.right);
        return Math.min(leftDepth, rightDepth);
    }
}
```

#### [Java Source Code](../../../src/main/java/com/algorithm/treedatastructure/MinimumDepth.java)