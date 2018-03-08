package com.xujz.reverseinteger;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        Solution solution = main.new Solution();
    }

    class Solution {
        public int reverse(int x) {
            if (x == 0) return 0;
            boolean isNegative = (x < 0) ? true : false;
            while(true) {
                if(x % 10 == 0) {
                    x /= 10;
                } else {
                    break;
                }

            }

            String reverseStr = new StringBuilder(String.valueOf(Math.abs(x))).reverse().toString();
            String maxIntStr = String.valueOf((int) Math.pow(2, 31));

            if (reverseStr.length() > 10) {
                return 0;
            } else {
                if(reverseStr.length() == 10) {
                    int i = 0;
                    while(true) {
                        if(reverseStr.charAt(i) > maxIntStr.charAt(i)) {
                            return 0;
                        } else if(reverseStr.charAt(i) < maxIntStr.charAt(i)) {
                            break;
                        } else {
                            i++;
                        }
                    }
                }

                return isNegative ? -Integer.parseInt(reverseStr) : Integer.parseInt(reverseStr);
            }
        }
    }
}
