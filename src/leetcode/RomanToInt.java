package leetcode;

/**
 * 罗马数字转整数
 *
 * 罗马数字包含以下七种字符：I， V， X， L，C，D 和 M。
 *
 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * 例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
 *
 * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
 *
 * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
 * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。
 * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
 * 给定一个罗马数字，将其转换成整数。输入确保在 1 到 3999 的范围内。
 *
 * I, X, C在特殊情况下表示 -1, -10，-100
 */
public class RomanToInt {

    public static void main(String[] args) {
        RomanToInt romanToInt = new RomanToInt();
        Solution solution = romanToInt.new Solution();
        System.out.println(solution.romanToInt("MCMXCIV"));
    }

    class Solution {
        public int romanToInt(String s) {
            s = s.concat("N");
            int count = 0;
            for(int i = 0, len = s.length(); i < len; i++) {
                char cur = s.charAt(i);
                if('C' == cur) {
                    if('D' == s.charAt(i + 1) || 'M' == s.charAt(i + 1)) count -= 100;
                    else count += 100;
                } else if('X' == cur) {
                    if('L' == s.charAt(i + 1) || 'C' == s.charAt(i + 1)) count -= 10;
                    else count += 10;
                } else if('I' == cur) {
                    if('V' == s.charAt(i + 1) || 'X' == s.charAt(i + 1)) count -= 1;
                    else count += 1;
                } else if('V' == cur) {
                    count += 5;
                } else if('L' == cur) {
                    count += 50;
                } else if('D' == cur) {
                    count += 500;
                } else if('M' == cur) {
                    count += 1000;
                } else count += 0;
            }

            return count;
        }
    }
}
