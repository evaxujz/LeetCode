package leetcode;

/**
 * 买卖股票的最佳时机
 *
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 *
 * 如果你最多只允许完成一笔交易（即买入和卖出一支股票），设计一个算法来计算你所能获取的最大利润。
 *
 * 注意你不能在买入股票前卖出股票。
 */
public class MaxProfit {

    public static void main(String[] args) {
        MaxProfit mp = new MaxProfit();
        Solution solution = mp.new Solution();
        System.out.println(solution.maxProfit(new int[] {7,7,5,3,6,4,10,20,1,21,3,20,48}));
    }

    /**
     * 实现：
     * 1.考虑特殊情况，数组为空，或只有0或1个元素返回0.
     * 2.考虑正常情况
     *  2.1.以第一天作为最低点，遍历之后所有元素，若元素比当前最低点低，则更新最低点
     *  2.2.若元素不比最低点低，则计算该节点卖出，当前最低点买入时的利润，并与之前求得的最高利润进行比较，取高者作为新的最高利润
     *
     * 思路：
     * 假设交易天数总共m天，已知交易在前n天完成的最高利润P，以及买入点L，卖出点H
     * 此时求交易在前n+1天完成的最高利润，设第n+1天的价格为Q
     * 此时有三种情况：
     *  1.Q > H: n+1天的价格为前n+1天的最高点，此时取L为买入点，Q为卖出点，为前n+1天的最高利润
     *  2.H > Q > L: n+1天的价格在前n天价格区间内，此时维持，L点买入， H点卖出，为前n+1天的最高利润
     *  3.L > Q: 此时n+1天的价格为前n+1天的最低点，若选择Q点买了，则需要保证在n+2到n+k（n + k <= m）天内能够出现一个价格点K，
     *  使得K - Q > H - L, 所以在出现这种情况时，可以将前n天的最高利润记录下来，然后从n+2开始计算每天的价格与Q
     *  点之间的利润，若利润高于 H - L，则更新最高利润，这样便能够得到前n+k天的利润直到当天价格低于Q点的n+k+1天，此时便重复这一步骤进行迭代
     *
     *  所以对于本题实现便是已知n天内的价格信息[p1, p2, ..., pn],获取该数组的最长递减序列[px0, px1, px2, ..., pxi](x0 = 1)
     *  根据这个序列将价格数组分成区间[pxi,px(i+1)),求得每个区间的最高利润，区间最高利润的最大值便是最终的最高利润
     */
    class Solution {
        public int maxProfit(int[] prices) {
            if(null == prices || 0 == prices.length || 1 == prices.length) return 0;

            int low = prices[0];
            int profit = 0;

            for(int i = 1; i < prices.length; i++) {
                //更新最低点
                if(low > prices[i]) low = prices[i];
                //profit为当前所在区间已知最高利润和已知区间最高利润的高者
                else if(prices[i] - low > profit) profit = prices[i] - low;
            }

            return profit;
        }
    }

}
