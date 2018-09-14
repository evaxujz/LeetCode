package leetcode;

/**
 * 打家劫舍
 *
 * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 *
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。
 */
public class Rob {

    public static void main(String[] args) {
        Rob r = new Rob();
        Solution solution = r.new Solution();
        System.out.println(solution.rob(new int[] {2,7,9,3,1}));
    }

    class Solution {
        public int rob(int[] nums) {
            int[] max = new int[nums.length];
            if(null == nums || 0 == nums.length) return 0;
            if(1 == nums.length) return nums[0];
            if(2 == nums.length) return (nums[1] > nums[0]) ? nums[1] : nums[0];

            max[0] = nums[0];
            max[1] = nums[1];
            max[2] = (nums[1] > nums[0] + nums[2]) ? nums[1] : nums[0] + nums[2];

            for(int i = 3, len = nums.length; i < len; i++) {
                max[i] = ((max[i -2] > max[i - 3]) ? max[i - 2] : max[i - 3]) + nums[i];
            }

            int more = max[nums.length - 1] > max[nums.length - 2] ? max[nums.length - 1] : max[nums.length - 2];
            return more > max[nums.length - 3] ? more : max[nums.length - 3];
        }
    }
}
