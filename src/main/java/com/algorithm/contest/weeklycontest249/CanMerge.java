package com.algorithm.contest.weeklycontest249;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.algorithm.treedatastructure.InorderTraversal;
import com.algorithm.treedatastructure.TreeNode;

public class CanMerge {
    public static void main(String[] args) {
        CanMerge c = new CanMerge();
        InorderTraversal inorder = new InorderTraversal();
        List<TreeNode> trees = new ArrayList<>();
        TreeNode n = new TreeNode(2, new TreeNode(1), null);
        TreeNode n1 = new TreeNode(3, new TreeNode(2), new TreeNode(5));
        TreeNode n2 = new TreeNode(5, new TreeNode(4), null);
        trees.add(n);
        trees.add(n1);
        trees.add(n2);
        TreeNode root = c.canMerge(trees);

        System.out.println(Arrays.toString(inorder.inorderTraversal(root).toArray()));

        List<TreeNode> trees2 = new ArrayList<>();
        TreeNode n11 = new TreeNode(5, new TreeNode(3), new TreeNode(8));
        TreeNode n12 = new TreeNode(3, new TreeNode(2), new TreeNode(6));
        trees2.add(n11);
        trees2.add(n12);
        TreeNode root2 = c.canMerge(trees2);
        System.out.println(root2);

        List<TreeNode> trees3 = new ArrayList<>();
        TreeNode n31 = new TreeNode(2, new TreeNode(1), new TreeNode(3));
        trees3.add(n31);
        TreeNode root3 = c.canMerge(trees3);
        if (root3 != null) {
            System.out.println(Arrays.toString(inorder.inorderTraversal(root3).toArray()));
        } else {
            System.out.println(root3);
        }

        List<TreeNode> trees4 = new ArrayList<>();
        TreeNode n41 = new TreeNode(5, new TreeNode(4), null);
        TreeNode n42 = new TreeNode(3, null, null);
        trees4.add(n41);
        trees4.add(n42);
        TreeNode root4 = c.canMerge(trees4);
        if (root4 != null) {
            System.out.println(Arrays.toString(inorder.inorderTraversal(root4).toArray()));
        } else {
            System.out.println(root4);
        }

        List<TreeNode> trees5 = new ArrayList<>();
        TreeNode n51 = new TreeNode(2, null, new TreeNode(3));
        TreeNode n52 = new TreeNode(1, null, new TreeNode(3));
        TreeNode n53 = new TreeNode(3, new TreeNode(2), null);
        trees5.add(n51);
        trees5.add(n52);
        trees5.add(n53);
        TreeNode root5 = c.canMerge(trees5);
        if (root5 != null) {
            System.out.println(Arrays.toString(inorder.inorderTraversal(root5).toArray()));
        } else {
            System.out.println(root5);
        }
        List<TreeNode> trees6 = new ArrayList<>();
        TreeNode n61 = new TreeNode(6, new TreeNode(4), null);
        TreeNode n62 = new TreeNode(7, new TreeNode(6), null);
        TreeNode n63 = new TreeNode(5, null, new TreeNode(7));
        trees6.add(n61);
        trees6.add(n62);
        trees6.add(n63);
        TreeNode root6 = c.canMerge(trees6);
        if (root6 != null) {
            System.out.println(Arrays.toString(inorder.inorderTraversal(root6).toArray()));
        } else {
            System.out.println(root6);
        }

        List<TreeNode> trees7 = new ArrayList<>();
        TreeNode n71 = new TreeNode(1, null, new TreeNode(4));
        TreeNode n72 = new TreeNode(5, new TreeNode(2), null);
        TreeNode n73 = new TreeNode(4, null, new TreeNode(5));
        trees7.add(n71);
        trees7.add(n72);
        trees7.add(n73);
        TreeNode root7 = c.canMerge(trees7);
        if (root7 != null) {
            System.out.println(Arrays.toString(inorder.inorderTraversal(root7).toArray()));
        } else {
            System.out.println(root7);
        }
    }

    public TreeNode canMerge(List<TreeNode> trees) {
        int n = trees.size();
        if (n == 1) {
            return trees.get(0);
        }
        Set<Integer> childs = new HashSet<>();
        Map<Integer, TreeNode> map = new HashMap<>();

        for (TreeNode node : trees) {
            map.put(node.val, node);
            if (node.left != null) {
                childs.add(node.left.val);
            }
            if (node.right != null) {
                childs.add(node.right.val);
            }
        }

        TreeNode root = null;
        for (TreeNode node : trees) {
            if (!childs.contains(node.val)) {
                root = node;
                break;
            }
        }
        int[] res = new int[1];
        res[0] = 1;

        if (root != null) {
            getChild(root, map, res, Integer.MIN_VALUE, Integer.MAX_VALUE);
        }
        if (res[0] < 0 || res[0] != n) {
            return null;
        }
        return root;
    }


    void getChild(TreeNode root, Map<Integer, TreeNode> map, int[] res, int min, int max) {
        if (res[0] < 0) {
            return;
        }
        if (root.left != null) {
            TreeNode l = map.get(root.left.val);
            if (l != null) {
                root.left = l;
                res[0]++;
                if (l.left != null && (l.left.val <= min || l.left.val >= max)) {
                    if (res[0] > 0) {
                        res[0] = -1;
                    }
                    return;
                }
                int top = Math.min(max, root.val);
                if (l.right != null && (l.right.val <= min || l.right.val >= top)) {
                    if (res[0] > 0) {
                        res[0] = -1;
                    }
                    return;
                }
                getChild(root.left, map, res, min, top);
            }
        }

        if (root.right != null) {
            TreeNode r = map.get(root.right.val);
            if (r != null) {
                root.right = r;
                res[0]++;
                int low = Math.max(root.val, min);
                if (r.left != null && (r.left.val <= low || r.left.val >= max)) {
                    if (res[0] > 0) {
                        res[0] = -1;
                    }
                    return;
                }
                if (r.right != null && (r.right.val <= min || r.right.val >= max)) {
                    if (res[0] > 0) {
                        res[0] = -1;
                    }
                    return;
                }
                getChild(root.right, map, res, low, max);
            }
        }
    }
}
