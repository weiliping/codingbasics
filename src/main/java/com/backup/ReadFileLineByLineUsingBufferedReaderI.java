package com.backup;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReadFileLineByLineUsingBufferedReaderI {
    public static void main(String[] args) {
        Map<String, String> keys = new HashMap<>();
        Map<Integer, String> resMap = new TreeMap<>();
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(
                    "/Users/paul/Documents/paul_work/memo/.interview/codingbasics/src/main/java/com/backup/tddd.log"));
            String line = reader.readLine();
            while (line != null) {
                // read next line
                String[] strs = line.split(";");
                for (String s :strs) {
                    String[] sts = s.substring(1, s.length() - 1).split(", ");
                    keys.put(sts[0], sts[1]);
                }
                line = reader.readLine();
            }
            reader.close();

            reader = new BufferedReader(new FileReader(
                    "/Users/paul/Documents/paul_work/memo/.interview/codingbasics/src/main/java/com/backup/des.txt"));
            line = reader.readLine();
            Pattern p = Pattern.compile("\\d+");
            while (line != null) {
                // read next line

                Matcher m = p.matcher(line);
                if (m.find()) {
                    String sn = m.group(0);
                    if (keys.containsKey(sn)) {
                        String res = line.replace("...", keys.get(sn));
                        resMap.put(Integer.valueOf(sn), res);
                    }
                }
                line = reader.readLine();
            }
            reader.close();
            Iterator<Integer> it = resMap.keySet().iterator();
            while (it.hasNext()) {
                Integer k = it.next();
                System.out.println(resMap.get(k));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
