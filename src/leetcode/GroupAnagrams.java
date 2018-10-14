package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 字谜分组
 *
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 *
 * 所有输入均为小写字母。
 * 不考虑答案输出的顺序。
 */
public class GroupAnagrams {

    public static void main(String[] args) {
        GroupAnagrams groupAnagrams = new GroupAnagrams();
        Solution solution = groupAnagrams.new Solution();
        System.out.println
                (solution.groupAnagrams(new String[] {"eat", "tea", "tan", "ate", "nat", "bat"}));
    }

    class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {
            int[] init = new int[26];
            int[] count = new int[26];

            Map<String, List<String>> map = new HashMap<>();
            for(String str : strs) {
                for(char c : str.toCharArray()) {
                    count[c - 'a']++;
                }
                StringBuilder sb = new StringBuilder();
                for(int i : count) {
                    sb.append(Integer.toHexString(i)).append("|");
                }
                String key = sb.toString();
                if(null == map.get(key)) {
                    List<String> list = new ArrayList<>();
                    list.add(str);
                    map.put(key, list);
                } else {
                    map.get(key).add(str);
                }
                System.arraycopy(init, 0, count, 0, 26);
            }

            List<List<String>> result = new ArrayList<>();
            for(Map.Entry entry : map.entrySet()) {
                result.add((List<String>) entry.getValue());
            }

            return result;
        }
    }
}
