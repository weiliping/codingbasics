package com.algorithm.contest.weeklycontest267;

public class DecodeCiphertext {
    public static void main(String[] args) {
//        System.out.println(decodeCiphertext("ch   ie   pr", 3));
//        System.out.println(decodeCiphertext("iveo    eed   l te   olc", 4));
//        System.out.println(decodeCiphertext("coding", 1));
//        System.out.println("[" + decodeCiphertext(" b  ac", 2) + "]");
//        System.out.println("[" + decodeCiphertext("a", 5) + "]");
        System.out.println("[" + decodeCiphertext("", 5) + "]");
    }

    public static String decodeCiphertext(String encodedText, int rows) {
        int len = encodedText.length();

        if (len == 0 || rows == 1) {
            return encodedText;
        }
        int cols = len / rows, startI = 0, startJ = 0;
        StringBuilder sb = new StringBuilder();
        while (startI < rows && startJ < cols) {
            int i = startI, j = startJ;
            while (i < rows && j < cols) {
                sb.append(encodedText.charAt(i * cols + j));
                i++;
                j++;
            }
            startJ++;
        }
        int last = sb.length() - 1;
        while(last >= 0 && sb.charAt(last) == ' ') {
            last--;
        }
        sb.delete(last + 1, sb.length());
        return sb.toString();
    }
}
