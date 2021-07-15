package com.backup;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ReadFileLineByLineUsingBufferedReaderIII {
    public static void main(String[] args) {
        Map<String, String> keys = new HashMap<>();
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(
                    "/Users/paul/Documents/paul_work/memo/.interview/codingbasics/src/main/java/com/target.txt"));
            String line = reader.readLine();
            while (line != null) {
                // read next line
                String[] strs = line.split(":     \\* ");
                keys.put(strs[0], strs[1]);
                line = reader.readLine();
            }
            reader.close();

            reader = new BufferedReader(new FileReader(
                    "/Users/paul/Documents/paul_work/memo/.interview/codingbasics/src/main/java/com/des.txt"));
            String line2 = reader.readLine();
            while (line2 != null) {
                // read next line
                int endInd = line2.indexOf("|[Java]");
                int startInd = line2.indexOf("](");

                String key = line2.substring(startInd+2, endInd - 1);
                String target = keys.get(key);
                if (target != null && !target.isEmpty()) {
                    String t = line2.replaceFirst(key, target);
                    System.out.println(t);
                }
                line2 = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
