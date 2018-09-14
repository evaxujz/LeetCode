package com.xujz.validpalindrome;

import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        Solution solution = main.new Solution();
    }

    class Solution {
        public boolean isPalindrome(String s) {
            s = handleString(s);
            int len = s.length();
            if(len == 0) return true;
            for(int i = 0; i < (len + 1) / 2; i++){
                if(s.charAt(i) != s.charAt(len - 1 - i)){
                    return false;
                }
            }
            return true;
        }

        public String handleString(String s){
            StringBuilder sb = new StringBuilder();
            IntStream.range(0, s.length()).forEach((i) -> {
                char c = s.charAt(i);
                if(c >= 'A' && c <= 'Z' ||
                   c >= 'a' && c <= 'z' ||
                   c >= '0' && c <= '9')
                {
                    sb.append(Character.toLowerCase(c));
                }
            });
            return sb.toString();
        }
    }
}
