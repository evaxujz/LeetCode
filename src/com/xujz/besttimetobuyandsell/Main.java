package com.xujz.besttimetobuyandsell;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
	    Solution solution = main.new Solution();
	    System.out.println(solution.maxProfit(new int[]{2, 2, 5}));
    }

    class Solution {
        public int maxProfit(int[] prices) {
            List<Integer> checkList = new ArrayList<Integer>();
            if(prices.length == 0 || prices.length == 1) return 0;

            if(prices[0] < prices[1]) checkList.add(0);
            for(int i = 1; i < prices.length - 1; i++) {
                if(isInflectionPoint(prices[i -1], prices[i], prices[i + 1])) {
                    checkList.add(i);
                }
            }
            if(prices[prices.length - 1] > prices[prices.length - 2]) checkList.add(prices.length - 1);

            if(checkList.size() % 2 != 0) checkList.remove(checkList.size() - 1);

            int sum = 0;
            for(int i = 0; i < checkList.size(); i = i + 2) {
                sum += prices[checkList.get(i + 1)] - prices[checkList.get(i)];
            }
            return sum;
        }

        public boolean isInflectionPoint(int first, int second, int third) {
            if((second > first && second >= third) ||
                    (second <= first && second < third)) {
                return true;
            } else {
                return false;
            }
        }
    }
}
