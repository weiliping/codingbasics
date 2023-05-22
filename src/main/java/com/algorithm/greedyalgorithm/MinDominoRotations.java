package com.algorithm.greedyalgorithm;

public class MinDominoRotations {

    public static void main(String[] args) {
        int[] A = new int[] { 2, 1, 2, 4, 2, 2 };
        int[] B = new int[] { 5, 2, 6, 2, 3, 2 };
        System.out.println(minDominoRotations(A, B));
    }

    public static int minDominoRotations(int[] A, int[] B) {
        int rotation = rotations(A, B, A[0]);
        if (rotation > -1 || A[0] == B[0]) {
            return rotation;
        }
        return rotations(A, B, B[0]);
    }

    static int rotations(int[] A, int[] B, int start) {
        int rotation1 = 0, rotation2 = 0;
        for (int i = 0; i < A.length; i++) {
            if (start != A[i] && start != B[i]) {
                return -1;
            } else if (start != A[i]) {
                rotation1++;
            } else if (start != B[i]){
                rotation2++;
            }
        }
        return Math.min(rotation1, rotation2);
    }
}
