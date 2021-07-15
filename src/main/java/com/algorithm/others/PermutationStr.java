package com.algorithm.others;

public class PermutationStr {

    public static void main(String[] args) {
        PermutationStr permute = new PermutationStr();
        permute.permute("ABC", 0, "ABC".length());
    }

    public void permute(String str, int s, int l) {
        System.out.println(" s = " + s + " l = " + l);
        if (s == l - 1) {
            System.out.println(str);
            return;
        }

        for (int j = s; j < l; j++) {
            str = swap(str, s, j);
            System.out.println("after swap: " + str + "  s[" + s + "] j[" + j + "]");
            permute(str, s + 1, l);
            str = swap(str, j, s);
        }
    }

    public String swap(String str, int i, int j) {

        char[] chars = str.toCharArray();
        char tmp = chars[i];
        chars[i] = chars[j];
        chars[j] = tmp;
        return String.valueOf(chars);
    }
}
