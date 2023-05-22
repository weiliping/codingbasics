package com.algorithm.treedatastructure;

import java.util.Arrays;

public class Codec {

    /**
     * #297
     * https://leetcode-cn.com/problems/serialize-and-deserialize-binary-tree/
     *
     * @param args
     */
    public static void main(String[] args) {
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(5);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(2);
        root.left.left.right = new TreeNode(1);
        root.right.right = new TreeNode(9);
        Codec c = new Codec();

        String s = c.serialize(root);
        System.out.println(s);

        TreeNode r = c.deserialize(s);

        System.out.println(Arrays.toString(PreorderTraversal.preorderTraversal(r).toArray()));
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serializeDfs(root, sb);
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] vals = data.split(" ");
        int[] ind = new int[] { 0 };

        return deserializeDfs(vals, ind);
    }

    TreeNode deserializeDfs(String[] vals, int[] ind) {
        if (ind[0] == vals.length) {
            return null;
        }

        String val = vals[ind[0]++];
        if ("#".equals(val)) {
            return null;
        }

        TreeNode root = new TreeNode(Integer.parseInt(val));

        root.left = deserializeDfs(vals, ind);
        root.right = deserializeDfs(vals, ind);
        return root;
    }

    private void serializeDfs(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("# ");
        } else {
            sb.append(root.val).append(" ");
            serializeDfs(root.left, sb);
            serializeDfs(root.right, sb);
        }
    }
}
