package leetcode.solution;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * @author zhihao.mao
 */
public class LongestSubstringWithoutRepeatingCharacters {

    public static int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {

            return 0;
        }
        Map<Character, Integer> charIndexMap = new HashMap<>();
        int max = 1;
        int start = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            Integer index = charIndexMap.get(c);
            if (index != null && index >= start) {
                max = Math.max(max, i - start);
                start = index + 1;
            }else {
                max = Math.max(max, i - start + 1);
            }
            charIndexMap.put(c, i);
        }

        return max;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
    }
}
