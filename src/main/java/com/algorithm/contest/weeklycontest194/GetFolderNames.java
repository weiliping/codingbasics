package com.algorithm.contest.weeklycontest194;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class GetFolderNames {
    public static void main(String[] args) {
        GetFolderNames g = new GetFolderNames();
        String[] res = g.getFolderNames(new String[] {"pes","fifa","gta","pes(2019)"});
        System.out.println(Arrays.toString(res));

        String[] res2 = g.getFolderNames(new String[] {"gta","gta(1)","gta","avalon"});
        System.out.println(Arrays.toString(res2));

        String[] res3 = g.getFolderNames(new String[] {"onepiece","onepiece(1)","onepiece(2)","onepiece(3)","onepiece"});
        System.out.println(Arrays.toString(res3));

        String[] res4 = g.getFolderNames(new String[] {"wano","wano","wano","wano"});
        System.out.println(Arrays.toString(res4));

        String[] res5 = g.getFolderNames(new String[] {"wano","wano","wano(1)","wano(1)", "wano", "wano(1)", "wano(2)"});
        System.out.println(Arrays.toString(res5));
    }

    public String[] getFolderNames(String[] names) {
        Map<String, Integer> map = new HashMap<>();
        HashSet<String> formatNames = new HashSet<>();
        int n = names.length;
        for (int i = 0; i < n; i++) {
            Integer frequence = map.get(names[i]);
            String pre = names[i];
            if (frequence == null) {
                frequence = 0;
            } else {
                names[i] = pre + "(" + frequence + ")";
            }

            while (!formatNames.add(names[i])) {
                frequence++;
                names[i] = pre + "(" + frequence + ")";
            }
            map.put(pre, frequence + 1);
        }
        return names;
    }
}
