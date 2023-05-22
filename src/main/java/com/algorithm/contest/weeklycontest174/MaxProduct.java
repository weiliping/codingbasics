package com.algorithm.contest.weeklycontest174;

import static com.algorithm.contest.weeklycontest178.IsSubPath.buildTree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

import com.algorithm.treedatastructure.TreeNode;

public class MaxProduct {

    static final int MOD = (int)1e9 + 7;

    public static void main(String[] args) {
        MaxProduct m = new MaxProduct();
        TreeNode root = buildTree(new Integer[]{1,null,2,3,4,null,null,5,6});
        System.out.println(m.maxProduct(root));

        TreeNode root1 = buildTree(new Integer[]{1,2,3,4,5,6,null});
        System.out.println(m.maxProduct(root1));

        TreeNode root2 = buildTree(new Integer[]{2,3,9,10,7,8,6,5,4,11,1, null, null, null, null});
        System.out.println(m.maxProduct(root2));

        TreeNode root3 = buildTree(new Integer[]{1, 1, null});
        System.out.println(m.maxProduct(root3));
    }

    public int maxProduct(TreeNode root) {
        List<int[]> sums = new ArrayList<>();

        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        ArrayDeque<Integer> indQueue = new ArrayDeque<>();
        queue.offer(root);
        sums.add(new int[]{root.val, -1});
        int currInd = 0;
        indQueue.offer(currInd);
        while (!queue.isEmpty()) {
            TreeNode r = queue.poll();
            Integer pInd = indQueue.poll();
            if (r.left != null) {
                currInd++;
                sums.add(new int[]{r.left.val, pInd});
                queue.offer(r.left);
                indQueue.offer(currInd);
            }
            if (r.right != null) {
                currInd++;
                sums.add(new int[]{r.right.val, pInd});
                queue.offer(r.right);
                indQueue.offer(currInd);
            }
        }
        int n = sums.size();
        for (int i = n - 1;  i >= 0; i--) {
            int[] sVal = sums.get(i);
            if (sVal[1] == -1) {
                continue;
            }
            int[] pVal = sums.get(sVal[1]);
            pVal[0] += sVal[0];
            sums.set(sVal[1], pVal);
        }

        int sum = sums.get(0)[0], half = (sum >> 1);

        int closestVal = sum, isGreat = 1;
        for (int i = 0; i < n; i++) {
            int min = Math.abs(sums.get(i)[0] - half);
            if (closestVal > min) {
                if (sums.get(i)[0] > half) {
                    isGreat = 1;
                } else {
                    isGreat = -1;
                }
                closestVal = min;
            }
        }
        long lPart = (long) (half + closestVal * isGreat);
        long rPart = sum - lPart;
        long res = lPart * rPart;
        return (int)(res % MOD);
    }
}
