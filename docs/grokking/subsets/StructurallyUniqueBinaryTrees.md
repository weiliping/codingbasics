# Structurally Unique Binary Search Trees - Hard

Given a number ```n```, write a function to return all structurally unique Binary Search Trees (BST) that can store values 1 to ```n```?


```
For example, for N = 2, there are 2 unique BSTs
     1               2  
      \            /
       2         1 

For N = 3, there are 5 possible BSTs
  1              3        3         2      1
    \           /        /        /  \      \
     3        2         1        1    3      2
    /       /            \                    \
   2      1               2                    3
```
##### Example 1:
```
Input: 2
Output: List containing root nodes of all structurally unique BSTs.
Explanation: Here are the 2 structurally unique BSTs storing all numbers from 1 to 2:
```

##### Example 2:

```
Input: 3
Output: List containing root nodes of all structurally unique BSTs.
Explanation: Here are the 5 structurally unique BSTs storing all numbers from 1 to 3:
```

#### Java Solution
```java
public class ConstructTrees {

    static List<TreeNode> constructTrees(int start, int end) {
        ArrayList<TreeNode> list = new ArrayList<>();
        if (start > end) {
            list.add(null);
            return list;
        }

        for (int i = start; i <= end; i++) {
            List<TreeNode> leftSubtree = constructTrees(start, i - 1);
            List<TreeNode> rightSubtree = constructTrees(i + 1, end);

            for (int j = 0; j < leftSubtree.size(); j++) {
                TreeNode left = leftSubtree.get(j);
                for (int k = 0; k < rightSubtree.size(); k++) {
                    TreeNode right = rightSubtree.get(k);
                    TreeNode node = new TreeNode(i);
                    node.left = left;
                    node.right = right;
                    list.add(node);
                }
            }
        }
        return list;
    }
}
```

#### [Java Source Code](../../../src/main/java/com/algorithm/subsets/ConstructTrees.java)

