package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 无重复字符的最长子串
 *
 * 给定一个字符串，找出不含有重复字符的最长子串的长度。
 */
public class LengthOfLongestSubstring {

    public static void main(String[] args) {
        LengthOfLongestSubstring l = new LengthOfLongestSubstring();
        Solution solution = l.new Solution();
        System.out.println(solution.lengthOfLongestSubstring("wwwssdcawef"));
    }

    class Solution {
        public int lengthOfLongestSubstring(String s) {
            Map<Character, Integer> map = new HashMap<>();
            int startIndex = 0, curIndex = 0;
            int maxLen = 0, curLen = 0;

            char[] value = s.toCharArray();

            for(int i = 0, len = value.length; i < len; i++) {
                char c = value[curIndex = i];

                if(map.get(c) == null || map.get(c) < startIndex) {
                    curLen++;
                    map.put(c, curIndex);
                } else {
                    startIndex = map.get(c) + 1;
                    curLen = curIndex - startIndex + 1;
                    map.put(c, curIndex);
                }

                if(curLen > maxLen) maxLen = curLen;
            }

            return maxLen;
        }
    }
}
