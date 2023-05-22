package com.algorithm.others;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

    public List<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0) {
            return res;
        }
        int m = matrix.length, n = matrix[0].length;
        int rBegin = 0, cBegin = 0, rEnd = m, cEnd = n;

        while (rEnd > rBegin && cEnd > cBegin) {
            if (n > 1) {
                for (int i = cBegin; i < cEnd; i++) {
                    res.add(matrix[rBegin][i]);
                }
                rBegin++;
            }

            if (m > 1) {
                for (int i = rBegin; i < rEnd; i++) {
                    res.add(matrix[i][cEnd - 1]);
                }
                cEnd--;
            }
            if (m == 1 || n == 1) {
                break;
            }

            for (int i = cEnd - 1; i >= cBegin && rEnd > rBegin; i--) {
                res.add(matrix[rEnd - 1][i]);
            }
            rEnd--;

            for (int i = rEnd - 1; i >= rBegin && cEnd > cBegin; i--) {
                res.add(matrix[i][cBegin]);
            }

            cBegin++;
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] numMatrix = new int[][] {
                { 1, 2, 3, 4 },
                { 5, 6, 7, 8 },
                { 9, 10, 11, 12 }
        };

        SpiralMatrix matrix = new SpiralMatrix();
        //        System.out.println(arrays.toString(matrix.spiralOrder(numMatrix)));
        System.out.println(matrix.spiralOrder(numMatrix));
    }
}
