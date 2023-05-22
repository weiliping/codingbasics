package com.algorithm.contest.weeklycontest159;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RemoveSubfolders {

    public static void main(String[] args) {
        String[] folders = new String[] { "/a", "/a/b", "/c/d", "/c/d/e", "/c/f" };
        RemoveSubfolders f = new RemoveSubfolders();
        List<String> res = f.removeSubfolders(folders);
        System.out.println(Arrays.toString(new RemoveSubfolders().removeSubfoldersI(folders).toArray()));
        System.out.println(Arrays.toString(res.toArray()));

        String[] folders1 = new String[] { "/a", "/a/b/c", "/a/b/d" };
        List<String> res1 = f.removeSubfolders(folders1);
        System.out.println(Arrays.toString(res1.toArray()));
        System.out.println(Arrays.toString(new RemoveSubfolders().removeSubfoldersI(folders1).toArray()));

        String[] folders2 = new String[] { "/a/b/c", "/a/b/d", "/a/b/ca" };
        System.out.println(Arrays.toString(new RemoveSubfolders().removeSubfoldersI(folders2).toArray()));
        List<String> res2 = f.removeSubfolders(folders2);
        System.out.println(Arrays.toString(res2.toArray()));
    }

    public List<String> removeSubfolders(String[] folder) {
        Folder root = new Folder();
        for (String name : folder) {
            build(root, name);
        }

        List<String> res = new ArrayList<>();
        dfs(root, res);
        return res;
    }

    void dfs(Folder root, List<String> res) {
        if (root == null) {
            return;
        }
        if (root.isEnding) {
            res.add(root.path);
            root.children = null;
            return;
        }
        if (!root.children.isEmpty()) {
            for (Map.Entry<String, Folder> i : root.children.entrySet()) {
                dfs(i.getValue(), res);
            }
        }
    }

    public void build(Folder root, String name) {
        String[] ns = name.split("/");
        Folder f = root;
        for (String n : ns) {
            Folder c = f.children.get(n);
            if (c == null) {
                c = new Folder();
            }
            f.children.put(n, c);
            f = c;
        }
        f.path = name;
        f.isEnding = true;
    }

    class Folder {
        boolean isEnding = false;
        Map<String, Folder> children = new HashMap<>();
        String path;

        public Folder() {
        }
    }

    TrieNode root = new TrieNode();

    public List<String> removeSubfoldersI(String[] folder) {
        List<String> res = new ArrayList<>();
        Arrays.sort(folder, (o1, o2) -> {
            return o1.length() - o2.length();
        });
        for (String f : folder) {
            if (insert(f)) {
                res.add(f);
            }
        }
        return res;
    }

    public boolean insert(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            if (c == '/' && node.isEnd) {
                return false;
            }
            int ch = c == '/' ? 26 : c - 'a';
            if (node.children[ch] == null) {
                node.children[ch] = new TrieNode();
            }
            node = node.children[ch];
        }
        node.isEnd = true;
        return true;
    }
}

class TrieNode {
    boolean isEnd;
    TrieNode[] children;

    public TrieNode() {
        children = new TrieNode[27];
    }
}
