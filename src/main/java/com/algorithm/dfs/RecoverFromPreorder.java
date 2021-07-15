package com.algorithm.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.algorithm.treedatastructure.TreeNode;

public class RecoverFromPreorder {

    public static void main(String[] args) {


    }
    public TreeNode recoverFromPreorder(String S) {
        return null;
    }

    TreeNode dfs(String s, String pre) {
        if (s == null || s == "") {
            return null;
        }
        String rootValue = s.substring(0, s.indexOf('-'));
        if (rootValue == null || rootValue == "") {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(rootValue));
        List<Integer> childIndex = findChildIndex(s, pre + "-");
        if (childIndex.size() > 0) {
            int leftEnd = 0;
            if (childIndex.size() > 1) {
                leftEnd = childIndex.get(1);
            }
            root.left = dfs(s.substring(0), pre + "-");
            root.right = dfs("", pre + "-");
        }
        return root;
    }

    List<Integer> findChildIndex(String s, String pre) {
        String pattern = "\\d+" + pre + "\\d+";
        Pattern r = Pattern.compile(pattern);
        Matcher matcher = r.matcher(s);
        List<Integer> indexes = new ArrayList<>();
        while (matcher.find()) {
            String[] strs = matcher.group().split(pre);
            int prevLength = strs[0].length() + pre.length();
            indexes.add(s.indexOf(matcher.group()) + prevLength);
        }
        return indexes;
    }
}
