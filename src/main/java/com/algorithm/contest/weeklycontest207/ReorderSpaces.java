package com.algorithm.contest.weeklycontest207;

import java.util.Arrays;

public class ReorderSpaces {
    public static void main(String[] args) {

        String text = "  this   is  a sentence ";
        ReorderSpaces r = new ReorderSpaces();
        System.out.println("["+ r.reorderSpaces(" practice   makes   perfect") + "]");
        System.out.println("["+ r.reorderSpaces(text) + "]");
//        String[] texts = text.split(" ");
//        System.out.println(Arrays.toString(texts));
    }
    public String reorderSpaces(String text) {
        int spaceCnt = 0, worldCnt = 0, noneSpaces = 0;
        char[] chrs = text.toCharArray();
        StringBuilder sb = new StringBuilder();
        for(char c : chrs) {
            if (c == ' ') {
                spaceCnt++;
                if (noneSpaces != 0) {
                    worldCnt++;
                    noneSpaces = 0;
                    sb.append('*');
                }
                continue;
            }
            noneSpaces++;
            sb.append(c);
        }
        if (noneSpaces != 0) {
            worldCnt++;
        }
        if (sb.charAt(sb.length() - 1) == '*') {
            sb.deleteCharAt(sb.length() - 1);
        }
        if (worldCnt == 1) {
            return spaceCnt == 0 ? sb.toString() : sb.toString() + getSpace(spaceCnt);
        }
        worldCnt--;
        int splitSpace = spaceCnt / worldCnt;
        int lastSpace = spaceCnt % worldCnt;
        String res = sb.toString().replace("*", getSpace(splitSpace));
        return lastSpace == 0 ? res : res + getSpace(lastSpace);
    }

    static String getSpace(int spaceNum) {
        StringBuilder sb = new StringBuilder();
        while (spaceNum > 0) {
            sb.append(' ');
            spaceNum--;
        }
        return sb.toString();
    }
}
