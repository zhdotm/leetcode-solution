package leetcode.solution;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 *
 * @author zhihao.mao
 */
public class LongestPalindromicSubstring {

    public static String longestPalindrome002(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }

        int maxLen = 1;
        int begin = 0;
        // dp[i][j] 表示 s[i..j] 是否是回文串
        boolean[][] dp = new boolean[len][len];
        // 初始化：所有长度为 1 的子串都是回文串
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }

        char[] charArray = s.toCharArray();
        // 递推开始
        // 先枚举子串长度
        for (int l = 2; l <= len; l++) {
            // 枚举左边界，左边界的上限设置可以宽松一些
            for (int i = 0; i < len; i++) {
                // 由 L 和 i 可以确定右边界，即 j - i + 1 = L 得
                int j = l + i - 1;
                // 如果右边界越界，就可以退出当前循环
                if (j >= len) {
                    break;
                }

                if (charArray[i] != charArray[j]) {
                    dp[i][j] = false;
                } else {
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }

                // 只要 dp[i][L] == true 成立，就表示子串 s[i..L] 是回文，此时记录回文长度和起始位置
                if (dp[i][j] && j - i + 1 > maxLen) {
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxLen);
    }

    public static String longestPalindrome001(String s) {
        int length = s.length();
        if (length == 1 || length == 0) {

            return s;
        }

        String maxPalindrome = s.substring(0, 1);
        Boolean[][] dp = new Boolean[length][length];
        Map<Character, List<Integer>> charIndexesMap = new HashMap<>();
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            List<Integer> indexes = charIndexesMap.get(c);
            if (indexes == null) {
                indexes = new ArrayList<>();
            }
            for (Integer index : indexes) {
                int currentLength = i - index + 1;
                if (currentLength > maxPalindrome.length()) {
                    if (isPalindrome001(s, dp, index, i)) {
                        maxPalindrome = s.substring(index, i + 1);
                    }
                }
            }
            indexes.add(i);
            charIndexesMap.put(c, indexes);
        }

        return maxPalindrome;
    }

    public static Boolean isPalindrome001(String input, Boolean[][] dp, Integer startIndex, Integer endIndex) {
        if (dp[startIndex][endIndex] != null) {

            return dp[startIndex][endIndex];
        }
        if (startIndex >= endIndex) {

            dp[startIndex][endIndex] = Boolean.TRUE;
            return Boolean.TRUE;
        }
        if (input.charAt(startIndex) != input.charAt(endIndex)) {

            dp[startIndex][endIndex] = Boolean.FALSE;
            return Boolean.FALSE;
        }

        Boolean isPalindrome = isPalindrome001(input, dp, startIndex + 1, endIndex - 1);
        dp[startIndex][endIndex] = isPalindrome;
        return isPalindrome;
    }

    public static void main(String[] args) {

        System.out.println(longestPalindrome001("11211"));
    }

}
