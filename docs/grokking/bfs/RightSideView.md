# 199. Binary Tree Right Side View - Medium

Given the ```root``` of a binary tree, imagine yourself standing on the <b>right side</b> of it, *return the values of the nodes you can see ordered from top to bottom*.

##### Example 1:
![](199_sample_01.jpeg)
```
Input: root = [1,2,3,null,5,null,4]
Output: [1,3,4]
```

##### Example 2:

```
Input: root = [1,null,3]
Output: [1,3]
```

##### Example 3:

```
Input: root = []
Output: []
``` 

##### Constraints:

- The number of nodes in the tree is in the range ```[0, 100]```.
- ```-100 <= Node.val <= 100```

#### Java Solution
```java
public class RightSideView {

    public static List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                TreeNode r = queue.poll();
                if (i == n - 1) {
                    res.add(r.val);
                }
                if (r.left != null) {
                    queue.offer(r.left);
                }

                if (r.right != null) {
                    queue.offer(r.right);
                }
            }
        }
        return res;
    }
}
```

#### [Java Source Code](../../../src/main/java/com/algorithm/treedatastructure/RightSideView.java)