package com.algorithm.contest.weeklycontest172;

import static com.algorithm.contest.weeklycontest178.IsSubPath.buildTree;
import static com.algorithm.treedatastructure.PreorderTraversal.preorderTraversal;

import java.util.Arrays;

import com.algorithm.treedatastructure.TreeNode;

public class RemoveLeafNodes {

    public static void main(String[] args) {
        RemoveLeafNodes r = new RemoveLeafNodes();
        TreeNode root = buildTree(new Integer[] {1,2,3,2,null,2,4});
        System.out.println(Arrays.toString(preorderTraversal(r.removeLeafNodes(root, 2)).toArray()));

        TreeNode root2 = buildTree(new Integer[] {1,3,3,3,2});
        System.out.println(Arrays.toString(preorderTraversal(r.removeLeafNodes(root2, 3)).toArray()));

        TreeNode root3 = buildTree(new Integer[] {1,2,null,2,null,2});
        System.out.println(Arrays.toString(preorderTraversal(r.removeLeafNodes(root3, 2)).toArray()));

        TreeNode root4 = buildTree(new Integer[] {1,1,1});
        System.out.println(Arrays.toString(preorderTraversal(r.removeLeafNodes(root4, 1)).toArray()));

        TreeNode root5 = buildTree(new Integer[] {1,2,3});
        System.out.println(Arrays.toString(preorderTraversal(r.removeLeafNodes(root5, 1)).toArray()));
    }
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        dfs(root, target, null, false);
        return isLeaf(root, target) ? null : root;
    }

    static void dfs(TreeNode root, int target, TreeNode parent, boolean isLeft) {
        if (root == null) {
            return;
        }
        dfs(root.left, target, root, true);
        dfs(root.right, target, root, false);
        if (isLeaf(root, target)) {
            if (parent != null) {
                if (isLeft) {
                    parent.left = null;
                } else {
                    parent.right = null;
                }
            }
        }
    }

    static boolean isLeaf(TreeNode root, int target) {
        return root.val == target && root.left == null && root.right == null;
    }
}
