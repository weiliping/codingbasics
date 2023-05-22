package com.algorithm.contest.weeklycontest163;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.algorithm.treedatastructure.TreeNode;

public class FindElements {

    public static void main(String[] args) {
//        TreeNode root = new TreeNode(-1);
//        root.right = new TreeNode(-1);
//        FindElements f = new FindElements(root);
//        System.out.println(f.find(1));
//        System.out.println(f.find(2));
//
//        TreeNode root1 = new TreeNode(-1);
//        root1.left = new TreeNode(-1);
//        root1.left.left = new TreeNode(-1);
//        root1.left.right = new TreeNode(-1);
//        root1.right = new TreeNode(-1);
//        FindElements f1 = new FindElements(root1);
//        System.out.println(f1.find(1));
//        System.out.println(f1.find(3));
//        System.out.println(f1.find(5));

        TreeNode root2 = new TreeNode(-1);
        root2.right = new TreeNode(-1);
        root2.right.left = new TreeNode(-1);
        root2.right.left.left = new TreeNode(-1);
        FindElements f2 = new FindElements(root2);
        System.out.println(f2.find(2));
        System.out.println(f2.find(3));
        System.out.println(f2.find(4));
        System.out.println(f2.find(5));
    }

    public List<Integer> eles;
    public FindElements(TreeNode root) {
        eles = new ArrayList<>();

        ArrayDeque<Integer> values = new ArrayDeque<>();
        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        values.offer(0);
        while (!queue.isEmpty()) {
            TreeNode r = queue.poll();
            Integer v = values.poll();
            eles.add(v);
            if (r.left != null) {
                queue.offer(r.left);
                values.offer(2 * v + 1);
            }

            if (r.right != null) {
                queue.offer(r.right);
                values.offer(2 * v + 2);
            }
        }
    }

    public boolean find(int target) {
        return Collections.binarySearch(eles, target) > -1;
    }
}
