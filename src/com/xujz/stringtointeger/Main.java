package com.xujz.stringtointeger;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        Solution solution = main.new Solution();
    }

    class Solution {
        public int myAtoi(String str) {
            str = str.trim();
            if(str.length() == 0) return 0;
            //flag: 0:未匹配 1:匹配到+/- 2:匹配到数字
            int flag = 0;
            int startPos = -1;
            int endPos = -1;
            for(int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                if((c == '+' || c == '-') && flag == 0) {
                    flag = 1;
                    startPos = i;
                    endPos = i;
                } else if(c >= '0' && c <= '9') {
                    if(flag == 0) {
                        flag = 2;
                        startPos = i;
                        endPos = i;
                    } else if(flag == 1) {
                        flag = 2;
                        endPos = i;
                    } else if(flag == 2) {
                        endPos = i;
                    }
                } else {
                    break;
                }
            }

            if(startPos >= 0 && endPos >= 0) {
                try {
                    int rtnInt = Integer.parseInt(str.substring(startPos, endPos + 1));
                    return rtnInt;
                } catch (NumberFormatException nfe1) {
                    if(flag == 0 || flag == 1) return 0;
                    else {
                        if(str.charAt(startPos) != '-') {
                            return 2147483647;
                        } else {
                            return -2147483648;
                        }
                    }
                }
            } else {
                return 0;
            }
        }
    }
}
