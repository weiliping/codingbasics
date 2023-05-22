package com.algorithm.contest.weeklycontest325;

public class ClosetTarget {
    public static void main(String[] args) {
        String[] words = new String[] { "hsdqinnoha", "mqhskgeqzr", "zemkwvqrww", "zemkwvqrww", "daljcrktje",
                "fghofclnwp", "djwdworyka", "cxfpybanhd", "fghofclnwp", "fghofclnwp" };
        String target = "zemkwvqrww";
        int startIndex = 8;
        System.out.println(closetTarget(words, target, startIndex));

        String[] words1 = new String[] { "pgmiltbptl", "jnkxwutznb", "bmeirwjars", "ugzyaufzzp", "pgmiltbptl",
                "sfhtxkmzwn", "pgmiltbptl", "pgmiltbptl", "onvmgvjhxa", "jyzdtwbwqp" };
        String target1 = "pgmiltbptl";
        int startIndex1 = 4;
        System.out.println(closetTarget(words1, target1, startIndex1));
    }

    public static int closetTarget(String[] words, String target, int startIndex) {
        int ind = -1, n = words.length;
        for (int j = 0; j < n; j++) {
            int t = (startIndex + j) % n;
            if (words[t].equals(target)) {
                ind = j;
                break;
            }
        }

        for (int j = 0; j > -n; j--) {
            int t = startIndex + j;
            if (t < 0) {
                t += n;
            }
            if (words[t].equals(target)) {
                if (ind > -j) {
                    ind = -j;
                    break;
                }
            }
        }
        return ind;
    }
}
