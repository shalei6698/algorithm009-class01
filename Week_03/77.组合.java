import java.util.LinkedList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=77 lang=java
 *
 * [77] 组合
 */

// @lc code=start
class Solution {
    public List<List<Integer>> combine(int n, int k) {
        // 递归
        // n, k = n - 1, k + (n - 1, k -1, n)

        // terminator
        if (n == k) {
            List<List<Integer>> ret = new LinkedList<>();
            List<Integer> item = new LinkedList<>();
            for (int i = 1; i <= n; i++) {
                item.add(i);
            }
            ret.add(item);
            return ret;
        }
        if (k == 1) {
            List<List<Integer>> ret = new LinkedList<>();
            for (int i = 1; i <= n; i++) {
                List<Integer> subItem = new LinkedList<Integer>();
                subItem.add(i);
                ret.add(subItem);
            }
            return ret;
        }

        // process && drill down
        final List<List<Integer>> ret = combine(n - 1, k);
        combine(n - 1, k - 1).forEach(item -> {
            item.add(n);
            ret.add(item);
        });;
        return ret;
    }
}
// @lc code=end

