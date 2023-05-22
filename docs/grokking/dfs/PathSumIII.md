# 437. Path Sum III

You are given a binary tree in which each node contains an integer value.

Find the number of paths that sum to a given value.

The path does not need to start or end at the root or a leaf, but it must go downwards (traveling only from parent nodes to child nodes).

The tree has no more than 1,000 nodes and the values are in the range -1,000,000 to 1,000,000.

##### Example:
```
root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8

      10
     /  \
    5   -3
   / \    \
  3   2   11
 / \   \
3  -2   1

Return 3. The paths that sum to 8 are:

1.  5 -> 3
2.  5 -> 2 -> 1
3. -3 -> 11
```

#### Java Solution
```java
public class PathSumIII {
    public static int pathSum(TreeNode root, int sum) {
        int[] res = new int[1];
        sumHelper(root, res, sum);
        return res[0];
    }

    private static void sumHelper(TreeNode root, int[] res, int sum) {
        if (root == null) {
            return;
        }
        pathSumHelper(root, res, sum);
        sumHelper(root.left, res, sum);
        sumHelper(root.right, res, sum);
    }

    private static void pathSumHelper(TreeNode root, int[] res, int sum) {
        if (root == null) {
            return;
        }
        if (root.val == sum) {
            res[0]++;
        }
        int remain = sum - root.val;
        pathSumHelper(root.left, res, remain);
        pathSumHelper(root.right, res, remain);
    }

    public static int pathSumI(TreeNode root, int sum) {
        HashMap<Integer, Integer> sums = new HashMap<>();
        sums.put(0, 1);
        int[] res = new int[1];
        process(root, res, 0, sum, sums);
        return res[0];
    }

    private static void process(TreeNode node, int[] res, int currSum, int sum, HashMap<Integer, Integer> sums) {
        if (node == null) {
            return;
        }
        currSum += node.val;
        if (sums.containsKey(currSum - sum)) {
            res[0] += sums.get(currSum - sum);
        }
        if (!sums.containsKey(currSum)) {
            sums.put(currSum, 0);
        }
        sums.put(currSum, sums.getOrDefault(currSum, 0) + 1);
        process(node.left, res, currSum, sum, sums);
        process(node.right, res, currSum, sum, sums);
        sums.put(currSum, sums.get(currSum) - 1);
    }
}
```

#### [Java Source Code](../../../src/main/java/com/algorithm/treedatastructure/PathSumIII.java)