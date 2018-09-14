package com.xujz.firstuniquecharinstring;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        Solution solution = main.new Solution();
    }

    class Solution {
        public int firstUniqChar(String s) {
            Map<Character, Integer> charMap = new LinkedHashMap<>();
            IntStream.range(0, s.length()).forEach((i) -> {
                charMap.put(s.charAt(i), charMap.getOrDefault(s.charAt(i), 0) + 1);
            });

            char firstUniqChar = ' ';

            for(Map.Entry<Character, Integer> entry : charMap.entrySet()){
                if(entry.getValue() == 1){
                    firstUniqChar = entry.getKey();
                    break;
                }
            }

            return s.indexOf(firstUniqChar);
        }
    }
}
