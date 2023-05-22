# 637. Average of Levels in Binary Tree - Easy

Given the ```root``` of a binary tree, return the average value of the nodes on each level in the form of an array. Answers within 10-5 of the actual answer will be accepted.

##### Example 1:
![](637_sample_01.jpg)
```
Input: root = [3,9,20,null,15,7]
Output: [3.00000,14.50000,11.00000]
Explanation: The average value of nodes on level 0 is 3, on level 1 is 14.5, and on level 2 is 11.
Hence return [3, 14.5, 11].
```

##### Example 2:
![](637_sample_02.jpg)

```
Input: root = [3,9,20,15,7]
Output: [3.00000,14.50000,11.00000]
```

##### Constraints:

- The number of nodes in the tree is in the range ```[1, 104]```.
- -2<sup>31</sup> <= Node.val <= 2<sup>31 - 1</sup>

#### Java Solution
```java
public class AverageOfLevels {

    public static List<Double> averageOfLevels(TreeNode root) {
        List<Double> rst = new ArrayList<>();
        if (root == null) {
            return rst;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            double sum = 0;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                sum += node.val;
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            rst.add(sum / size);
        }

        return rst;
    }
}
```

#### [Java Source Code](../../../src/main/java/com/algorithm/treedatastructure/AverageOfLevels.java)