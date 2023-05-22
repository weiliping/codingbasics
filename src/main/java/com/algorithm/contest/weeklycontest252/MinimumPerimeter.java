package com.algorithm.contest.weeklycontest252;

public class MinimumPerimeter {
    public static void main(String[] args) {
        System.out.println(minimumPerimeter(1));
        System.out.println(minimumPerimeter(13));
        System.out.println(minimumPerimeter(1000000000));
    }
    public static long minimumPerimeter(long neededApples) {
        long n = 1;
        for(; 2 * n * (n + 1) * (2 * n + 1) < neededApples; ++n);
        return (n << 3);
    }
}
