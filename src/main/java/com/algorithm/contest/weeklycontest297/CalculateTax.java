package com.algorithm.contest.weeklycontest297;

public class CalculateTax {
    public static void main(String[] args) {
        int[][] brackets = new int[][] { { 3, 50 }, { 7, 10 }, { 12, 25 } };
        int income = 10;
        System.out.println(calculateTax(brackets, income));
    }

    public static double calculateTax(int[][] brackets, int income) {
        double tax = 0.00;
        int prevAmount = 0;
        for (int[] bracket : brackets) {
            if (bracket[0] <= income) {
                tax += (bracket[0] - prevAmount) * (bracket[1] / 100.00);
                prevAmount = bracket[0];
            } else {
                tax += (income - prevAmount) * (bracket[1] / 100.00);
                break;
            }
        }
        return tax;
    }
}
