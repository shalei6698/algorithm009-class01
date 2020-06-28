/*
 * @lc app=leetcode.cn id=72 lang=java
 *
 * [72] 编辑距离
 */

// @lc code=start
class Solution {
    public int minDistance(String word1, String word2) {
        // 状态：val(i, j) word1 前i个子串 到 word2 前j个子串
        // DP 方程：word1[i] == word2[j] -> val(i, j) = val(i - 1, j - 1)
        // word1[i] != word2[j] -> val(i, j) = min(val(i - 1, j), val(i, j - 1), val(i-1, j-1)) + 1
        if (word1.length() == 0) {
            return word2.length();
        } else if (word2.length() == 0) {
            return word1.length();
        }
        int[] row = new int[word2.length() + 1];
        for (int i = 0; i <= word2.length(); i++) {
            row[i] = i;
        }
        
        // 
        for (int i = 1; i <= word1.length(); i++) {
            int lastVal = row[0];
            row[0] = i;

            for (int j = 1; j <= word2.length(); j++) {
                int rowj = row[j];
                if (word1.charAt(i - 1) == word2.charAt(j-1)) {
                    row[j] = lastVal;
                } else {
                    row[j] = min(row[j - 1], lastVal, row[j]) + 1;
                }
                lastVal = rowj;
            }
        }
        return row[row.length - 1];
    }

    private int min(int i, int j, int k) {
        if (i > j) {
            return j > k ? k : j;
        } else {
            return i > k ? k : i;
        }
    }
}
// @lc code=end

