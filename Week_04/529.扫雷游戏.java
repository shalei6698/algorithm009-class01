import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * @lc app=leetcode.cn id=529 lang=java
 *
 * [529] 扫雷游戏
 */

// @lc code=start
class Solution {
    public char[][] updateBoard(char[][] board, int[] click) {
        if (board[click[0]][click[1]] == 'M') {
            board[click[0]][click[1]] = 'X';
            return board;
        }

        if (board[click[0]][click[1]] != 'E') {
            return board;
        }

        Queue<int[]> queue = new LinkedList<>();

        queue.add(click);

        while (!queue.isEmpty()) {
            int[] p = queue.poll();
            if (board[p[0]][p[1]] != 'E') {
                continue;
            }
            char num = '0';
            List<int[]> posList = new ArrayList<>();

            for (int i = -1; i <= 1; i++) {
                if (p[0] + i == -1 || p[0] + i == board.length) {
                    continue;
                }
                for (int j = -1; j <= 1; j++) {
                    if (p[1] + j == -1 || p[1] + j == board[0].length) {
                        continue;
                    }
                    if (i == 0 && j == 0) {
                        continue;
                    }
                    posList.add(new int[]{p[0] + i, p[1] + j});
                }
            }
    
            for (int[] pos: posList) {
                if (board[pos[0]][pos[1]] == 'M') {
                    num ++;
                }
            }

            if (num == '0') {
                board[p[0]][p[1]] = 'B';
                queue.addAll(posList);
            } else {
                board[p[0]][p[1]] = num;
            }
        }

        return board;
    }

}
// @lc code=end

