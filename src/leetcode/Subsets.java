package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 子集
 *
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集(幂集)
 */
public class Subsets {

    public static void main(String[] args) {
        Subsets s = new Subsets();
        Solution solution = s.new Solution();
        System.out.println(solution.subsets(new int[] {1, 2, 3}));
    }

    class Solution {
        public List<List<Integer>> subsets(int[] nums) {
            List<List<Integer>> result = new ArrayList<>();
            List<Integer> goal = new ArrayList<>();
            int len = nums.length;
            subsets(nums, goal, len - 1, result);
            return result;
        }

        public void subsets(int[] origin, List<Integer> goal, int pos, List result) {
            if(pos == -1) {
                result.add(new ArrayList<Integer>(goal));
                return;
            } else {
                goal.add(origin[pos]);
                subsets(origin, goal, pos - 1, result);
                goal.remove(goal.size() - 1);

                subsets(origin, goal, pos - 1, result);
            }
        }
    }
}
