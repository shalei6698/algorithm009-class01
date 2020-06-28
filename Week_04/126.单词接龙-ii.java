import java.beans.BeanInfo;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=126 lang=java
 *
 * [126] 单词接龙 II
 */

// @lc code=start
class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        // 一层一层广度优先遍历
        List<List<String>> ret = new ArrayList<>();
        Queue<List<String>> queue = new LinkedList<>();

        if (!wordList.contains(endWord)) {
            return ret;
        }

        List<String> initItem = new LinkedList<>();
        initItem.add(endWord);
        queue.add(initItem);

        if (jumpAble(beginWord, endWord)) {
            initItem.add(0, beginWord);
            ret.add(initItem);
            return ret;
        }


        while (!queue.isEmpty()) {
            int length = queue.size();
            Set<String> wordSet = new HashSet<>();

            for (int i = 0; i < length; i++) {
                List<String> item = queue.poll();
                String lastWord = item.get(0);
                for (String word: wordList) {
                    if (jumpAble(lastWord, word)) {
                        List<String> newItem = new LinkedList<>(item);
                        newItem.add(0, word);
                        queue.add(newItem);
                        wordSet.add(word);

                        if (jumpAble(word, beginWord)) {
                            newItem.add(0, beginWord);
                            ret.add(newItem);
                        }
                    }
                }
            }

            if (!ret.isEmpty()) {
                return ret;
            }

            wordList.removeAll(wordSet);
        }
        
        return ret;
    }

	private boolean jumpAble(String lastWord, String word) {
        int count = 0;
        for (int i = 0; i < lastWord.length(); i++) {
            if (lastWord.charAt(i) != word.charAt(i)) {
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

