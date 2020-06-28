/*
 * @lc app=leetcode.cn id=45 lang=java
 *
 * [45] 跳跃游戏 II
 */

// @lc code=start
class Solution {
    public int jump(int[] nums) {
        int ret = 0;

        // 最大值缩小范围
        int numMax = nums[0];
        for (int num: nums) {
            if (numMax < num) {
                numMax = num;
            }
        }

        int p = nums.length - 1;

        while (p > 0) {
            // 逆向贪心
            for (int i = numMax <= p ? p - numMax : 0; i < p; i++) {
                if (nums[i] >= p - i) {
                    p = i;
                    ret++;
                    break;
                }
            }
        }

        return ret;
    }
}
// @lc code=end

