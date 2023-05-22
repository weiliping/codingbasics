package com.algorithm;

import java.nio.file.Paths;

public class Join_Path {
    /// <summary>
    /// The path parameter
    /// </summary>
    public static String Path;

    /// <summary>
    /// The childPath parameter
    /// </summary>
    public static String ChildPath = "";

    /// <summary>
    /// Determines if the path should be resolved after being joined
    /// </summary>
    /// <value></value>
    public static boolean Resolve;

    public static void main(String[] args) {
        for (int p = 0; p < args.length; p++) {
            if (args[p].equals("-Path") || args[p].equals("-ChildPath"))
                continue;
            else if (args[p].equals("-Resolve"))
                Resolve = true;
            else if (p > 0 && args[p - 1].equals("-Path"))
                Path = args[p];
            else if (p > 0 && args[p - 1].equals("-ChildPath"))
                ChildPath = args[p];
        }
        if (Path == null) {
            System.out.println("Parameter is missing.");
            return;
        }
        // Join_Path.ProcessRecord(Path.split(","), ChildPath, Resolve);

        // check("java Join_Path -Path C:,D: -ChildPath Windows -Resolve",
        // "C:\\Windows\nD:\\Windows\n");
        // It should be able to join-path special string 'Variable:' with 'foo'
        // check("java Join_Path -Path Variable: -ChildPath foo",
        // "Variable:\\foo\n");
        // It should be able to join-path special string 'Alias:' with 'foo'
        // check("java Join_Path -Path Alias: -ChildPath foo",
        // "Alias:\\foo\n");

        String path1 = "C:,D:";
        String ChildPath1 = "test1 test2";
        boolean Resolve = true;
        ProcessRecord(path1.split(","), ChildPath1.split(" "), Resolve);
        // ProcessRecord(path1.split(","), ChildPath1.split(" "), Resolve);
        // ProcessRecord("Variable:".split(","), "test1 test2".split(" "), false);
        // ProcessRecord("Alias:".split(","), "foo", false);
    }

    /// <summary>
    /// Parses the specified path and returns the portion determined by the
    /// boolean parameters.
    /// </summary>
    public static void ProcessRecord(String[] Path, String[] ChildPath, boolean Resolve) {
        for (String path : Path) {
            String joinedPath = path;
            for (String childPath : ChildPath) {
                joinedPath = String.join("\\", joinedPath, childPath);
            }
            if (Resolve) {
                try {
                    java.nio.file.Path resolvedPath = Paths.get(joinedPath);
                    System.out.println(resolvedPath);
                } catch (Exception e) {
                    System.out.println("invalid path" + joinedPath);
                    System.exit(0);
                }
            } else
                System.out.println(joinedPath);
        }
    }
}
