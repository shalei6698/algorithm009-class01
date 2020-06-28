/*
 * @lc app=leetcode.cn id=33 lang=java
 *
 * [33] 搜索旋转排序数组
 */

// @lc code=start
class Solution {
    public int search(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }
        if (nums[nums.length - 1] >= nums[0]) {
            return binarySearch(nums, 0, nums.length - 1, target);
        }

        // 找到转折点
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] > nums[nums.length - 1]) {
                left = mid + 1;
            } else if (nums[mid] < nums[0]) {
                right = mid - 1;
            }
        }
        int idx = nums[left] >= nums[0] ? left + 1 : left;

        if (target > nums[idx - 1] || target < nums[idx]) {
            return -1;
        }

        if (target >= nums[0]) {
            return binarySearch(nums, 0, idx - 1, target);
        } else {
            return binarySearch(nums, idx, nums.length - 1, target);
        }
    }

    int binarySearch(int[] nums, int left, int right, int target) {
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }


}
// @lc code=end

