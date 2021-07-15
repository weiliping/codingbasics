package com.algorithm.contest.weeklycontest208;

import java.util.*;

public class ThroneInheritance {

    public static void main(String[] args) {
        ThroneInheritance t= new ThroneInheritance("king");
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

    Map<String, List<String>> children;
    String king;
    Set<String> deaths;

    public ThroneInheritance(String kingName) {
        king = kingName;
        deaths = new HashSet<String>();
        children = new HashMap<String, List<String>>();
    }

    public void birth(String parentName, String childName) {
        List<String> chs = children.getOrDefault(parentName, new ArrayList<>());
        chs.add(childName);
        children.put(parentName, chs);
    }

    public void death(String name) {
        deaths.add(name);
    }

    public List<String> getInheritanceOrder() {
        List<String> res = new ArrayList<>();
        dfs(king, res);
        return res;
    }

    void dfs(String name, List<String> res) {
        if (!deaths.contains(name)) {
            res.add(name);
        }

        List<String> chs = children.getOrDefault(name, new ArrayList<String>());
        for (String c : chs) {
            dfs(c, res);
        }
    }
}
