/*
 * @lc app=leetcode.cn id=64 lang=java
 *
 * [64] 最小路径和
 */

// @lc code=start
class Solution {
    public int minPathSum(int[][] grid) {
        int[] layerMin = new int[grid[0].length];
        layerMin[layerMin.length - 1] = grid[grid.length - 1][layerMin.length - 1];
        for (int i = layerMin.length - 2; i >= 0; i--) {
            layerMin[i] = layerMin[i+1] + grid[grid.length - 1][i];
        }

        for (int i = grid.length - 2; i >= 0; i--) {
            layerMin[layerMin.length - 1] += grid[i][layerMin.length - 1];
            for (int j = layerMin.length - 2; j >= 0; j--) {
                layerMin[j] = (layerMin[j] > layerMin[j + 1] ? layerMin[j + 1] : layerMin[j]) + grid[i][j]; 
            }
        }
        return layerMin[0];
    }
}
// @lc code=end

