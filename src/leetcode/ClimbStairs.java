package leetcode;

/**
 * 爬楼梯
 *
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 *
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 *
 * 注意：给定 n 是一个正整数。
 */
public class ClimbStairs {

    public static void main(String[] args) {
        ClimbStairs cs = new ClimbStairs();
        Solution solution = cs.new Solution();
        System.out.println(solution.climbStairs(100));
    }

    /**
     * 1.有多少种能爬到n-1个台阶的方法，这些方法都可以通过再爬1个台阶到达第n个台阶
     * 2.有多少种能爬到n-2个台阶的方法，这些方法都可以通过再爬2个台阶到达第n个台阶
     *
     * 所以能爬到第n个台阶的方法为 1 + 2
     */
    class Solution {
        public int climbStairs(int n) {
            if(1 == n || 2 == n) return n;
            int[] count = new int[n];
            count[0] = 1;
            count[1] = 2;

            int i = 3;
            while(i <= n) {
                count[i - 1] = count[i - 2] + count[i - 3];
                i++;
            }

            return count[n - 1];
        }
    }
}
