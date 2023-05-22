package com.backup;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadFileLineByLineUsingBufferedReaderIV {
    public static void main(String[] args) {
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(
                    "/Users/paul/Documents/paul_work/memo/.interview/codingbasics/src/main/java/com/backup/des_t.txt"));
            String line = reader.readLine();

            while (line != null) {
                int ind = line.substring(1).indexOf('|');
                String str = line.substring(1, ind + 1);
                System.out.println(line.substring(ind + 1) + str + " |");
                // read next line
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
