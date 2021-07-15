package com.backup;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadFileLineByLineUsingBufferedReaderII {
    public static void main(String[] args) {
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(
                    "/Users/paul/Documents/paul_work/memo/.interview/codingbasics/src/main/java/com/data_test.txt"));
            String line = reader.readLine();
            String append = "";
            while (line != null) {
                // read next line
                if (line.startsWith("#")) {
                    append = line.substring(2);
                } else {
                    if (!line.isEmpty()) {
                        System.out.println("|**" + append + "**" + line);
                    }
                }
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
