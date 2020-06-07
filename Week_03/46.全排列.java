import java.util.LinkedList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=46 lang=java
 *
 * [46] 全排列
 */

// @lc code=start

// 回溯
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ret = new LinkedList<>();
        if (nums.length == 0) {
            return ret;
        }

        // 状态
        LinkedList<Integer> path = new LinkedList<>();
        boolean[] used = new boolean[nums.length];

        // 深度优先遍历
        dfs(nums, 0, path, used, ret);

        return ret;
    }

    private void dfs(int[] nums, int depth, LinkedList<Integer> path, boolean[] used, List<List<Integer>> ret) {
        if (depth == nums.length) {
            ret.add(new LinkedList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                used[i] = true;
                path.add(nums[i]);
                dfs(nums, depth + 1, path, used, ret);
                used[i] = false;
                path.pollLast();
            }
        }
    }

}

// 直接递归
class Solution2 {
    public List<List<Integer>> permute(int[] nums) {
        return getPermute(nums, 0);
    }

    List<List<Integer>> getPermute(int[] nums, int n) {
        List<List<Integer>> ret = new LinkedList<>();
        // terminator
        if (n == nums.length - 1) {
            ret.add(new LinkedList<Integer>(){{
                add(nums[n]);
            }});
            return ret;
        }

        // drill down
        List<List<Integer>> preItems = getPermute(nums, n + 1);

        // process
        preItems.forEach(item -> {
			for (int i = 0; i <= item.size(); i++) {
                LinkedList<Integer> newItem = (LinkedList<Integer>) ((LinkedList<Integer>) item).clone();
                newItem.add(i, nums[n]);
                ret.add(newItem);
            }
        });

        return ret;
    }
}
// @lc code=end

