package com.datastructure;

class BinaryTree {
    int data;
    BinaryTree left;
    BinaryTree right;

    public BinaryTree(int val) {
        data = val;
    }
}

public class BinaryTreeSearch {

    private BinaryTree tree;

    public BinaryTree search(int val) {
        BinaryTree p = tree;

        while (p != null) {
            if (p.data == val) {
                return p;
            }
            if (p.data > val) {
                p = p.left;
            } else {
                p = p.right;
            }
        }
        return null;
    }

    public void insert(int val) {
        if (tree == null) {
            tree = new BinaryTree(val);
            return;
        }

        BinaryTree p = tree;

        while (p != null) {
            if (p.data > val) {
                if (p.left == null) {
                    p.left = new BinaryTree(val);
                    return;
                }
                p = p.left;
            } else {
                if (p.right == null) {
                    p.right = new BinaryTree(val);
                    return;
                }
                p = p.right;
            }
        }
    }

    public void delete(int val) {
        BinaryTree p = tree;
        BinaryTree pp = null;

        while (p != null && p.data != val) {
            pp = p;
            if (p.data > val) {
                p = p.left;
            } else {
                p = p.right;
            }
        }

        if (p == null) {
            return;
        }

        if (p.left != null && p.right != null) {
            BinaryTree minP = p.right;
            BinaryTree minPP = p;

            while (minP.left != null) {
                minPP = minP;
                minP = minP.left;
            }
            p.data = minP.data;
            p = minP;
            pp = minPP;
        }

        BinaryTree child;

        if (p.left != null) {
            child = p.left;
        } else if (p.right != null) {
            child = p.right;
        } else {
            child = null;
        }

        if (pp == null) {
            tree = child;
        } else if (pp.left == p) {
            pp.left = child;
        } else {
            pp.right = child;
        }
    }
}
