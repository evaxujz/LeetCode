package com.xujz.implementstr;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        Solution solution = main.new Solution();
    }
    class Solution {
        public int strStr(String haystack, String needle) {
            int haystackLen = haystack.length();
            int needleLen = needle.length();
            if(haystackLen < needleLen) return -1;
            for(int i = 0; i < haystackLen - needleLen + 1; i++) {
                if(needle.equals(haystack.substring(i, i + needleLen))){
                    return i;
                }
            }
            return -1;
        }
    }
}
