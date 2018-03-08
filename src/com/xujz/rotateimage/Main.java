package com.xujz.rotateimage;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        Solution solution = main.new Solution();
    }

    class Solution {
        public void rotate(int[][] matrix) {
            int size = matrix[0].length;
            int left = 0, right = size - 1, top = 0, bottom = size - 1;
            while(left < right) {
                int round = right - left;
                for(int i = 0; i < round; i++) {
                    int temp = matrix[top][left + i];
                    matrix[top][left + i] = matrix[bottom - i][left];
                    matrix[bottom - i][left] = matrix[bottom][right - i];
                    matrix[bottom][right - i] = matrix[top + i][right];
                    matrix[top + i][right] = temp;
                }
                left++;
                right--;
                top++;
                bottom--;
            }
        }
    }
}