import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode.cn id=455 lang=java
 *
 * [455] 分发饼干
 */

// @lc code=start
class Solution {
    public int findContentChildren(int[] g, int[] s) {
        List<Integer> chList = getSortedList(g);
        List<Integer> cookieList = getSortedList(s);
        int ret = 0;
        for (Integer ch: chList) {
            while (cookieList.size() > 0 && cookieList.get(0) < ch) {
                cookieList.remove(0);
            }
            if (cookieList.size() == 0) {
                break;
            } else {
                cookieList.remove(0);
                ret++;
            }
        }
        return ret;
    }

	private List<Integer> getSortedList(int[] g) {
        List<Integer> ret = new ArrayList<>();
        for (int num: g) {
            ret.add(num);
        }
        ret.sort(Integer::compare);
        return ret;
	}

    
}
// @lc code=end

