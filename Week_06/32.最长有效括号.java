/*
 * @lc app=leetcode.cn id=32 lang=java
 *
 * [32] 最长有效括号
 */

// @lc code=start
class Solution {
    public int longestValidParentheses(String s) {
        // 状态： 包含i字符的最大有效长度
        // DP方程：
        // 1. '(' -> val(i) = 0
        // 2. i - 1 = '(', val(i) = val(i-2) + 2
        // 3. i - 1 = ')', val(i) = val(i - 1) + (i - 1 - val(i-1) - 1 == '(' ? 2 +  val(...) : 0)
        if (s.length() == 0) {
            return 0;
        }
        int[] counts = new int[s.length()];
        counts[0] = 0;
        int ret = 0;

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                counts[i] = 0;
            } else {
                if (s.charAt(i - 1) == '(') {
                    counts[i] = i - 2 >= 0 ? counts[i - 2] + 2 : 2;
                } else {
                    if (counts[i - 1] == 0) {
                        counts[i] = 0;
                    } else {
                        int left = i - 1 - counts[i - 1];
                        if (left < 0) {
                            counts[i] = 0;
                        } else {
                            if (s.charAt(left) == '(') {
                                counts[i] = counts[i - 1] + 2 + (left - 1 > 0 ? counts[left - 1] : 0); 
                            } else {
                                counts[i] = 0;
                            }
                        }
                    }
                }
                if (counts[i] > ret) {
                    ret = counts[i];
                }
            }
        }
        return ret;
    }
}
// @lc code=end

