package com.algorithm.graphdata;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class SequenceReconstruction {

    public static void main(String[] args) {
        int[] originalSeq = new int[] {1, 2, 3, 4};
        int[][] seqs = new int[][] {{1, 2}, {2, 3}, {3, 4}};
        System.out.println(canStruction(originalSeq, seqs));

        int[] originalSeq1 = new int[] {1, 2, 3, 4};
        int[][] seqs1 = new int[][] {{1, 2}, {2, 3}, {2, 4}};
        System.out.println(canStruction(originalSeq1, seqs1));

        int[] originalSeq2 = new int[] {3, 1, 4, 2, 5};
        int[][] seqs2 = new int[][] {{3, 1, 5}, {1, 4, 2, 5}};
        System.out.println(canStruction(originalSeq2, seqs2));
    }

    public static boolean canStruction(int[] originalSeq, int[][] seqs) {
        Map<Integer, HashSet> graph = new HashMap<>();
        Map<Integer, Integer> inDegree = new HashMap<>();

        for (int[] seq : seqs) {
            for (int i = 1; i < seq.length; i++) {
                HashSet<Integer> g = graph.getOrDefault(seq[i - 1], new HashSet<Integer>());
                g.add(seq[i]);
                graph.put(seq[i - 1], g);
                int degree = inDegree.getOrDefault(seq[i], 0);
                inDegree.put(seq[i], degree + 1);
                if (!inDegree.containsKey(seq[i - 1])) {
                    inDegree.put(seq[i - 1], 0);
                }
            }
        }

        if (inDegree.size() != originalSeq.length) {
            return false;
        }

        LinkedList<Integer> queue = new LinkedList<>();
        for (Map.Entry<Integer, Integer> m : inDegree.entrySet()) {
            if (m.getValue() == 0) {
                queue.offer(m.getKey());
            }
        }

        List<Integer> res = new ArrayList<>();
        while (!queue.isEmpty()) {
            if (queue.size() > 1) {
                return false;
            }

            if (originalSeq[res.size()] != queue.get(0)) {
                return false;
            }
            int i = queue.poll();
            res.add(i);
            HashSet<Integer> childs = graph.get(i);
            if (childs != null) {
                for (Integer c : childs) {
                    int degree = inDegree.get(c);
                    inDegree.put(c, degree - 1);
                    if (degree == 1) {
                        queue.offer(c);
                    }
                }
            }
        }
        return res.size() == originalSeq.length;
    }
}
