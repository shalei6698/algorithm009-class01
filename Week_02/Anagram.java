import java.util.HashMap;
import java.util.Map;

/**
 * 242. 有效的字母异位词
 * https://leetcode-cn.com/problems/valid-anagram/
 */
public class Anagram {
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> charCount1 = getHashCount(s);
        Map<Character, Integer> charCount2 = getHashCount(t);
        return charCount1.equals(charCount2);
    }

    private Map<Character, Integer> getHashCount(String s) {
        Map<Character, Integer> ret = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            Character chr = s.charAt(i);
            ret.put(chr, ret.getOrDefault(chr, 0) + 1);
        }
        return ret;
    }
}
