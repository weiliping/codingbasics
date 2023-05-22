package com.algorithm.treedatastructure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UniqueBinarySearchTreesII {

    /**
     * #95
     * https://leetcode-cn.com/problems/unique-binary-search-trees-ii/
     * 
     * @param args
     */
    public static void main(String[] args) {
        List<TreeNode> trees = generateTrees(3);
        for (TreeNode t : trees) {
            System.out.println(Arrays.toString(PreorderTraversal.preorderTraversal(t).toArray()));
        }
    }

    public static List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new ArrayList<>();
        }
        ArrayList<TreeNode>[][] memo = new ArrayList[n][n];
        return helper(1, n, memo);
    }

    static List<TreeNode> helper(int start, int end, ArrayList<TreeNode>[][] memo) {
        List<TreeNode> res = new ArrayList<>();
        if (start > end) {
            res.add(null);
            return res;
        }
        if (memo[start - 1][end - 1] != null) {
            return memo[start - 1][end - 1];
        }
        for (int i = start; i <= end; i++) {
            List<TreeNode> leftNodes = helper(start, i - 1, memo);
            List<TreeNode> rightNodes = helper(i + 1, end, memo);
            for (TreeNode lNode : leftNodes) {
                for (TreeNode rNode : rightNodes) {
                    TreeNode r = new TreeNode(i);
                    r.left = lNode;
                    r.right = rNode;
                    res.add(r);
                }
            }
        }
        memo[start - 1][end - 1] = new ArrayList<>(res);
        return res;
    }
}
