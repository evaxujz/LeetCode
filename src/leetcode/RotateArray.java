package leetcode;

import java.util.Arrays;

/**
 * 旋转数组
 *
 * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数
 *
 * r:代表对数组进行reverse
 * （ArBr）r = BA
 *
 * [1, 2, 3, ..., k, k + 1, k + 2, ..., k + m] => [k + 1, k + 2, ..., k + m, 1, 2, 3, ..., k]
 * [1, 2, 3, ..., k] => A
 * [k + 1, k + 2, ..., k + m] => B
 */
public class RotateArray {

    public static void main(String[] args) {
        RotateArray rotateArray = new RotateArray();
        Solution solution = rotateArray.new Solution();
        int[] array = new int[] {1, 2, 3, 4, 5, 6, 7};
        solution.rotate(array, 3);
        System.out.println(Arrays.toString(array));
    }

    class Solution {
        public void rotate(int[] nums, int k) {
            int len = nums.length;
            k = len - k % len;
            if(0 == k) return;

            reverse(nums, 0, k -1);
            reverse(nums, k, len - 1);
            reverse(nums, 0, len - 1);
        }

        public void reverse(int[] nums, int start, int end) {
            for(int i = start, j = end; i < j; i++, j--) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }
    }
}
