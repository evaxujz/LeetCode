package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 三数之和
 *
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
 */
public class ThreeSum {

    public static void main(String[] args) {
        ThreeSum threeSum = new ThreeSum();
        ThreeSum.Solution solution = threeSum.new Solution();
        System.out.println(solution.threeSum(new int[]{-3, -4, -2, 0, 2, 2, -2, 1, -1, 2, 3, -1, -5, -4, -5, 1}));
    }

    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            Arrays.sort(nums);
            int negativeSize = 0;
            int positiveSize = 0;
            int zeroSize = 0;
            for (int i = 0, len = nums.length; i < len; i++) {
                if (nums[i] < 0) {
                    negativeSize++;
                } else if (nums[i] == 0) {
                    zeroSize++;
                } else {
                    positiveSize = nums.length - (negativeSize + zeroSize);
                    break;
                }
            }

            List<Integer> negativeNums = new ArrayList<>();
            Map<Integer, Integer> negativeCount = new HashMap<>();
            for (int i = 0, len = negativeSize; i < len; i++) {
                int num = nums[i];
                if (negativeCount.get(num) != null) {
                    negativeCount.put(num, negativeCount.get(num) + 1);
                } else {
                    negativeCount.put(num, 1);
                    negativeNums.add(num);
                }
            }

            List<Integer> positiveNums = new ArrayList<>();
            Map<Integer, Integer> positiveCount = new HashMap<>();
            for (int i = negativeSize + zeroSize, len = nums.length; i < len; i++) {
                int num = nums[i];
                if (positiveCount.get(num) != null) {
                    positiveCount.put(num, positiveCount.get(num) + 1);
                } else {
                    positiveCount.put(num, 1);
                    positiveNums.add(num);
                }
            }

            List<List<Integer>> result = new ArrayList<>();

            for (int i : positiveNums) {
                for (int j : negativeNums) {
                    int k = 0 - (i + j);
                    if (k < 0) {
                        if (k == j && negativeCount.get(k) >= 2) {
                            result.add(Arrays.asList(k, k, i));
                            negativeCount.put(k, 1);
                        } else if (k > j && negativeCount.get(k) != null) {
                            result.add(Arrays.asList(j, k, i));
                        } else if (k < j) break;
                    }
                }
            }

            for (int i : negativeNums) {
                for (int j : positiveNums) {
                    int k = 0 - (i + j);
                    if (k > 0) {
                        if (k == j && positiveCount.get(k) >= 2) {
                            result.add(Arrays.asList(i, k, k));
                            positiveCount.put(k, 1);
                        } else if (k > j && positiveCount.get(k) != null) {
                            result.add(Arrays.asList(i, j, k));
                        } else if (k < j) break;
                    }
                }
            }

            if (zeroSize <= 0) return result;

            for (int i : positiveCount.keySet()) {
                if (negativeCount.get(-i) != null)
                    result.add(Arrays.asList(-i, 0, i));
            }

            if (zeroSize < 3) return result;

            result.add(Arrays.asList(0, 0, 0));

            return result;
        }
    }
}
