/*
 * @lc app=leetcode.cn id=55 lang=java
 *
 * [55] 跳跃游戏
 */

// @lc code=start
class Solution {
    public boolean canJump(int[] nums) {
        int p = nums.length - 1;
        while (p > 0) {
            Boolean flag = false;
            for (int i = 0; i < p; i++) {
                if (nums[i] >= p - i) {
                    p = i;
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                return false;
            }
        }
        return true;
    }
}
// @lc code=end

