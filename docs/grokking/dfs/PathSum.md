# 112. Path Sum - Easy

Given the ```root``` of a binary tree and an integer targetSum, return ```true``` if the tree has a <b>root-to-leaf</b> path such that adding up all the values along the path equals ```targetSum```.

A <b>leaf</b> is a node with no children.

##### Example 1:
![](112_sample_01.jpeg)

```
Input: root = [5,4,8,11,null,13,4,7,2,null,null,null,1], targetSum = 22
Output: true
```

##### Example 2:
![](112_sample_02.jpeg)
```
Input: root = [1,2,3], targetSum = 5
Output: false
```

##### Example 3:

```
Input: root = [1,2], targetSum = 0
Output: false
```

##### Constraints:

- The number of nodes in the tree is in the range ```[0, 5000]```.
- ```-1000 <= Node.val <= 1000```
- ```-1000 <= targetSum <= 1000```

#### Java Solution
```java
public class PathSum {

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null && root.val == sum) {
            return true;
        }
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }
}
```

#### [Java Source Code](../../../src/main/java/com/algorithm/treedatastructure/PathSum.java)