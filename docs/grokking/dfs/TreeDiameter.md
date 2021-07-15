# 543. Diameter of Binary Tree - Easy

Given the ```root``` of a binary tree, return the length of the <b>diameter</b> of the tree.

The <b>diameter</b> of a binary tree is the <b>length</b> of the longest path between any two nodes in a tree. This path may or may not pass through the ```root```.

The <b>length</b> of a path between two nodes is represented by the number of edges between them.

 
##### Example 1:

![](543_sample_01.jpeg)
```
Input: root = [1,2,3,4,5]
Output: 3
Explanation: 3is the length of the path [4,2,1,3] or [5,2,1,3].
```

##### Example 2:

```
Input: root = [1,2]
Output: 1
``` 

##### Constraints:

- The number of nodes in the tree is in the range ```[1, 104]```.
- ```-100 <= Node.val <= 100```

#### Java Solution
```java
public class DiameterOfBinaryTree {
    public static int diameterOfBinaryTree(TreeNode root) {
        int[] res = new int[1];
        Map<TreeNode, Integer> m = new HashMap<>();
        diameterHelper(m, res, root);
        return res[0];
    }

    static int diameterHelper(Map<TreeNode, Integer> m, int[] res, TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (m.containsKey(root)) {
            return m.get(root);
        }
        int l = diameterHelper(m, res, root.left);
        int r = diameterHelper(m, res, root.right);
        res[0] = Math.max(res[0], l + r);
        m.put(root, Math.max(l, r) + 1);
        return m.get(root);
    }
}
```

#### [Java Source Code](../../../src/main/java/com/algorithm/treedatastructure/DiameterOfBinaryTree.java)