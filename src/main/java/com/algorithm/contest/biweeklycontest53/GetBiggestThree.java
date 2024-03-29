package com.algorithm.contest.biweeklycontest53;

import java.util.Arrays;
import java.util.PriorityQueue;

public class GetBiggestThree {
    public static void main(String[] args) {
        GetBiggestThree g = new GetBiggestThree();
        int[][] grid1 = new int[][] { { 3, 4, 5, 1, 3 }, { 3, 3, 4, 2, 3 }, { 20, 30, 200, 40, 10 }, { 1, 5, 5, 4, 1 },
                { 4, 3, 2, 2, 5 } };
        System.out.println(Arrays.toString(g.getBiggestThree(grid1)));

        int[][] grid2 = new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        System.out.println(Arrays.toString(g.getBiggestThree(grid2)));

        int[][] grid3 = new int[][] { { 7 }, { 7 }, { 7 } };
        System.out.println(Arrays.toString(g.getBiggestThree(grid3)));

        int[][] grid4 = new int[][] {
                { 1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048, 4096, 8192, 16384, 32768, 65536, 1, 2, 4, 8, 16,
                        32, 64, 128, 256, 512, 1024, 2048, 4096, 8192, 16384, 32768, 65536, 1, 2, 4, 8, 16, 32, 64, 128,
                        256, 512, 1024, 2048, 4096, 8192, 16384, 32768 },
                { 65536, 1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048, 4096, 8192, 16384, 32768, 65536, 1, 2, 4, 8,
                        16, 32, 64, 128, 256, 512, 1024, 2048, 4096, 8192, 16384, 32768, 65536, 1, 2, 4, 8, 16, 32, 64,
                        128, 256, 512, 1024, 2048, 4096, 8192, 16384 },
                { 32768, 65536, 1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048, 4096, 8192, 16384, 32768, 65536, 1,
                        2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048, 4096, 8192, 16384, 32768, 65536, 1, 2, 4, 8, 16,
                        32, 64, 128, 256, 512, 1024, 2048, 4096, 8192 },
                { 16384, 32768, 65536, 1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048, 4096, 8192, 16384, 32768,
                        65536, 1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048, 4096, 8192, 16384, 32768, 65536, 1, 2,
                        4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048, 4096 },
                { 8192, 16384, 32768, 65536, 1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048, 4096, 8192, 16384,
                        32768, 65536, 1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048, 4096, 8192, 16384, 32768,
                        65536, 1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048 },
                { 4096, 8192, 16384, 32768, 65536, 1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048, 4096, 8192, 16384,
                        32768, 65536, 1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048, 4096, 8192, 16384, 32768,
                        65536, 1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024 },
                { 2048, 4096, 8192, 16384, 32768, 65536, 1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048, 4096, 8192,
                        16384, 32768, 65536, 1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048, 4096, 8192, 16384,
                        32768, 65536, 1, 2, 4, 8, 16, 32, 64, 128, 256, 512 },
                { 1024, 2048, 4096, 8192, 16384, 32768, 65536, 1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048, 4096,
                        8192, 16384, 32768, 65536, 1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048, 4096, 8192, 16384,
                        32768, 65536, 1, 2, 4, 8, 16, 32, 64, 128, 256 },
                { 512, 1024, 2048, 4096, 8192, 16384, 32768, 65536, 1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048,
                        4096, 8192, 16384, 32768, 65536, 1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048, 4096, 8192,
                        16384, 32768, 65536, 1, 2, 4, 8, 16, 32, 64, 128 },
                { 256, 512, 1024, 2048, 4096, 8192, 16384, 32768, 65536, 1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024,
                        2048, 4096, 8192, 16384, 32768, 65536, 1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048, 4096,
                        8192, 16384, 32768, 65536, 1, 2, 4, 8, 16, 32, 64 },
                { 128, 256, 512, 1024, 2048, 4096, 8192, 16384, 32768, 65536, 1, 2, 4, 8, 16, 32, 64, 128, 256, 512,
                        1024, 2048, 4096, 8192, 16384, 32768, 65536, 1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048,
                        4096, 8192, 16384, 32768, 65536, 1, 2, 4, 8, 16, 32 },
                { 64, 128, 256, 512, 1024, 2048, 4096, 8192, 16384, 32768, 65536, 1, 2, 4, 8, 16, 32, 64, 128, 256, 512,
                        1024, 2048, 4096, 8192, 16384, 32768, 65536, 1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048,
                        4096, 8192, 16384, 32768, 65536, 1, 2, 4, 8, 16 },
                { 32, 64, 128, 256, 512, 1024, 2048, 4096, 8192, 16384, 32768, 65536, 1, 2, 4, 8, 16, 32, 64, 128, 256,
                        512, 1024, 2048, 4096, 8192, 16384, 32768, 65536, 1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024,
                        2048, 4096, 8192, 16384, 32768, 65536, 1, 2, 4, 8 },
                { 16, 32, 64, 128, 256, 512, 1024, 2048, 4096, 8192, 16384, 32768, 65536, 1, 2, 4, 8, 16, 32, 64, 128,
                        256, 512, 1024, 2048, 4096, 8192, 16384, 32768, 65536, 1, 2, 4, 8, 16, 32, 64, 128, 256, 512,
                        1024, 2048, 4096, 8192, 16384, 32768, 65536, 1, 2, 4 },
                { 8, 16, 32, 64, 128, 256, 512, 1024, 2048, 4096, 8192, 16384, 32768, 65536, 1, 2, 4, 8, 16, 32, 64,
                        128, 256, 512, 1024, 2048, 4096, 8192, 16384, 32768, 65536, 1, 2, 4, 8, 16, 32, 64, 128, 256,
                        512, 1024, 2048, 4096, 8192, 16384, 32768, 65536, 1, 2 },
                { 4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048, 4096, 8192, 16384, 32768, 65536, 1, 2, 4, 8, 16, 32, 64,
                        128, 256, 512, 1024, 2048, 4096, 8192, 16384, 32768, 65536, 1, 2, 4, 8, 16, 32, 64, 128, 256,
                        512, 1024, 2048, 4096, 8192, 16384, 32768, 65536, 1 },
                { 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048, 4096, 8192, 16384, 32768, 65536, 1, 2, 4, 8, 16, 32,
                        64, 128, 256, 512, 1024, 2048, 4096, 8192, 16384, 32768, 65536, 1, 2, 4, 8, 16, 32, 64, 128,
                        256, 512, 1024, 2048, 4096, 8192, 16384, 32768, 65536 },
                { 1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048, 4096, 8192, 16384, 32768, 65536, 1, 2, 4, 8, 16,
                        32, 64, 128, 256, 512, 1024, 2048, 4096, 8192, 16384, 32768, 65536, 1, 2, 4, 8, 16, 32, 64, 128,
                        256, 512, 1024, 2048, 4096, 8192, 16384, 32768 },
                { 65536, 1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048, 4096, 8192, 16384, 32768, 65536, 1, 2, 4, 8,
                        16, 32, 64, 128, 256, 512, 1024, 2048, 4096, 8192, 16384, 32768, 65536, 1, 2, 4, 8, 16, 32, 64,
                        128, 256, 512, 1024, 2048, 4096, 8192, 16384 },
                { 32768, 65536, 1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048, 4096, 8192, 16384, 32768, 65536, 1,
                        2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048, 4096, 8192, 16384, 32768, 65536, 1, 2, 4, 8, 16,
                        32, 64, 128, 256, 512, 1024, 2048, 4096, 8192 },
                { 16384, 32768, 65536, 1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048, 4096, 8192, 16384, 32768,
                        65536, 1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048, 4096, 8192, 16384, 32768, 65536, 1, 2,
                        4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048, 4096 },
                { 8192, 16384, 32768, 65536, 1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048, 4096, 8192, 16384,
                        32768, 65536, 1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048, 4096, 8192, 16384, 32768,
                        65536, 1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048 },
                { 4096, 8192, 16384, 32768, 65536, 1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048, 4096, 8192, 16384,
                        32768, 65536, 1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048, 4096, 8192, 16384, 32768,
                        65536, 1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024 },
                { 2048, 4096, 8192, 16384, 32768, 65536, 1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048, 4096, 8192,
                        16384, 32768, 65536, 1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048, 4096, 8192, 16384,
                        32768, 65536, 1, 2, 4, 8, 16, 32, 64, 128, 256, 512 },
                { 1024, 2048, 4096, 8192, 16384, 32768, 65536, 1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048, 4096,
                        8192, 16384, 32768, 65536, 1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048, 4096, 8192, 16384,
                        32768, 65536, 1, 2, 4, 8, 16, 32, 64, 128, 256 },
                { 512, 1024, 2048, 4096, 8192, 16384, 32768, 65536, 1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048,
                        4096, 8192, 16384, 32768, 65536, 1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048, 4096, 8192,
                        16384, 32768, 65536, 1, 2, 4, 8, 16, 32, 64, 128 },
                { 256, 512, 1024, 2048, 4096, 8192, 16384, 32768, 65536, 1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024,
                        2048, 4096, 8192, 16384, 32768, 65536, 1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048, 4096,
                        8192, 16384, 32768, 65536, 1, 2, 4, 8, 16, 32, 64 },
                { 128, 256, 512, 1024, 2048, 4096, 8192, 16384, 32768, 65536, 1, 2, 4, 8, 16, 32, 64, 128, 256, 512,
                        1024, 2048, 4096, 8192, 16384, 32768, 65536, 1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048,
                        4096, 8192, 16384, 32768, 65536, 1, 2, 4, 8, 16, 32 },
                { 64, 128, 256, 512, 1024, 2048, 4096, 8192, 16384, 32768, 65536, 1, 2, 4, 8, 16, 32, 64, 128, 256, 512,
                        1024, 2048, 4096, 8192, 16384, 32768, 65536, 1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048,
                        4096, 8192, 16384, 32768, 65536, 1, 2, 4, 8, 16 },
                { 32, 64, 128, 256, 512, 1024, 2048, 4096, 8192, 16384, 32768, 65536, 1, 2, 4, 8, 16, 32, 64, 128, 256,
                        512, 1024, 2048, 4096, 8192, 16384, 32768, 65536, 1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024,
                        2048, 4096, 8192, 16384, 32768, 65536, 1, 2, 4, 8 },
                { 16, 32, 64, 128, 256, 512, 1024, 2048, 4096, 8192, 16384, 32768, 65536, 1, 2, 4, 8, 16, 32, 64, 128,
                        256, 512, 1024, 2048, 4096, 8192, 16384, 32768, 65536, 1, 2, 4, 8, 16, 32, 64, 128, 256, 512,
                        1024, 2048, 4096, 8192, 16384, 32768, 65536, 1, 2, 4 },
                { 8, 16, 32, 64, 128, 256, 512, 1024, 2048, 4096, 8192, 16384, 32768, 65536, 1, 2, 4, 8, 16, 32, 64,
                        128, 256, 512, 1024, 2048, 4096, 8192, 16384, 32768, 65536, 1, 2, 4, 8, 16, 32, 64, 128, 256,
                        512, 1024, 2048, 4096, 8192, 16384, 32768, 65536, 1, 2 },
                { 4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048, 4096, 8192, 16384, 32768, 65536, 1, 2, 4, 8, 16, 32, 64,
                        128, 256, 512, 1024, 2048, 4096, 8192, 16384, 32768, 65536, 1, 2, 4, 8, 16, 32, 64, 128, 256,
                        512, 1024, 2048, 4096, 8192, 16384, 32768, 65536, 1 },
                { 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048, 4096, 8192, 16384, 32768, 65536, 1, 2, 4, 8, 16, 32,
                        64, 128, 256, 512, 1024, 2048, 4096, 8192, 16384, 32768, 65536, 1, 2, 4, 8, 16, 32, 64, 128,
                        256, 512, 1024, 2048, 4096, 8192, 16384, 32768, 65536 },
                { 1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048, 4096, 8192, 16384, 32768, 65536, 1, 2, 4, 8, 16,
                        32, 64, 128, 256, 512, 1024, 2048, 4096, 8192, 16384, 32768, 65536, 1, 2, 4, 8, 16, 32, 64, 128,
                        256, 512, 1024, 2048, 4096, 8192, 16384, 32768 },
                { 65536, 1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048, 4096, 8192, 16384, 32768, 65536, 1, 2, 4, 8,
                        16, 32, 64, 128, 256, 512, 1024, 2048, 4096, 8192, 16384, 32768, 65536, 1, 2, 4, 8, 16, 32, 64,
                        128, 256, 512, 1024, 2048, 4096, 8192, 16384 },
                { 32768, 65536, 1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048, 4096, 8192, 16384, 32768, 65536, 1,
                        2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048, 4096, 8192, 16384, 32768, 65536, 1, 2, 4, 8, 16,
                        32, 64, 128, 256, 512, 1024, 2048, 4096, 8192 },
                { 16384, 32768, 65536, 1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048, 4096, 8192, 16384, 32768,
                        65536, 1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048, 4096, 8192, 16384, 32768, 65536, 1, 2,
                        4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048, 4096 },
                { 8192, 16384, 32768, 65536, 1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048, 4096, 8192, 16384,
                        32768, 65536, 1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048, 4096, 8192, 16384, 32768,
                        65536, 1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048 },
                { 4096, 8192, 16384, 32768, 65536, 1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048, 4096, 8192, 16384,
                        32768, 65536, 1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048, 4096, 8192, 16384, 32768,
                        65536, 1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024 },
                { 2048, 4096, 8192, 16384, 32768, 65536, 1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048, 4096, 8192,
                        16384, 32768, 65536, 1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048, 4096, 8192, 16384,
                        32768, 65536, 1, 2, 4, 8, 16, 32, 64, 128, 256, 512 },
                { 1024, 2048, 4096, 8192, 16384, 32768, 65536, 1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048, 4096,
                        8192, 16384, 32768, 65536, 1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048, 4096, 8192, 16384,
                        32768, 65536, 1, 2, 4, 8, 16, 32, 64, 128, 256 },
                { 512, 1024, 2048, 4096, 8192, 16384, 32768, 65536, 1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048,
                        4096, 8192, 16384, 32768, 65536, 1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048, 4096, 8192,
                        16384, 32768, 65536, 1, 2, 4, 8, 16, 32, 64, 128 },
                { 256, 512, 1024, 2048, 4096, 8192, 16384, 32768, 65536, 1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024,
                        2048, 4096, 8192, 16384, 32768, 65536, 1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048, 4096,
                        8192, 16384, 32768, 65536, 1, 2, 4, 8, 16, 32, 64 },
                { 128, 256, 512, 1024, 2048, 4096, 8192, 16384, 32768, 65536, 1, 2, 4, 8, 16, 32, 64, 128, 256, 512,
                        1024, 2048, 4096, 8192, 16384, 32768, 65536, 1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048,
                        4096, 8192, 16384, 32768, 65536, 1, 2, 4, 8, 16, 32 },
                { 64, 128, 256, 512, 1024, 2048, 4096, 8192, 16384, 32768, 65536, 1, 2, 4, 8, 16, 32, 64, 128, 256, 512,
                        1024, 2048, 4096, 8192, 16384, 32768, 65536, 1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048,
                        4096, 8192, 16384, 32768, 65536, 1, 2, 4, 8, 16 },
                { 32, 64, 128, 256, 512, 1024, 2048, 4096, 8192, 16384, 32768, 65536, 1, 2, 4, 8, 16, 32, 64, 128, 256,
                        512, 1024, 2048, 4096, 8192, 16384, 32768, 65536, 1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024,
                        2048, 4096, 8192, 16384, 32768, 65536, 1, 2, 4, 8 },
                { 16, 32, 64, 128, 256, 512, 1024, 2048, 4096, 8192, 16384, 32768, 65536, 1, 2, 4, 8, 16, 32, 64, 128,
                        256, 512, 1024, 2048, 4096, 8192, 16384, 32768, 65536, 1, 2, 4, 8, 16, 32, 64, 128, 256, 512,
                        1024, 2048, 4096, 8192, 16384, 32768, 65536, 1, 2, 4 },
                { 8, 16, 32, 64, 128, 256, 512, 1024, 2048, 4096, 8192, 16384, 32768, 65536, 1, 2, 4, 8, 16, 32, 64,
                        128, 256, 512, 1024, 2048, 4096, 8192, 16384, 32768, 65536, 1, 2, 4, 8, 16, 32, 64, 128, 256,
                        512, 1024, 2048, 4096, 8192, 16384, 32768, 65536, 1, 2 },
                { 4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048, 4096, 8192, 16384, 32768, 65536, 1, 2, 4, 8, 16, 32, 64,
                        128, 256, 512, 1024, 2048, 4096, 8192, 16384, 32768, 65536, 1, 2, 4, 8, 16, 32, 64, 128, 256,
                        512, 1024, 2048, 4096, 8192, 16384, 32768, 65536, 1 } };
        System.out.println(Arrays.toString(g.getBiggestThree(grid4)));
    }

