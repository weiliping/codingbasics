package com.algorithm.dp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.algorithm.treedatastructure.TreeNode;

public class RobIII {

    public static void main(String[] args) {

    }

    public int rob(TreeNode root) {
        return dfs(root, new HashMap<>());
    }

    int dfs(TreeNode root, Map<TreeNode, Integer> dp) {
        if (root == null) {
            return 0;
        }

        if (dp.containsKey(root)) {
            return dp.get(root);
        }

        int v = 0;

        if (root.left != null) {
            v += dfs(root.left.left, dp) + dfs(root.left.right, dp);
        }

        if (root.right != null) {
            v += dfs(root.right.left, dp) + dfs(root.right.right, dp);
        }

        v = Math.max(v + root.val, dfs(root.left, dp) + dfs(root.right, dp));

        dp.put(root, v);
        return v;
    }
}
