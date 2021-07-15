# 103. Binary Tree Zigzag Level Order Traversal 

Given the ```root``` of a binary tree, return the zigzag level order traversal of its nodes' values. (i.e., from left to right, then right to left for the next level and alternate between).

##### Example 1:
![](103_sample.jpg)

```
Input: root = [3,9,20,null,null,15,7]
Output: [[3],[20,9],[15,7]]
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

Constraints:
- The number of nodes in the tree is in the range ```[0, 2000]```.
- ```-100 <= Node.val <= 100```

#### Java Solution
```java
public class ZigzagLevelOrder {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        LinkedList<TreeNode> s = new LinkedList<>();
        s.add(root);
        int cns = 0;
        while (!s.isEmpty()) {
            List<Integer> levelRes = new ArrayList<>();
            for (int i = s.size(); i > 0; i--) {
                TreeNode p = s.pop();
                levelRes.add(p.val);
                if (p.left != null) {
                    s.add(p.left);
                }
                if (p.right != null) {
                    s.add(p.right);
                }
            }

            if (cns % 2 == 1) {
                Collections.reverse(levelRes);
            }
            res.add(levelRes);
            cns++;
        }
        return res;
    }
}
```

#### [Java Source Code](../../../src/main/java/com/algorithm/treedatastructure/ZigzagLevelOrder.java)
