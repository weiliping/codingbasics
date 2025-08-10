package com.algorithm.math;

public class Clumsy {
    public static void main(String[] args) {
        Clumsy clumsy = new Clumsy();
        System.out.println(clumsy.clumsy(10)); // Example usage
        System.out.println(clumsy.clumsy(4));  // Output: 7
        System.out.println(clumsy.clumsy(5));  // Output: 7
        System.out.println(clumsy.clumsy(6));  // Output: 8
    }
    public int clumsy(int n) {
        int s = n;
        if (n > 1) {
            s *= n - 1;
        }
        if (n > 2) {
            s /= n - 2;
        }
        if (n > 3) {
            s += n - 3;
        }
        if (n < 5) {
            return s;
        }
        int i = n - 4;
        for (; i > 4; i -= 4) {
            s -= toV(i);    
        }
        if (i > 0) {
            int j = i;
            if (i > 1) {
                j *= i - 1;
            }
            if (i > 2) {
                j /= i - 2;
            }
            if (i > 3) {
                j -= i - 3;
            }
            s -= j;
        }
        return s;
    }
    private int toV(int i) {
        int j = i;
        j *= i - 1;
        j /= i - 2;
        j -= i - 3;
        return j;
    } 
}
