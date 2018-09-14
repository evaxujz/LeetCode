package leetcode;

/**
 * 第一个错误的版本
 *
 * 你是产品经理，目前正在带领一个团队开发新的产品。不幸的是，你的产品的最新版本没有通过质量检测。由于每个版本都是基于之前的版本开发的，所以错误的版本之后的所有版本都是错的。
 *
 * 假设你有 n 个版本 [1, 2, ..., n]，你想找出导致之后所有版本出错的第一个错误的版本。
 *
 * 你可以通过调用 bool isBadVersion(version) 接口来判断版本号 version 是否在单元测试中出错。实现一个函数来查找第一个错误的版本。你应该尽量减少对调用 API 的次数。
 *
 * 思路：本质上是二分查找，确认为第一个badVersion的条件为前后两个版本的isBadVersion结果为false， true
 * 所以二分查找每次定位到的中值判断是最后一个正确版本还是第一个错误版本
 * 若都不是，则中值若为true，则表明错误版本在中值版本前，此时修改查找上限
 * 反之修改查找下限
 */
public class FirstBadVersion {

    public static void main(String[] args) {
        FirstBadVersion fbv = new FirstBadVersion();
        Solution solution = fbv.new Solution();
        System.out.println(solution.firstBadVersion(12));
    }

    public class Solution extends VersionControl {

        private boolean[] versions = new boolean[] {false, false, false, false, false, false, false,
            true, true, true, true, true};

        public boolean isBadVersion(int version) {
            return versions[version - 1];
        }

        public int firstBadVersion(int n) {
            if(0 == n) return -1;
            if(true == isBadVersion(1)) return 1;

            int startIndex = 1;
            int endIndex = n;

            while(startIndex < endIndex) {
                int mid = startIndex + ((endIndex - startIndex) >> 1);
                if(true == isBadVersion(mid) && false == isBadVersion(mid - 1)) return mid;
                else if(true == isBadVersion(mid + 1) && false == isBadVersion(mid)) return mid + 1;
                else {
                    if(false == isBadVersion(mid)) startIndex = mid + 1;
                    else endIndex = mid - 1;
                }
            }

            return -1;
        }
    }
}

abstract class VersionControl {
    public abstract boolean isBadVersion(int version);
}
