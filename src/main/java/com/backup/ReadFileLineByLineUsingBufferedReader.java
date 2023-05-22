package com.backup;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReadFileLineByLineUsingBufferedReader {
    public static void main(String[] args) {
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(
                    "/Users/paul/Documents/paul_work/memo/.interview/codingbasics/src/main/java/com/daaa.txt"));
            String line = reader.readLine();
            Pattern p = Pattern.compile("\\d+");
            while (line != null) {
                Matcher m = p.matcher(line);
                boolean find = false;
                while (m.find()) {
                    String sn = m.group(0);
                    System.out.print(" | ");
                    System.out.print(sn);
                    System.out.print(" | ");
                    String str = line.substring(2);
                    String col = str.replace(" - " + sn, "");
                    System.out.print(str.replace(" - " + sn, ""));
                    System.out.print("|[java" + col.substring(col.lastIndexOf(']')));
                    System.out.println(" |...|");
                    find = true;
                }
                if (!find){
                    System.out.println(line);
                }
                // read next line
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
