package leetcode;

/**
 * 只出现一次的数字
 *
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 */
public class SingleNumber {


    public static void main(String[] args) {
        int[] nums = new int[] {1, 2, 3, 4, 1, 2, 3};

        SingleNumber sn = new SingleNumber();
        Solution solution = sn.new Solution();
        System.out.println(solution.singleNumber(nums));
    }

    /**
     * a ^ a = 0 (位运算)
     */
    class Solution {
        public int singleNumber(int[] nums) {
            int result = nums[0];
            for(int i = 1; i < nums.length; i++) {
                result ^= nums[i];
            }
            return result;
        }
    }
}
