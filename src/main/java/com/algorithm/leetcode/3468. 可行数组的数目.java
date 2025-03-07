class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] original = {1, 2, 3, 4};
        int[][] bounds = {{1,10}, {2,9}, {3, 8}, {4, 7}};
        int res = solution.countArrays(original, bounds);
        System.out.println(res);
    }
    public int countArrays(int[] original, int[][] bounds) {
        int n = original.length;
        int cnt = bounds[0][1] - bounds[0][0] + 1;
        for (int i = 1; i < n; i++) {
            int diff = original[i] - original[i - 1];
            int preL = bounds[i - 1][0] + diff;
            int preR = bounds[i - 1][1] + diff;
            int rangL = Math.max(bounds[i][0], preL);
            int rangR = Math.min(bounds[i][1], preR);
            if (rangL > rangR) {
                return 0;
            }
            cnt *= (rangR - rangL + 1);
        }
        return cnt;
    }    
}
