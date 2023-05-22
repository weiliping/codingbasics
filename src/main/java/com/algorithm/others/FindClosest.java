package com.algorithm.others;

public class FindClosest {
    static void findClosest(int A[], int B[], int C[],
            int p, int q, int r) {
        int diff = Integer.MAX_VALUE; // Initialize min diff

        // Initialize result
        int res_i = 0, res_j = 0, res_k = 0;

        // Traverse arrays
        int i = 0, j = 0, k = 0;
        while (i < p && j < q && k < r) {
            // Find minimum and maximum of current three elements
            int minimum = Math.min(A[i],
                    Math.min(B[j], C[k]));
            int maximum = Math.max(A[i],
                    Math.max(B[j], C[k]));

            // Update result if current diff is
            // less than the min diff so far
            if (maximum - minimum < diff) {
                res_i = i;
                res_j = j;
                res_k = k;
                diff = maximum - minimum;
            }

            // We can't get less than 0
            // as values are absolute
            if (diff == 0)
                break;

            // Increment index of array
            // with smallest value
            if (A[i] == minimum)
                i++;
            else if (B[j] == minimum)
                j++;
            else
                k++;
        }

        // Print result
        System.out.println(A[res_i] + " " +
                B[res_j] + " " + C[res_k]);
    }

    // Driver code
    public static void main(String[] args) {
        int A[] = { 1, 4, 10 };
        int B[] = { 2, 15, 20 };
        int C[] = { 10, 12 };

        int p = A.length;
        int q = B.length;
        int r = C.length;

        // Function calling
        findClosest(A, B, C, p, q, r);
    }
}
