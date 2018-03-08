package com.xujz.movezeroes;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        int[] nums = new int[]{0, 0, 1};
        Solution solution = main.new Solution();
        solution.moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }

    class Solution {
        public void moveZeroes(int[] nums) {
            int size = nums.length;
            if(size == 0 || size == 1) {
                return;
            }

            int len = 0;
            int begin = size - 1;
            for(int i = size - 1; i >= 0; i--){
                if(nums[i] != 0){
                    begin = i;
                    len++;
                } else {
                    if(i == size - 1){
                        continue;
                    } else{
                        System.arraycopy(nums, begin, nums, begin - 1, len);
                        nums[begin + len - 1]  = 0;
                        begin = i;
                    }
                }
            }
        }
    }
}
