package com.algorithm.contest.weeklycontest190;

import java.util.Arrays;
import java.util.List;

import com.algorithm.treedatastructure.TreeNode;

public class PseudoPalindromicPaths {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(9);
        root.right = new TreeNode(1);
        root.left.right = new TreeNode(1);
        root.right.right = new TreeNode(1);
        root.right.right.left = new TreeNode(7);
        root.right.right.left.right = new TreeNode(4);

        PseudoPalindromicPaths p = new PseudoPalindromicPaths();
        System.out.println(p.pseudoPalindromicPaths(root));

    }
    public int pseudoPalindromicPaths (TreeNode root) {
        int[] res = new int[1];
        dfs(root, res, new int[10]);
        return res[0];
    }

    void dfs(TreeNode root, int[] res, int[] nums) {
        nums[root.val]++;
        if (root.left == null && root.right == null) {
            int cnt = 0;
            for (int i = 1; i < 10; i++) {
                if ((nums[i] & 1) == 1) {
                    cnt++;
                    if (cnt > 1) {
                        break;
                    }
                }
            }
            if (cnt <= 1) {
                res[0]++;
            }
            return;
        }

        if (root.left != null) {
            dfs(root.left, res, Arrays.copyOf(nums, nums.length));
        }

        if (root.right != null) {
            dfs(root.right, res, Arrays.copyOf(nums, nums.length));
        }
    }

    boolean isPseudo(List<Integer> nums) {
        int n = nums.size();
        if (n == 1) {
            return true;
        }
        int[] cnts = new int[11];

        for (int num : nums) {
            cnts[num]++;
        }
        boolean hasOdd = false;
        for (int i = 1; i < 10; i++) {
            if ((cnts[i] & 1) == 1) {
                if (!hasOdd) {
                    hasOdd = true;
                } else {
                    return false;
                }
            }
        }

        int i = 0, j = n - 1;
        while (i <= j) {
            if (nums.get(i) != nums.get(j)) {
                return true;
            }
            i++;
            j--;
        }
        return false;
    }

    public int pseudoPalindromicPathsI(TreeNode root){
        int[] res = new int[1];
        preorder(root, 0, res);
        return res[0];
    }
    public void preorder(TreeNode root, int num, int[] res){
        if (root != null) {
            int tmp = num ^ (1 << root.val);
            if(root.left == null && root.right == null){
                if(tmp==0 || (tmp&(tmp-1))==0){
                    res[0]++;
                }
            } else {
                if(root.left != null){
                    preorder(root.left, tmp, res);
                }
                if(root.right != null){
                    preorder(root.right, tmp, res);
                }
            }
        }
    }

    public int pseudoPalindromicPathsII(TreeNode root) {
        int[] arr = new int[10], res = new int[1];
        preOrder(root, arr, res);
        return res[0];
    }
    public void preOrder(TreeNode root, int[] arr, int[] res){
        if(root != null){
            arr[root.val]++;
            // 叶子节点 ，统计数组中奇数个元素的个数
            if(root.left == null && root.right == null){
                int cnt = 0;
                for(int a : arr){
                    if(a%2!=0){
                        cnt++;
                    }
                }
                // 奇数个元素的小于2，才能组成回文序列
                if(cnt<=1){
                    res[0]++;
                }
                return;
            } else {
                // 左节点不为空，将数组拷贝出一个新的，继续前序遍历
                if(root.left != null){
                    preOrder(root.left, Arrays.copyOfRange(arr, 0, arr.length), res);
                }
                if(root.right != null){
                    preOrder(root.right,Arrays.copyOfRange(arr, 0, arr.length), res);
                }
            }
        }
    }
}
