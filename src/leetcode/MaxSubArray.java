package leetcode;

/**
 * 最大子序和
 *
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素!!），返回其最大和。
 */
public class MaxSubArray {

    public static void main(String[] args) {
        MaxSubArray ms = new MaxSubArray();
        Solution solution = ms.new Solution();
        System.out.println(solution.maxSubArray(new int[] {-2,1,-3,4,-1,2,1,-5,4}));
    }

    /**
     * 数组[P1, P2, P3，...，Pm]
     * 已知前n个元素的最大和Kn及包括Pn元素在内的连续子数组的和Ln（可能为多个元素组成的正和，或者单个Pn元素的非正和，
     * 这是由于子数组最少包括一个元素导致的，若数组全为负，需要找出最大数作为最大和）
     * 1.若Ln为非正数：直接取Pn+1作为新的连续子数组，和为Ln+1（=Pn+1），与Kn比较取最大值最为Kn+1
     * 2.若Ln为正数：
     *  2.1.此时若Ln + Pn+1 >= 0，则加入Pn+1组成新的连续子数组和为Ln+1，并与Kn比较取最大值为Kn+1
     *  2.2.此时若Ln + Pn+1 < 0，则直接取Pn+1作为新的连续子数组，和为Ln+1（=Pn+1）
     * 3.上述过程得出前n+1个元素的最大和Kn+1
     */
    class Solution {
        public int maxSubArray(int[] nums) {
            if(null == nums || 0 == nums.length) return 0;
            if(1 == nums.length) return nums[0];

            int maxSum = nums[0];
            int sum = nums[0];

            for(int i = 1, len = nums.length; i < len; i++) {
                int num = nums[i];

                if(sum <= 0) {
                    sum = num;
                    maxSum = (maxSum > sum) ? maxSum : sum;
                } else {
                    if(sum + num >= 0) {
                        sum += num;
                        maxSum = (maxSum > sum) ? maxSum : sum;
                    } else {
                        sum = num;
                    }
                }
            }

            return maxSum;
        }
    }
}
