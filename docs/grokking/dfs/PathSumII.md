# 113. Path Sum II - Medium

Given the ```root``` of a binary tree and an integer ```targetSum```, return all <b>root-to-leaf</b> paths where each path's sum equals ```targetSum```.

A <b>leaf</b> is a node with no children.
 
##### Example 1:
![](113_sample_01.jpeg)

```
Input: root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
Output: [[5,4,11,2],[5,8,4,5]]
```

##### Example 2:
![](113_sample_02.jpeg)

```
Input: root = [1,2,3], targetSum = 5
Output: []
```

##### Example 3:

```
Input: root = [1,2], targetSum = 0
Output: []
```

##### Constraints:

- The number of nodes in the tree is in the range [0, 5000].
- -1000 <= Node.val <= 1000
- -1000 <= targetSum <= 1000

#### Java Solution
```java
public class RootToLeafPathsSum {

    public List<List<Integer>> pathSum(TreeNode node, int sum) {
        Stack<Integer> s = new Stack<>();
        List<List<Integer>> res = new ArrayList<>();
        pathSumHelper(node, sum, s, res);
        return res;
    }

    void pathSumHelper(TreeNode node, int sum, Stack<Integer> s, List<List<Integer>> res) {
        if (node == null) {
            return;
        }
        s.add(node.val);
        if (sum == node.val && node.left == null && node.right == null) {
            res.add(new ArrayList<>(s));
        }
        pathSumHelper(node.left, sum - node.val, s, res);
        pathSumHelper(node.right, sum - node.val, s, res);
        s.pop();
    }
}
```

#### [Java Source Code](../../../src/main/java/com/algorithm/treedatastructure/RootToLeafPathsSum.java)