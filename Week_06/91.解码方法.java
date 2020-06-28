/*
 * @lc app=leetcode.cn id=91 lang=java
 *
 * [91] 解码方法
 */

// @lc code=start
class Solution {
    public int numDecodings(String s) {
        // 状态：第ｉ个和前一个合并的可能数，第ｉ个不合并的可能数
        // bottom-top
        if (s.length() == 0) {
            return 0;
        }
        if (s.charAt(0) == '0') {
            return 0;
        }

        int joinCount = 0;
        int imJoinCount = 1;
        for (int i = 1; i <= s.length() - 1; i++) {
            int thisImJosinCount = 0;
            // im join
            if (s.charAt(i) != '0') {
                thisImJosinCount = joinCount + imJoinCount;
            }
            // join
            if (s.charAt(i - 1) == '1' || (s.charAt(i - 1) == '2' && s.charAt(i) < '7')) {
                joinCount = imJoinCount;
            } else {
                joinCount = 0;
            }
            imJoinCount = thisImJosinCount;
        }

        return joinCount + imJoinCount;
    }
}
// @lc code=end

