/*
 * @lc app=leetcode.cn id=221 lang=java
 *
 * [221] 最大正方形
 */

// @lc code=start
class Solution {
    public int maximalSquare(char[][] matrix) {
        // 状态：包含ｉ，ｊ　的最大正方形数
        // DP方程：val(i,j) = min(val(i-1,j), val(i, j-1), val(i-1,j-1)) + 1
        if (matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        int[] row = new int[matrix[0].length];
        int ret = 0;
        for (int i = 0; i < matrix[0].length; i++) {
            if (matrix[0][i] == '1') {
                ret = 1;
                row[i] = 1;
            } else {
                row[i] = 0;
            }
        }

        for (int i = 1; i < matrix.length; i++) {
            int last = row[0];
            row[0] = matrix[i][0] == '1' ? 1 : 0;
            if (row[0] > ret) {
                ret = row[0];
            }

            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][j] == '0') {
                    last = row[j];
                    row[j] = 0;
                    continue;
                }
                int newVal = min(last, row[j - 1], row[j]) + 1;
                last = row[j];
                row[j] = newVal;
                if (newVal > ret) {
                    ret = newVal;
                }
            }
        }
        return ret * ret;
    }

    private int min(int last, int i, int j) {
        if (last > i) {
            return i > j ? j : i;
        } else {
            return last > j ? j : last;
        }
    }
}
// @lc code=end

