package com.algorithm.contest.weeklycontest151;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class InvalidTransactions {
    public static void main(String[] args) {
        InvalidTransactions i = new InvalidTransactions();
        String[] trans1 = new String[] { "alice,20,800,mtv", "alice,50,100,beijing" };
        System.out.println(Arrays.toString(i.invalidTransactions(trans1).toArray()));

        String[] trans2 = new String[] { "alice,20,800,mtv","alice,50,1200,mtv" };

        System.out.println(Arrays.toString(i.invalidTransactions(trans2).toArray()));

        String[] trans3 = new String[] { "alice,20,800,mtv","bob,50,1200,mtv" };
        System.out.println(Arrays.toString(i.invalidTransactions(trans3).toArray()));

        String[] trans4 = new String[] {"alice,20,800,mtv","alice,50,100,mtv","alice,51,100,frankfurt"};
        System.out.println(Arrays.toString(i.invalidTransactions(trans4).toArray()));

        String[] trans5 = new String[] {"alice,20,800,mtv","bob,50,1200,mtv","alice,20,800,mtv","alice,50,1200,mtv","alice,20,800,mtv","alice,50,100,beijing"};
        System.out.println(Arrays.toString(i.invalidTransactions(trans5).toArray()));

        String[] trans6 = new String[]{"bob,689,1910,barcelona","alex,696,122,bangkok","bob,832,1726,barcelona","bob,820,596,bangkok","chalicefy,217,669,barcelona","bob,175,221,amsterdam"};
        System.out.println(Arrays.toString(i.invalidTransactions(trans6).toArray()));
    }

    public List<String> invalidTransactions(String[] transactions) {
        Map<String, List<Trans>> mp = new HashMap<>();
        int n = transactions.length;
        Set<Integer> conflicts = new HashSet<>();
        for (int i = 0; i < n; i++) {
            String trans = transactions[i];
            String[] info = trans.split(",");
            if (Integer.parseInt(info[2]) > 1000) {
                conflicts.add(i);
            }
            List<Trans> sub = mp.getOrDefault(info[0], new ArrayList<>());
            sub.add(new Trans(Integer.parseInt(info[1]), i, info[3]));
            mp.put(info[0], sub);
        }
        List<String> res = new ArrayList<>();
        for (List<Trans> p : mp.values()) {
            if (p.size() == 1) {
                continue;
            }
            Collections.sort(p, (a, b) -> a.time == b.time ? a.city.compareTo(b.city) : a.time - b.time);
            int len = p.size();
            for (int i = 0; i < len; i++) {
                Trans cur = p.get(i);
                int next = cur.time + 60;
                for (int j = i + 1; j < len; j++) {
                    Trans nextTran = p.get(j);
                    if (cur.city.equals(nextTran.city)) {
                        continue;
                    }
                    if (next >= nextTran.time) {
                        conflicts.add(cur.ind);
                        conflicts.add(nextTran.ind);
                        continue;
                    }
                    break;
                }
            }
        }
        for (Integer i : conflicts) {
            res.add(transactions[i]);
        }
        return res;
    }

    class Trans {
        private Integer time;
        private int ind;
        private String city;

        public Trans(Integer time, int ind, String city) {
            this.time = time;
            this.ind = ind;
            this.city = city;
        }
    }
}
