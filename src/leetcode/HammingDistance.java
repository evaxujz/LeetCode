package leetcode;

/**
 * 汉明距离
 *
 * 两个整数之间的汉明距离指的是这两个数字对应二进制位不同的位置的数目。
 *
 * 给出两个整数 x 和 y，计算它们之间的汉明距离。
 *
 * 注意：
 * 0 ≤ x, y < 2^31
 */
public class HammingDistance {

    public static void main(String[] args) {
        HammingDistance hammingDistance = new HammingDistance();
        Solution solution = hammingDistance.new Solution();
        System.out.println(solution.hammingDistance(8, 4));
    }

    class Solution {
        public int hammingDistance(int x, int y) {
            int and = x ^ y;
            return Integer.toBinaryString(and)
                    .replaceAll("0", "")
                    .length();
        }
    }
}
