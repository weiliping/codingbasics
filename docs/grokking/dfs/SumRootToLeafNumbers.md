# 129. Sum Root to Leaf Numbers

You are given the root of a binary tree containing digits from 0 to 9 only.

Each root-to-leaf path in the tree represents a number.

- For example, the root-to-leaf path ```1 -> 2 -> 3``` represents the number ```123```.

Return the total sum of all root-to-leaf numbers.

A <b>leaf</b> node is a node with no children.

##### Example 1:

![](129_sample_01.jpeg)
```
Input: root = [1,2,3]
Output: 25
Explanation:
The root-to-leaf path 1->2 represents the number 12.
The root-to-leaf path 1->3 represents the number 13.
Therefore, sum = 12 + 13 = 25.
```

##### Example 2:

![](129_sample_02.jpeg)
```
Input: root = [4,9,0,5,1]
Output: 1026
Explanation:
The root-to-leaf path 4->9->5 represents the number 495.
The root-to-leaf path 4->9->1 represents the number 491.
The root-to-leaf path 4->0 represents the number 40.
Therefore, sum = 495 + 491 + 40 = 1026.
```

##### Constraints:

- The number of nodes in the tree is in the range [1, 1000].
- 0 <= Node.val <= 9
- The depth of the tree will not exceed 10.

#### Java Solution
```java
public class SumRootToLeafNumbers {

    public int sumNumbers(TreeNode root) {
        return sumNumsDFS(root, 0);
    }

    int sumNumsDFS(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        sum = sum * 10 + root.val;
        if (root.left == null && root.right == null) {
            return sum;
        }
        return sumNumsDFS(root.left, sum) + sumNumsDFS(root.right, sum);
    }
}
```

#### [Java Source Code](../../../src/main/java/com/algorithm/treedatastructure/SumRootToLeafNumbers.java)