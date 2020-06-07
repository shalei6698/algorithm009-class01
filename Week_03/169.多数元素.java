/*
 * @lc app=leetcode.cn id=169 lang=java
 *
 * [169] 多数元素
 */

// @lc code=start
class Solution {
    public int majorityElement(int[] nums) {
        // 摩尔投票法
        // 需要确定数组存在多数元素
        int currentNum = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == currentNum) {
                count ++;
            } else {
                count --;
                if (count == 0) {
                    currentNum = nums[i];
                    count = 1;
                }
            }
        }
        return currentNum;
    }
}
// @lc code=end

