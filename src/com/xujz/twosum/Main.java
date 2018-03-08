package com.xujz.twosum;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        int[] nums = new int[]{1, 2, 3, 4, 9};
        Solution solution = main.new Solution();
        System.out.println(Arrays.toString(solution.twoSum(nums, 7)));
    }

    class Solution {
        public int[] twoSum(int[] nums, int target) {
            Map<Integer, Integer> map = new HashMap<>();
            for(int i = 0; i < nums.length; i++) {
                if(map.containsKey(target - nums[i])){
                    return new int[]{map.get(target - nums[i]), i};
                } else {
                    map.put(nums[i], i);
                }
            }
            return new int[]{0, 0};
        }
    }
}
