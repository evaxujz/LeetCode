package leetcode;

/**
 * 递增的三元子序列
 *
 * 给定一个未排序的数组，判断这个数组中是否存在长度为 3 的递增子序列。
 *
 * 数学表达式如下:
 *
 * 如果存在这样的 i, j, k,  且满足 0 ≤ i < j < k ≤ n-1，
 * 使得 arr[i] < arr[j] < arr[k] ，返回 true ; 否则返回 false 。
 * 说明: 要求算法的时间复杂度为 O(n)，空间复杂度为 O(1) 。
 */
public class IncreasingTriplet {

    public static void main(String[] args) {
        IncreasingTriplet i = new IncreasingTriplet();
        Solution solution = i.new Solution();
        System.out.println(solution.increasingTriplet(new int[] {5,1,5,5,2,5,4}));
    }

    class Solution {
        public boolean increasingTriplet(int[] nums) {
            if(nums.length < 3) return false;

            boolean hasLessFirstElement = false;
            boolean hasSecondElement = false;

            // 首元素作为已知的三元递增子序列的第一元素
            int firstElement = nums[0];
            /**
             * lessFirstElement用来存储比第一元素小的元素,
             * 由于需要两个元素才能更新最小二元递增序列
             * 所以在找到第二个能够替代的元素前需要保存第一个替代元素
             * lessFirstElement与secondElement的初始值可任意取值, 因为是由上面两个
             * boolean变量来确定这两个变量内的值是否有效
             */
            int lessFirstElement = Integer.MIN_VALUE;
            int secondElement = Integer.MIN_VALUE;

            // firstElement = nums[0], 所以从索引为1的元素开始
            for(int i = 1, len = nums.length; i < len; i++) {
                int currentElement = nums[i];
                if(currentElement < firstElement) {
                    if(hasSecondElement) {
                        if(hasLessFirstElement) {
                            /**
                             * 当前元素小于第一元素且已存在二元递增子序列,
                             * 若已存在暂存的元素, 此时存在两个小于第一元素的元素,
                             * 若当前元素小于第一个暂存元素则替换暂存元素, 若大于
                             * 第一个暂存元素, 此时这两个暂存元素可以组成更小的
                             * 二元递增子序列, 替换当前二元递增子序列
                             *
                             */
                            if(currentElement < lessFirstElement) {
                                lessFirstElement = currentElement;
                            } else if(currentElement > lessFirstElement) {
                                firstElement = lessFirstElement;
                                secondElement = currentElement;
                                hasLessFirstElement = false;
                            }
                        }
                        /**
                         * 当前元素小于第一元素且已存在二元递增子序列,
                         * 若不存在暂存元素, 则暂存该元素
                         */
                        else {
                            lessFirstElement = currentElement;
                            hasLessFirstElement = true;
                        }
                    }
                    /**
                     * 当前元素小于第一元素且不存在二元递增子序列,
                     * 更新第一元素
                     */
                    else {
                        firstElement = currentElement;
                    }
                }
                else if(currentElement > firstElement) {
                    if(hasSecondElement) {
                        /**
                         * 当前元素大于第一元素且存在二元递增子序列,
                         * 若当前元素小于第二元素, 则更新第二元素组成新的
                         * 更小的二元递增子序列, 若当前元素大于第二元素,
                         * 此时当前元素与当前二元递增子序列构成三元递增
                         * 子序列, 返回true
                         */
                        if(currentElement < secondElement) {
                            secondElement = currentElement;
                        } else if(currentElement > secondElement) {
                            return true;
                        }
                    }
                    /**
                     * 当前元素大于第一元素且不存在二元递增子序列,
                     * 当前元素与第一元素构成二元递增子序列
                     */
                    else {
                        secondElement = currentElement;
                        hasSecondElement = true;
                    }
                }
            }
            return false;
        }
    }
}
