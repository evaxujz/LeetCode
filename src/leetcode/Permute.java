package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 全排列
 *
 * 给定一个没有重复数字的序列，返回其所有可能的全排列
 */
public class Permute {

    public static void main(String[] args) {
        Permute p = new Permute();
        Solution solution = p.new Solution();
    }

    class Solution {
        public List<List<Integer>> permute(int[] nums) {
            List<List<Integer>> result = new ArrayList<>();
            List<Integer> origin = new ArrayList<>();
            for(int i : nums) origin.add(i);
            List<Integer> goal = new ArrayList<>();
            int remain = nums.length;
            permute(origin, goal, remain, result);
            return result;
        }

        public void permute(List<Integer> origin, List<Integer> goal, int remain, List result) {
            if(remain == 0) {
                result.add(new ArrayList<Integer>(goal));
            } else {
                for(int i = 0; i < origin.size(); i++) {
                    Integer num = origin.get(i);
                    if(num != null) {
                        origin.set(i, null);
                        goal.add(num);
                        permute(origin, goal, remain - 1, result);
                        goal.remove(goal.size() - 1);
                        origin.set(i, num);
                    }
                }
            }
        }
    }
}
