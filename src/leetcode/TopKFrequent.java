package leetcode;

import java.util.*;

/**
 * 前K个高频元素
 *
 * 给定一个非空的整数数组，返回其中出现频率前 k 高的元素
 */
public class TopKFrequent {
    public static void main(String[] args) {
        TopKFrequent t = new TopKFrequent();
        Solution solution = t.new Solution();
        System.out.println(solution.topKFrequent(new int[] {2,1,3,4,5},1) );
    }

    class Solution {
        public List<Integer> topKFrequent(int[] nums, int k) {
            Map<Integer, Integer> map = new HashMap<>();
            for(int num :nums) {
                if(null == map.get(num)) {
                    map.put(num, 1);
                } else {
                    map.put(num, map.get(num) + 1);
                }
            }

            PriorityQueue<Integer> queue = new PriorityQueue<>((o1 ,o2) -> map.get(o1) - map.get(o2));
            for(int key : map.keySet()) {
                if(queue.size() < k) {
                    queue.add(key);
                } else if(map.get(key) > map.get(queue.peek())) {
                    queue.remove();
                    queue.add(key);
                }
            }

            List<Integer> list = new ArrayList<>();
            while(!queue.isEmpty()) {
                list.add(queue.remove());
            }
            return list;
        }
    }
}
