package leetcode;

/**
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为1000。
 */
public class LongestPalindrome {

    public static void main(String[] args) {
        LongestPalindrome l = new LongestPalindrome();
        Solution solution = l.new Solution();
        NewSolution newSolution = l.new NewSolution();
        LastSolution lastSolution = l.new LastSolution();
        System.out.println(lastSolution.longestPalindrome("abacab"));
    }

    /**
     * 若前n个字符的以n字符为终点的最长回文子串为Pm - Pn,
     * 则添加了n+1个字符, 只需比较Pm-1 - Pn+1 是够为回文串, 是则与最长回文子串比较更新, 不是则比较Pm - Pn+1是够为回文串,
     * 是则比较更新, 不是则找出以Pn+1为终点的最长回文子串进行下一轮迭代
     */
    class LastSolution {
        public String longestPalindrome(String s) {
            if(s.length() == 0) return s;
            char[] str = s.toCharArray();
            StringBuilder maxStr = new StringBuilder(s.substring(0, 1));
            StringBuilder tailStr = new StringBuilder(s.substring(0, 1));
            int startIndex = 0;
            for(int i = 1, len = s.length(); i < len; i++) {
                if(startIndex > 0) {
                    if(str[startIndex - 1] == str[i]) {
                        tailStr.insert(0, str[startIndex - 1]).append(str[i]);
                        startIndex--;
                        if(tailStr.length() > maxStr.length())
                            maxStr = new StringBuilder(tailStr);
                        continue;
                    }
                }
                if(isPalindrome(tailStr.append(str[i]))) {
                    if(tailStr.length() > maxStr.length())
                        maxStr = new StringBuilder(tailStr);
                    continue;
                } else {
                    tailStr.deleteCharAt(tailStr.length() - 1);
                }
                StringBuilder tmpStr = new StringBuilder(s.substring(startIndex + 1, i + 1));
                for(int j = startIndex + 1; j <= i; j++) {
                    if(isPalindrome(tmpStr)) {
                        startIndex = j;
                        tailStr = new StringBuilder(tmpStr);
                        break;
                    } else {
                        tmpStr.deleteCharAt(0);
                    }
                }
                if(tailStr.length() > maxStr.length())
                    maxStr = new StringBuilder(tailStr);
            }
            return maxStr.toString();
        }

        public boolean isPalindrome(StringBuilder sb) {
            if(sb.toString().equals(sb.reverse().toString())) {
                sb.reverse();
                return true;
            } else {
                sb.reverse();
                return false;
            }
        }
    }

    /**
     * 若前n个字符的以n字符为终点的最长回文子串为Pm - Pn,
     * 则添加了n+1个字符, 只需比较Pm_1 - Pn+1 是够为回文串, 是则与最长回文子串比较更新, 不是则比较Pm - Pn+1是够为回文串,
     * 是则比较更新, 不是则比较Pm+1 - Pn+1是否为回文子串, 是则更新末尾回文子串, 若以上都不是, 则此时前n+1个字符的以n+1字符为终点的最长回文子串为Pn+1
     */
    class NewSolution {
        public String longestPalindrome(String s) {
            if(s.length() == 0) return s;
            String maxStr = String.valueOf(s.charAt(0));
            String tailStr = maxStr;
            int startIndex = 0;
            for(int i = 1, len = s.length(); i < len; i++) {
                if(startIndex > 0) {
                    if(s.charAt(startIndex - 1) == s.charAt(i)) {
                        tailStr = s.charAt(startIndex - 1) + tailStr + s.charAt(i);
                        startIndex--;
                        if(tailStr.length() > maxStr.length()) maxStr = tailStr;
                        continue;
                    }
                }
                if(isPalindrome(tailStr + s.charAt(i))) {
                    tailStr = tailStr + s.charAt(i);
                    if(tailStr.length() > maxStr.length()) maxStr = tailStr;
                    continue;
                }
                int index = i;
                tailStr = String.valueOf(s.charAt(i));
                for(int j = i - 1; j > startIndex; j--) {
                    if(isPalindrome(s.substring(j, i + 1))) {
                        tailStr = s.substring(j, i + 1);
                        index = j;
                    }
                }
                startIndex = index;
                if(tailStr.length() >= maxStr.length()) maxStr = tailStr;
            }
            return maxStr;
        }

        public boolean isPalindrome(String s) {
            StringBuilder sb = new StringBuilder(s);
            if(s.equals(sb.reverse().toString())) return true;
            else return false;
        }
    }

    /**
     * 假设已知前n个字符的最长回文子串, 则要求得前n+1个字符的最长回文子串,则以n+1字符为终点, 一次遍历前n个字符
     * 判断该n种情况是否存在回文子串并选出最长子串与前n个字符的最长子串进行比较取最大值, 复杂度为O(n ^ 2),
     * 优化1: 若已知前n个字符的最长子串长度为k, 则n+1个字符只需比较长度为k+1以上的子串是够为回文串
     * 优化2: 为n+1字符为末尾, 则回文子串的第一个字符必须与n+1字符一样
     */
    class Solution {
        public String longestPalindrome(String s) {
            if (s.length() == 0) return s;
            int startIndex = 0, len = 1;
            for (int i = 1, size = s.length(); i < size; i++) {
                for (int j = i - len; j >= 0; j--) {
                    if (s.charAt(j) == s.charAt(i)) {
                        String str = s.substring(j, i + 1);
                        if (isPalindrome(str) && str.length() > len) {
                            len = str.length();
                            startIndex = j;
                        }
                    }
                }
            }
            return s.substring(startIndex, startIndex + len);
        }

        public boolean isPalindrome(String s) {
            StringBuilder sb = new StringBuilder(s);
            if (s.equals(sb.reverse().toString())) return true;
            else return false;
        }
    }
}
