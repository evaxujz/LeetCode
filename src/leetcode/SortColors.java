package leetcode;

import java.util.Arrays;

/**
 * 颜色分类
 *
 * 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 *
 * 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色
 *
 * 一个直观的解决方案是使用计数排序的两趟扫描算法。
 * 首先，迭代计算出0、1 和 2 元素的个数，然后按照0、1、2的排序，重写当前数组。
 * 你能想出一个仅使用常数空间的一趟扫描算法吗？
 */
public class SortColors {
    public static void main(String[] args) {
        SortColors s = new SortColors();
        Solution solution = s.new Solution();
        int[] nums = new int[] {0, 0, 1, 2, 0, 1, 2, 0, 1};
        solution.sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }

    class Solution {
        public void sortColors(int[] nums) {
            if(nums == null) return;
            int redCount = 0;
            int whiteCount = 0;
            for(int i = 0; i < nums.length; i++) {
                if(nums[i] == 0) redCount++;
                else if(nums[i] == 1) whiteCount++;
            }
            for(int i = 0; i < redCount; i++) nums[i] = 0;
            for(int i = redCount; i < redCount + whiteCount; i++) nums[i] = 1;
            for(int i = redCount + whiteCount; i < nums.length; i++) nums[i] = 2;
        }
    }

    class Solution2 {
        public void sortColors(int[] nums) {
            if(null == nums || 1 == nums.length) return;

            /* 红球的最终位置与蓝球的初始位置 */
            int rbpos = -1;
            int bbpos = nums.length;

            /* 左扫描的当前索引位置与右扫描的当前索引位置 */
            int leftIndex = 0;
            int rightIndex = nums.length - 1;

            /* 左扫描是否发现蓝球, 右扫描是否发现红球 */
            boolean findBlueBall = false;
            boolean findRedBall = false;

            /* 当前扫描方向 */
            boolean toRight = true;

            while(true) {
                if(findRedBall && findBlueBall) {
                    nums[++rbpos] = 0;
                    nums[--bbpos] = 2;
                    findRedBall = false;
                    findBlueBall = false;
                }

                if(toRight) {
                    if(2 == nums[leftIndex]) {
                        findBlueBall = true;
                        toRight = false;
                    } else if (0 == nums[leftIndex]) {
                        nums[++rbpos] = 0;
                    }
                    leftIndex++;
                } else {
                    if(0 == nums[rightIndex]) {
                        findRedBall = true;
                        toRight = true;
                    } else if(2 == nums[rightIndex]) {
                        nums[--bbpos] = 2;
                    }
                    rightIndex--;
                }

                if(leftIndex > rightIndex) {
                    if(findRedBall && findBlueBall) {
                        nums[++rbpos] = 0;
                        nums[--bbpos] = 2;
                    } else if(findBlueBall) {
                        nums[--bbpos] = 2;
                    }

                    for(int i = rbpos + 1; i < bbpos; i++) {
                        nums[i] = 1;
                    }
                    break;
                }
            }
        }
    }
}
