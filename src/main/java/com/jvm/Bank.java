package com.jvm;

public class Bank {
    private int code = 210;

    class SBI {
        void display() {
            System.out.println("Code is " + code);
        }
    }

    public static void main(String args[]) {
        Bank b = new Bank();
        Bank.SBI sbi = b.new SBI();
        sbi.display();
    }
}
