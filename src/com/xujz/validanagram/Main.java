package com.xujz.validanagram;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        Solution solution = main.new Solution();
        String s = "a";
        String t = "b";
        System.out.println(solution.isAnagram(s, t));
    }

    class Solution {
        public boolean isAnagram(String s, String t) {
            if(s.length() != t.length()) return false;

            Map<Character, Integer> sMap = new HashMap<>(), tMap = new HashMap<>();
            IntStream.range(0, s.length()).forEach((i) -> sMap.put(s.charAt(i), sMap.getOrDefault(s.charAt(i), 0) + 1));
            IntStream.range(0, t.length()).forEach((i) -> tMap.put(t.charAt(i), tMap.getOrDefault(t.charAt(i), 0) + 1));

            for(Character c : sMap.keySet()) {
                if((int) sMap.getOrDefault(c, 0) !=  (int) tMap.getOrDefault(c, 0)) {
                    System.out.println("c: " + c + ", s = " + sMap.get(c) + ", t = " + tMap.get(c));
                    return false;
                }
            }
            return true;
        }

        public String unicode2Char(String s) {
            String[] sArr = s.split("\\\\\\\\u");
            StringBuilder sBuilder = new StringBuilder().append(sArr[0]);
            for(int i = 1; i < sArr.length; i++) {
                sBuilder.append(String.valueOf((char) Integer.parseInt(sArr[i].substring(0, 2), 16)));
                sBuilder.append(sArr[i].substring(2));
            }
            return sBuilder.toString();
        }
    }
}
