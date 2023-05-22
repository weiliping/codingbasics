package com.algorithm.subsets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.algorithm.treedatastructure.PreorderTraversal;
import com.algorithm.treedatastructure.TreeNode;

public class ConstructTrees {

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        List<TreeNode> trees= constructTrees(1, 3);
        for(TreeNode n : trees) {
            System.out.println(Arrays.toString(new PreorderTraversal().preorderTraversal(n).toArray()));
        }
    }

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
