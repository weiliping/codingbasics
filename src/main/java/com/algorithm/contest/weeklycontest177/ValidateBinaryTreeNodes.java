package com.algorithm.contest.weeklycontest177;

import java.util.ArrayList;
import java.util.List;

public class ValidateBinaryTreeNodes {

    public static void main(String[] args) {
        ValidateBinaryTreeNodes v = new ValidateBinaryTreeNodes();
//        int n1 = 4, leftChild1[] = new int[] {1,-1,3,-1}, rightChild1[] = new int[] {2,-1,-1,-1};
//        System.out.println(v.validateBinaryTreeNodes(n1, leftChild1, rightChild1));
//        int n2 = 4, leftChild2[] = new int[] {1,-1,3,-1}, rightChild2[] = new int[] {2,3,-1,-1};
//        System.out.println(v.validateBinaryTreeNodes(n2, leftChild2, rightChild2));

        int n3 = 2, leftChild3[] = new int[] {1,0}, rightChild3[] = new int[] {-1,-1};
        System.out.println(v.validateBinaryTreeNodes(n3, leftChild3, rightChild3));

        int n4 = 6, leftChild4[] = new int[] {1,-1,-1,4,-1,-1}, rightChild4[] = new int[] {2,-1,-1,5,-1,-1};
        System.out.println(v.validateBinaryTreeNodes(n4, leftChild4, rightChild4));
    }

    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        int[] inDegrees = new int[n];
        List<Integer>[] edges = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            edges[i] = new ArrayList<>();
        }
        for (int i = 0; i < n; i++) {
            if (leftChild[i] != -1) {
                if (inDegrees[leftChild[i]] > 0){
                    return false;
                }
                inDegrees[leftChild[i]]++;
                edges[i].add(leftChild[i]);
            }
            if (rightChild[i] != -1) {
                if (inDegrees[rightChild[i]] > 0) {
                    return false;
                }
                inDegrees[rightChild[i]]++;
                edges[i].add(rightChild[i]);
            }
        }
        int start = -1;
        for (int i = 0; i < n; i++) {
            if (inDegrees[i] == 0) {
                if (start == -1) {
                    start = i;
                    continue;
                }
                return false;
            }
        }

        if (start == -1) {
            return false;
        }

        boolean[] visited = new boolean[n];
        boolean isValid = isValid(edges, start, visited);
        if (!isValid) {
            return false;
        }

        for (boolean v : visited) {
            if (!v) {
                return false;
            }
        }
        return true;
    }

    boolean isValid(List<Integer>[] nodes, int i, boolean[] visited) {
        if (visited[i]) {
            return false;
        }
        visited[i] = true;
        List<Integer> childs = nodes[i];
        if (childs.size() > 2) {
            return false;
        }
        for (Integer ch : childs) {
            if (!isValid(nodes, ch, visited)) {
                return false;
            }
        }
        return true;
    }
}
