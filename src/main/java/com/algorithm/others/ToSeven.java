package com.algorithm.others;

public class ToSeven {

    String transform(long n, int destDecimal) {
        int powTime = 0;
        long result = 1;
        long num = abs(n);
        while (destDecimal * result <= num) {
            result = result * destDecimal;
            powTime++;
        }

        String abc = "";
        long s = 0, r = 0;
        while (powTime > -1) {
            s = num / result;
            r = num % result;
            abc = abc + s;
            result = result / destDecimal;
            num = r;
            powTime--;
        }
        return n > 0 ? abc : "-" + abc;
    }

    public static void main(String[] args) {
        ToSeven s = new ToSeven();
        System.out.println(s.transform(-128, 8));
    }

    long abs(long l) {
        return l < 0 ? -l : l;
    }
}
