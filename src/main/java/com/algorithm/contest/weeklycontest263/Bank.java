package com.algorithm.contest.weeklycontest263;

public class Bank {
    public static void main(String[] args) {
        Bank b = new Bank(new long[] {10, 100, 20, 50, 30});
        System.out.println(b.withdraw(3, 10));
        System.out.println(b.transfer(5, 1, 20));
    }

    private long[] accountBalance;
    private int size;
    public Bank(long[] balance) {
        accountBalance = balance;
        size = balance.length;
    }

    public boolean transfer(int account1, int account2, long money) {
        if (account1 >= size || account2 >= size) {
            return false;
        }

        if (accountBalance[account1] < money) {
            return false;
        }
        accountBalance[account1] -= money;
        accountBalance[account2] += money;
        return true;
    }

    public boolean deposit(int account, long money) {
        if (account >= size) {
            return false;
        }
        accountBalance[account] += money;
        return true;
    }

    public boolean withdraw(int account, long money) {
        if (account >= size || accountBalance[account] < money) {
            return false;
        }
        accountBalance[account] -= money;
        return true;
    }
}
