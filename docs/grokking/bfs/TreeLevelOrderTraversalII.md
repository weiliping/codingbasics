# 107. Binary Tree Level Order Traversal II - Medium

Given the ```root``` of a binary tree, return the bottom-up level order traversal of its nodes' values. (i.e., from left to right, level by level from leaf to root).

##### Example 1:
![](107_sample.jpg)
```
Input: root = [3,9,20,null,null,15,7]
Output: [[15,7],[9,20],[3]]
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
public class LevelOrderTraversalII {

    public static List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        q.offer(null);
        List<Integer> subRes = new ArrayList<>();
        while (true) {
            TreeNode tmp = q.poll();
            if (tmp != null) {
                subRes.add(tmp.val);
                if (tmp.left != null) {
                    q.offer(tmp.left);
                }
                if (tmp.right != null) {
                    q.offer(tmp.right);
                }
            } else {
                res.add(subRes);
                subRes = new ArrayList<>();
                if (q.isEmpty()) {
                    break;
                }
                q.offer(null);
            }
        }

        Collections.reverse(res);
        return res;
    }
}
```

#### [Java Source Code](../../../src/main/java/com/algorithm/treedatastructure/LevelOrderTraversalII.java)