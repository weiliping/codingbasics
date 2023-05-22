# 102. Binary Tree Level Order Traversal - Medium

Given the ```root``` of a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right, level by level).

##### Example 1:
![](102_sample.jpg)
```
Input: root = [3,9,20,null,null,15,7]
Output: [[3],[9,20],[15,7]]
```
##### Example 2:
```
Input: root = [1]
Output: [[1]]
```

##### Example 3:
```
Input: root = []
Output: []
```

##### Constraints:

- The number of nodes in the tree is in the range ```[0, 2000]```.
- ```-1000 <= Node.val <= 1000```

#### Java Solution
```java
public class LevelOrderTraversal {

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();

        if (root == null) {
            return res;
        }
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.offer(root);
        nodeQueue.offer(null);
        List<Integer> subRes = new ArrayList<>();
        while (true) {
            TreeNode curr = nodeQueue.poll();
            if (curr != null) {
                subRes.add(curr.val);
                if (curr.left != null) {
                    nodeQueue.offer(curr.left);
                }
                if (curr.right != null) {
                    nodeQueue.offer(curr.right);
                }
            } else {
                res.add(subRes);
                subRes = new ArrayList<>();
                if (nodeQueue.isEmpty()) {
                    break;
                }
                nodeQueue.offer(null);
            }
        }
        return res;
    }

    public static List<List<Integer>> levelOrderBacking(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        levelOrderHelper(root, 0, res);
        return res;
    }

    static void levelOrderHelper(TreeNode root, int level, List<List<Integer>> res) {
        if (root == null) {
            return;
        }
        if (level == res.size()) {
            res.add(new ArrayList<>());
        }
        res.get(level).add(root.val);
        levelOrderHelper(root.left, level + 1, res);
        levelOrderHelper(root.right, level + 1, res);
    }
}
```

#### [Java Source Code](../../../src/main/java/com/algorithm/treedatastructure/LevelOrderTraversal.java)