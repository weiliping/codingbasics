package com.algorithm.contest.biweeklycontest52;

import java.util.Arrays;

public class RotateTheBox {
    public static void main(String[] args) {
        RotateTheBox r = new RotateTheBox();
//        char[][] box = new char[][] {{'#','.','#'}};
//        char[][] rotateBox = r.rotateTheBox(box);
//        for (char[] c : rotateBox) {
//            System.out.println(Arrays.toString(c));
//        }

        char[][] box2 = new char[][] {{'#','.','*','.'}, {'#','#','*','.'}};
        char[][] rotateBox2 = r.rotateTheBox(box2);
        for (char[] c : rotateBox2) {
            System.out.println(Arrays.toString(c));
        }

        char[][] box3 = new char[][] {{'#','#','*','.','*','.'},{'#','#','#','*','.','.'},{'#','#','#','.','#','.'}};
        char[][] rotateBox3 = r.rotateTheBox(box3);
        for (char[] c : rotateBox3) {
            System.out.println(Arrays.toString(c));
        }
    }

    public char[][] rotateTheBox(char[][] box) {
        int n = box.length, m = box[0].length;
        char[][] rotateBox = new char[m][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                rotateBox[j][n - 1 - i] = box[i][j];
            }
        }

        for (int i = 0; i < n; i++) {
            int j = m - 1, k;
            while (j > 0) {
                if (rotateBox[j][i] == '#' || rotateBox[j][i] == '*') {
                    j--;
                    continue;
                }
                k = j - 1;
                while (k > 0 && rotateBox[k][i] == '.') {
                    k--;
                }
                if (rotateBox[k][i] == '*') {
                    j = k - 1;
                } else {
                    rotateBox[j][i] = rotateBox[k][i];
                    rotateBox[k][i] = '.';
                    j--;
                }
            }
        }
        return rotateBox;
    }
}
