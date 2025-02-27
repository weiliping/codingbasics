/*
 * @lc app=leetcode.cn id=3453 lang=java
 *
 * [3453] 分割正方形 I
 */

// @lc code=start

class Solution {
    public double separateSquares(int[][] squares) {
        long s = 0;
        int maxY = 0; 

        for (int[] square : squares) {
            s += (long) square[2] * square[2];
            maxY = Math.max(maxY, square[1] + square[2]);
        }
        double i = 0;
        double j = maxY;
        for (int k = 0; k < 47; k++) {
            double mid = (j + i) / 2 ;
            if (isCheck(squares, mid, s)) {
                j = mid;
            } else {
                i = mid;
            }
        }
        return (i + j) / 2;    
    }

    public boolean isCheck(int[][] squares, double mid, long s) {
        double s2 = 0;
        for (int k = 0; k < squares.length; k++) {
            double y = squares[k][1];
            if (y < mid) {
                double l = squares[k][2];
                s2 += l * Math.min(mid - y, l);
            }
        }
        return s2 >= s/2.0;
    }  
}
// @lc code=end

