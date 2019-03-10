package leetcode;

import java.util.Arrays;

/**
 * 在排序数组中查找元素的第一个和最后一个位置
 *
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 * 你的算法时间复杂度必须是 O(log n) 级别。
 * 如果数组中不存在目标值，返回 [-1, -1]。
 *
 * 思路:
 * 二分查找确认是否有目标值,
 * 有的话, 在第一次找到的目标值两侧分别再次进行二分查找, 确认目标值的开始位置与结束位置
 */
public class SearchRange {
    public static void main(String[] args) {
        SearchRange s = new SearchRange();
        Solution solution = s.new Solution();
        System.out.println(Arrays.toString(solution.searchRange(new int[] {5,7,7,8,8,10}, 6)));
    }

    class Solution {
        public int[] searchRange(int[] nums, int target) {
            int begin = 0;
            int end = nums.length - 1;
            int targetAnchor = -1;
            while(begin <= end) {
                int mid = (begin + end) / 2;
                if(nums[mid] == target) {
                    targetAnchor = mid;
                    break;
                } else if(nums[mid] < target) {
                    begin = mid + 1;
                } else {
                    end = mid - 1;
                }
            }

            if(targetAnchor == -1) {
                return new int[] {-1, -1};
            }

            begin = 0;
            end = targetAnchor - 1;
            int targetBegin = targetAnchor;
            while(begin <= end) {
                int mid = (begin + end) / 2;
                if(nums[mid] == target) {
                    if(mid <= 0 || nums[mid - 1] != target) {
                        targetBegin = mid;
                        break;
                    }
                    end =  mid - 1;
                } else {
                    begin = mid + 1;
                }
            }

            begin = targetAnchor + 1;
            end = nums.length - 1;
            int targetEnd = targetAnchor;
            while(begin <= end) {
                int mid = (begin + end) / 2;
                if(nums[mid] == target) {
                    if(mid >= nums.length - 1 || nums[mid + 1] != target) {
                        targetEnd = mid;
                        break;
                    }
                    begin =  mid + 1;
                } else {
                    end = mid - 1;
                }
            }
            return new int[] {targetBegin, targetEnd};
        }
    }
}
