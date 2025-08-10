/*
 * @lc app=leetcode.cn id=3407 lang=java
 *
 * [3407] 子字符串匹配模式
 */

// @lc code=start
class Solution {
    public boolean hasMatch(String s, String p) {
        if ("*".equals(p)) {
            return true;
        }
        String[] ws = p.split("\\*");
        if (ws.length == 1) {
            return s.contains(ws[0]);
        }
        if (ws[0].isEmpty()) {
            return s.contains(ws[1]);
        }
        int sInd = s.indexOf(ws[0]);
        int eInd = s.lastIndexOf(ws[1]);
        return sInd != -1 && eInd != -1 && sInd + ws[0].length() <= eInd;
    }
}
// @lc code=end

