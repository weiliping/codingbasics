package com.algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Test_Join_Path {
    public static void main(String[] args) {
        // It should output multiple paths when called with multiple -Path targets
        check("java Join_Path -Path C:,D: -ChildPath Windows -Resolve",
                "C:\\Windows\nD:\\Windows\n");
        // It should be able to join-path special string 'Variable:' with 'foo'
        check("java Join_Path -Path Variable: -ChildPath foo",
                "Variable:\\foo\n");
        // It should be able to join-path special string 'Alias:' with 'foo'
        check("java Join_Path -Path Alias: -ChildPath foo",
                "Alias:\\foo\n");
    }

    public static void check(String cmd, String expectedOutput) {
        try {
            ProcessBuilder processBuilder = new ProcessBuilder();
            processBuilder.command(cmd.split(" "));
            Process process = processBuilder.start();

            StringBuilder outputLines = new StringBuilder();
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()))) {
                String line;
                while ((line = reader.readLine()) != null)
                    outputLines.append(line + "\n");
            }

            String output = outputLines.toString();
            if (output.equals(expectedOutput))
                System.out.println("Pass");
            else
                System.out.println("Failure.\nExpected:\n" + expectedOutput + "Actual:\n" + output);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
