import java.util.*;

/**
 * 49. 字母异位词分组
 * https://leetcode-cn.com/problems/group-anagrams/
 */
public class AnagramGroup {
    List<Integer> initCount = new ArrayList<>(Collections.nCopies(26, 0));

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<List<Integer>, List<String>> retMap = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            String str = strs[i];
            List<Integer> key = getCountArray(str);
            List<String> group = retMap.get(key);
            if (group == null) {
                List<String> newGroup = new LinkedList<>();
                newGroup.add(str);
                retMap.put(key, newGroup);
            } else {
                group.add(str);
            }
        }
        return new ArrayList<>(retMap.values());
    }

    /**
     * @param s 小写字符串
     * @return a~z 计数
     */
    public List<Integer> getCountArray(String s) {
        List<Integer> ret = new ArrayList<>(initCount);
        for (int i = 0; i < s.length(); i++) {
            int idx = s.charAt(i) - 'a';
            ret.set(idx, ret.get(idx) + 1);
        }
        return ret;
    }

}
