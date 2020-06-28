import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=200 lang=java
 *
 * [200] 岛屿数量
 */

// @lc code=start
class Solution {
    public int numIslands(char[][] grid) {
        int ret = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    ret++;
                    bfs(i, j, grid);
                }

            }
        }
        return ret;
    }

	private void bfs(int i, int j, char[][] grid) {
        Set<int[]> visited = new HashSet<>();
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{i, j});
        visited.add(new int[]{i, j});
        grid[i][j] = '0';

        while (queue.size() > 0) {
            int[] pos = queue.poll();
            int x = pos[0];
            int y = pos[1];

            List<int[]> posList = new LinkedList<>();

            if (x > 0) {
                posList.add(new int[]{x - 1, y});
            }
            if (x < grid.length - 1) {
                posList.add(new int[]{x + 1, y});
            }
            if (y > 0) {
                posList.add(new int[]{x, y - 1});
            }
            if (y < grid[0].length - 1) {
                posList.add(new int[]{x, y + 1});
            }

            for (int[] p: posList) {
                if (grid[p[0]][p[1]] == '1' && !visited.contains(p)) {
                    queue.add(p);
                    visited.add(p);
                    grid[p[0]][p[1]] = '0';
                }
            }
        }
    }
}
// @lc code=end

