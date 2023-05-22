package com.algorithm.backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class CloneGraph {

    /**
     * #133
     * https://leetcode-cn.com/problems/clone-graph/
     * @param args
     */
    public static void main(String[] args) {

        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        ArrayList<Node> neighbor1 = new ArrayList<>();
        neighbor1.add(node2);
        neighbor1.add(node4);
        node1.neighbors = neighbor1;
        ArrayList<Node> neighbor2 = new ArrayList<>();
        neighbor1.add(node1);
        neighbor1.add(node3);
        node2.neighbors = neighbor2;

        ArrayList<Node> neighbor3 = new ArrayList<>();
        neighbor1.add(node3);
        neighbor1.add(node4);
        node3.neighbors = neighbor3;

        ArrayList<Node> neighbor4 = new ArrayList<>();
        neighbor1.add(node1);
        neighbor1.add(node3);
        node4.neighbors = neighbor4;

        Node cloneNode = cloneGraphBfs(node1);
        printNode(cloneNode, new HashMap<Node, Node>());
    }

    static void printNode(Node node, Map<Node, Node> res) {
        if (node == null) {
            return;
        }
        if (res.containsKey(node)) {
            System.out.println(node.val);
            return;
        }
        res.put(node, node);
        System.out.println(node.val);
        for (Node neighbor : node.neighbors) {
            res.put(neighbor, neighbor);
            printNode(neighbor, res);
        }
    }

    public static Node cloneGraphBfs(Node node) {
        if (node == null) {
            return null;
        }
        Map<Node, Node> nodeMap = new HashMap<>();
        Queue<Node> q = new LinkedList<>();
        Node clone = new Node(node.val);
        nodeMap.put(node, clone);
        q.offer(node);
        while (!q.isEmpty()) {
            Node t = q.poll();
            for (Node neighbor : t.neighbors) {
                if (!nodeMap.containsKey(neighbor)) {
                    nodeMap.put(neighbor, new Node(neighbor.val));
                    q.offer(neighbor);
                }
                nodeMap.get(t).neighbors.add(nodeMap.get(neighbor));
            }
        }
        return clone;
    }

    public Node cloneGraph(Node node) {
        Map<Node, Node> nodeMap = new HashMap<>();
        return helper(node, nodeMap);
    }

    static Node helper(Node node, Map<Node, Node> nodeMap) {
        if (node == null) {
            return node;
        }

        if (nodeMap.containsKey(node)) {
            return nodeMap.get(node);
        }

        Node clone = new Node(node.val);
        nodeMap.put(node, clone);
        for (Node neighbor : node.neighbors) {
            clone.neighbors.add(helper(neighbor, nodeMap));
        }
        return clone;
    }
}
