import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * @lc app=leetcode.cn id=127 lang=java
 *
 * [127] 单词接龙
 */

// @lc code=start
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.remove(endWord)) {
            return 0;
        }
        Queue<String> queue = new LinkedList<>();
        Queue<Integer> layers = new LinkedList<>();
        queue.add(endWord);
        layers.add(1);

        while (queue.size() > 0) {
            String word = queue.poll();
            Integer layer = layers.poll();
            if (jumpAble(word, beginWord)) {
                return layer + 1;
            }

            Iterator<String> iter = wordList.iterator();
            while (iter.hasNext()) {
                String item = iter.next();
                if (jumpAble(word, item)) {
                    queue.add(item);
                    layers.add(layer + 1);
                    iter.remove();
                }
            }
        }

        return 0;
    }

	private boolean jumpAble(String word, String item) {
        int count = 0;
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) != item.charAt(i)) {
                count++;
                if (count > 1) {
                    return false;
                }
            }
        }
		return true;
	}
}
// @lc code=end

