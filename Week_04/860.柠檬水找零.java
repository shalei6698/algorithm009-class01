/*
 * @lc app=leetcode.cn id=860 lang=java
 *
 * [860] 柠檬水找零
 */

// @lc code=start
class Solution {
    int[] nums = new int[]{5, 10, 20};

    public boolean lemonadeChange(int[] bills) {
        int[] moneys = new int[nums.length];
        for (int bill: bills) {
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == bill) {
                    moneys[i]++;
                    break;
                }
            }
            
            if (!payBack(bill - 5, moneys)) {
                return false;
            }
        }
        return true;
    }

	private boolean payBack(int bill, int[] moneys) {
        // 贪心
        for (int i = nums.length - 2; i >= 0; i--) {
            if (bill < nums[i]) {
                continue;
            }
            int n = bill / nums[i];
            n = moneys[i] < n ? moneys[i] : n;
            bill -= nums[i] * n;
            moneys[i] -= n;
        }
        return bill == 0;
	}
}
// @lc code=end