    public int[] getBiggestThree(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        PriorityQueue<Integer> queue = new PriorityQueue<>(3);
        int k = Math.min(n, m);
        k = (k & 1) == 0 ? k - 1 : k;
        while (k > 0) {
            int start = (k - 1) >> 1;
            for (int i = 0; i + k - 1 < n; i++) {
                for (int j = 0; j + k - 1 < m; j++) {
                    int subSum = sum(grid, i + start, j, start);
                    if (queue.size() < 3) {
                        if (!queue.contains(subSum)) {
                            queue.offer(subSum);
                        }
                        continue;
                    }
                    if (subSum > queue.peek() && !queue.contains(subSum)) {
                        queue.poll();
                        queue.offer(subSum);
                    }
                }
            }
            k -= 2;
        }
        int len = queue.size();
        int[] res = new int[len];
        int i = len - 1;
        while (i >= 0) {
            res[i--] = queue.poll();
        }
        return res;
    }

    static int sum(int[][] grid, int i, int j, int k) {
        int sum = grid[i][j];
        int l = k << 2, index = 1, ii = i - 1, jj = j + 1;
        while (index < l) {
            sum += grid[ii][jj];
            int curr = index / k;
            if (curr < 2) {
                jj++;
            } else {
                jj--;
            }
            if (curr == 0 || curr == 3) {
                ii--;
            } else {
                ii++;
            }
            index++;
        }
        return sum;
    }
}
