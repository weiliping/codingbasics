package com.algorithm.contest.weeklycontest184;

import java.util.HashMap;
import java.util.Map;

public class EntityParser {
    public static void main(String[] args) {
        EntityParser e = new EntityParser();
        String str ="x &gt; y &amp;&amp; x &lt; y is always false";
        System.out.println(e.entityParser(str));
        str ="&amp; is an HTML entity but &ambassador; is not.";
        System.out.println(e.entityParser(str));
        str ="leetcode.com&frasl;problemset&frasl;all";
        System.out.println(e.entityParser(str));
        str ="Stay home! Practice on Leetcode :)";
        System.out.println(e.entityParser(str));
        str ="and I quote: &quot;...&quot;";
        System.out.println(e.entityParser(str));
    }

    static Map<String, String> mp = new HashMap<>();
    static {
        mp.put("&quot;", "\"");
        mp.put("&apos;", "'");
        mp.put("&amp;", "&");
        mp.put("&gt;", ">");
        mp.put("&lt;", "<");
        mp.put("&frasl;", "/");
    }
    public String entityParser(String text) {
        StringBuilder sb = new StringBuilder();
        int n = text.length();
        char[] chrs = text.toCharArray();
        int s = -1, pre = 0;
        for (int i = 0; i < n; i++) {
            if (chrs[i] == '&') {
                s = i;
                continue;
            }
            if (chrs[i] == ';') {
                if (s != -1) {
                    String key = text.substring(s,  i + 1);
                    if (mp.get(key) != null) {
                        if (pre < s) {
                            sb.append(text.substring(pre, s));
                        }
                        sb.append(mp.get(key));
                        pre = i + 1;
                    }
                }
                s = -1;
            }
        }
        sb.append(text.substring(pre));
        return sb.toString();
    }
}
