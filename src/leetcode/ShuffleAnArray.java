package leetcode;

import java.util.Arrays;

public class ShuffleAnArray {

    public static void main(String[] args) {
        ShuffleAnArray shuffleAnArray = new ShuffleAnArray();
        Solution solution = shuffleAnArray.new Solution(new int[] {1, 2, 3, 4, 5, 6, 7});
        System.out.println(Arrays.toString(solution.shuffle()));
        System.out.println(Arrays.toString(solution.shuffle()));
        System.out.println(Arrays.toString(solution.shuffle()));
        System.out.println(Arrays.toString(solution.shuffle()));
        System.out.println(Arrays.toString(solution.shuffle()));
    }

    class Solution {

        private int[] array;

        public Solution(int[] nums) {
            array = nums;
        }

        /** Resets the array to its original configuration and return it. */
        public int[] reset() {
            return array;
        }

        /** Returns a random shuffling of the array. */
        public int[] shuffle() {
            int[] shuffled = new int[array.length];
            for(int i = 0; i < array.length; i++) {
                if(0 == array[i]) continue;
                int pos = (int) (System.nanoTime() & Integer.MAX_VALUE) % array.length;
                while(0 != shuffled[pos]) pos = ++pos % array.length;
                shuffled[pos] = array[i];
            }
            return shuffled;
        }
    }
}
