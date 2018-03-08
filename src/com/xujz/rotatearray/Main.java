package com.xujz.rotatearray;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        int[] nums = new int[]{1, 2, 3, 4, 5};
        Solution solution = main.new Solution();
        solution.rotate(nums, 3);
        System.out.println(Arrays.toString(nums));
    }

    class Solution {
        public void rotate(int[] nums, int k) {
            k = k % nums.length;
            if(nums.length == 0 || k == 0) return;
            int[] nowTemp = new int[k];
            int[] nextTemp = new int[k];

            int wholeCount = nums.length / k;
            int remain = nums.length % k;
            System.arraycopy(nums, 0, nowTemp, 0, k);
            for(int i = 1; i < wholeCount; i++) {
                System.arraycopy(nums, k * i, nextTemp, 0, k);
                System.arraycopy(nowTemp, 0, nums, k * i, k);
                System.arraycopy(nextTemp, 0, nowTemp, 0, k);
            }

            System.arraycopy(nums, k * wholeCount, nextTemp, 0, remain);
            System.arraycopy(nowTemp, 0, nums, k * wholeCount, remain);
            System.arraycopy(nowTemp, remain, nums, 0, k - remain);
            System.arraycopy(nextTemp, 0, nums, k - remain, remain);
        }
    }
}
