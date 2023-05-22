package com.algorithm.contest.weeklycontest270;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import com.algorithm.treedatastructure.TreeNode;

public class GetDirections {

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(1);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(4);
        GetDirections g = new GetDirections();
        System.out.println(g.getDirections(root, 3, 6));

        TreeNode root1 = new TreeNode(2);
        root1.left = new TreeNode(1);
        System.out.println(g.getDirections(root1, 2, 1));
    }

    public String getDirections(TreeNode root, int startValue, int destValue) {
        TreeNode r = parent(root, startValue, destValue);
        StringBuilder p1 = path(r, startValue, true);
        StringBuilder p2 = path(r, destValue, false);
        if (p2 != null) {
            p2.reverse();
        }
        if (p1 == null || p1.length() == 0) {
            return p2.toString();
        }
        if (p2 == null || p2.length() == 0) {
            return p1.toString();
        }
        p1.append(p2);
        return p1.toString();
    }

    public StringBuilder path(TreeNode p, int v, boolean isStart) {
        if (p == null) {
            return null;
        }
        if (p.val == v) {
            return new StringBuilder();
        }
        StringBuilder left = path(p.left, v, isStart);
        if (left != null) {
            left.append(isStart ? 'U': 'L');
            return left;
        }
        StringBuilder right = path(p.right, v, isStart);
        if (right != null) {
            right.append(isStart ? 'U': 'R');
            return right;
        }
        return null;
    }

    public TreeNode parent(TreeNode root, int s, int d) {
        if (root == null) {
            return null;
        }
        if (root.val == s || root.val == d) {
            return root;
        }
        TreeNode left = parent(root.left, s, d);
        TreeNode right = parent(root.right, s, d);
        if (left != null && right != null) {
            return root;
        }
        if (left == null) {
            return right;
        }
        return left;
    }
}
