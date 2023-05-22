package com.algorithm.contest.weeklycontest208;

import java.util.*;

public class ThroneInheritanceI {
    public static void main(String[] args) {
        ThroneInheritanceI t= new ThroneInheritanceI("king");
        System.out.println(Arrays.toString(t.getInheritanceOrder().toArray()));
        t.birth("king", "andy"); // 继承顺序：king > andy
        System.out.println(Arrays.toString(t.getInheritanceOrder().toArray()));
        t.birth("king", "bob"); // 继承顺序：king > andy > bob
        System.out.println(Arrays.toString(t.getInheritanceOrder().toArray()));
        t.birth("king", "catherine"); // 继承顺序：king > andy > bob > catherine
        System.out.println(Arrays.toString(t.getInheritanceOrder().toArray()));
        t.birth("andy", "matthew"); // 继承顺序：king > andy > matthew > bob > catherine
        System.out.println(Arrays.toString(t.getInheritanceOrder().toArray()));
        t.birth("bob", "alex"); // 继承顺序：king > andy > matthew > bob > alex > catherine
        System.out.println(Arrays.toString(t.getInheritanceOrder().toArray()));
        t.birth("bob", "asha"); // 继承顺序：king > andy > matthew > bob > alex > asha > catherine
        System.out.println(Arrays.toString(t.getInheritanceOrder().toArray())); // 返回 ["king", "andy", "matthew", "bob", "alex", "asha", "catherine"]
        t.death("bob"); // 继承顺序：king > andy > matthew > bob（已经去世）> alex > asha > catherine
        System.out.println(Arrays.toString(t.getInheritanceOrder().toArray())); // 返回 ["king", "andy", "matthew", "alex", "asha", "catherine"]
    }

    class Node {
        String name;
        Node next;
        Node last; // 记录最后一个儿子
        boolean isDeleted = false;

        Node(String _name) {
            name = _name;
        }
    }

    Map<String, Node> map = new HashMap<>();
    Node head = new Node(""), tail = new Node("");

    public ThroneInheritanceI(String name) {
        Node root = new Node(name);
        root.next = tail;
        head.next = root;
        map.put(name, root);
    }

    public void birth(String pname, String cname) {
        Node node = new Node(cname);
        map.put(cname, node);
        Node p = map.get(pname);
        Node tmp = p;
        while (tmp.last != null) tmp = tmp.last;
        node.next = tmp.next;
        tmp.next = node;
        p.last = node;
    }

    public void death(String name) {
        Node node = map.get(name);
        node.isDeleted = true;
    }

    public List<String> getInheritanceOrder() {
        List<String> ans = new ArrayList<>();
        Node tmp = head.next;
        while (tmp.next != null) {
            if (!tmp.isDeleted) ans.add(tmp.name);
            tmp = tmp.next;
        }
        return ans;
    }
}
