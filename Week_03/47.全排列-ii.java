import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=47 lang=java
 *
 * [47] 全排列 II
 */

// @lc code=start
class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        if (nums.length == 0) {
            return ret;
        }

        // 回溯状态
        Deque<Integer> path = new ArrayDeque<>();
        List<Integer> uniqNums = new ArrayList<>();
        List<Integer> unUseCounts = new ArrayList<>();
        Map<Integer, Integer> numIdxMap = new HashMap<>();
        for (int num: nums) {
            Integer idx = numIdxMap.get(num);
            if (idx == null) {
                uniqNums.add(num);
                unUseCounts.add(1);
                numIdxMap.put(num, uniqNums.size() - 1);
            } else {
                unUseCounts.set(idx, unUseCounts.get(idx) + 1) ;
            }
        }

        // 深度优先遍历
        dfs(nums.length, 0, uniqNums, unUseCounts, path, ret);

        return ret;
    }

    private void dfs(int maxDepth, int depth, List<Integer> uniqNums, List<Integer> unUseCounts, Deque<Integer> path,
            List<List<Integer>> ret) {
        
        if (depth == maxDepth) {
            ret.add(new ArrayList<Integer>(path));
            return;
        }
        for (int i = 0; i < uniqNums.size(); i++) {
            if (unUseCounts.get(i) > 0) {
                path.add(uniqNums.get(i));
                unUseCounts.set(i, unUseCounts.get(i) - 1);
                dfs(maxDepth, depth + 1, uniqNums, unUseCounts, path, ret);
                path.pollLast();
                unUseCounts.set(i, unUseCounts.get(i) + 1);
            }
        }
    }

}
// @lc code=end

