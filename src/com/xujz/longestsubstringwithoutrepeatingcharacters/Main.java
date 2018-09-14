package com.xujz.longestsubstringwithoutrepeatingcharacters;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        Solution solution = main.new Solution();
        System.out.println(solution.lengthOfLongestSubstring("abcabcbb"));
    }

    class Solution {
        int lengthOfLongestSubstring(String s) {
            Map<Character, Integer> map = new HashMap<>();
            int mstart = 0, mlength = 0;
            int start = 0, length = 0;
            for(int i = 0, len = s.length(); i < len; i++) {
                Character c = s.charAt(i);
                if(start > map.getOrDefault(c, -1)) {
                    map.put(c, i);
                    length++;
                } else {
                    if(length > mlength) {
                        mlength = length;
                        mstart = start;
                    }
                    start = map.get(c) + 1;
                    length = i - map.get(c);
                    map.put(c, i);
                }
            }

            return (length > mlength) ? length : mlength;
        }
    }
}
