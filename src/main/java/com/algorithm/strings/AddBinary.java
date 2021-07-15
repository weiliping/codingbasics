package com.algorithm.strings;

public class AddBinary {
    /**
     * #67
     * https://leetcode-cn.com/problems/add-binary
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(new AddBinary().addBinary("1010", "1011"));
    }

    public String addBinary(String a, String b) {
        if (a == null || a.length() == 0) {
            return b;
        }
        if (b == null || b.length() == 0) {
            return a;
        }

        int pa = a.length() - 1;
        int pb = b.length() - 1;

        int flag = 0;

        StringBuilder sb = new StringBuilder();
        while (pa >= 0 || pb >= 0) {
            int va = 0, vb = 0;
            if (pa >= 0) {
                va = a.charAt(pa) - '0';
                pa--;
            }

            if (pb >= 0) {
                vb = b.charAt(pb) - '0';
                pb--;
            }

            int sum = va + vb + flag;

            if (sum >= 2) {
                sb.append(sum - 2);
                flag = 1;
            } else {
                sb.append(sum);
                flag = 0;
            }
        }
        if (flag == 1) {
            sb.append(1);
        }
        return sb.reverse().toString();
    }
}
