package com.algorithm.contest.biweeklycontest65;

import java.util.Arrays;

public class Robot {
    public static void main(String[] args) {
        Robot r = new Robot(20, 13);
        r.step(12);
        r.step(21);
        System.out.println(Arrays.toString(r.getPos()));
        System.out.println(r.getDir());
        r.step(17);
        System.out.println(Arrays.toString(r.getPos()));
        System.out.println(r.getDir());
        System.out.println(Arrays.toString(r.getPos()));
        System.out.println(r.getDir());
    }
    int[] curPos;
    int m;
    int n;
    int h;
    int q;
    int f;
    boolean isMove = false;
    public Robot(int width, int height) {
        m = width;
        n = height;
        h = m + n - 2;
        f = (h << 1);
        q = (m << 1) + n - 3;
        curPos = new int[] { 0, 0 };
    }

    public void step(int num) {
        if (!isMove) {
            isMove = true;
        }
        int ind = getInd(curPos[0], curPos[1], m - 1, n - 1, q, f);
        num = (num + ind) % f;
        reverseInd(num, m - 1, n - 1, h, q, f);
    }

    public int[] getPos() {
        return curPos;
    }

    public String getDir() {
        int i = curPos[0], j = curPos[1];
        if (!isMove || (j == 0 && i != 0)) {
            return "East";
        }
        if (i == m - 1 && j != 0) {
            return "North";
        }
        if (j == n - 1 && i != m - 1) {
            return "West";
        }
        return "South";
    }

    void reverseInd(int ind, int m, int n, int h, int q, int f) {
        if (ind <= h) {
            if (ind <= m) {
                curPos[0] = ind;
                curPos[1] = 0;
                return;
            }
            curPos[0] = m;
            curPos[1] = ind - m;
            return;
        }
        if (q >= ind) {
            curPos[0] = q - ind;
            curPos[1] = n;
            return;
        }
        curPos[0] = 0;
        curPos[1] = f - ind;
    }

    int getInd(int i, int j, int m, int n, int q, int f) {
        if (j == 0 || i == m) {
            return i + j;
        }
        if (j == n) {
            return q - i;
        }
        return f - j;
    }
}
