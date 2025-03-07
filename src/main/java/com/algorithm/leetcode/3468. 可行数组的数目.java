class Solution {
    public int countArrays(int[] original, int[][] bounds) {
        int preL = bounds[0][0], preR = bounds[0][1];
        for (int i = 1; i < original.length; i++) {
            int diff = original[i] - original[i - 1];
            preL = Math.max(bounds[i][0], preL + diff);
            preR = Math.min(bounds[i][1], preR + diff);
            if (preL > preR) {
                return 0;
            }
        }
        return preR - preL + 1;
    }    
}
