package com.algorithm.stacksandqueues;

import java.util.ArrayList;
import java.util.Stack;

public class SimplifyDirectoryPath {
    /**
     * #71
     * https://leetcode-cn.com/problems/simplify-path/
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(simplifyPath("/home/"));
    }

    public static String simplifyPath(String path) {
        if (path == null || path.trim() == "") {
            return path;
        }

        Stack<String> s = new Stack<>();
        String[] paths = path.split("/");

        for (String p : paths) {
            if (!s.isEmpty() && "..".equals(p)) {
                s.pop();
            } else if (!".".equals(p) && !"".equals(p) && !"..".equals(p)) {
                s.push(p);
            }
        }
        ArrayList<String> p = new ArrayList<>(s);
        return new StringBuilder().append("/").append(String.join("/", p)).toString();
    }
}
