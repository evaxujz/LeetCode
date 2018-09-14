package leetcode;

/**
 * 3的幂
 *
 * 给定一个整数，写一个函数来判断它是否是 3 的幂次方。
 *
 * 将十进制数转换为三进制，则三的幂满足1，10， 100， 1000， 10000， ...
 */
public class IsPowerOfThree {

    public static void main(String[] args) {
        IsPowerOfThree isPowerOfThree = new IsPowerOfThree();
        Solution solution = isPowerOfThree.new Solution();
        System.out.println(solution.isPowerOfThree(81));
    }

    class Solution {
        public boolean isPowerOfThree(int n) {
            String str = Integer.toString(n, 3);
            if('1' != str.charAt(0)) return false;
            for(int i = 1; i < str.length(); i++) {
                if('0' != str.charAt(i)) return false;
            }
            return true;
        }
    }
}
