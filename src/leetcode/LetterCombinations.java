package leetcode;

import java.util.*;

/**
 * 电话号码的字母组合
 *
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 *
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 */
public class LetterCombinations {
    public static void main(String[] args) {
        LetterCombinations l = new LetterCombinations();
        Solution solution = l.new Solution();
        System.out.println(solution.letterCombinations("123450"));
    }

    class Solution {
        public List<String> letterCombinations(String digits) {
            Map<Character, List<Character>> map = new HashMap<>();
            map.put('1', Arrays.asList());
            map.put('2', Arrays.asList('a', 'b', 'c'));
            map.put('3', Arrays.asList('d', 'e', 'f'));
            map.put('4', Arrays.asList('g', 'h', 'i'));
            map.put('5', Arrays.asList('j', 'k', 'l'));
            map.put('6', Arrays.asList('m', 'n', 'o'));
            map.put('7', Arrays.asList('p', 'q', 'r', 's'));
            map.put('8', Arrays.asList('t', 'u', 'v'));
            map.put('9', Arrays.asList('w', 'x', 'y', 'z'));
            map.put('0', Arrays.asList());

            List<String> result = new ArrayList<>();
            String s = digits.replaceAll("[0 | 1]", "");
            System.out.println(s);

            StringBuilder sb = new StringBuilder();
            int len = s.length();
            combination(sb, s, 0, result, map);

            return result;
        }

        public void combination(StringBuilder sb, String s, int index,
                                List<String> list, Map<Character, List<Character>> map) {
            if(s == null || s.length() == 0) return;
            int len = s.length();
            if(index == len - 1) {
                for(char c : map.get(s.charAt(index))) {
                    sb.append(c);
                    list.add(sb.toString());
                    sb.deleteCharAt(index);
                }
                return;
            }

            for(char c : map.get(s.charAt(index))) {
                sb.append(c);
                combination(sb, s, index + 1, list, map);
                sb.deleteCharAt(index);
            }
        }
    }
}
